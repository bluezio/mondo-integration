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
package uk.ac.york.mondo.integration.hawk.emc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.thrift.TException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;

import uk.ac.york.mondo.integration.hawk.emf.impl.HawkResourceImpl;

/**
 * Specialized version of {@link #EmfModel} that takes advantage of the extra
 * methods in a {@link #HawkResource} (mostly getting all instances of a type),
 * to make the most out of the lazy loading modes.
 */
public class RemoteHawkModel extends EmfModel {
	private HawkResourceImpl hawkResource;

	@Override
	protected Collection<EObject> getAllOfTypeFromModel(String type) throws EolModelElementTypeNotFoundException {
		final EClass eClass = classForName(type);
		EList<EObject> allOfKind;
		try {
			allOfKind = hawkResource.fetchNodes(eClass, false);
			final List<EObject> allOfType = new ArrayList<>();
			
			for (EObject ofKind : allOfKind) {
				if (ofKind.eClass() == eClass) {
					allOfType.add(ofKind);
				}
			}
			return allOfType;
		} catch (TException | IOException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}

	@Override
	protected Collection<EObject> getAllOfKindFromModel(String kind) throws EolModelElementTypeNotFoundException {
		try {
			return hawkResource.fetchNodes(classForName(kind), false);
		} catch (TException | IOException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}

	@Override
	protected void loadModel() throws EolModelLoadingException {
		loadModelFromUri();
		this.hawkResource = (HawkResourceImpl) modelImpl;

		if (hawkResource.getDescriptor().getLoadingMode().isGreedyElements()) {
			/*
			 * Only set up the containment change listeners if we use the GREEDY
			 * or LAZY_ATTRIBUTES loading modes.
			 */
			setupContainmentChangeListeners();
		}
	}

	@Override
	protected ResourceSet createResourceSet() {
		/**
		 * We cannot use a cached resource set here, as that would be
		 * potentially thread-unsafe. It could have multiple threads trying to
		 * use the same HawkResourceImpl, which is not thread-safe.
		 */
		return new ResourceSetImpl();
	}

}
