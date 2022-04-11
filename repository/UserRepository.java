package com.cgpack5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cgpack5.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
@Query(value="select u.user_password  from User_Table u where u.user_name=?1",nativeQuery=true)
	String getUsername(String userName);

}
