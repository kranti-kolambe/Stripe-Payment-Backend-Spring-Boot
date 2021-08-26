package com.khk.Dao;

import com.khk.entity.PaymentDetails;

public interface PaymentDetailDao {

	//String addPaymentDetails(PaymentDetails paymentDetails, String email);
	String addPaymentDetails(PaymentDetails pd);
	PaymentDetails getPaymentDetail(String id);

	

}
