package com.webdiane_mb.daotest;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.webdiane_mb.domain.MemberVO;
import com.webdiane_mb.persistence.MemberDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class MemberDAOTest 
{
	
	@Autowired
	private MemberDAO mdao;
	
	/*
	@Test
	public void testGetTime()
	{
		
		System.out.println( mdao.getTime());
	}
	*/
	
	// CRUD(Create데이터 생성
	/*
	@Test
	public void testInsertMember()
	{
		MemberVO newMember = MemberVO.builder()
		.userId("douner")
		.userPwd("1234")
		.userName("도우")
		.mobile("010-1111-1111")
		.email("dooly@abc.com")
		.build(); // builder패턴 : setter로 반환하여 객체를 생성한다
		
		if(mdao.registerMember(newMember)==1) System.out.println("회원 저장 성공");
	}
	/*
	
	
	/*
	@Test
	public void selectMemeberById()
	{
		System.out.println(mdao.selectMemberByUserID("dooly").toString());
	}
	*/
	
	@Test
	public void selectAllMemebersTest()
	{
		List<MemberVO> members = mdao.selectAllMembers();
		for (MemberVO m : members) // memebers에서 하나씩 꺼내서 memberVO에 저장시킨다.
		{
			System.out.println(m.toString());
		}
	}
}
