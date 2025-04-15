package kr.ac.kopo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

// SQL 의 SELECT를 써보겠다!
// t_test 테이블의 id, name 조회

public class SELECTMain01 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		try {
			// 1단계 : 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩완료...");

			// 2단계 : DB접속 Connection 객체 얻기
			String url 		= "jdbc:oracle:thin:@localhost:1521:xe";
			String user 	= "hr";
			String password = "hr";

			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("conn : " + conn);

			// 3단계 : 쿼리생성 및 실행
			// String sql = "select id, name";
			String sql = "select id as 아이디, name as 이름";
			       sql += " from t_test ";
			       sql += " order by id ";
					
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

//			while(rs.next()) {
//				String id = rs.getString("id");
//				String name = rs.getString("name");
//				System.out.println(id + "("+name+")");
//			}
			
			while(rs.next()) {
				String id = rs.getString("아이디");
				String name = rs.getString("이름");
				System.out.println(id + "("+name+")");
			}
			
//			while(rs.next()) {
//				String id = rs.getString(1);
//				String name = rs.getString(2);
//				System.out.println(id + "("+name+")");
//			}
			
			
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
