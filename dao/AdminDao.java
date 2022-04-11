package com.cgpack5.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgpack5.exception.AdminCreationException;
import com.cgpack5.exception.InvalidAdminException;
import com.cgpack5.exception.TrainCreationException;
import com.cgpack5.model.Admin;
import com.cgpack5.repository.AdminRepository;

import com.cgpack5.service.AdminService;
@Service
public class AdminDao implements AdminService {
@Autowired
AdminRepository repos;
	@Override
	public Admin addAdmin(Admin admin) throws AdminCreationException {
		
		if(repos.existsById(admin.getAdminId()))
		{
			throw new AdminCreationException("This admin is available");
		}
		
	
		return  repos.save(admin);
		
		
		
		
	}

	@Override
	public void deleteAdmin(int adminId) {
		repos.deleteById(adminId);
	
		
	}

	@Override
	public String getAdminName(int adminId)throws InvalidAdminException{
		if(!repos.existsById(adminId))
		{
			throw new InvalidAdminException("This admin is not available");
		}
		return repos.getadminname(adminId);
		
	}

	@Override
	public String getAdminPassword(int adminId)throws InvalidAdminException {
		if(!repos.existsById(adminId))
		{
			throw new InvalidAdminException("This admin is not available");
		}
		return repos.getadminpassword(adminId);
		
	}

}
