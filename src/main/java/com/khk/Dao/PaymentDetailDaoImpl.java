package com.khk.Dao;

import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.khk.entity.PaymentDetails;
import com.khk.entity.Subscription;
import com.khk.entity.User;

@Repository
public class PaymentDetailDaoImpl implements PaymentDetailDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	//public String addPaymentDetails(PaymentDetails paymentDetails, String email) 
	public String addPaymentDetails(PaymentDetails pd){
		System.out.println("Payment details in DAO  "+pd);
		Session session= sessionFactory.getCurrentSession();
		String msg;
		 
		
		 System.out.println("subscription after payment changed");
			Integer id=(Integer) session.save(pd);
			System.out.println("Payment details added in db");
		
		
		 if(id!=0)
			msg="payment Details Added Successfully!!";
		 else
			 msg="Something went Wrong!!";
		
		 String email=pd.getCustomerEmailId(); 
		 Criteria  criteria=session.createCriteria(User.class);
		  criteria.add(Restrictions.eq("email",email));
		  User u=(User) criteria.uniqueResult();
		  u.setSubscription(new Subscription("1 Month","Subscribed"));
		  session.update(u);
		return msg;
		 
	}

	@Override
	public PaymentDetails getPaymentDetail(String id) {
		Session session= sessionFactory.getCurrentSession();
		PaymentDetails paymentDetails=session.get(PaymentDetails.class, id);
		
		return paymentDetails;
	}
	
	
}
	
