package com.itskb.ws06.service;

import java.util.ArrayList;

import com.itskb.ws06.dto.AccountDto;
import com.itskb.ws06.dto.UserDto;

public interface BankService {
	ArrayList<AccountDto> getAccountList(int userSeq);
	
	UserDto getUserDetail(int userSeq);
	
	ArrayList<AccountDto> getAccountList();
	
	ArrayList<AccountDto> getAccountListSortByBalance();
	
	ArrayList<AccountDto> getAccountListSortByUserSeq();
}
