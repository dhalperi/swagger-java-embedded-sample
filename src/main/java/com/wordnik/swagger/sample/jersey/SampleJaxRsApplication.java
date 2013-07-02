package com.wordnik.swagger.sample.jersey;

import javax.servlet.ServletConfig;
import javax.ws.rs.core.Context;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

import com.sun.jersey.api.core.DefaultResourceConfig;
import com.sun.jersey.spi.inject.SingletonTypeInjectableProvider;
import com.wordnik.swagger.sample.resource.PetResource;
import com.wordnik.swagger.sample.resource.PetStoreResource;
import com.wordnik.swagger.sample.resource.SampleExceptionMapper;
import com.wordnik.swagger.sample.resource.UserResource;

public final class SampleJaxRsApplication extends DefaultResourceConfig {

	public SampleJaxRsApplication() {
		/* Swagger BeanConfig. */
		// getSingletons().add(new SampleBeanConfig());
		// getClasses().add(SampleBeanConfig.class);
		/* Swagger writers */
		getClasses()
				.add(com.wordnik.swagger.jaxrs.listing.ResourceListingProvider.class);
		getClasses().add(
				com.wordnik.swagger.jaxrs.listing.ApiDeclarationProvider.class);
		/* JSON mapper. */
		getClasses().add(JacksonJsonProvider.class);
		/* Exception mapper. */
		getClasses().add(SampleExceptionMapper.class);
		/* Application resources. */
		getClasses().add(UserResource.class);
		getClasses().add(PetResource.class);
		getClasses().add(PetStoreResource.class);
		/* Swagger API listing resource. */
		getClasses().add(
				com.wordnik.swagger.jaxrs.listing.ApiListingResourceJSON.class);
		/*
		 * Even though the default JaxRsReader doesn't use ServletConfig, Jersey
		 * will throw an exception at startup if there's no such provider. Thus,
		 * Swagger requires us to set a Provider to inject a null ServletConfig.
		 */
		getSingletons().add(
				new SingletonTypeInjectableProvider<Context, ServletConfig>(
						ServletConfig.class, null) {
				});
		/* Swagger BeanConfig. */
		// getSingletons().add(new SampleBeanConfig());
		// getClasses().add(SampleBeanConfig.class);
	}

	public static void main(String[] args) throws Exception {
		final int port = 8002;
		SampleJaxRsWebserver server = new SampleJaxRsWebserver(port);
		server.start();
		System.in.read();
		server.stop();
	}
}