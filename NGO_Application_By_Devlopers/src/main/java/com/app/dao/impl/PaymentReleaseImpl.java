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

import com.app.bean.Payment;
import com.app.bean.PaymentRelease;
import com.app.dao.PaymentReleaseDao;
import com.app.utility.FactoryUtility;

public class PaymentReleaseImpl implements PaymentReleaseDao {

	public int MackPaymnetTONGO(int id, String SchemeName, double amount) {
		// TODO Auto-generated method stub
		org.hibernate.SessionFactory factory = new Configuration().configure("administrator.cfg.xml")
				.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
			PreparedStatement pstmt = con.prepareStatement("select * from project inner join activity on project.project_Id=activity.proId where Acti_Id=?");
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();

			PaymentRelease pay = new PaymentRelease();
			while (rs.next()) {
				pay.setActivity(rs.getString("Activity_Name"));
				pay.setDate(LocalDate.now());
				pay.setSchemeName(SchemeName);
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
			return 0;
		}
	}

	public List<PaymentRelease> listPaymentReleases() {
		Session session = FactoryUtility.getSession();

		Query<PaymentRelease> query=session.createQuery("From PaymentRelease");
		return query.list();
	}

}
