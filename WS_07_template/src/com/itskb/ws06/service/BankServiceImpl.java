package com.itskb.ws06.service;
/**
 * 고객과 계좌에 관련된 서비스
 * (Business Logic 을 처리하는 객체)
 * */

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import com.itskb.ws06.dto.AccountDto;
import com.itskb.ws06.dto.UserDto;

public class BankServiceImpl implements BankService{
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
	public BankServiceImpl() {
		//배열 생성
		 userList = new ArrayList<>(); 
		 accountList = new ArrayList<>(); 
		
		// 각 배열방에 고객과 계좌를 생성한다.
		 //고객 4명
		 userList.add(new UserDto(100, "장희정", "8253jang@daum.net", "010-8875-8253", false));
		 userList.add(new UserDto(200, "이효리", "lee@daum.net", "010-2222-3333", false));
		 userList.add(new UserDto(300, "송중기", "song@naver.com", "010-5554-2222", false));
		 userList.add(new UserDto(400, "삼순이", "sam@daum.com", "010-2222-2222", false));
		 
		 //계좌는 6개 정도
		 accountList.add(new AccountDto(1, "1111-11111", 1000000, 100));
		 accountList.add(new AccountDto(2, "2222-22222", 250000, 100));
		 accountList.add(new AccountDto(3, "3333-33333", 350000, 100));
		 accountList.add(new AccountDto(4, "4444-44444", 150000, 200));
		 accountList.add(new AccountDto(5, "5555-55555", 250000, 200));
		 accountList.add(new AccountDto(6, "6666-66666", 350000, 300));
		 
	}//생성자 끝
	
    /**
	  특정 사용자의 계좌 목록을 배열로 리턴 하는 메소드를 작성한다
	*/
	@Override
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
	@Override
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
	@Override
	public ArrayList<AccountDto> getAccountList() {
		
		return accountList;
	}
	
	/**
	 * 잔고 기준으로 정렬한 모든 계좌 목록을 리턴 하는 메소드를 작성한다 (내림차순)
	 */
	@Override
	public ArrayList<AccountDto> getAccountListSortByBalance() {
		ArrayList<AccountDto> al = (ArrayList<AccountDto>) accountList.clone();
		// 이렇게 하면 복사본 생성
		List<AccountDto> al1 = new ArrayList<>(accountList);
		Collections.sort(al, new Comparator<AccountDto> () {
			@Override
			public int compare(AccountDto a, AccountDto b) {
				return b.getBalance() - a.getBalance();
			}
		});
		Collections.sort(al1, (AccountDto a, AccountDto b) -> b.getBalance() - a.getBalance());
		return al;
	}
	
	/**
	 * 사용자 일련번호 기준으로 정렬한 모든 계좌 목록을 리턴 하는 메소드를 작성한다
	 */
	@Override
	public ArrayList<AccountDto> getAccountListSortByUserSeq() {
		ArrayList<AccountDto> al = (ArrayList<AccountDto>) accountList.clone();
		Collections.sort(al, new Comparator<AccountDto> () {
			@Override
			public int compare(AccountDto a, AccountDto b) {
				return  a.getUserSeq() - b.getUserSeq();
			}
		});
		return al;
	}
}










