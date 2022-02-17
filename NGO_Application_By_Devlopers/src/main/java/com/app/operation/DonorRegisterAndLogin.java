
package com.app.operation;

import java.util.Scanner;
import com.app.Dto.DonorLoginDto;
import com.app.Dto.RequestDto;
import com.app.Dto.UserProfile;
import com.app.dao.DonorLoginDao;




public class DonorRegisterAndLogin {
	public static void donorRegisterandLogin(Scanner sn, RequestDto request,String donorName) throws Exception {
		String choice;
		
			System.out.println("-------------Welcome to Donor Portal--------------");
			
			System.out.println("Donor Login:-");
			
				DonorLoginDto donorLoginDto=new RequestDto().loginDonor();
				UserProfile userProfile=new DonorLoginDao().login(donorLoginDto);
				donorName = userProfile.getVolName();
				if (userProfile != null) {
					System.out.println(userProfile);
				
					do {
						System.out.println("!------------Donor Portal----------------!");
						System.out.println();
						System.out.println("1.Update Your Details");
						System.out.println("2.Donation");
						System.out.println("3.Donation Receipt");
						
						System.out.println();
						System.out.println("!------------END----------------!");
						System.out.println("Enter Your Choice");
						int key1=sn.nextInt();
						switch (key1) {
						case 1:
							AddAdminDonor.donarRequest();
							break;
						case 2:
							AddPayment.makePayment();
							
							break;
						case 3:
							AddPayment.makePdf();
						default:
							break;
						}
					
						System.out.println("do you want to continue...Press-(y):");
						choice = sn.next();
					} while (choice.equalsIgnoreCase("y"));
					
				}else {
				
			
				System.out.println("Invalid Request");}
				
			
	}

}