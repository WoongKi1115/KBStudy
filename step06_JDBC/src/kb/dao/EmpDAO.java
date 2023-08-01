package kb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kb.common.DBManager;
import kb.dto.EmpDTO;

public class EmpDAO {
	/**
	 * emp테이블의 사원 정보 검색하기
	 * SELECT EMPNO, ENAME, JOB, SAL, HIREDATE FROM EMP
	 * */
	public List<EmpDTO> selectAll() {
		// 로드 연결 실행 닫기
		// try 밖에 선언해야함. finally에서 사용해야 하므로.
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT EMPNO, ENAME, JOB, SAL, HIREDATE FROM EMP";
		List<EmpDTO> list = new ArrayList<>();
		try {
			// DB 연동에 필수
			con = DBManager.getConnection(); // 연결
			ps = con.prepareStatement(sql);
			// ?가 있다면 ?의 개수만큼 순서대로 set 설정
			
			// DB에 쿼리 전송 - excuteUpdate(), excuteQuery()
			rs = ps.executeQuery();
			while (rs.next()) { // rs.next()는 앞으로 한 행을 내림. true일 동안 돔.
				//현재 행의 열의 정보를 가져온다(조회)
				int empno = rs.getInt("EMPNO");
				String ename = rs.getString("ENAME");
				String job = rs.getString("job");
				int sal = rs.getInt(4);
				String hiredate = rs.getString(5);
				
//				System.out.println(empno+" | " + ename);
				EmpDTO emp = new EmpDTO(empno, ename, job, sal, hiredate);
				list.add(emp);
			}
			
		} catch (SQLException e){
			e.printStackTrace();
		}finally {
			DBManager.releaseConnection(con, ps, rs);
		}
		return list;
	}//selectAll End

	/**
	 * 사원 등록하기
	 * insert into emp(empno, ename, job, sal, hiredate) values (?,?,?,?,sysdate)
	 * */
	public int insert(EmpDTO emp) {
		// 필요한 변수 선언
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "insert into emp(empno, ename, job, sal, hiredate) values (?,?,?,?,sysdate)";
		int result = 0;
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			// ?가 있다면 ? 개수막큼 set 설정
			ps.setInt(1, emp.getEmpno());
			ps.setString(2, emp.getEname());
			ps.setString(3, emp.getJob());
			ps.setInt(4, emp.getSal());
			// DB에 쿼리 전송
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(con, ps);
		}
		return result;
	}//insert End
	
}//classEnd
