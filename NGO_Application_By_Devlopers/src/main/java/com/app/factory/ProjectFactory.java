package com.app.factory;

import com.app.dao.ProjectDao;
import com.app.dao.impl.ProjectDaoImpl;

public class ProjectFactory {
	public static ProjectDao getProject_ListDao() {
		return new ProjectDaoImpl();
	}

}
