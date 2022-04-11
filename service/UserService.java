package com.cgpack5.service;

import com.cgpack5.exception.AdminCreationException;
import com.cgpack5.exception.InvalidAdminException;
import com.cgpack5.exception.UserCreationException;
import com.cgpack5.model.Train;
import com.cgpack5.model.User;

public interface UserService {
public User addUser(User user)throws UserCreationException;
public void removeUser(int userId);

}
