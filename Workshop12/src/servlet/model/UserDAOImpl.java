package servlet.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class UserDAOImpl implements UserDAO{
	private DataSource ds;
	
	private static UserDAOImpl dao = new UserDAOImpl();
	private UserDAOImpl() {
		try {
			Context ic = new InitialContext(); //Naming Service를 위한 객체..
			ds = (DataSource)ic.lookup("java:comp/env/jdbc/mysql");
		} catch(NamingException e) {
			System.out.println(e);
		}
	}
	public static UserDAOImpl getInstance() {
		return dao;
	}
	
	@Override
	public Connection getConnection() throws SQLException {
		return ds.getConnection();
	}
	
	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		if(ps!=null) ps.close();
		if(conn!=null) conn.close();
	}
	
	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if(rs!=null) rs.close();
		closeAll(ps, conn);
	}
	
	@Override
	public UserVO login(String userId, String password) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		UserVO vo = null;
		
		try {
			conn = getConnection();
			String query = "SELECT * FROM userinfo WHERE userId=? AND password=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, userId);
			ps.setString(2, password);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				vo = new UserVO(userId, password, rs.getString("name"), rs.getString("email"));
			}	
		} finally {
			closeAll(rs, ps, conn);
		}
		return vo;
	}
	
}