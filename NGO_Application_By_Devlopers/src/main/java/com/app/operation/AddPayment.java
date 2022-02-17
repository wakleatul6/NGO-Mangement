package com.app.operation;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.app.Dto.DonationDto;
import com.app.Dto.RequestDto;
import com.app.bean.Activity;
import com.app.bean.Payment;
import com.app.bean.Project;
import com.app.dao.ActivityDao;
import com.app.dao.impl.ActivityImpl;
import com.app.dao.impl.PaymentImpl;
import com.app.dao.impl.ProjectDaoImpl;



public class AddPayment {
	public static void AddPayment(String donorName) throws IOException, SQLException {
	Scanner sn= new  Scanner(System.in);
	String test;
	do {
		System.out.println("-----------------Admin Payment Portal------------------");
		System.out.println("1.List of Donation Details");
		System.out.println("2.Make Payment");
		System.out.println("3.Maximum Amount Donation");
		System.out.println("4.You Want Receipt");
		System.out.println("!----------------End--------------------------!");
		System.out.println("Enter you choice:");
		int key=sn.nextInt();
		switch (key) {
		case 1:
			ListOfDonation();
			break;

		case 2:
			
			makePayment();

			break;
		case 3:
			
			maximumDonation();
		
			break;
			
		case 4:
			makePdf();
			break;	
		}
		System.out.println("do you want to continue...Press -(y):");
		 test = sn.next();
	} while (test.equalsIgnoreCase("y"));

	}
	/**
	 * @throws SQLException
	 */
	public static void maximumDonation() throws SQLException {
		Connection	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
		PreparedStatement	pstmt = con.prepareStatement("select max(amount) from donation_details  ");
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				
		
		double amount=rs.getDouble(1);
		List<Payment> emp1=new PaymentImpl().getMaxAmount(amount);
		if(emp1!=null) {
			for(Payment e:emp1) {
			System.out.println(e.getPay_ID()+"\t"+e.getDoner()+"\t"+e.getProject_Name()+"\t"+e.getActivity()+"\t"+e.getAmount()+"\t"+e.getDate());
			
		}
		}
			}
	}
	/**
	 * @throws IOException
	 * @throws SQLException 
	 */
	public static void makePdf() throws IOException, SQLException {
		Connection	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
		PreparedStatement	pstmt = con.prepareStatement("select * from donation_details order by payment_Id desc limit 1  ");
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
		
		int payment_Id=rs.getInt(1);
		List<Payment> emp1=new PaymentImpl().getOneDetails(payment_Id);
		Scanner sn=new Scanner(System.in);
		if(emp1!=null)
		{
			for(Payment e:emp1) {
				System.out.println("enter your file name");
				String txt=sn.next();
				File file=new File("D:\\Receipt\\"+txt+".txt");
				FileWriter fw=new FileWriter(file,true);
				fw.write("\r\n"+" Thanks For Viste Symboisis NGO");
				fw.write("\r\n"+"Payment ID=" +e.getPay_ID() );
				fw.write("\r\n"+"Name="+e.getDoner());
				fw.write("\r\n"+ "Project Name="+e.getProject_Name());
				fw.write("\r\n"+"Activity Name="+e.getActivity());
				fw.write("\r\n"+"Amount="+e.getAmount()+"Rs");
				fw.write("\r\n"+"Date="+e.getDate());
				System.out.println("Receipt Save Succesfully");
				fw.close();
			}
		}else {
			System.out.println("something went wrong..!");
		}
	
	}
	}
	/**
	 * 
	 */
	public static void ListOfDonation() {
		List<Payment> list=new PaymentImpl().listDonationDto();
		if(list!=null)
		{
			for(Payment e:list) {
				System.out.println("Payment ID"+"\t"+"Doner"+"\t"+"ProjectName"+"\t"+"Activity"+"\t"+"Amount"+"\t"+"Date");
				System.out.println(e.getPay_ID()+"\t"+e.getDoner()+"\t"+e.getProject_Name()+"\t"+e.getActivity()+
						"\t"+e.getAmount()+"\t"+e.getDate());
			}
		}else {
			System.out.println("something went wrong..!");
		}
	}
	
	
	
	////Make Payment
	
	
		public static void makePayment() throws IOException, SQLException {
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
			System.out.println("Enter Your Name");
			String donorName=sn.next();
			System.out.println("Enter your  Payment Amount:");
			double amount = sn.nextDouble();
			PaymentImpl impl = new PaymentImpl();
		//	Payment payment = new RequestDto().paymentRequest();
			impl.MackPaymnetTONGO(id, donorName, amount);
			System.out.println("Payment Successful");
			System.out.println("You Want Payment Receipt.......Press (y)");
			String test=sn.next();
			if(test.equalsIgnoreCase("y")) {
				makePdf();
			}
			
	
			
			
		}
  }

  