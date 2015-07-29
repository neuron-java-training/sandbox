package hu.neuron.java.service.webservice.rest;

import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("resources")
public class ApplicationConfig extends Application {

	public Set<Class<?>> getClasses() {
		return getRestClasses();
	}

	// Auto-generated from RESTful web service wizard
	private Set<Class<?>> getRestClasses() {
		Set<Class<?>> resources = new java.util.HashSet<Class<?>>();

		resources
				.add(hu.neuron.java.service.webservice.rest.UserRestWebService.class);
		return resources;
	}
}