package jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.common.DBManager;
import jdbc.dto.AccountDto;
import jdbc.dto.UserAccountCntDto;

public class AccountDaoImpl implements AccountDao{

	private static AccountDaoImpl instance = new AccountDaoImpl();
	
	private AccountDaoImpl() {}
	
	public static AccountDaoImpl getInstance() {
		return instance;
	}

	
	@Override
	public int insert(AccountDto accountDto) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "insert into account values (?, ?, ?, ?)";
		int result = 0;
		try {
		 	con = DBManager.getConnection();
		 	ps = con.prepareStatement(sql);
		 	ps.setInt(1, accountDto.getAccountSeq());
		 	ps.setString(2, accountDto.getAccountNumber());
		 	ps.setInt(3, accountDto.getBalance());
		 	ps.setInt(4, accountDto.getUserSeq());
		 	result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(con, ps);
		}
		
		return result;
	}

	@Override
	public int update(AccountDto accountDto) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "update account set account_seq = (?), account_number = (?), balance = (?), user_seq = (?)"
				+ "where account_seq = (?)";
		int result = 0;
		try {
		 	con = DBManager.getConnection();
		 	ps = con.prepareStatement(sql);
		 	ps.setInt(1, accountDto.getAccountSeq());
		 	ps.setString(2, accountDto.getAccountNumber());
		 	ps.setInt(3, accountDto.getBalance());
		 	ps.setInt(4, accountDto.getUserSeq());
		 	ps.setInt(5, accountDto.getAccountSeq());
		 	result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(con, ps);
		}
		
		return result;
	}

	@Override
	public int delete(int accountSeq) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "delete account where account_seq = (?)";
		int result = 0;
		try {
		 	con = DBManager.getConnection();
		 	ps = con.prepareStatement(sql);
		 	ps.setInt(1, accountSeq);
		 	result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(con, ps);
		}
		
		return result;
	}

	@Override
	public List<AccountDto> selectAll() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from account";
		List<AccountDto> list = new ArrayList<>();
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				int accountseq = rs.getInt("account_seq");
				String accountNum = rs.getString("account_number");
				int balance = rs.getInt("balance");
				int userSeq = rs.getInt("user_seq");
				AccountDto dto = new AccountDto(accountseq, accountNum, balance, userSeq, null);
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(con, ps, rs);
		}
		
		return list;
	}

	@Override
	public AccountDto selectOne(int accountSeq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AccountDto> selectBalanceDescTop3() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AccountDto> selectUsersAccountByName(String searchName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserAccountCntDto> selectUserAccountCnt() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
