package com.app.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.bean.Donor;
import com.app.bean.User;
import com.app.utility.FactoryUtility;

public class RegisterDao {

	public int register(Donor donor) {
		try {
			Session session = FactoryUtility.getSession();
			Transaction tx = session.beginTransaction();
			session.save(donor);

			tx.commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int userregister(User user) {
		try {
			Session session = FactoryUtility.getSession();
			Transaction tx = session.beginTransaction();
			session.save(user);

			tx.commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}
