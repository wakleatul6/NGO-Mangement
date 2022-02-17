package com.app.dao;

import java.util.List;

import com.app.bean.Project;


public interface ProjectDao {
	int updateData(Project emp);
	int insertData(Project emp);
	int deleteData(int id);
	List<Project> listProjects();
	List<Project> getEmployee(int proId);

}
