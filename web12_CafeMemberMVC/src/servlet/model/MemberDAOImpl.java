package servlet.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import config.ServerInfo;

public class MemberDAOImpl implements MemberDAO{
	//싱글톤...
	private static MemberDAOImpl dao = new MemberDAOImpl();
	private DataSource ds;
//	private MemberDAOImpl() {
//		try {
//			Class.forName(ServerInfo.DRIVER_NAME);
//			System.out.println("드라이버 로딩 성공...");
//			
//		}catch(ClassNotFoundException e) {
//			System.out.println("드라이버 로딩 실패...");
//		}
//	}
	
	//DataSource방식..
	private MemberDAOImpl() {
		//Naming Service... JNDI Service... 이름으로 객체에 해당하는 주소값 받아온다..
		try {
			InitialContext ic = new InitialContext();
			ds = (DataSource)ic.lookup("java:comp/env/jdbc/mysql");
			System.out.println("DataSource Lookup.. Ok");
		} catch (NamingException e) {
			System.out.println("DataSource Lookup... Fail");
		}
	}
	
	public static MemberDAOImpl getInstance() {
		return dao;
	}
	@Override
	public Connection getConnection() throws SQLException {		
		System.out.println("디비연결 성공....");
		return ds.getConnection(); //인자값은 이미 Context.xml에 다 들어가 있으므로 필요없음 공장에서 하나씩 다 받아옴
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException{
		if(ps!=null) ps.close();		
		if(conn != null) conn.close();
	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException{		
		if(rs != null)	rs.close();
		closeAll(ps, conn);		
	}

	@Override
	public void registerMember(MemberVO vo) throws SQLException {		
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn=  getConnection();
			String query = "INSERT INTO member VALUES(?,?,?,?)";
			ps = conn.prepareStatement(query);
			System.out.println("PreparedStatement 생성됨...registerMember");
			
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getPassword());
			ps.setString(3, vo.getName());
			ps.setString(4, vo.getAddress());
			
			System.out.println(ps.executeUpdate()+" row INSERT OK!!");
		}finally{
			closeAll(ps, conn);
		}
	}

	@Override
	public ArrayList<MemberVO> showAllMember() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<MemberVO> list = new ArrayList<>();
		try {
			conn = getConnection();
			String query = "SELECT id, password, name, address FROM member";
			ps = conn.prepareStatement(query);
			System.out.println("PreparedStatement.... RegisterMember()...");
			
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new MemberVO(
						rs.getString("id"),
						rs.getString("password"),
						rs.getString("name"),
						rs.getString("address")));
			}
		}finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}

	@Override
	public MemberVO findByIdMember(String id) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		MemberVO vo = null;
		try{
			conn = getConnection();
			//
			String query = "SELECT id, password, name, address FROM member WHERE id=?";
			ps = conn.prepareStatement(query);
			System.out.println("PreparedStatement....findByIdMember()..");
			
			ps.setString(1,id);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				vo =  new MemberVO(id, 
								   rs.getString("password"), 
								   rs.getString("name"),
								   rs.getString("address"));
			}
		}finally{
			closeAll(rs, ps, conn);
		}
		return vo;
	}	
	
	


	
	public static void main(String[] args) throws Exception {
		MemberDAOImpl dao=MemberDAOImpl.getInstance();
		//MemberVO VO = dao.findByIdMember("encore");
		//System.out.println(VO);
		
		ArrayList<MemberVO> list = dao.showAllMember();
		System.out.println(list);
	}

}





