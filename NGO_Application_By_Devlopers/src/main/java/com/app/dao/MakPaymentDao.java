package com.app.dao;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class MakPaymentDao {

	Connection con=null;
	PreparedStatement pstmt=null;
	public MakPaymentDao() {
		
	
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
