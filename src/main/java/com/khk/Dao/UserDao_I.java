package com.khk.Dao;

import java.util.List;

import com.khk.entity.Subscription;
import com.khk.entity.User;

public interface UserDao_I {

	String registerUser(User user);

	List<Subscription> getAllSubscription();

	User loginCheck(String email, String psw);

	String changeStatus(String email);

	User getUserByEmailId(String email);

}
