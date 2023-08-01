package jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.common.DBManager;
import jdbc.dto.UserDto;

public class UserDAOImpl implements UserDAO{

	@Override
	public int insert(UserDto userDto) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "insert into users values (?, ?, ?, ?, ?)";
		int result = 0;
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, userDto.getUserSeq());
			ps.setString(2, userDto.getName());
			ps.setString(3, userDto.getEmail());
			ps.setString(4, userDto.getPhone());
			ps.setString(5, userDto.isSleep() ? "Y" : "N");
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(con, ps);
		}
		return result;
	}

	@Override
	public int update(UserDto userDto) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "Update users set user_seq = (?), user_name = (?), user_email = (?),"
				+ " user_phone = (?), user_is_sleep = (?)  where user_seq = (?)";
		int result = 0;
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, userDto.getUserSeq());
			ps.setString(2, userDto.getName());
			ps.setString(3, userDto.getEmail());
			ps.setString(4, userDto.getPhone());
			ps.setString(5, userDto.isSleep() ? "Y" : "N");
			ps.setInt(6, userDto.getUserSeq());
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(con, ps);
		}
		return result;
	}

	@Override
	public int delete(int userSeq) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "delete users where user_seq = (?)";
		int result = 0;
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, userSeq);
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(con, ps);
		}
		return result;
	}

	@Override
	public List<UserDto> selectAll() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from users";
		List<UserDto> list = new ArrayList<>();
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				int userSeq = rs.getInt("user_seq");
				String userName = rs.getString("user_name");
				String userEmail = rs.getString("user_email");
				String userPhone = rs.getString("user_phone");
				boolean userSleep = rs.getString("user_is_sleep") == "Y" ? true : false;
				UserDto userdto = new UserDto(userSeq, userName, userEmail, userPhone, userSleep);
				list.add(userdto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(con, ps, rs);
		}
		return list;
	}

	@Override
	public UserDto selectOne(int userSeq) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from users where user_Seq = (?)";
		UserDto userDto = null;
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, userSeq);
			rs = ps.executeQuery();
			rs.next();
			String userName = rs.getString("user_name");
			String userEmail = rs.getString("user_email");
			String userPhone = rs.getString("user_phone");
			boolean userSleep = rs.getString("user_is_sleep") == "Y" ? true : false;
			userDto = new UserDto(userSeq, userName, userEmail, userPhone, userSleep);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(con, ps, rs);
		}
		return userDto;
	}
	
}
