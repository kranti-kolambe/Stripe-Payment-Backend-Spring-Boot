package com.khk.Service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khk.Dao.PaymentDetailDao;
import com.khk.Dao.UserDao_I;
import com.khk.entity.PaymentDetails;
import com.khk.entity.User;

@Service
@Transactional
public class PaymentDetailServiceImpl implements PaymentDetailService {
	@Autowired
	PaymentDetailDao paymentDetailDao;
	@Autowired
	UserDao_I userDao;
//	@Override
//	public void addPaymentDetails(PaymentDetails paymentDetails) {
//		paymentDetailDao.addPaymentDetails(paymentDetails);
		
	//}

	@Override
	public PaymentDetails getPaymentDetail(String id) {
		PaymentDetails paymentDetails=paymentDetailDao.getPaymentDetail(id);
		String status=paymentDetails.getPaymentStatus();
		//if(status.equalsIgnoreCase("succeeded")||status.equalsIgnoreCase("complete"))
		//{
			User user=userDao.getUserByEmailId(paymentDetails.getCustomerEmailId());
			user.getSubscription().setStatus("Subscribed");
			
		//}
		return paymentDetails;
	}

	@Override
	//public String setPaymentDetail(PaymentDetails paymentDetails,String email) 
	public String setPaymentDetail(PaymentDetails pd){
		System.out.println("Payment details in Service  "+pd);
		String msg=paymentDetailDao.addPaymentDetails(pd);
		return msg;
	}

}
