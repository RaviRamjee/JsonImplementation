package com.json.controller;
import java.util.Arrays;
import java.util.List;

import com.json.bean.User;
public class UserService {
	
	public List<User> getUsers()
	{
		return Arrays.asList(new User("one","Rahul","rahul@gmail.com",23,"Banglore"),
				new User("two","Sam","sam@gmail.com",25,"Hyderabad"),
				new User("three","Chandan","chand@gmail.com",26,"Mumbai"));
	}

}
