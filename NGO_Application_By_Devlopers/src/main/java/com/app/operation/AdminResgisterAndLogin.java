package com.app.operation;

import java.io.IOException;
import java.util.Scanner;

import com.app.Dto.RequestDto;
import com.app.bean.User;
import com.app.dao.RegisterDao;

public class AdminResgisterAndLogin {
	
	public static void adminRegistrationAndLogin(Scanner sn,String donorName) throws Exception, IOException {
		int choice;
		String test1;
		do {

			System.out.println("----------Welcome to Admin Portal---------------");
			System.out.println("1. Project Portal");
			System.out.println("2. Donar Portal");
			System.out.println("3. AddActivity Portal");
			System.out.println("4. Payment Portal");
			System.out.println("!----------------End--------------------------!");
			System.out.println("Enter you choice:");
			choice = sn.nextInt();
			switch (choice) {
			case 1:
				AddProject.addProject();
				break;
			case 2:
				AddAdminDonor.addAdminDonor();
				break;
			case 3:
				AddActivity.addActivity();
				break;
			case 4:
				ReleasePayment.ReleasePayment(donorName);
				break;
			}
			System.out.println("do you want to continue...Press(y):");
			test1 = sn.next();
		} while (test1.equalsIgnoreCase("y"));
	}






public static void userRegistration() {
	System.out.println("--------Welcome to  Admin Register Portal------------");
	
	
	
	
		User user = new RequestDto().registerUser();
		int i = new RegisterDao().userregister(user);
		if (i == 1) {
			System.out.println("Welcome To Symbiosis NGO");
			System.out.println("Record inserted successfully.");
		} else {
			System.out.println("something went wrong");
		}
}}

