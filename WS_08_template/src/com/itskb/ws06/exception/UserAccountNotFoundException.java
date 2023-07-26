package com.itskb.ws06.exception;

public class UserAccountNotFoundException extends Exception{
	
	public UserAccountNotFoundException() {
		super("존재하지 않는 계좌입니다.");
	}
	
	public UserAccountNotFoundException(String e) {
		super(e);
	}
}
