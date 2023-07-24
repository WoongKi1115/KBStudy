package com.itskb.ws05.view;

import java.util.ArrayList;

import com.itskb.ws05.dto.AccountDto;
import com.itskb.ws05.dto.UserDto;
import com.itskb.ws05.service.BankService;

public class TestView {

public static void main(String[] args) {
		
		BankService bankService = new BankService();
		System.out.println("1. 모든 계좌정보 조회 ------");
		print(bankService.getAccountList());
		
		System.out.println("2.잔액기준으로 정렬하기 -------------");
		print(bankService.getAccountListSortByBalance());
		
		
		System.out.println("3.UserSeq 기준으로 정렬하기 -------------");
		print(bankService.getAccountListSortByUserSeq());
		
		
		System.out.println("4. 모든 계좌정보 조회 ------");
		print(bankService.getAccountList());
		
	}
	
	/**
	 * 계좌목록 출력하기
	 * */
	public static void print(ArrayList<AccountDto> accountList) {
		for (AccountDto accountDto : accountList) {
			System.out.println(accountDto);
		}
		System.out.println();
	}

}// 클래스 끝




