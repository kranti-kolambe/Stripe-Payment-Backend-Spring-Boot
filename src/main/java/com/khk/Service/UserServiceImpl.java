package com.khk.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khk.Dao.UserDao_I;
import com.khk.entity.PaymentDetails;
import com.khk.entity.Subscription;
import com.khk.entity.User;

@Service
@Transactional
public class UserServiceImpl implements UserService_I {
	@Autowired
	UserDao_I userDao;
	@Override
	public String registerUser(User user) {
		System.out.println("In Service registerUser()");
		String msg=userDao.registerUser(user);
		
		return msg;
	
	}
	@Override
	public List<Subscription> getAllSubscription() {
		List<Subscription> subscriptionList=userDao.getAllSubscription();
		return subscriptionList;
	}
	@Override
	public User loginCheck(User u) {
		String email=u.getEmail();
		String psw=u.getPassword();
		User user=userDao.loginCheck(email,psw);
		return user;
	}
	@Override
	public String changeStatus(User u) {
		String user=userDao.changeStatus(u);
		return user;
	}
	
}
