package com.json.bean;

import com.googlecode.objectify.annotation.Id;

public class User {
	
	@Id
	private int user_id;
	private String user_name;
	private String user_email;
	private int user_age;
	private String user_address;
	
	public User() {} 
	
	public User(int user_id, String user_name, String user_email, int user_age, String user_address) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_email = user_email;
		this.user_age = user_age;
		this.user_address = user_address;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name + ", user_email=" + user_email + ", user_age="
				+ user_age + ", user_address=" + user_address + "]";
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public int getUser_age() {
		return user_age;
	}
	public void setUser_age(int user_age) {
		this.user_age = user_age;
	}
	public String getUser_address() {
		return user_address;
	}
	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}
	
}