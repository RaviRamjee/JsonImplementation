package com.json.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.gson.Gson;
import com.json.bean.User;
import com.json.model.UserJsonImpl;

public class UserDatastoreImpl extends HttpServlet {

	// getting datastore service
	DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
	Gson gson = new Gson();
	
	//extracting user data from html form
	private User extractDatafromHtmlForm(HttpServletRequest request) {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		int age = Integer.parseInt(request.getParameter("age"));
		String address = request.getParameter("address");

		User user = new User();
		// user.setUserId("one");
		user.setUserName(name);
		user.setUserEmail(email);
		user.setUserAge(age);
		user.setUserAddress(address);

		return user;

	}
	
	/**private <T> T extractUserData(Class<T> t, HttpServletRequest request) throws Exception {
		BufferedReader reader = new BufferedReader(request.getReader());
		String responseString = "";
		String responseJsonString = "";
		while ((responseString = reader.readLine()) != null) {
			responseJsonString += responseString;

		}
		System.out.println(responseJsonString);
		return gson.fromJson(responseJsonString, t);
	}*/

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		/**
		    getting the name from the html form 
		    comparing the string which is comming from the html form  for update action     
		    comparing the string which is comming from the html form for delete action  
		 */
		String req=request.getParameter("put");
		if(req.equals("update")) 
		{
			this.doPut(request, response); //calling doPost method for update
		}
		else if(req.equals("delete")) 
		{
			this.doDelete(request, response); //calling doDolete method for delete user data
		}else
		{
			/**
			      extracting the user details from datastore
			 */
		String id=request.getParameter("Id");
		User u = new User();
		Key key = KeyFactory.createKey("User",id);

		Entity e = null;
		try {
			e = ds.get(key); //getting the key from the datastore 
			System.out.println("the entity value is: " + e); 
			response.setContentType("application/json");
            response.getWriter().println(gson.toJson(u));
            PrintWriter out=response.getWriter();
            out.print(e); //printing the details of the user on the web brower
		} catch (EntityNotFoundException e1) {
			e1.printStackTrace();
		}
		}
		
		/** for getting all the user data with order
		 * 
		 * Query q=new Query("User").addSort("userName",Query.SortDirection.ASCENDING);
		 * PreparedQuery pq=ds.prepare(q); for(Entity e1:pq.asIterable()) {
		 * System.out.println(e1.getProperty("userName").toString());
		 * System.out.println(e1.getProperty("userEmail").toString());
		 * System.out.println(e1.getProperty("userAge").toString());
		 * System.out.println(e1.getProperty("userAddress").toString()); }
		 */
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

        
		// getting data from the html form
		User u = new User();
		try {
			u = extractDatafromHtmlForm(request);
			UserJsonImpl uImpl = new UserJsonImpl();
			uImpl.insert(u); //calling insert method for insert the data in datastore
           //response.sendRedirect("./UserDetails.html");
		} catch (Exception e) {
			e.printStackTrace();
		}
		PrintWriter out=response.getWriter();
		out.print("Inserted succesfully");
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		    String id=request.getParameter("Id");
		
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			int age = Integer.parseInt(request.getParameter("age"));
			String address = request.getParameter("address");
 
			// creating Entity class object to create entity kind in datastore
			User user = new User();
			// user.setUserId("one");
			user.setUserName(name);
			user.setUserEmail(email);
			user.setUserAge(age);
			user.setUserAddress(address);
			UserJsonImpl uImpl = new UserJsonImpl();
			//calling updateUserDataWithId method for updating the user data in datastore
			uImpl.updateUserDataWithId(user,id);
			
			PrintWriter out=response.getWriter();
			out.print("Updated succesfully");
			/**response.setContentType("application/json");
            response.getWriter().println(gson.toJson(u));*/
		
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id=request.getParameter("Id");
		Key key = KeyFactory.createKey("User", id);
		ds.delete(key);
		
		PrintWriter out=response.getWriter(); //printing message on the web browser
		out.print("Deleted succesfully");
	}

}
