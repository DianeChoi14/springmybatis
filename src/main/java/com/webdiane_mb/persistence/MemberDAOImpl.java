package com.webdiane_mb.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	/*
	@Override
	public int updateMemberMobile(String userId, String Mobile) //
	{
	업데이트 sql문에서 파라미터가 2개일 때 > Map 사용
	*/
	
	@Override
	public int updateMemberMobile(String userId, String Mobile) 
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("mobile", Mobile);
		params.put("userId", userId);
		return sqlSession.update(NS + ".modifyMobile", params);
	}
	
	// SqlSession Template.update()는 파라미터를 1개만 받을 수 있다. 이 쿼리문은 파라미터가 2개이므로 Map으로 파라미터를 감싸서 넘긴다
	// 오토와이어드, 인젝트로 주입하는 의존성 객체는 스프링이 관리하는 객체여야 함(root-context.xml의 beans에 있는 객체)
	// root-context.xml에 beans에 선언하면 스프링 컨테이너 메모리에서 계속 사용되므로 X, 클래스 내에서 선언하여 사용 

	@Override
	public int removeMember(String userId) 
	{
		return sqlSession.delete(NS + ".removeMember", userId);
	}


}
