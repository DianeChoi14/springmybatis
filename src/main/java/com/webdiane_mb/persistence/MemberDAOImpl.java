package com.webdiane_mb.persistence;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webdiane_mb.domain.MemberVO;

@Repository // 현재클래스가 DAO객체임을 스프링에게 알려주고, 스프링 컨테이너에 의해 관리되도록 한다.
public class MemberDAOImpl implements MemberDAO 
{	
	@Autowired // Inject는 자바 병용 프레임워크에서 모두 사용 가능, Autowired는 스프링 전용(조금 더 빠르다)
	private SqlSessionTemplate sqlSession ;
	private static String NS = "com.webdiane_mb.mapper.MemberMapper";
	
	@Override
	public String getTime() 
	{
		return sqlSession.selectOne(NS + ".getTime");
	}
	
	@Override
	public int registerMember(MemberVO newMember)
	{
		return sqlSession.insert(NS + ".saveMember", newMember);
	}
	
	@Override
	public MemberVO selectMemberByUserID(String userId)
	{
		return sqlSession.selectOne(NS + ".getMemberByUserId", userId);
	}

	@Override
	public List<MemberVO> selectAllMembers() 
	{
		return sqlSession.selectList(NS + ".getAllMembers");
	}
	
	
}
