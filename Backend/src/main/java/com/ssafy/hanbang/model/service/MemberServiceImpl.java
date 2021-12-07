package com.ssafy.hanbang.model.service;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.hanbang.model.MemberDto;
import com.ssafy.hanbang.model.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private SqlSession sqlSession;
	
//	@Override
//	public MemberDto login(MemberDto memberDto) throws Exception {
//		if(memberDto.getEmail() == null || memberDto.getPwd() ==null)
//			return null;
//		return sqlSession.getMapper(MemberMapper.class).login(memberDto);
//	}
//
//	@Override
//	public MemberDto userInfo(String email) throws Exception {
//		return sqlSession.getMapper(MemberMapper.class).userInfo(email);
//	}

	@Override
	public MemberDto select(String email) throws SQLException {
		return sqlSession.getMapper(MemberMapper.class).select(email);
	}	
	
	@Override
	public int insert(MemberDto memberDto) throws Exception {
		return sqlSession.getMapper(MemberMapper.class).insert(memberDto);
	}

	@Override
	public int delete(String email) throws Exception {
		return sqlSession.getMapper(MemberMapper.class).delete(email);
	}

	@Override
	public int update(MemberDto memberDto) throws Exception {
		return sqlSession.getMapper(MemberMapper.class).update(memberDto);
	}

	@Override
	public int count() throws Exception {
		return sqlSession.getMapper(MemberMapper.class).count();
	}

	

}
