package com.itskb.ws06.service;
/**
 * 고객과 계좌에 관련된 서비스
 * (Business Logic 을 처리하는 객체)
 * */

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.security.auth.login.AccountNotFoundException;

import com.itskb.ws06.dto.AccountDto;
import com.itskb.ws06.dto.InstallAccountDto;
import com.itskb.ws06.dto.LoanAccountDto;
import com.itskb.ws06.dto.SavingAccountDto;
import com.itskb.ws06.dto.UserDto;

public class BankService {
	//final은 고정값= 값변경불가 (반드시 초기화 필수)
	final int ACCOUNT_SIZE = 10; /**계좌 최대개수*/
	final int USER_SIZE = 5;/**고객 최대개수 */
	
	int ACCOUNT_CURRENT_SIZE; /** 현재계좌의 개수 */
	int USER_CURRENT_SIZE; /**현재 고객의 개수 */
	
	ArrayList<AccountDto> accountList;
	ArrayList<UserDto> userList;
	
	/**
	 * 생성자에서 테스트를 위한 고객 및 계좌 객체를 생성하고 배열에 저장한다
	 * */
	public BankService() {
		//배열 생성
		 userList = new ArrayList<>(); 
		 accountList = new ArrayList<>(); 
		
		// 각 배열방에 고객과 계좌를 생성한다.
		 userList.add( new UserDto(111, "홍길동", "hong@gildong@com", "010-1111-1111", false) );
			userList.add( new UserDto(222, "이길동", "lee@gildong@com", "010-2222-2222", true) );
			userList.add( new UserDto(333, "삼길동", "sam@gildong@com", "010-3333-3333", false) );
			
			accountList.add( new InstallAccountDto(20, "00200202002002", 1000, 111, 12, 10000) );
			
			accountList.add( new SavingAccountDto(10, "00100101001001", 500, 111, 100) );
			
			accountList.add( new LoanAccountDto(60, "00600606006006", 500, 333, "House") );
			accountList.add( new LoanAccountDto(30, "00300303003003", 0, 111, "Building") );
			
			accountList.add( new SavingAccountDto(70, "00700707007007", 500, 333, 200) );
			
			accountList.add( new LoanAccountDto(50, "00500505005005", 200, 222, "Car") );
			accountList.add( new SavingAccountDto(40, "00400404004004", 1000, 222, 50) );
		 
	}//생성자 끝
	
    /**
	  특정 사용자의 계좌 목록을 배열로 리턴 하는 메소드를 작성한다
	*/
	public ArrayList<AccountDto> getAccountList(int userSeq) {
		ArrayList<AccountDto> al = new ArrayList<>();
		 for (int i = 0; i<accountList.size(); i++) {
			 if (accountList.get(i).getUserSeq() == userSeq) {
				 al.add(accountList.get(i));
			 }
		 }
		 if (al.size() == 0) {
			 return null;
		 }
		
		return al;
	}
	
	
	/**
	   특정 사용자의 고객 정보를 리턴 하는 메소드를 작성한다
	   
	   @param : 고객의 sequence
	   @return : null이면 고객의정보없다 
	**/
	public UserDto getUserDetail(int userSeq) {
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getUserSeq() == userSeq) {
				return userList.get(i);
			}
		}
		
		return null;
	}
	
	/**
	 * 모든 계좌 목록을 리턴 하는 메소드를 작성한다
	 */
	public ArrayList<AccountDto> getAccountList() {
		
		return accountList;
	}
	
	/**
	 * 잔고 기준으로 정렬한 모든 계좌 목록을 리턴 하는 메소드를 작성한다 (내림차순)
	 */
	public ArrayList<AccountDto> getAccountListSortByBalance() {
		ArrayList<AccountDto> al = (ArrayList<AccountDto>) accountList.clone();
		Collections.sort(al, new Comparator<AccountDto> () {
			@Override
			public int compare(AccountDto a, AccountDto b) {
				return b.getBalance() - a.getBalance();
			}
		});
		return al;
	}
	
	/**
	 * 사용자 일련번호 기준으로 정렬한 모든 계좌 목록을 리턴 하는 메소드를 작성한다
	 */
	public ArrayList<AccountDto> getAccountListSortByUserSeq() {
		ArrayList<AccountDto> al = (ArrayList<AccountDto>) accountList.clone();
		Collections.sort(al, new Comparator<AccountDto> () {
			@Override
			public int compare(AccountDto a, AccountDto b) {
				return a.getUserSeq() - b.getUserSeq();
			}
		});
		return al;
	}
}










