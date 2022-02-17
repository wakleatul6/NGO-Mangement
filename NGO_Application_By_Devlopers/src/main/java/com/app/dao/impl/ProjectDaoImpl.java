package com.app.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.app.bean.Project;
import com.app.dao.ProjectDao;
import com.app.utility.FactoryUtility;



public class ProjectDaoImpl implements ProjectDao{

	public int updateData(Project pt) {
		// TODO Auto-generated method stub
		Session session=FactoryUtility.getSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			Query<Project>query=session.createQuery("update Project set projectName='"+pt.getProjectName()+"' where proId="+pt.getProId());
			session.update(pt);
			tx.commit();
			
			return 1;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.rollback();
			return 0;
		}
			
	}

	public int insertData(Project emp) {
		// TODO Auto-generated method stub
Session session=FactoryUtility.getSession();
Transaction tx=null;
try {
	tx=session.beginTransaction();
	session.persist(emp);
	tx.commit();
	
	return 1;
	
} catch (Exception e) {
	// TODO: handle exception
	e.printStackTrace();
	tx.rollback();
	return 0;
}
		
	}

	public int deleteData(int proId) {
		// TODO Auto-generated method stub
		Session session=FactoryUtility.getSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			String hql="delete from Project where proId ="+proId;
		Query<Project>query=session.createQuery(hql);
	
		int row=query.executeUpdate();
		tx.commit();
		
		return row;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.rollback();
			return 0;
		}
	}

	
	public List<Project> listProjects() {
		Session session=FactoryUtility.getSession();
		Transaction tx=null;
		String hql="From Project";
		Query<Project>query=session.createQuery(hql);
		List<Project> list=query.list();
		
		return list;
	}

	public List<Project> getEmployee(int proId) {
		Session session=FactoryUtility.getSession();
		Transaction tx=null;
		String hql="From Project Where proId ="+proId;
		Query<Project>query=session.createQuery(hql);
		//query.setParameter(1, id);
		List<Project> list=query.list();
		
		return list;
	}


}
