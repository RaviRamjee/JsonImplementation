package com.json.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.json.bean.User;

public class UserDataTest {

	@Test
	public void test() {
		
		//getting User class Object
		User user=new User();
		user.setUserId(101);
		user.setUserName("Samrat Kumar");
		user.setUserEmail("samrat@gmail.com");
		user.setUserAge(25);
		user.setUserAddress("Banglore");
		
		assertEquals(101,user.getUserId());
		assertEquals("Samrat Kumar",user.getUserName());
		assertEquals("samrat@gmail.com",user.getUserEmail());
		assertEquals(25,user.getUserAge());
		assertEquals("Banglore",user.getUserAddress());
		
		//if it will be null then throw AssertionError
		assertNotNull(user.getUserName());
		assertNotNull(user.getUserEmail());
	}

}
