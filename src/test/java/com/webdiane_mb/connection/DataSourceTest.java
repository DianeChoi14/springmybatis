package com.webdiane_mb.connection;

import java.sql.Connection;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) // test패키지에서 Spring Container에 접근할 수 있도록 함(현재 영역이 다르므로)
@ContextConfiguration // root-context.xml파일의 위치를 제공하여 파일에 접근할 수 잇도록
(
	locations= {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"} // 하드디스크(file), **로드할 파일 사이에 폴더가 위치할 수 있음을 암시
)
public class DataSourceTest 
{	
	@Inject
	private DataSource ds; // Spring container(스프링메모리)에서 데이터타입이 DataSource인 객체를 찾아-설정파일(root-context.xml)을-의존성(객체)주입
	// 스프링에서는 new하여 객체를 생성할 필요 없이 스프링에서 관리하고 있는 데이터를 사용
	
	
	@Test
	public void testConnection() throws SQLException
	{
		//System.out.println("ds출력"+ds.toString());
		
		Connection con = ds.getConnection();
		if(con!=null) System.out.println("연결성공");
	}
}
