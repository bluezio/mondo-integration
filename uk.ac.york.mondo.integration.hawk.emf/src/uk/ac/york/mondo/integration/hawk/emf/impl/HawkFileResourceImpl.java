/*******************************************************************************
 * Copyright (c) 2015 University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Antonio Garcia-Dominguez - initial API and implementation
 *******************************************************************************/
package uk.ac.york.mondo.integration.hawk.emf.impl;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.thrift.TException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;

import uk.ac.york.mondo.integration.api.FailedQuery;
import uk.ac.york.mondo.integration.api.HawkInstanceNotFound;
import uk.ac.york.mondo.integration.api.HawkInstanceNotRunning;
import uk.ac.york.mondo.integration.api.InvalidQuery;
import uk.ac.york.mondo.integration.api.UnknownQueryLanguage;
import uk.ac.york.mondo.integration.hawk.emf.HawkResource;
import uk.ac.york.mondo.integration.hawk.emf.IHawkResourceChangeListener;

public class HawkFileResourceImpl extends ResourceImpl implements HawkResource {

	private final HawkResource mainResource;

	/** Only to be used from Exeed (from the createExecutableExtension Eclipse call). */
	public HawkFileResourceImpl() {
		this.mainResource = null;
	}

	/**
	 * Creates a resource as a subordinate of another. Used to indicate the
	 * repository URL and file of an {@link EObject}.
	 */
	public HawkFileResourceImpl(final URI uri, final HawkResource mainResource) {
		super(uri);
		this.mainResource = mainResource;
	}

	@Override
	public boolean hasChildren(final EObject o) {
		if (mainResource != null) {
			return mainResource.hasChildren(o);
		} else {
			return o.eAllContents().hasNext();
		}
	}

	@Override
	public Map<EObject, Object> fetchValuesByEStructuralFeature(final EStructuralFeature feature)
			throws HawkInstanceNotFound, HawkInstanceNotRunning, TException, IOException {
		return mainResource.fetchValuesByEStructuralFeature(feature);
	}

	@Override
	public EList<EObject> fetchNodes(final EClass eClass)
			throws HawkInstanceNotFound, HawkInstanceNotRunning, TException, IOException {
		return mainResource.fetchNodes(eClass);
	}

	@Override
	public List<Object> fetchValuesByEClassifier(final EClassifier dataType) throws HawkInstanceNotFound,
			HawkInstanceNotRunning, UnknownQueryLanguage, InvalidQuery, FailedQuery, TException, IOException {
		return mainResource.fetchValuesByEClassifier(dataType);
	}

	@Override
	public Map<EClass, List<EAttribute>> fetchTypesWithEClassifier(final EClassifier dataType) throws HawkInstanceNotFound,
			HawkInstanceNotRunning, UnknownQueryLanguage, InvalidQuery, FailedQuery, TException {
		return mainResource.fetchTypesWithEClassifier(dataType);
	}

	@Override
	public boolean addSyncEndListener(final Runnable r) {
		return mainResource.addSyncEndListener(r);
	}

	@Override
	public boolean removeSyncEndListener(final Runnable r) {
		return mainResource.removeSyncEndListener(r);
	}

	@Override
	public boolean addChangeListener(final IHawkResourceChangeListener l) {
		return mainResource.addChangeListener(l);
	}

	@Override
	public boolean removeChangeListener(final IHawkResourceChangeListener l) {
		return mainResource.removeChangeListener(l);
	}
}
