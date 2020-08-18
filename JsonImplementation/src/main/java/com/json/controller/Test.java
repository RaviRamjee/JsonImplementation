package com.json.controller;

import com.google.api.Logging;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.json.bean.User;

import JsonImplementation.UserImpl;
import JsonImplementation.UserRegister;

public class Test {
	
	public static void main(String[] args) {
		UserRegister ur=new UserRegister();
		User u = new User();
		ObjectifyService.init();
		
		//LoggingOptions.Builder optionsBuilder = LoggingOptions.newBuilder();
		//Logging logging = optionsBuilder.setProjectId("<<PROJECT_ID>>").build().getService();
	
		u.setUserId("one");
		u.setUserName("Ajay");
		u.setUserEmail("ajay@gmail.com");
		u.setUserAge(25);
		u.setUserAddress("Delhi");
		
		UserImpl uImpl=new UserImpl();
        uImpl.save(u);
	}

}
