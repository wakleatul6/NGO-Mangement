package com.app.dao;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.app.Dto.LoginDto;
import com.app.Dto.Profile;
import com.app.test.Client;

public class LoginDao {

	Connection con = null;
	PreparedStatement pstmt = null;

	public LoginDao() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public Profile login(LoginDto LoginDto) throws Exception {
		pstmt = con.prepareStatement("select * from user where uname=? and password=?");
		pstmt.setString(1, LoginDto.getUname());
		pstmt.setString(2, LoginDto.getPassword());
		ResultSet rs = pstmt.executeQuery();
		com.app.Dto.Profile profile = new com.app.Dto.Profile();
		Scanner sn=new Scanner(System.in);
		if (rs.next()) {
			profile.setUname(rs.getString("uname"));
			profile.setPassword(rs.getString("password"));
			profile.setRole(rs.getString("role"));
			
		} else {
			System.out.println("Sorry Your Not Registered Admin" + "\r\n" + "Please Contact to User ");
			System.out.println("you Want Go To HomePage.....Press(Y)");
			String test=sn.next();
			if(test.equalsIgnoreCase("y")) {
				Client.main(null);
			}else {
				System.out.println("something went wrong");
			}
				
		}
		return profile;
	}
}

  	