package com.example.ws04.dao;

import com.example.ws04.common.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class BannerDaoImpl implements BannerDao{

	@Override
	public List<String> listBanner() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<String> bannerList = new ArrayList<>();
		String sql = "select banner_text from banner ";
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				bannerList.add(rs.getString("banner_text"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.releaseConnection(con,pstmt,rs);
		}
		
		return bannerList;
	}

}
