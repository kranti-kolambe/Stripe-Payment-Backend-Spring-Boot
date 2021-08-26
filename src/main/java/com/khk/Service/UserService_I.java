package com.khk.Service;

import java.util.List;


import com.khk.entity.Subscription;
import com.khk.entity.User;

public interface UserService_I {

	String registerUser(User user);

	List<Subscription> getAllSubscription();

	User loginCheck(User u);

	String changeStatus(String email);

	

}
