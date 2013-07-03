package com.wordnik.swagger.sample.jersey;

import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;
import com.wordnik.swagger.jaxrs.config.BeanConfig;

public final class SampleJaxRsApplication extends PackagesResourceConfig {

	public SampleJaxRsApplication() {
		super("com.wordnik.swagger.sample.resource",
				"com.wordnik.swagger.jaxrs.listing");
		getContainerResponseFilters().add(new SampleCrossOriginFilter());
	}

	public static void main(String[] args) throws Exception {
		final int port = 8002;

		BeanConfig config = new BeanConfig();
		config.setResourcePackage("com.wordnik.swagger.sample.resource");
		config.setVersion("1.0.0");
		config.setBasePath("http://localhost:8002/api");

		SampleJaxRsWebserver server = new SampleJaxRsWebserver(port);
		server.start();
		System.in.read();
		server.stop();
	}

	private class SampleCrossOriginFilter implements ContainerResponseFilter {
		@Override
		public ContainerResponse filter(ContainerRequest request,
				ContainerResponse response) {
			response.getHttpHeaders().add("Access-Control-Allow-Origin", "*");
			response.getHttpHeaders().add("Access-Control-Allow-Methods",
					"GET, POST, DELETE, PUT");
			response.getHttpHeaders().add("Access-Control-Allow-Headers",
					"Content-Type");
			return response;
		}
	}
}