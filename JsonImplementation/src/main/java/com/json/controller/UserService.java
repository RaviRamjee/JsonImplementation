package com.json.controller;
import java.util.Arrays;
import java.util.List;

import com.json.bean.User;
public class UserService {
	
	public List<User> getUsers()
	{
		return Arrays.asList(new User(1001,"Rahul","rahul@gmail.com",23,"Banglore"),
				new User(1002,"Sam","sam@gmail.com",25,"Hyderabad"),
				new User(1003,"Chandan","chand@gmail.com",26,"Mumbai"));
	}

}
