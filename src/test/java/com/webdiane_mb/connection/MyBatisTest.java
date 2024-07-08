package com.webdiane_mb.connection;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) // test패키지에서 Spring Container에 접근할 수 있도록 함(현재 영역이 다르므로)
@ContextConfiguration // root-context.xml파일의 위치를 제공하여 파일에 접근할 수 잇도록
(
	locations= {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"} // 하드디스크(file), **로드할 파일 사이에 폴더가 위치할 수 있음을 암시
)
public class MyBatisTest 
{
	@Inject
	private SqlSessionFactory sqlFactory; // Spring 컨테이너에서 SqlSessionFactory 객체를 찾아 주입
	
	@Test
	public void testSqlSessionFactory()
	{
		System.out.println("연결확인 :" + sqlFactory.toString());
		
		SqlSession session = sqlFactory.openSession();
		if(session!=null) System.out.println("세션확인 :" + session.toString());
	}
}
