package com.webdiane_mb.domain;

import java.sql.Timestamp;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@ToString
@Builder
public class MemberVO
{
	private String userId;
	private String userPwd;
	private String userName;
	private String mobile;
	private String email;
	private Timestamp registerDate;
	private String userImg;
	private int userPoint;
	
}
