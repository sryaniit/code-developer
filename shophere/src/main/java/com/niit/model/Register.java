package com.niit.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Register {

@Column	
private String name;

@Id
private String username;

@Column
private String password;

@Column
private long mobilenum;

@Column
private String email;


public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public long getMobilenum() {
	return mobilenum;
}

public void setMobilenum(long mobilenum) {
	this.mobilenum = mobilenum;
}

}
