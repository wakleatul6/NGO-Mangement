
package com.app.test;

import java.util.Scanner;
import com.app.Dto.Profile;
import com.app.Dto.RequestDto;
import com.app.Dto.UserProfile;
import com.app.Dto.DonorLoginDto;
import com.app.Dto.LoginDto;
import com.app.bean.User;
import com.app.dao.DonorLoginDao;
import com.app.dao.LoginDao;
import com.app.dao.RegisterDao;
import com.app.operation.AdminResgisterAndLogin;
import com.app.operation.DonorRegisterAndLogin;

public class Client {

	public static void main(String[] args) throws Exception {
		Scanner sn = new Scanner(System.in);
		String test, donorName = "";
		int choice;
		do {
			System.out.println("---------------Welcome To Symboisis NGO-----------------");

			System.out.println("press 1. User Admin Registration");
			System.out.println("Press 2. Admin Portal");
			System.out.println("press 3. Donor Portal");
			System.out.println("------------End----------------");
			System.out.println("Enter your choice");
			int key = sn.nextInt();
			switch (key) {
			case 1:
				
				
				AdminResgisterAndLogin.userRegistration();
						break;
						
			case 2: // admin Login
				LoginDto LoginDto = new RequestDto().loginRequest();
				Profile profile = new LoginDao().login(LoginDto);
				donorName = profile.getUname();
				if (profile != null && profile.getRole().equals("Admin")) {
					AdminResgisterAndLogin.adminRegistrationAndLogin(sn, donorName);

				} else {
					System.out.println("Sorry Your Not Registered Admin" + "/n" + "Please Contact to User ");
				}	break;

			case 3:
				DonorRegisterAndLogin.donorRegisterandLogin(sn, null, donorName);
				
				
				
				
				break;
			default:
				break;
			}
			System.out.println("do you want to continue...Press-(y):");
			test = sn.next();
		} while (test.equalsIgnoreCase("y"));

	}

	/**
	 * 
	 */
	

}