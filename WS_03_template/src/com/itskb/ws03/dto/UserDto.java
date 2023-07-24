package com.itskb.ws03.dto;
/**
 *  고객의 정보를 관리할 객체 
 * */
public class UserDto {
  int userSeq;
  String name;
  String email;
  String phone;
  boolean isSleep;
  
  public int getUserSeq() {
	return userSeq;
}

public void setUserSeq(int userSeq) {
	this.userSeq = userSeq;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone = phone;
}

public boolean getIsSleep() {
	return isSleep;
}

public void setSleep(boolean isSleep) {
	this.isSleep = isSleep;
}

public UserDto() {
	  
  }
  
  public UserDto(int userSeq, String name, String email, String phone, boolean isSleep) {
	  this.userSeq = userSeq;
	  this.name = name;
	  this.email = email;
	  this.phone = phone;
	  this.isSleep = isSleep;
  }
}
