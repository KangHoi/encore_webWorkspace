package servlet.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BookDAOImpl implements BookDAO{
	private DataSource ds;
	
	private static BookDAOImpl dao = new BookDAOImpl();
	private BookDAOImpl() {
		try {
			InitialContext ic = new InitialContext();
			ds = (DataSource)ic.lookup("java:comp/env/jdbc/mysql");
		} catch(NamingException e) {
			System.out.println(e);
		}
	}
	public static BookDAOImpl getInstance() {
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
	
	public void registerBook(Book vo) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = getConnection();
			
			String query = "INSERT INTO book(isbn, title, catalogue, nation, publish_date, publisher, author, price, description) "
								+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(query);
			
			ps.setString(1, vo.getIsbn());
			ps.setString(2, vo.getTitle());
			ps.setString(3, vo.getCatalogue());
			ps.setString(4, vo.getNation());
			ps.setString(5, vo.getPublish_date());
			ps.setString(6, vo.getPublisher());
			ps.setString(7, vo.getAuthor());
			ps.setInt(8, vo.getPrice());
			ps.setString(9, vo.getDescription());

			ps.executeUpdate(); //추가 해야한다..
		} finally {
			closeAll(ps, conn);
		}
	}
	
	@Override
	public ArrayList<Book> showAllBook() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ArrayList<Book> list = new ArrayList<Book>();
		
		try {
			conn = getConnection();
			
			String query = "SELECT * FROM book";
			ps = conn.prepareStatement(query);

			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Book(
						rs.getString("isbn"),
						rs.getString("title"),
						rs.getString("catalogue"),
						rs.getString("nation"),
						rs.getString("publish_date"),
						rs.getString("publisher"),
						rs.getString("author"),
						rs.getInt("price"),
						rs.getString("description")
						));
			}	
		} finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}
	
}