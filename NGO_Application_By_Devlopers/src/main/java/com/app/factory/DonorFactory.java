package com.app.factory;


import com.app.dao.DonorDao;
import com.app.dao.impl.DonorDaoImpl;


public class DonorFactory {
	public static DonorDao getAdministratorDao() {
		return new DonorDaoImpl();
	}

}
