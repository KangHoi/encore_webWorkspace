package servlet.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface UserDAO {
	public Connection getConnection() throws SQLException;
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException;
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException;
	
	public UserVO login(String id, String password) throws SQLException;
}
