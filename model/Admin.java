package com.cgpack5.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
@Entity
@Table(name="Admin_Table")
public class Admin {
@Id
private int adminId;
@Autowired
@OneToOne(cascade = CascadeType.ALL)
private User user;
public int getAdminId() {
	return adminId;
}
public void setAdminId(int adminId) {
	this.adminId = adminId;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
}
