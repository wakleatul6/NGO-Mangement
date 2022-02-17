package com.app.dao;

import java.util.List;

import com.app.bean.Donor;


public interface DonorDao {
	
	int updateData(Donor emp);
	int insertData(Donor emp);
	int deleteData(int id);
	List<Donor> listDonor();
	List<Donor> getDonor(int id);

}
