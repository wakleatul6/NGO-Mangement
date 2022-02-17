package com.app.dao;

import java.util.List;


import com.app.bean.PaymentRelease;

public interface PaymentReleaseDao {
	int  MackPaymnetTONGO(int id ,String donor,double amount);
	 List<PaymentRelease> listPaymentReleases();
}
