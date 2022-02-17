package com.app.operation;
import java.util.List;
import java.util.Scanner;

import com.app.Dto.RequestDto;
import com.app.bean.Donor;
import com.app.dao.DonorDao;
import com.app.dao.impl.DonorDaoImpl;

public class AddAdminDonor {
	public RequestDto request;
	public String choice;
	
	/**
	 * @param sn
	 * @param empDao
	 */

		
	
	public static void addAdminDonor()
	{
		DonorDaoImpl empDao1=new DonorDaoImpl();
		Scanner sn=new Scanner(System.in);
		int choice;
		System.out.println("!----------------Doner Poratal-------!");
		System.out.println("1. Add Donor");
		System.out.println("2. Update Donor Details");
		System.out.println("3. Delete Donor");
		System.out.println("4. All Donors List");
		System.out.println("5. Get Single Donor Details");
		System.out.println("!----------------End--------------------------!");
		System.out.println("Enter you choice:");
		choice=sn.nextInt();
		
		switch (choice) {
		case 1:
			request();
			break;
		case 2:
			donarRequest();
			break;
		case 3:
			deleteDonorRequest();
			break;
		case 4:
			allDataDonorRequest();
			break;
		case 5:
			singleDataDonorRequest();
			break;
		
			
		default:
			break;
		}
	}
	/**
	 * @param sn
	 * @param empDao1
	 */
	private static void singleDataDonorRequest() {
		Scanner sn=new Scanner(System.in);
	 DonorDao empDao1=new DonorDaoImpl();
		System.out.println("Enter your id:");
		int empId=sn.nextInt();
		
		List<Donor> emp1=empDao1.getDonor(empId);
		if(emp1!=null)
		{
			for(Donor e:emp1) {
				System.out.println(e.getVolUserId()+"\t"+e.getVolName()+"\t"
			+e.getVolMob()+"\t"+e.getVolEmail());
			}
		}else {
			System.out.println("Data Not Inserted something went wrong..!");
		}
	}
	/**
	 * @param empDao1
	 */
	private static void allDataDonorRequest() {
		
		 DonorDao empDao1=new DonorDaoImpl();
		List<Donor> list=empDao1.listDonor();
		if(list!=null)
		{
			for(Donor e:list) {
				System.out.println(e.getVolUserId()+"\t"+e.getVolName()+"\t"
			+e.getVolEmail()+"\t"+e.getVolMob());
			}
		}else {
			System.out.println("something went wrong..!");
		}
	}
	/**
	 * @param sn
	 * @param empDao1
	 */
	public static void deleteDonorRequest() {
		Scanner sn=new Scanner(System.in);
		 DonorDao empDao1=new DonorDaoImpl();
		System.out.println("Enter your id:");
		int volId=sn.nextInt();
		

		int row=empDao1.deleteData(volId);
		if(row==1)
		{
			System.out.println("Data deleted successfully.");
		}else {
			System.out.println("Data Not Inserted something went wrong..!");
		}
	}
	/**
	 * @param sn
	 * @param empDao
	 */
	public static void request() {
		Scanner sn=new Scanner(System.in);
		Donor donor=new Donor();
		 DonorDao empDao=new DonorDaoImpl();
		System.out.println("Enter your Donor id:");
		int id=sn.nextInt();
		System.out.println("Enter your Donor name:");
		String name=sn.next();
		System.out.println("Enter your Donor User_Name:");
		String user_name=sn.next();
		System.out.println("Enter your Donor Password:");
		
		System.out.println("Password Must be"+"\r\n"+"One UpperCase"+"\r\n"+"One LowerCase"+"\r\n"+"One Number"+"\r\n"+"One Character");
		String pass=sn.next();
		String regex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}$";
		System.out.println("Enter your Donor mobile_number:");
		long mol_Num=sn.nextLong();
		System.out.println("Enter your Donor Email_Id");
		String email_Id=sn.next();
		        boolean validPassword = isValidPassword(pass,regex);
        if(validPassword==true){
        	donor.setVolPass(pass);
        	Donor emp =new Donor(id, name, user_name, email_Id, mol_Num, pass);
    		int i=empDao.insertData(emp);
    		
    		if(i==1)
    		{
    			System.out.println("Data inserted successfully.");
    		}else {
    			System.out.println("Data Not Inserted something went wrong..!");
    		}
        			
        }
        else {
        	System.out.println("Enter valid  password:" );
    		String password1=sn.next();
    		donor.setVolPass(password1);
    		Donor emp =new Donor(id, name, user_name, email_Id, mol_Num, password1);
    		int i=empDao.insertData(emp);
    		
    		if(i==1)
    		{
    			System.out.println("Data inserted successfully.");
    		}else {
    			System.out.println("Data Not Inserted something went wrong..!");
    		}
        }
                }
	private static boolean isValidPassword(String pass, String regex) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * @param sn
	 * @param empDao
	 */
	public static void donarRequest() {
		Donor donor=new Donor();
		DonorDao empDao=new DonorDaoImpl();
		Scanner sn=new Scanner(System.in);
		System.out.println("Enter your Donor id:");
		int id1=sn.nextInt();
		System.out.println("Enter your Donor name:");
		String name1=sn.next();
		System.out.println("Enter your Donor User_Name:");
		String user_name1=sn.next();
		System.out.println("Enter your Donor mobile_number:");
		long mol_Num1=sn.nextLong();
		System.out.println("Enter your Donor Email_Id");
		String email_Id1=sn.next();
		System.out.println("Enter Your Donor Passward");
		System.out.println("Password Must be"+"\r\n"+"One UpperCase"+"\r\n"+"One LowerCase"+"\r\n"+"One Number"+"\r\n"+"One Character");
		String pass=sn.next();
		String regex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}$";
        boolean validPassword = isValidPassword(pass,regex);
        if(validPassword==true){
        	donor.setVolPass(pass);
        	Donor emp5 =new Donor(id1, name1, user_name1, email_Id1, mol_Num1, pass);
    		int i2=empDao.insertData(emp5);
    		
    		if(i2==1)
    		{
    			System.out.println("Data updated successfully.");
    		}else {
    			System.out.println("Data Not updated something went wrong..!");
    		}
        			
        }
        else {
        	System.out.println("Enter valid  password:" );
    		String password1=sn.next();
    		donor.setVolPass(password1);
    		Donor emp5 =new Donor(id1, name1, user_name1, email_Id1, mol_Num1, password1);
    		int i2=empDao.updateData(emp5);
    		
    		if(i2==1)
    		{
    			System.out.println("Data updated successfully.");
    		}else {
    			System.out.println("Data Not updated something went wrong..!");
    		}
        }
		
	}
		}
		

