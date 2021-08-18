package com.khk.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.khk.entity.PaymentDetails;

@Repository
public class PaymentDetailDaoImpl implements PaymentDetailDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public String addPaymentDetails(PaymentDetails paymentDetails) {
		Session session= sessionFactory.getCurrentSession();
		String msg;
		 Integer id=(Integer) session.save(paymentDetails);
			 
		 if(id!=0)
			msg="payment Details Added Successfully!!";
		 else
			 msg="Something went Wrong!!";
		return null;
		 
	}

	@Override
	public PaymentDetails getPaymentDetail(String id) {
		Session session= sessionFactory.getCurrentSession();
		PaymentDetails paymentDetails=session.get(PaymentDetails.class, id);
		
		return paymentDetails;
	}
	
	
}
	
