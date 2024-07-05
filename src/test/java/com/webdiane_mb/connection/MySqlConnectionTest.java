package com.webdiane_mb.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

public class MySqlConnectionTest 
{
	//private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver"; // 암호화된 드라이버
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/webdiane";
	private static final String USER = "root";
	private static final String PASSWORD = "1234";

	@Test
	public void testConnection() throws ClassNotFoundException, SQLException //  throws ClassNotFoundException 객체의예외를 컨트롤러(서비스)로 미루기 위해 쓰는 명령어, try/catch는 여기서 response를 받을 수 없기 때문에 사용X

	{
		
		Class.forName(DRIVER);
		Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
		
		if(con!=null) { System.out.println("연결 성공!");}
	}
}
