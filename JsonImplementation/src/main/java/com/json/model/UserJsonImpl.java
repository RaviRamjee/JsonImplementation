package com.json.model;

import com.json.bean.User;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.gson.Gson;
import com.json.controller.UserService;

public class UserJsonImpl {
	
	    //getting datastore service
		DatastoreService ds=DatastoreServiceFactory.getDatastoreService();
		
		public void insert(User u)
		{
			    //creating Entity class object to create entity kind in datastore
			    Entity e=new Entity("User");
			    
			    //e.setProperty("user_id", u.getUser_id());
			    e.setProperty("user_name", u.getUser_name());
			    e.setProperty("user_email", u.getUser_email());
			    e.setProperty("user_age", u.getUser_age());
			    e.setProperty("user_address", u.getUser_address());
			    ds.put(e);
			    
		 
		}		   

}
