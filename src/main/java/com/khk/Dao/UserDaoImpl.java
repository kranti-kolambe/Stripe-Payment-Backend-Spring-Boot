package com.khk.Dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.khk.entity.PaymentDetails;
//import com.khk.entity.Country;
import com.khk.entity.Subscription;
import com.khk.entity.User;
@Repository
public class UserDaoImpl implements UserDao_I {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public String registerUser(User user) {
		System.out.println("In Dao registerUser()");
					
			Session session= sessionFactory.getCurrentSession();
		
			 Integer id=(Integer) session.save(user);
			
			 String msg="";
			 if(id!=0)
				msg="Employee Registered Successfully!!" ;
			 else
				 msg="Employee not Registered, Something went wrong!!" ;
			 return msg;
		
	}

	@Override
	public List<Subscription> getAllSubscription() {
		Session session= sessionFactory.getCurrentSession();
		List<Subscription> subscriptionList=session.createQuery("from Subscription").list();
		return subscriptionList;
		
	}

	@Override
	public User loginCheck(String email, String psw) {
		Session session= sessionFactory.getCurrentSession();
		Criteria criteria=session.createCriteria(User.class);
		criteria.add(Restrictions.eq("email",email));
		criteria.add(Restrictions.eq("password",psw));
		User user=(User) criteria.uniqueResult();
		return user;
	}

	@Override
	public String changeStatus(String email) {
		String msg="";
		 Session session=sessionFactory.getCurrentSession();
		 //User u=session.get(User.class, email);
		 Criteria criteria=session.createCriteria(User.class);
			criteria.add(Restrictions.eq("email",email));
			User u=(User) criteria.uniqueResult();
		 String status=u.getSubscription().getStatus();
		 if(status.equalsIgnoreCase("not subscribed"))
			msg="User is not subscribed yet";
		 else if(status.equalsIgnoreCase("subscribed")) 
			 u.setSubscription(new Subscription("1 Month","Cancel subscription"));
		 	
			 else
				 u.setSubscription(new Subscription("1 Month","subscribed"));
		 session.saveOrUpdate(u);
		 msg="Status of id="+u.getFname()+" "+u.getLname()+" Changed to "+u.getSubscription().getStatus()+" !!";
		return msg;
		
	}
	@Override
	public User getUserByEmailId(String email) {
		Session session= sessionFactory.getCurrentSession();
		User user=session.get(User.class, email);
		return user;
	}

}
