package com.app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.app.Dto.UserProfile;
import com.app.operation.DonorRegisterAndLogin;
import com.app.test.Client;
import com.app.Dto.DonorLoginDto;
import com.app.Dto.LoginDto;

public class DonorLoginDao {
	Connection con=null;
	PreparedStatement pstmt=null;
	public DonorLoginDao() {
		
	
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	public UserProfile login(DonorLoginDto donor) throws Exception {
		pstmt=con.prepareStatement("select * from donor where volUserId=? and volPass=?");
		pstmt.setString(1, donor.getVolUserId());
		pstmt.setString(2, donor.getVolPass());
		ResultSet rs=pstmt.executeQuery();
		UserProfile userProfile=new UserProfile();
		Scanner sn=new Scanner(System.in);
		if(rs.next()) {
			userProfile.setVolName(rs.getString("volName"));
			userProfile.setVolEmail(rs.getString("volEmail"));
			userProfile.setVolMob(rs.getLong("volMob"));
			userProfile.setVolUserId(rs.getString("volPass"));
			userProfile.setMsg("Welcome to your profile ."+rs.getString("volName")+" login Successfully.");
			
			
			
		}
		else {
			System.out.println("Sorry Your Not Registered " + "\r\n" + "Please Contact to Admin ");
			System.out.println("you Want Go To HomePage.....Press(Y)");
			String test=sn.next();
			if(test.equalsIgnoreCase("y")) {
				Client.main(null);
			}else {
				System.out.println("something went wrong");
			}
		}
		
		return userProfile;
		
	}
}
