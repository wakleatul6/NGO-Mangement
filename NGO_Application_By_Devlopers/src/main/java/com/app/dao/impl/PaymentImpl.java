package com.app.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.app.Dto.DonationDto;
import com.app.bean.Activity;
import com.app.bean.Payment;
import com.app.bean.Project;
import com.app.dao.PaymentDao;
import com.app.utility.FactoryUtility;
import com.mysql.cj.xdevapi.SessionFactory;

public class PaymentImpl implements PaymentDao {

	public int MackPaymnetTONGO(int id,String donorName,double amount) {
		// TODO Auto-generated method stub
		org.hibernate.SessionFactory factory=new Configuration().configure("administrator.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
			PreparedStatement pstmt=con.prepareStatement("select * from project inner join activity on project.project_Id=activity.proId where Acti_Id=?");
			pstmt.setInt(1, id);
			ResultSet rs=pstmt.executeQuery();
			
			Payment pay=new Payment();
			while(rs.next()) {
				pay.setActivity(rs.getString("Activity_Name"));
				pay.setDate(LocalDate.now());
				pay.setDoner(donorName);
				pay.setProject_Name(rs.getString("projectName"));
				pay.setAmount(amount);
				
			
			}
			session.save(pay);
			tx.commit();
			
			return 1;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.rollback();
			session.close();
			return 0;
		}
	

	}

	public List<Payment> listDonationDto() {
		Session session = FactoryUtility.getSession();

		Query<Payment> query=session.createQuery("From Payment");
		return query.list();
	}

	public List<Payment> getOneDetails(int payment_Id) {
		Session session = FactoryUtility.getSession();
		Transaction tx = null;
		String hql = "From Payment Where pay_ID =" + payment_Id;
		Query<Payment> query = session.createQuery(hql);
		// query.setParameter(1, id);
		List<Payment> list = query.list();
		return list;

	}

	public List<Payment> getMaxAmount(double amount) {
		Session session = FactoryUtility.getSession();
		Transaction tx = null;
		String hql = "From Payment Where amount =" + amount;
		Query<Payment> query = session.createQuery(hql);
		
		List<Payment> list = query.list();
		return list;
	}

	
	

	

	
}
