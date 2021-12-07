package com.ssafy.hanbang.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.hanbang.model.FollowDto;
import com.ssafy.hanbang.model.mapper.FollowMapper;

@Service
public class FollowServiceImpl implements FollowService {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insertFollow(FollowDto followDto) throws Exception {
		return sqlSession.getMapper(FollowMapper.class).insertFollow(followDto);
	}

	@Override
	public int deleteFollow(FollowDto followDto) throws Exception {
		return sqlSession.getMapper(FollowMapper.class).deleteFollow(followDto);
	}

	@Override
	public List<FollowDto> listFollowFromuser(String fromuser) throws Exception {
		return sqlSession.getMapper(FollowMapper.class).listFollowFromuser(fromuser);
	}

	@Override
	public int getCountFromuser(String fromuser) throws Exception {
		return sqlSession.getMapper(FollowMapper.class).getCountFromuser(fromuser);
	}

	@Override
	public List<FollowDto> listFollowTouser(String touser) throws Exception {
		return sqlSession.getMapper(FollowMapper.class).listFollowTouser(touser);
	}

	@Override
	public int getCountTouser(String touser) throws Exception {
		return sqlSession.getMapper(FollowMapper.class).getCountTouser(touser);
	}

	@Override
	public int getFromTo(FollowDto followDto) {
		return sqlSession.getMapper(FollowMapper.class).getFromTo(followDto);
	}

}
