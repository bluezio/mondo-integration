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
package uk.ac.york.mondo.integration.server.gzip;

import java.io.IOException;
import java.util.Collections;
import java.util.Dictionary;
import java.util.Set;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.GZIPOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.equinox.http.jetty.JettyCustomizer;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.servlets.gzip.AbstractCompressedStream;
import org.eclipse.jetty.servlets.gzip.CompressedResponseWrapper;
import org.eclipse.jetty.servlets.gzip.GzipHandler;

public class Customizer extends JettyCustomizer {

	private static final class CustomLevelGzipHandler extends GzipHandler {

		private final int level;

		public CustomLevelGzipHandler(int level) {
			this.level = level;
		}

		@Override
		protected CompressedResponseWrapper newGzipResponseWrapper(HttpServletRequest request, HttpServletResponse response) {
			// This is pretty much a straight copy of the original version, but using a slightly different GZIPOutputStream
			return new CompressedResponseWrapper(request,response)
		    {
		        {
		            super.setMimeTypes(getMimeTypes(), _excludeMimeTypes);
		            super.setBufferSize(getBufferSize());
		            super.setMinCompressSize(getMinGzipSize());
		        }
		        
		        @Override
		        protected AbstractCompressedStream newCompressedStream(HttpServletRequest request,HttpServletResponse response) throws IOException
		        {
		            return new AbstractCompressedStream("gzip",request,this,_vary)
		            {
		                @Override
		                protected DeflaterOutputStream createStream() throws IOException
		                {
		                	return new GZIPOutputStream(_response.getOutputStream(), _bufferSize){{def.setLevel(level);}};			                    	
		                }
		            };
		        }
		    };
		}

		@Override
		public Set<String> getMimeTypes() {
			// MIME types to be compressed
			return Collections.singleton("application/x-thrift");
		}

	}

	@Override
	public Object customizeContext(Object context, Dictionary<String, ?> settings) {
		if (context instanceof ContextHandler) {
			final GzipHandler gzipHandler = new CustomLevelGzipHandler(Deflater.BEST_COMPRESSION);
			gzipHandler.setBufferSize(16384);
			final ContextHandler contextHandler = (ContextHandler)context;
			contextHandler.setHandler(gzipHandler);
		}
		return super.customizeContext(context, settings);
	}
}
