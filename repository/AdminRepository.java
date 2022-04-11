package com.cgpack5.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cgpack5.exception.InvalidAdminException;
import com.cgpack5.model.Admin;
@Transactional
@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer>{

	
@Query(value="select u.user_name from Admin_Table a inner join User_Table u on a.user_user_id=u.user_id where admin_id=?1",nativeQuery = true)
	public String getadminname(int adminId);


@Query(value="select u.user_password from User_Table u inner join Admin_Table a on a.user_user_id=u.user_id where admin_id=?1",nativeQuery=true)
public String getadminpassword(int adminId);


}
