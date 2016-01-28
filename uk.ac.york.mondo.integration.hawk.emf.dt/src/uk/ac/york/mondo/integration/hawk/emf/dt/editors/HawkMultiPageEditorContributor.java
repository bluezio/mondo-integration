/*******************************************************************************
 * Copyright (c) 2015-2016 University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Antonio Garcia-Dominguez - initial API and implementation
 *******************************************************************************/
package uk.ac.york.mondo.integration.hawk.emf.dt.editors;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.ide.IDEActionFactory;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.MultiPageEditorActionBarContributor;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.ui.texteditor.ITextEditorActionConstants;

import uk.ac.york.mondo.integration.hawk.emf.dt.Activator;

/**
 * Manages the installation/deinstallation of global actions for multi-page editors.
 * Responsible for the redirection of global actions to the active editor.
 * Multi-page contributor replaces the contributors for the individual editors in the multi-page editor.
 */
public class HawkMultiPageEditorContributor extends MultiPageEditorActionBarContributor {
	private static final String EXEED_EDITOR_ID = "org.eclipse.epsilon.dt.exeed.ExeedEditor";
	private IEditorPart activeEditorPart;
	private Action emfOpenAction;

	/**
	 * Creates a multi-page contributor.
	 */
	public HawkMultiPageEditorContributor() {
		super();
		createActions();
	}

	/**
	 * Returns the action registered with the given text editor.
	 * @return IAction or null if editor is null.
	 */
	protected IAction getAction(ITextEditor editor, String actionID) {
		return (editor == null ? null : editor.getAction(actionID));
	}

	@Override
	public void setActivePage(IEditorPart part) {
		if (activeEditorPart == part)
			return;

		activeEditorPart = part;

		IActionBars actionBars = getActionBars();
		if (actionBars != null) {
			ITextEditor editor = (part instanceof ITextEditor) ? (ITextEditor) part : null;

			actionBars.setGlobalActionHandler(
				ActionFactory.DELETE.getId(),
				getAction(editor, ITextEditorActionConstants.DELETE));
			actionBars.setGlobalActionHandler(
				ActionFactory.UNDO.getId(),
				getAction(editor, ITextEditorActionConstants.UNDO));
			actionBars.setGlobalActionHandler(
				ActionFactory.REDO.getId(),
				getAction(editor, ITextEditorActionConstants.REDO));
			actionBars.setGlobalActionHandler(
				ActionFactory.CUT.getId(),
				getAction(editor, ITextEditorActionConstants.CUT));
			actionBars.setGlobalActionHandler(
				ActionFactory.COPY.getId(),
				getAction(editor, ITextEditorActionConstants.COPY));
			actionBars.setGlobalActionHandler(
				ActionFactory.PASTE.getId(),
				getAction(editor, ITextEditorActionConstants.PASTE));
			actionBars.setGlobalActionHandler(
				ActionFactory.SELECT_ALL.getId(),
				getAction(editor, ITextEditorActionConstants.SELECT_ALL));
			actionBars.setGlobalActionHandler(
				ActionFactory.FIND.getId(),
				getAction(editor, ITextEditorActionConstants.FIND));
			actionBars.setGlobalActionHandler(
				IDEActionFactory.BOOKMARK.getId(),
				getAction(editor, IDEActionFactory.BOOKMARK.getId()));
			actionBars.updateActionBars();
		}
	}

	private void createActions() {
		emfOpenAction = new Action() {
			public void run() {
				if (activeEditorPart == null) {
					return;
				}
				reopenWithExeed(activeEditorPart);
			}
		};
		emfOpenAction.setText("Open with Exeed");
		emfOpenAction.setToolTipText("Opens the model with the Epsilon Exeed editor");
		emfOpenAction.setImageDescriptor(Activator.getImageDescriptor("/icons/hawkmodel.png"));
	}

	@Override
	public void contributeToMenu(IMenuManager manager) {
		IMenuManager menu = new MenuManager("&Hawk");
		manager.prependToGroup(IWorkbenchActionConstants.MB_ADDITIONS, menu);
		menu.add(emfOpenAction);
	}

	@Override
	public void contributeToToolBar(IToolBarManager manager) {
		manager.add(new Separator());
		manager.add(emfOpenAction);
	}

	public static void reopenWithExeed(IEditorPart activeEditorPart) {
		final IEditorInput existingInput = activeEditorPart.getEditorInput();
		if (existingInput instanceof IFileEditorInput) {
			IFileEditorInput existingFileInput = (IFileEditorInput) existingInput;
			final IFileEditorInput newFileInput = new FileEditorInput(existingFileInput.getFile());
			try {
				final IWorkbench workbench = PlatformUI.getWorkbench();
				final IWorkbenchPage page = workbench.getActiveWorkbenchWindow().getActivePage();
				page.openEditor(newFileInput, HawkMultiPageEditorContributor.EXEED_EDITOR_ID, true, IWorkbenchPage.MATCH_ID | IWorkbenchPage.MATCH_INPUT);
			} catch (Throwable e) {
				Activator.getDefault().logError(e);
			}
		}
	}

}
