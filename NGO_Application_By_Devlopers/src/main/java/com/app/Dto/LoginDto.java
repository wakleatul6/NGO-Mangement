package com.app.Dto;

public class LoginDto {


	private String uname;
	private String password;

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
	public LoginDto(String uname, String password) {
		super();
		this.uname = uname;
		this.password = password;
	}
	public LoginDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
