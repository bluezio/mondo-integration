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
package uk.ac.york.mondo.integration.hawk.servlet.servlets;

import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.server.TServlet;

import uk.ac.york.mondo.integration.api.Hawk;
import uk.ac.york.mondo.integration.hawk.servlet.Activator;

/**
 * Servlet that exposes {@link HawkThriftIface} through the {@link TTupleProtocol}.
 */
public class HawkThriftTupleServlet extends TServlet {
	private static final long serialVersionUID = 1L;

	public HawkThriftTupleServlet() throws Exception {
		this(new HawkThriftIface());
	}

	private HawkThriftTupleServlet(HawkThriftIface iface) {
		super(new Hawk.Processor<Hawk.Iface>(iface), new TTupleProtocol.Factory());
		iface.setArtemisServer(Activator.getInstance().getArtemisServer());
	}
 
}
