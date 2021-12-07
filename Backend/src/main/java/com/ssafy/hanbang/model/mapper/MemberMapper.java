package com.ssafy.hanbang.model.mapper;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.hanbang.model.MemberDto;

@Mapper
public interface MemberMapper {
	
//	public MemberDto login(MemberDto memberDto) throws SQLException;
//	public MemberDto userInfo(String email) throws SQLException;
	
	public int insert(MemberDto memberDto) throws SQLException;
	//여기가 select넣을 자리
	public MemberDto select(String email) throws SQLException;
	public int delete(String email) throws SQLException;
	public int update(MemberDto memberDto) throws SQLException;
	public int count() throws SQLException;
}
