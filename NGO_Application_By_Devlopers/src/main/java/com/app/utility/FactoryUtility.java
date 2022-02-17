package com.app.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class FactoryUtility {
private static SessionFactory factory;
static {
	try {
		factory=new Configuration().configure("administrator.cfg.xml").buildSessionFactory();
		
	}catch (Exception e) {
		
		e.printStackTrace();
	}
}
static ThreadLocal<Session> tl=new ThreadLocal();
static Session session=null;
public static Session getSession() {
	try {
		if (tl.get()==null) {
			session=factory.openSession();
			tl.set(session);
			return session;
		}
			else {
				return tl.get();
		}
	
}
	catch (Exception e) {
	// TODO: handle exception
	return null;
}
}
public static void cloesSession() {
	try {
		session.close();
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}
}
