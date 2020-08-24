package com.json.model;

import com.json.bean.User;

import java.util.UUID;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.gson.Gson;
import com.json.controller.UserService;

public class UserJsonImpl {

	// getting datastore service
	DatastoreService ds = DatastoreServiceFactory.getDatastoreService();

	public void insert(User u) {
		// creating Entity class object to create entity kind in datastore
		Entity e = new Entity("User",UUID.randomUUID().toString());

		//e.setProperty("userId",101);
		e.setProperty("userName", u.getUserName());
		e.setProperty("userEmail", u.getUserEmail());
		e.setProperty("userAge", u.getUserAge());
		e.setProperty("userAddress", u.getUserAddress());
		Key key=ds.put(e);
		System.out.println(key);

	}

	//method for update the user data without the key
	public void updateUserData(User u) {
		// creating Entity class object to create entity kind in datastore
		Entity e = new Entity("User");
		//e.setProperty("userId", u.getUserId());
		e.setProperty("userName", u.getUserName());
		e.setProperty("userEmail", u.getUserEmail());
		e.setProperty("userAge", u.getUserAge());
		e.setProperty("userAddress", u.getUserAddress());
		Key key=ds.put(e);
		System.out.println(key);
	}
	
	//method for update the user data with the help of "key"
	public void updateUserDataWithId(User u,String id) {
		// creating Entity class object to create entity kind in datastore
		Entity e = new Entity("User",id);

		//e.setProperty("userId", u.getUserId());
		e.setProperty("userName", u.getUserName());
		e.setProperty("userEmail", u.getUserEmail());
		e.setProperty("userAge", u.getUserAge());
		e.setProperty("userAddress", u.getUserAddress());
		Key key=ds.put(e);
		System.out.println(key);
		
	}
}
