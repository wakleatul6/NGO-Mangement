package com.app.factory;

import com.app.dao.PaymentDao;
import com.app.dao.impl.PaymentImpl;

public class PaymentFactory {
	public static PaymentDao getMakePaymentDao() {
		return new PaymentImpl();
	}

}
