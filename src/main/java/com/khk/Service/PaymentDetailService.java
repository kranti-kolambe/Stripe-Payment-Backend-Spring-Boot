package com.khk.Service;

import com.khk.entity.PaymentDetails;

public interface PaymentDetailService {

	//void addPaymentDetails(PaymentDetails paymentDetails);

	PaymentDetails getPaymentDetail(String id);

	String setPaymentDetail(PaymentDetails paymentDetails);
	//String setPaymentDetail(String email);
}
