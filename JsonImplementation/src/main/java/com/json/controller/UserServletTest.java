package com.json.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.json.bean.User;
import com.json.model.UserJsonImpl;

public class UserServletTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserServletTest() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

		// getting data from the html form
		User user = new User();
		try {
			user = extractDatafromHtmlForm(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		User u = jsonConversion(user); //it return the converted User object from json formate 
		UserJsonImpl uimpl = new UserJsonImpl(); 
		uimpl.insert(setUserData(u));  //setting properties of Datastore 
	}
    
	//method for json conversion into object and vice-versa
	public User jsonConversion(User user) {
		// getting Gson Object
		Gson json = new Gson();
		String s = json.toJson(user);
		System.out.println(s);
		User u = json.fromJson(s, User.class);
		return u;

	}

	// method for set the user data with setter method
	public User setUserData(User u) {
		User user1 = new User();
		user1.setUserName(u.getUserName());
		user1.setUserEmail(u.getUserEmail());
		user1.setUserAge(u.getUserAge());
		user1.setUserAddress(u.getUserAddress());

		return user1;

	}

	//extracting data from the html form
	private User extractDatafromHtmlForm(HttpServletRequest request) {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		int age = Integer.parseInt(request.getParameter("age"));
		String address = request.getParameter("address");

		User user = new User();
		user.setUserId("one");
		user.setUserName(name);
		user.setUserAge(age);
		user.setUserAddress(address);

		return user;

	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
