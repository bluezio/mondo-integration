/*******************************************************************************
 * Copyright (c) 2011-2015 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Konstantinos Barmpis - initial API and implementation
 *     Antonio Garcia-Dominguez - move to servlet project, remove dependency on eclipse.ui
 ******************************************************************************/
package uk.ac.york.mondo.integration.hawk.servlet.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.hawk.core.IHawk;
import org.hawk.core.IMetaModelUpdater;
import org.hawk.core.IVcsManager;
import org.hawk.core.graph.IGraphDatabase;
import org.hawk.core.util.HawkConfig;
import org.hawk.core.util.HawksConfig;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class HManager {

	private static HManager inst;

	public static HManager getInstance() {
		if (inst == null)
			inst = new HManager();
		return inst;
	}

	private static void createExecutableExtensions(final String propertyName,
			final List<IConfigurationElement> elements) throws CoreException {
		for (IConfigurationElement i : elements) {
			i.createExecutableExtension(propertyName);
		}
	}

	private static Set<String> getAttributeFor(final String attributeName,
			final List<IConfigurationElement> elems) {
		Set<String> indexes = new HashSet<String>();
		for (IConfigurationElement i : elems) {
			indexes.add(i.getAttribute(attributeName));
		}
		return indexes;
	}

	private static List<IConfigurationElement> getConfigurationElementsFor(
			final String extensionPointId) {
		ArrayList<IConfigurationElement> els = new ArrayList<IConfigurationElement>();
		if (Platform.isRunning()) {
			IConfigurationElement[] e = Platform.getExtensionRegistry()
					.getConfigurationElementsFor(
							extensionPointId);

			els.addAll(Arrays.asList(e));
		}
		return els;
	}

	private Set<HModel> all = new HashSet<HModel>();

	private boolean firstRun = true;

	public HManager() {
		try {
			getBackends();
			getVCS();
			createExecutableExtensions("MetaModelParser", getMmps());
			createExecutableExtensions("ModelParser", getMps());
			createExecutableExtensions("ModelUpdater", getUps());
			getLanguages();

			/*
			for (IConfigurationElement i : languages) {
				h.addQueryLanguage((IQueryEngine) i.createExecutableExtension("query_language"));
			}
			*/
		} catch (Exception e) {
			System.err.println("error in initialising osgi config:");
			e.printStackTrace();
		}
	}

	public void addHawk(HModel e) {
		all.add(e);
	}

	public IGraphDatabase createGraph(IHawk hawk) throws Exception {
		for (IConfigurationElement i : getBackends()) {
			if (i.getAttribute("store").equals(hawk.getDbtype())) {
				return (IGraphDatabase) i.createExecutableExtension("store");
			}
		}
		throw new Exception("cannot instantiate this type of graph: " + hawk.getDbtype());
	}

	/**
	 * Creates a new instance of the specified VCSManager.
	 * 
	 * @throws CoreException
	 *             There was an exception while creating the VCSManager.
	 * @throws NoSuchElementException
	 *             No VCSManager with that name exists.
	 */
	public IVcsManager createVCSManager(String s) throws CoreException {
		for (IConfigurationElement i : getVCS()) {
			if (i.getAttribute("VCSManager").equals(s)) {
				return (IVcsManager) i.createExecutableExtension("VCSManager");
			}
		}
		throw new NoSuchElementException("cannot instantiate this type of manager: " + s);
	}

	public void delete(HModel o, boolean exists) {
		if (all.contains(o)) {
			if (exists) {
				o.stop();
				o.delete();
			} else {
				o.removeHawkFromMetadata(new HawkConfig(o.getName(), o
						.getFolder()));
			}
			all.remove(o);
		} else {
			o.removeHawkFromMetadata(new HawkConfig(o.getName(), o.getFolder()));
		}
	}

	public List<IConfigurationElement> getBackends() {
		return getConfigurationElementsFor("org.hawk.core.BackEndExtensionPoint");
	}

	public Object[] getElements(Object parent) {
		if (firstRun)
			loadHawksFromMetadata();
		return all.toArray();
	}

	public IGraphDatabase getGraphByIndexerName(String indexerName) {
		for (HModel hm : all)
			if (hm.getName().equals(indexerName))
				return hm.getGraph();
		return null;
	}

	public Set<HModel> getHawks() {
		if (firstRun)
			loadHawksFromMetadata();
		return all;
	}

	/**
	 * Returns the {@link HModel} instance with the specified name among the
	 * existing Hawk instances.
	 * 
	 * @throws NoSuchElementException
	 *             There are no instances with the specified name.
	 */
	public HModel getHawkByName(String name) {
		for (HModel m : getHawks()) {
			if (m.getName().equals(name)) {
				return m;
			}
		}
		throw new NoSuchElementException();
	}

	public Collection<String> getIndexerNames() {
		ArrayList<String> name = new ArrayList<String>();
		for (HModel hm : all)
			if (hm.isRunning())
				name.add(hm.getName());
		return name;
	}

	public Set<String> getIndexTypes() {
		return getAttributeFor("store", getBackends());
	}

	public List<IConfigurationElement> getLanguages() {
		return getConfigurationElementsFor("org.hawk.core.QueryExtensionPoint");
	}

	public Set<String> getMetaModelTypes() {
		return getAttributeFor("MetaModelParser", getMmps());
	}

	public IMetaModelUpdater getMetaModelUpdater() throws CoreException {

		IConfigurationElement[] e = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(
						"org.hawk.core.MetaModelUpdaterExtensionPoint");

		IConfigurationElement i = null;
		for (IConfigurationElement ii : e) {
			if (i == null) {
				i = ii;
			}
			else {
				System.err.println("more than one metamodel updater found, only one allowed");
			}
		}

		if (i != null)
			return (IMetaModelUpdater) i
					.createExecutableExtension("metamodelupdater");
		else
			return null;

	}

	public List<IConfigurationElement> getMmps() {
		return getConfigurationElementsFor("org.hawk.core.MetaModelExtensionPoint");
	}

	public Set<String> getModelTypes() {
		return getAttributeFor("ModelParser", getMps());
	}

	public List<IConfigurationElement> getMps() {
		return getConfigurationElementsFor("org.hawk.core.ModelExtensionPoint");
	}

	public Set<String> getUpdaterTypes() {
		return getAttributeFor("ModelUpdater", getUps());
	}

	public List<IConfigurationElement> getUps() {
		return getConfigurationElementsFor("org.hawk.core.ModelUpdaterExtensionPoint");
	}

	public List<IConfigurationElement> getVCS() {
		return getConfigurationElementsFor("org.hawk.core.VCSExtensionPoint");
	}

	public Set<String> getVCSTypes() {
		return getAttributeFor("VCSManager", getVCS());
	}

	public boolean stopAllRunningInstances() {
		System.out.println("shutting down hawk:");
		for (HModel hm : all) {
			if (hm.isRunning()) {
				System.out.println("stopping: " + hm.getName() + " : " + hm.getFolder());
				hm.stop();
			}
		}
		return true;
	}

	private void loadHawksFromMetadata() {
		IEclipsePreferences preferences = InstanceScope.INSTANCE.getNode("org.hawk.ui2");

		try {
			Collection<HawkConfig> hawks = new HashSet<HawkConfig>();

			String xml = preferences.get("config", null);

			if (xml != null) {
				XStream stream = new XStream(new DomDriver());
				stream.processAnnotations(HawksConfig.class);
				stream.processAnnotations(HawkConfig.class);
				stream.setClassLoader(HawksConfig.class.getClassLoader());
				HawksConfig hc = (HawksConfig) stream.fromXML(xml);
				for (HawkConfig s : hc.getConfigs())
					hawks.add(s);
			}

			for (HawkConfig s : hawks) {
				addHawk(HModel.createFromFolder(s, this));
			}

		} catch (Exception e) {
			e.printStackTrace();
			preferences.remove("config");
		}
		firstRun = false;
	}

}
