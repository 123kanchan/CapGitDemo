package com.cgpack5.service;

import com.cgpack5.exception.AdminCreationException;
import com.cgpack5.exception.InvalidAdminException;
import com.cgpack5.exception.TrainCreationException;
import com.cgpack5.model.Admin;

public interface AdminService {
public Admin addAdmin(Admin admin)throws AdminCreationException;
public void deleteAdmin(int adminId);
public String getAdminName(int adminId)throws InvalidAdminException;
public String getAdminPassword(int adminId) throws InvalidAdminException;
}
