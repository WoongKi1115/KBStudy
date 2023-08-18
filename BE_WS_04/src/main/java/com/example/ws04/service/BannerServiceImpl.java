package com.example.ws04.service;

import com.example.ws04.dao.BannerDao;
import com.example.ws04.dao.BannerDaoImpl;

import java.util.List;



public class BannerServiceImpl implements BannerService{

	@Override
	public List<String> listBanner() {
		BannerDao bannerDao = new BannerDaoImpl();
		return bannerDao.listBanner();
	}

}
