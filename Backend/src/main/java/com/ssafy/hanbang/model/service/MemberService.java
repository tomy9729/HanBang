package com.ssafy.hanbang.model.service;

import java.sql.SQLException;

import com.ssafy.hanbang.model.MemberDto;

public interface MemberService {
	
//	public MemberDto login(MemberDto memberDto) throws Exception;
//	public MemberDto userInfo(String email) throws Exception;
	
	public int insert(MemberDto memberDto) throws Exception;
	public MemberDto select(String email) throws SQLException;
	public int delete(String email) throws Exception;
	public int update(MemberDto memberDto) throws Exception;
	public int count() throws Exception;
}
