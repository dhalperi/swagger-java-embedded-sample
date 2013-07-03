package com.wordnik.swagger.sample.resource;

import javax.servlet.ServletConfig;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.Provider;

import com.sun.jersey.spi.inject.SingletonTypeInjectableProvider;

/*
 * Even though the default JaxRsReader doesn't use ServletConfig, Jersey
 * will throw an exception at startup if there's no such provider. Thus,
 * Swagger requires us to set a Provider to inject a null ServletConfig.
 */
@Provider
public class NullServletConfigProvider extends
		SingletonTypeInjectableProvider<Context, ServletConfig> {

	public NullServletConfigProvider() {
		super(ServletConfig.class, null);
	}
}