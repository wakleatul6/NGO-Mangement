package com.app.dao.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import com.app.bean.Donor;
import com.app.dao.DonorDao;
import com.app.utility.FactoryUtility;


public class DonorDaoImpl implements DonorDao{

	public int updateData(Donor emp) {
		// TODO Auto-generated method stub
		Session session=FactoryUtility.getSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			Query<Donor>query=session.createQuery("UPDATE Donor SET volEmail='emp.getVolEmail()',volMob='emp.getVolMob()',volName='emp.getVolName()',volUserId='emp.getVolUserId()',volPass='emp.getVolPass' WHERE volId='emp.getVolId()'");
			session.saveOrUpdate(emp);
			tx.commit();
			
			return 1;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.rollback();
			return 0;
		}
			
	}

	public int insertData(Donor emp) {
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
String hql="delete from Donor where volId ="+id;
		Query<Donor>query=session.createQuery(hql);
	
		int row=query.executeUpdate();
		tx.commit();
		FactoryUtility.cloesSession();
		return row;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.rollback();
			return 0;
		}
	}

	public List<Donor> listDonor() {
		// TODO Auto-generated method stub
		Session session=FactoryUtility.getSession();
		Transaction tx=null;
		String hql="From Donor";
			Query<Donor>query=session.createQuery(hql);
			List<Donor> list=query.list();
			
			return list;

	}

	public 	List<Donor> getDonor(int id) {
		
		// TODO Auto-generated method stub
		Session session=FactoryUtility.getSession();
		Transaction tx=null;
		String hql="From Donor Where volId ="+id;
		Query<Donor>query=session.createQuery(hql);
		//query.setParameter(1, id);
		List<Donor> list=query.list();
		
		return list;
	
	}

	ProjectDaoImpl empDao1=new ProjectDaoImpl();
	
	


		
	}


