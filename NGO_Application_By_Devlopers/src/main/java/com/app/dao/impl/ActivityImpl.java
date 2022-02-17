package com.app.dao.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.app.bean.Project;
import com.app.bean.Activity;

import com.app.dao.ActivityDao;

import com.app.utility.FactoryUtility;




public class ActivityImpl implements ActivityDao{

	public int updateData(Activity emp) {
		// TODO Auto-generated method stub
		Session session=FactoryUtility.getSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			Query<Activity>query=session.createQuery("update AddActivity set activity='"+emp.getActivity()+"' where actId="+emp.getActId());
			session.update(emp);
			tx.commit();
			
			return 1;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.rollback();
			return 0;
		}
	}

	public int insertData(Activity emp) {
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

	public int deleteData(int id) {
		// TODO Auto-generated method stub
		Session session=FactoryUtility.getSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
String hql="delete from AddActivity where actId ="+id;
		Query<Activity>query=session.createQuery(hql);
	
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

	public List<Activity> listActivity() {
		// TODO Auto-generated method stub
		Session session=FactoryUtility.getSession();
		Transaction tx=session.beginTransaction();
		String hql="From Activity";
			Query<Activity>query=session.createQuery(hql);
			List<Activity> list=query.list();
			
			return list;
	}

	public List<Activity> getActivity(int id) {
		// TODO Auto-generated method stub
		Session session=FactoryUtility.getSession();
		Transaction tx=null;
		String hql="From activity Where actId ="+id;
		Query<Activity>query=session.createQuery(hql);
		//query.setParameter(1, id);
		List<Activity> list=query.list();
		
		return list;
	}
	public List<Activity> getProjectactivity(int id){
		Session session=FactoryUtility.getSession();
		Transaction tx=null;
		String hql="From Activity WHERE proId= "+id;
		Query<Activity>query=session.createQuery(hql);
		//query.setParameter(1, id);
	    List<Activity> list=query.list();
		
		return list;
	}


}
