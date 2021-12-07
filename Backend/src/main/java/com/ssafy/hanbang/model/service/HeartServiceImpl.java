package com.ssafy.hanbang.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.hanbang.model.HeartDto;
import com.ssafy.hanbang.model.mapper.HeartMapper;

@Service
public class HeartServiceImpl implements HeartService {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insertHeart(HeartDto heartDto) throws Exception {
		return sqlSession.getMapper(HeartMapper.class).insertHeart(heartDto);
	}

	@Override
	public int deleteHeart(HeartDto heartDto) throws Exception {
		return sqlSession.getMapper(HeartMapper.class).deleteHeart(heartDto);
	}

	@Override
	public int countHeartUser(String email) throws Exception {
		return sqlSession.getMapper(HeartMapper.class).countHeartUser(email);
	}

	@Override
	public List<HeartDto> listHeartUser(String email) throws Exception {
		return sqlSession.getMapper(HeartMapper.class).listHeartUser(email);
	}

	@Override
	public int countHeartBoard(int boardno) throws Exception {
		return sqlSession.getMapper(HeartMapper.class).countHeartBoard(boardno);
	}

	@Override
	public List<HeartDto> listHeartBoard(int boardno) throws Exception {
		return sqlSession.getMapper(HeartMapper.class).listHeartBoard(boardno);
	}

	@Override
	public int getHeart(HeartDto heartDto) {
		return sqlSession.getMapper(HeartMapper.class).getHeart(heartDto);
	}

}
