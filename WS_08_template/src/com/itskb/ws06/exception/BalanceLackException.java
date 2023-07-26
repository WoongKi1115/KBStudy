package com.itskb.ws06.exception;

public class BalanceLackException extends Exception{
	public BalanceLackException() {
		super("부족합니다.");
	}
	
	public BalanceLackException(String e) {
		super(e);
	}
}
