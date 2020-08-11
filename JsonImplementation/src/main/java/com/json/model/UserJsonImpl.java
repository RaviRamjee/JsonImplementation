package com.json.model;

import com.json.bean.User;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.gson.Gson;
import com.json.controller.UserService;

public class UserJsonImpl {

	// getting datastore service
	DatastoreService ds = DatastoreServiceFactory.getDatastoreService();

	public void insert(User u) {
		// creating Entity class object to create entity kind in datastore
		Entity e = new Entity("User",101);

		e.setProperty("userId", u.getUserId());
		e.setProperty("userName", u.getUserName());
		e.setProperty("userEmail", u.getUserEmail());
		e.setProperty("userAge", u.getUserAge());
		e.setProperty("userAddress", u.getUserAddress());
		ds.put(e);

	}

	public void updateUserData(User u) {
		// creating Entity class object to create entity kind in datastore
		Entity e = new Entity("User",102);

		e.setProperty("userId", u.getUserId());
		e.setProperty("userName", u.getUserName());
		e.setProperty("userEmail", u.getUserEmail());
		e.setProperty("userAge", u.getUserAge());
		e.setProperty("userAddress", u.getUserAddress());
		ds.put(e);
	}
}
