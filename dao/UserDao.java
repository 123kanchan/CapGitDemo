package com.cgpack5.dao;

import org.springframework.beans.factory.annotation.Autowired;

import com.cgpack5.exception.AdminCreationException;
import com.cgpack5.exception.InvalidAdminException;
import com.cgpack5.exception.UserCreationException;
import com.cgpack5.model.User;
import com.cgpack5.repository.UserRepository;
import com.cgpack5.service.UserService;

public class UserDao implements UserService {

	@Autowired
	UserRepository userrepos;
	@Override
	public User addUser(User user) throws UserCreationException{
	if(userrepos.existsById(user.getUserId())) {
		throw new UserCreationException("user already exist");
	}
	return userrepos.save(user);
	}

	@Override
	public void removeUser(int userId) {
		// TODO Auto-generated method stub
		
	}

}
