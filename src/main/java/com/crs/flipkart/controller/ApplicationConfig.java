/**
 * 
 */
package com.crs.flipkart.controller;

import org.glassfish.jersey.server.ResourceConfig;

//import com.crs.flipkart.restcontroller;

/**
 * @author Rama
 *
 */
public class ApplicationConfig  extends ResourceConfig{

	public ApplicationConfig() {
	//register(CustomerController.class);
	register(StudentRestApi.class);
	}
	
}
