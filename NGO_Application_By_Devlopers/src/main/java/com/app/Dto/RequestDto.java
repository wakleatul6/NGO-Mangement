package com.app.Dto;

import java.time.LocalDate;
import java.util.Scanner;

import com.app.bean.Activity;
import com.app.bean.Donor;
import com.app.bean.Payment;
import com.app.bean.Project;
import com.app.bean.User;

public class RequestDto {
	Scanner sn = new Scanner(System.in);

	public User registerUser() {
		User user = new User();
		System.out.println("Enter your userName:");
		String uname = sn.next();
		System.out.println("Enter your password:");

		System.out.println("Password Must be*"+"\t"+"One UpperCase*"+"\t"+"One LowerCase*"+"\t"+"One Number*"+"\t"+"One Character*");
		String password = sn.next();
		String regex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}$";
		boolean validPassword = isValidPassword(password, regex);
		if (validPassword == true) {
			user.setPassword(password);
			System.out.println("Enter valid  password:");
			String password1 = sn.next();
		} else {
			System.out.println("Enter valid  password:");
			String password1 = sn.next();
			user.setPassword(password1);
		}

		System.out.println("Enter your Role:");
		String role = sn.next();
		user.setUname(uname);
		user.setRole(role);
		return user;
	}

	private boolean isValidPassword(String password, String regex) {
		// TODO Auto-generated method stub
		return false;
	}

	public Donor registeRequest() {
		Donor donor = new Donor();
		System.out.println("Enter your ID");
		int volId = sn.nextInt();
		System.out.println("Enter your Name");
		String volName = sn.next();

		System.out.println("Enter your email:");
		String volEmail = sn.next();
		System.out.println("Enter your mobile:");
		long volMob = sn.nextLong();
		System.out.println("Enter your userName:");
		String volUserId = sn.next();

		System.out.println("Enter your password:");
		System.out.println("Password Must be*"+"\t"+"One UpperCase*"+"\t"+"One LowerCase*"+"\t"+"One Number*"+"\t"+"One Character*");
		String volPass = sn.next();
		String regex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}$";
		boolean validPassword = isValidPassword(volPass, regex);
		if (validPassword == true) {
			donor.setVolPass(volPass);
			return new Donor(volId, volUserId, volName, volEmail, volMob, volPass);
		} else {
			System.out.println("Enter valid  password:");
			String password1 = sn.next();
			donor.setVolPass(password1);
			return new Donor(volId, volUserId, volName, volEmail, volMob, password1);
		}

	}

	public LoginDto loginRequest() {
		System.out.println("Enter your userName:");
		String uname = sn.next();
		System.out.println("Enter your password:");
		String password = sn.next();

		return new LoginDto(uname, password);
	}

	public Payment paymentRequest() {

		Activity act = new Activity();
		System.out.println("Enter your Doner Name:");
		String uname = sn.next();
		System.out.println("Enter your ProjectName:");
		String projectName = sn.next();
		System.out.println("Enter your Activity:");
		String activity = sn.next();
		System.out.println("Enter your Amount:");
		double amount = sn.nextDouble();
		return new Payment(uname, projectName, activity, amount, LocalDate.now());
	}
	
	public DonorLoginDto loginDonor() {
		System.out.println("Enter your userName:");
		String uname = sn.next();
		System.out.println("Enter your password:");
		String password = sn.next();

		return new DonorLoginDto(uname, password);
	}

}