package com.khk.Dao;

import com.khk.entity.PaymentDetails;

public interface PaymentDetailDao {

	String addPaymentDetails(PaymentDetails paymentDetails);

	PaymentDetails getPaymentDetail(String id);

	

}
