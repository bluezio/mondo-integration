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
package uk.ac.york.mondo.integration.hawk.remote.thrift;

import java.io.File;
import java.io.IOException;

import org.apache.thrift.transport.TTransportException;
import org.hawk.core.IConsole;
import org.hawk.core.ICredentialsStore;
import org.hawk.core.IHawk;
import org.hawk.core.IModelIndexer;

import uk.ac.york.mondo.integration.api.Hawk.Client;
import uk.ac.york.mondo.integration.api.utils.APIUtils;
import uk.ac.york.mondo.integration.api.utils.APIUtils.ThriftProtocol;

public class ThriftRemoteHawk implements IHawk {

	private final Client client;
	private final IConsole console;
	private ThriftRemoteModelIndexer indexer;
	private File folder;

	public ThriftRemoteHawk(String name, String location, File parentFolder, ICredentialsStore credStore, IConsole console, ThriftProtocol thriftProtocol) throws TTransportException, IOException {
		this.console = console;
		this.client = APIUtils.connectToHawk(location, thriftProtocol);
		this.folder = parentFolder;
		this.indexer = new ThriftRemoteModelIndexer(name, parentFolder, client, credStore, console);
	}

	@Override
	public IModelIndexer getModelIndexer() {
		return indexer;
	}

	@Override
	public String getDbtype() {
		return null;
	}

	@Override
	public void setDbtype(String dbtype) {
		console.printerrln(String.format(
				"WARN: %s does not allow for changing the DB type - ignoring",
				this.getClass().getName()));
	}

	@Override
	public boolean exists() {
		return folder != null && folder.exists();
	}

}
