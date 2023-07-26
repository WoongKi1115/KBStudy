package com.itskb.ws06.service;

import java.util.ArrayList;
import java.util.List;

import com.itskb.ws06.dto.AccountDto;
import com.itskb.ws06.dto.UserDto;
import com.itskb.ws06.exception.BalanceLackException;
import com.itskb.ws06.exception.UserAccountNotFoundException;

public interface BankService {
	List<AccountDto> getAccountList(int userSeq);
	
	UserDto getUserDetail(int userSeq);
	
	List<AccountDto> getAccountList();
	
	List<AccountDto> getAccountListSortByBalance();
	
	List<AccountDto> getAccountListSortByUserSeq();
	
	AccountDto getUserAccount(int userSeq, int accountSeq) throws UserAccountNotFoundException;
	
	int withdraw(int userSeq, int accountSeq, int amount) throws BalanceLackException, UserAccountNotFoundException;
}
