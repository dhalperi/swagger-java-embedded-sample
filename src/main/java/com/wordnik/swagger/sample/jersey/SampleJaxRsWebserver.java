package com.wordnik.swagger.sample.jersey;

import java.io.IOException;
import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import org.glassfish.grizzly.http.server.HttpServer;

import com.sun.jersey.api.container.grizzly2.GrizzlyServerFactory;
import com.sun.jersey.api.core.ResourceConfig;

public final class SampleJaxRsWebserver {
	private final HttpServer webServer;

	public SampleJaxRsWebserver(final int port) throws IOException {
		URI baseUri = UriBuilder.fromUri("http://localhost/api").port(port)
				.build();
		ResourceConfig masterApplication = new SampleJaxRsApplication();
		webServer = GrizzlyServerFactory.createHttpServer(baseUri,
				masterApplication);
	}

	public void start() throws Exception {
		webServer.start();
	}

	public void stop() throws Exception {
		webServer.stop();
	}
}