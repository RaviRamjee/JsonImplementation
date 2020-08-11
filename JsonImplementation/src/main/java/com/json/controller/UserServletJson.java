package com.json.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
import com.google.gson.Gson;
import com.google.gson.stream.JsonWriter;
import com.json.bean.User;
import com.json.model.UserJsonImpl;

@WebServlet("/UserServletJson")
public class UserServletJson extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// getting datastore service
	DatastoreService ds = DatastoreServiceFactory.getDatastoreService();

	public UserServletJson() {
		super();

	}
	Gson gson = new Gson();

	/**
	 * response.setContentType("application/json");
	 * response.setCharacterEncoding("UTF-8");
	 * 
	 * List<User> user=new ArrayList(); user=service.getUsers();
	 * 
	 * Gson gson=new Gson(); String json=gson.toJson(user);
	 * System.out.println(json);
	 * 
	 * PrintWriter out=response.getWriter(); out.print(json);
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
         
		// getting data from the html form
		User u = new User();
		try {
			u = extractUserData(User.class, request);
			UserJsonImpl uImpl = new UserJsonImpl();
			uImpl.insert(u);
			response.setContentType("application/json");
            response.getWriter().println(gson.toJson(u));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * private User extractDatafromHtmlForm() { String name
	 * =request.getParameter("name"); String email = request.getParameter("email");
	 * int age = Integer.parseInt(request.getParameter("age")); String address
	 * =request.getParameter("address");
	 * 
	 * User user = new User(); user.setUserId(101); user.setUserName(name);
	 * user.setUserAge(age); user.setUserAddress(address);
	 * 
	 * return user;
	 * 
	 * 
	 * }
	 */

	private <T> T extractUserData(Class<T> t, HttpServletRequest request) throws Exception {
		BufferedReader reader = new BufferedReader(request.getReader());
		String responseString = "";
		String responseJsonString = "";
		while ((responseString = reader.readLine()) != null) {
			responseJsonString += responseString;

		}
		System.out.println(responseJsonString);
		return gson.fromJson(responseJsonString, t);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//int userId=Integer.parseInt(request.getParameter("userId"));
		User u = new User();
		Key key = KeyFactory.createKey("User",101);
		
		Entity e = null;
		try {
			e = ds.get(key);
			System.out.println("the entity value is: " + e);
			response.setContentType("application/json");
            response.getWriter().println(gson.toJson(u));
		} catch (EntityNotFoundException e1) {
			e1.printStackTrace();
		}

	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// creating Entity class object to create entity kind in datastore
		User u = new User();
		try {
			u = extractUserData(User.class, request);
			UserJsonImpl uImpl = new UserJsonImpl();
			uImpl.updateUserData(u);
			response.setContentType("application/json");
            response.getWriter().println(gson.toJson(u));
		} catch (Exception e) {
			e.printStackTrace();
		}  
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Key key = KeyFactory.createKey("User", 101);
		ds.delete(key);
	}

}
