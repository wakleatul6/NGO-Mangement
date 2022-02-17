package com.app.operation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.app.bean.Activity;
import com.app.bean.PaymentRelease;
import com.app.bean.Project;
import com.app.dao.impl.ActivityImpl;
import com.app.dao.impl.PaymentImpl;
import com.app.dao.impl.PaymentReleaseImpl;
import com.app.dao.impl.ProjectDaoImpl;

public class ReleasePayment {
	public static void ReleasePayment(String donorName) throws IOException, SQLException {
		Scanner sn= new  Scanner(System.in);
		String test;
		do {
			System.out.println("-----------------Admin Payment Portal------------------");
			System.out.println("1.List of Donation Details");
			System.out.println("2 Payment Release");
			System.out.println("3.Maximum Amount Donation");
			
			System.out.println("!----------------End--------------------------!");
			System.out.println("Enter you choice:");
			int key=sn.nextInt();
			switch (key) {
			case 1:
				AddPayment.ListOfDonation();
				break;

			case 2:
				
				makePayment();

				break;
			case 3:
				
				AddPayment.maximumDonation();
			
			}
			System.out.println("do you want to continue...Press -(y):");
			 test = sn.next();
		} while (test.equalsIgnoreCase("y"));

		}
		
		public static void listPaymentReleases() {
			List<PaymentRelease> list=new PaymentReleaseImpl().listPaymentReleases();
			if(list!=null)
			{
				for(PaymentRelease e:list) {
					System.out.println(e.getPay_ID()+"\t"+e.getSchemeName()+"\t"+e.getProject_Name()+"\t"+e.getActivity()+
							"\t"+e.getAmount()+"\t"+e.getDate());
				}
			}else {
				System.out.println("something went wrong..!");
			}
		}
		
		////Make Payment
		
		
		
			public static void makePayment() {
				Scanner sn=new Scanner(System.in);
				List<Project>list1=new ProjectDaoImpl().listProjects();
				System.out.println("id"+ "\t" +"name");
				for (Project pProject : list1) {
					System.out.println(pProject.getProId()+"\t" + pProject.getProjectName());
				}
				System.out.println("Enter your Project Id for payment:");
				int id = sn.nextInt();
				List<Activity> list = new ActivityImpl().getProjectactivity(id);
				System.out.println("id"+ "\t" +"name");
				for (Activity pActivity : list) {
					System.out.println(pActivity.getActId()+"\t" + pActivity.getActivity());
				}
				System.out.println("Enter your Activity Id for payment:");
				int id1 = sn.nextInt();
				System.out.println("Enter Your Scheme Name");
				String SchemeName=sn.next();
				System.out.println("Enter your  Payment Amount:");
				double amount = sn.nextDouble();
				PaymentReleaseImpl impl = new PaymentReleaseImpl();
			//	Payment payment = new RequestDto().paymentRequest();
				impl.MackPaymnetTONGO(id, SchemeName, amount);
				
				
		
				
				
			}
	  }

