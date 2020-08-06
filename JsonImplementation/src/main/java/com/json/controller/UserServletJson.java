package com.json.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.stream.JsonWriter;
import com.json.bean.User;
import com.json.model.UserJsonImpl;

@WebServlet("/UserServletJson")
public class UserServletJson extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserServletJson() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*
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

		// getting data from the html form
		User u=new User();
		try {
	     u = extractUserData(request);
		} catch (Exception e) {
			e.printStackTrace();
		} 
        
		// getting Gson Object
		/*Gson json = new Gson();
		String s = json.toJson(user);
		System.out.println(s);
		User u = json.fromJson(s, User.class);*/

		User user1 = new User();
		user1.setUser_name(u.getUser_name());
		user1.setUser_email(u.getUser_email());
		user1.setUser_age(u.getUser_age());
		user1.setUser_address(u.getUser_address());

		UserJsonImpl uimpl = new UserJsonImpl();
		uimpl.insert(user1);

	}

	/*private User extractDatafromHtmlForm(HttpServletRequest request)
	{
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		int age = Integer.parseInt(request.getParameter("age"));
		String address = request.getParameter("address");
		
		User user = new User();
		user.setUser_id(101);
		user.setUser_name(name);
		user.setUser_age(age);
		user.setUser_address(address);
		
		return user;
		
		
	}*/
	
	private  User extractUserData(HttpServletRequest request) throws Exception
	{
		BufferedReader reader = new BufferedReader(request.getReader());
		String responseString="";
		String responseJsonString="";
		while ((responseString = reader.readLine()) != null)
		{
		responseJsonString += responseString;
		
		}
		System.out.println(responseJsonString);
		Gson gson=new Gson();
		return gson.fromJson(responseJsonString, User.class);
		
	}
	
	
	
	
	
	
}
