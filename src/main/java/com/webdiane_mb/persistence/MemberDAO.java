package com.webdiane_mb.persistence;

import java.util.List;

import com.webdiane_mb.domain.MemberVO;

// Interface : 추상메서드(바디가 없는 메서드), 상수, dafault메서드만 가질 수 있다.
public interface MemberDAO 
{
	// DB서버의 현재 날짜와 시간을 얻어오는 메서드로 만들기
	// > 쿼리문을 사용하여 Mybatis에 Mapper파일을 만들어준다
	public String getTime(); 
	
	//default int countMember() { return 0; } 
	
	public int registerMember(MemberVO newmember);
	
	// userId로 회원정보를 얻어오는 메서드
	public MemberVO selectMemberByUserID(String userId);
	
	// 모든 회원정보를 가져오는 메서드
	public List<MemberVO> selectAllMembers();
	
	// 회원의 전화번호를 변경하는 메서드
	public int updateMemberMobile(String userId, String Mobile);
	
	// 회원의 정보를 삭제하는 메서드
	public int removeMember(String userId);
	

}
