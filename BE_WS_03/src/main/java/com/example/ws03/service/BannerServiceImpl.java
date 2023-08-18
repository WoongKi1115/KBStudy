package com.example.ws03.service;

import com.example.ws03.dao.BannerDaoImpl;

import java.util.List;

public class BannerServiceImpl implements BannerService{

    private static BannerServiceImpl instance = new BannerServiceImpl();

    private BannerServiceImpl() {};

    public static BannerServiceImpl getInstance() {
        return instance;
    }
    private static BannerDaoImpl bannerDao = BannerDaoImpl.getInstance();
    @Override
    public List<String> listBanner() {
        List<String> bannerList = bannerDao.listBanner();
        if (bannerList.isEmpty()) {
            return null;
        }
        return bannerList;
    }
}
