package com.ssafy.hanbang.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.hanbang.model.InterestDto;
import com.ssafy.hanbang.model.mapper.InterestMapper;

@Service
public class InterestServiceImpl implements InterestService {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insertInterest(InterestDto interestDto) {
		return sqlSession.getMapper(InterestMapper.class).insertInterest(interestDto);
	}

	@Override
	public List<InterestDto> listInterest(int userno) {
		return sqlSession.getMapper(InterestMapper.class).listInterest(userno);
	}

	@Override
	public InterestDto selectInterest(int interno) {
		return sqlSession.getMapper(InterestMapper.class).selectInterest(interno);
	}

	@Override
	public int updateInterest(InterestDto interestDto) {
		return sqlSession.getMapper(InterestMapper.class).updateInterest(interestDto);
	}

	@Override
	public int deleteInterest(int interno) {
		return sqlSession.getMapper(InterestMapper.class).deleteInterest(interno);
	}

	@Override
	public int delete(InterestDto interestDto) {
		return sqlSession.getMapper(InterestMapper.class).delete(interestDto);
	}

	@Override
	public int get(InterestDto interestDto) {
		return sqlSession.getMapper(InterestMapper.class).get(interestDto);
	}
	
	

}
