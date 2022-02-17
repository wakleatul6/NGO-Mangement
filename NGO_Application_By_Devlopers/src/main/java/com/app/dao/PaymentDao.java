package com.app.dao;

import java.util.List;
import com.app.bean.Payment;


public interface PaymentDao {
	int  MackPaymnetTONGO(int id ,String donor,double amount);
	 List<Payment> listDonationDto();
	 List<Payment> getOneDetails(int payment_Id);
	 List<Payment> getMaxAmount(double amount);
}
