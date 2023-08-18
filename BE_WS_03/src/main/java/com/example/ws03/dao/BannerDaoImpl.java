package com.example.ws03.dao;

import com.example.ws03.common.DBManager;
import jdk.nashorn.internal.objects.annotations.Getter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BannerDaoImpl implements BannerDao{

    private static BannerDaoImpl instance = new BannerDaoImpl();

    private BannerDaoImpl() {};

    public static BannerDaoImpl getInstance() {
        return instance;
    }

    @Override
    public List<String> listBanner() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<String> list  = new ArrayList<>();
        String sql="select * from banner";
        try {
            con = DBManager.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String ban = rs.getString("BANNER_TEXT");
                list.add(ban);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.releaseConnection(con, ps, rs);
        }

        return list;
    }
}
