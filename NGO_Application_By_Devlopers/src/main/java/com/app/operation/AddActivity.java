
package com.app.operation;

import java.util.List;
import java.util.Scanner;

import com.app.bean.Activity;
import com.app.bean.Project;
import com.app.dao.ActivityDao;
import com.app.dao.impl.ActivityImpl;
import com.app.dao.impl.ProjectDaoImpl;

public class AddActivity {
	public static void addActivity() {
		int choice;
		Scanner sn=new Scanner(System.in);
		ActivityDao empDao=new ActivityImpl();
		System.out.println("!------------Project Activity Portal----------------!");
		System.out.println("1.Add Activity ");
		System.out.println("2.Update Activity Details");
		System.out.println("3.Delete Activity");
		System.out.println("4.All Activitys List");
		System.out.println("5.Get Single Activity Details");
		System.out.println("!----------------End--------------------------!");
		System.out.println("Enter you choice:");
		choice=sn.nextInt();
		
		switch (choice) {
		case 1:
			List<Project> projects=new ProjectDaoImpl().listProjects();
			System.out.println("Project ID"+"\t"+"Project Name");
			for(Project project:projects) {
				System.out.println(project.getProId()+"\t"+project.getProjectName());
			}
			System.out.println("Enter your Project Id for Activity:");
			int projectId=sn.nextInt();
			
			insertActivityRequest(empDao, projectId);
			break;
		case 2:
			updateActivityRequest(empDao, sn);
			break;
		case 3:
			deleteActivityRequest(empDao, sn);
			break;
		case 4:
			allActivityListRequest(empDao);
			break;
		case 5:
			singleActivityRequest(empDao, sn);
			break;

		default:
			break;
}
	}

	/**
	 * @param empDao
	 * @param sn
	 */
	private static void singleActivityRequest(ActivityDao empDao, Scanner sn) {
		System.out.println("Enter your id:");
		int empId=sn.nextInt();
		
		List<Activity> emp1=empDao.getActivity(empId);
		if(emp1!=null)
		{
			for(Activity e:emp1) {
				System.out.println(e.getActId()+"\t"+e.getActivity());
			}
		}else {
			System.out.println("something went wrong..!");
		}
	}

	/**
	 * @param empDao
	 */
	private static void allActivityListRequest(ActivityDao empDao) {
		List<Activity> list=empDao.listActivity();
		if(list!=null)
		{
			for(Activity e:list) {
				System.out.println(e.getActId()+"\t"+e.getActivity());
			}
		}else {
			System.out.println("something went wrong..!");
		}
	}

	/**
	 * @param empDao
	 * @param sn
	 */
	private static void deleteActivityRequest(ActivityDao empDao, Scanner sn) {
		System.out.println("Enter your AddActivity id:");
		int actId=sn.nextInt();
		

		int row=empDao.deleteData(actId);
		if(row==1)
		{
			System.out.println("Data deleted successfully.");
		}else {
			System.out.println("Data Not deleted something went wrong..!");
		}
	}

	/**
	 * @param empDao
	 * @param sn
	 */
	private static void updateActivityRequest(ActivityDao empDao, Scanner sn) {
		System.out.println("Enter your Activity id:");
		int actId1=sn.nextInt();
		System.out.println("Enter your Activity name:");
		String activity2=sn.next();
		Activity emp5=new Activity(actId1,activity2);
		int i2=empDao.updateData(emp5);
		if(i2==1)
		{
			System.out.println("Data update successfully.");
		}else {
			System.out.println("Data Not update something went wrong..!");
		}
	}

	/**
	 * @param empDao
	 * @param sn
	 */
	private static void insertActivityRequest(ActivityDao empDao, int id) {
		System.out.println("Enter Your Activity Name");
		String activity=new Scanner(System.in).next();
		Activity emp=new Activity( activity);
		emp.setProId(id);
		int i1=empDao.insertData(emp);
		if(i1==1) {
			System.out.println("Data inserted Successfully.");
		}
		else {
			System.out.println("Data Not Insrted Something Went Wrong...!");
		}
	}
}
