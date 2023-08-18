package com.example.ws04.dao;

import com.example.ws04.common.DBManager;
import com.example.ws04.dto.UserDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LoginDaoImpl implements LoginDao{

    @Override
    public UserDto login(String email) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        UserDto dto = null;
        String sql = "select * from users where user_email = ? ";
        try {
            con = DBManager.getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, email);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                int userSeq = rs.getInt("user_Seq");
                String name = rs.getString("user_name");
                String userEmail = rs.getString("user_email");
                String phone = rs.getString("user_phone");
                boolean isSleep = (rs.getString("user_is_sleep").equals("N")) ? false : true;
                String password = rs.getString("password");
                dto = new UserDto(userSeq, name, password, userEmail, phone, isSleep);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.releaseConnection(con, pstmt, rs);
        }

        return dto;
    }
}
