package com.ssafy.hanbang.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.hanbang.model.HouseDealDto;
import com.ssafy.hanbang.model.mapper.HouseDealMapper;

@Service
public class HouseDealServiceImpl implements HouseDealService {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<HouseDealDto> list(int aptCode) throws Exception {
		return sqlSession.getMapper(HouseDealMapper.class).list(aptCode);
	}

}
