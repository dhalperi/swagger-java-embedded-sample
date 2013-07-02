package com.wordnik.swagger.sample.jersey;

import com.wordnik.swagger.jaxrs.config.BeanConfig;

public class SampleBeanConfig extends BeanConfig {
	public SampleBeanConfig() {
		setResourcePackage("com.wordnik.swagger.sample.resource");
		setVersion("1.0.0");
		setBasePath("http://localhost:8002/api");
	}
}