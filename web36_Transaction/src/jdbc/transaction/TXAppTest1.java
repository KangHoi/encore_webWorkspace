package jdbc.transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import config.ServerInfo;

public class TXAppTest1 {
	public static void main(String[] args) throws Exception{
		Class.forName(ServerInfo.DRIVER_NAME);
		System.out.println("드라이버 로딩..");
		
		Connection conn = DriverManager.getConnection(ServerInfo.URL, "root", "1234");
		System.out.println("디비 연결 성공....");
		
		//2개의 쿼리문 작성... 최소 단위인 이 두 쿼리문을 하나의 단위로 묶는 작업이 transaction
		String query1 = "INSERT INTO test(name, birthday) VALUES(?,?)";
		String query2 = "SELECT num, name, birthday FROM test WHERE num=?";
		
		//위 2개의 작업을 transaction 처리함(더 이상 쪼갤 수 없는 원자단위로 묶음)
		//transaction의 시작..//////////////////////////////////
		conn.setAutoCommit(false); //자동 커밋 해제
		
		PreparedStatement ps = conn.prepareStatement(query1);
		ps.setString(1, "전지현");
		ps.setString(2, "1980-01-22"); //2
		ps.executeUpdate();
		
		PreparedStatement ps2 = conn.prepareStatement(query2);
		ps2.setInt(1, 4);//num=4인 사람은 없으므로 에러.. rollback.. 위 부분의 전지현도 함께 롤백되므로 추가 안됨
		ResultSet rs = ps2.executeQuery();
		if(!rs.next()) {//4에 해당하는 사람이 존재하지 않는다면
			//rollback.. 
			conn.rollback();
			System.out.println("찾는 번호에 해당하는 사람이 없어서 rollback 합니다.. 전지현 추가 안됨!");
		}else {//만약 4에 해당하는 사람이 존재한다면
			//commit..
			conn.commit();
			System.out.println("번호에 해당하는 사람이 있어 commit 합니다.. 전지현 추가됨!");
		}
		//이 안에 들어오는 모든 작업은 원자성을 가진다.
		//transaction 마무리... 다시 원래대로 돌려놓음
		conn.setAutoCommit(true);
		////////transaction 끝.../////////////에러날 경우 rollback 정상 실행일 경우 commit////////////
		
	}

}
