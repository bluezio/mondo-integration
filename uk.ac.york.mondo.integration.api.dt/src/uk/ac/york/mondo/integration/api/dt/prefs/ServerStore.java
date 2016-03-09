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
package uk.ac.york.mondo.integration.api.dt.prefs;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.preference.IPreferenceStore;

public class ServerStore {
	private static final String MONDO_SERVERS_PREFERENCE = "serverURLs";
	private static final String URL_SEPARATOR = ",";

	private final IPreferenceStore prefStore;

	public ServerStore(IPreferenceStore prefStore) {
		this.prefStore = prefStore;
	}

	public List<Server> readAllServers() {
		final String sValue = prefStore.getString(MONDO_SERVERS_PREFERENCE);

		final ArrayList<Server> servers = new ArrayList<>();
		if (!IPreferenceStore.STRING_DEFAULT_DEFAULT.equals(sValue)) {
			String[] urls = sValue.split(URL_SEPARATOR);
			for (String url : urls) {
				servers.add(new Server(url));
			}
		}

		return servers;
	}

	public void saveAllServers(List<Server> servers) {
		StringBuffer sbuf = new StringBuffer();
		boolean first = true;
		for (Server server : servers) {
			if (first) {
				first = false;
			} else {
				sbuf.append(URL_SEPARATOR);
			}
			sbuf.append(server.getBaseURL());
		}
		prefStore.putValue(MONDO_SERVERS_PREFERENCE, sbuf.toString());
	}
}
