package com.app.operation;

import java.util.List;
import java.util.Scanner;

import com.app.Dto.RequestDto;
import com.app.bean.Project;
import com.app.dao.impl.ProjectDaoImpl;

public class AddProject {
	
	public RequestDto request;
	public String choice;

	
	/**
	 * @param sn
	 * @param empDao1
	 */
	public static void addProject()throws Exception {
		int choice;
		String test;
		ProjectDaoImpl empDao1=new ProjectDaoImpl();
		Scanner sn=new Scanner(System.in);
			
		System.out.println("!----------------Project Portal------------!");
		System.out.println("1. Add Project");
		System.out.println("2. Update project Details");
		System.out.println("3. Delete Project");
		System.out.println("4. All Project List");
		System.out.println("5. Get Single Project Details");
		System.out.println("!----------------End--------------------------!");
		System.out.println("Enter you choice:");
		choice=sn.nextInt();
		switch (choice) {
		case 1: //insert Project
			
			insertProjectRequest(empDao1, sn);
			break;
		case 2: //update project Details
			updateProjectRequest(empDao1, sn);
			break;
		case 3://delete Project
			deleteProjectRequest(empDao1, sn);
			break;
		case 4://Get All Project List
			allProjectListRequest(empDao1);
			break;
		case 5://get Single Project Details
			singleProjectRequest(empDao1, sn);
			break;
		
		}
	}


	/**
	 * @param empDao1
	 * @param sn
	 */
	private static void singleProjectRequest(ProjectDaoImpl empDao1, Scanner sn) {
		System.out.println("Enter your id:");
		int empId=sn.nextInt();
		
		List<Project> emp1=empDao1.getEmployee(empId);
		if(emp1!=null)
		{
			for(Project e:emp1) {
				System.out.println(e.getProId()+"\t"+e.getProjectName());
			}
		}else {
			System.out.println(" something went wrong..!");
		}
	}


	/**
	 * @param empDao1
	 */
	private static void allProjectListRequest(ProjectDaoImpl empDao1) {
		List<Project> list=empDao1.listProjects();
		if(list!=null){
			for(Project e:list) {
				System.out.println(e.getProId()+"\t"+e.getProjectName());
			}
		}else {
			System.out.println("something went wrong..!");
		}
	}


	/**
	 * @param empDao1
	 * @param sn
	 */
	private static void deleteProjectRequest(ProjectDaoImpl empDao1, Scanner sn) {
		System.out.println("Enter your id:");
		int id1=sn.nextInt();
		

		int row=empDao1.deleteData(id1);
		if(row==1)
		{
			System.out.println("Data Deleted successfully.");
		}else {
			System.out.println("Data Not Deleted something went wrong..!");
		}
	}


	/**
	 * @param empDao1
	 * @param sn
	 */
	private static void updateProjectRequest(ProjectDaoImpl empDao1, Scanner sn) {
		System.out.println("Enter your Id:");
		int id2=sn.nextInt();
		System.out.println("Enter your Project Name:");
		String name1=sn.next();
		
		Project emp5=new Project(name1, id2);
		int i2=empDao1.updateData(emp5);
		if(i2==1)
		{
			System.out.println("Data update successfully.");
		}else {
			System.out.println("Data Not Update something went wrong..!");
		}
	}


	/**
	 * @param empDao1
	 * @param sn
	 */
	private static void insertProjectRequest(ProjectDaoImpl empDao1, Scanner sn) {
		System.out.println("Enter your Project Name:");
		String name=sn.next();
		
		Project emp=new Project(name);
		int i1=empDao1.insertData(emp);
		if(i1==1)
		{
			System.out.println("Data inserted successfully.");
		}else {
			System.out.println("Data Not Inserted something went wrong..!");
		}
	}
}