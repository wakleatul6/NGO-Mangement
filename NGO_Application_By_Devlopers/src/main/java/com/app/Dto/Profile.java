package com.app.Dto;
public class Profile {

	private String uname;
	private String password;
	private String role;
	public Profile(String uname, String password, String role) {
		super();
		this.uname = uname;
		this.password = password;
		this.role = role;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Profile [uname=" + uname + ", password=" + password + ", role=" + role + "]";
	}
	public Profile() {
		super();
		// TODO Auto-generated constructor stub
	}
	}