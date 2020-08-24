package com.json.controller;

import java.io.PrintWriter;

import com.google.api.Logging;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.json.bean.User;

import ObjectifyImplementation.UserImpl;
import ObjectifyImplementation.UserRegister;

public class Test {
	
	public static void main(String[] args) {
		DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
		
		//LoggingOptions.Builder optionsBuilder = LoggingOptions.newBuilder();
		//Logging logging = optionsBuilder.setProjectId("<<PROJECT_ID>>").build().getService();
	
		
	

		
			// creating Entity class object to create entity kind in datastore
			Entity e = new Entity("User","0ecc29db-a795-4206-8b73-0d68aecb239f");

			//e.setProperty("userId",101);
			e.setProperty("userName", "Rahul");
			e.setProperty("userEmail","rahul@yahoomail.com");
			e.setProperty("userAge",23);
			e.setProperty("userAddress","Mumbai");
			ds.put(e);

		
		
	}

}
