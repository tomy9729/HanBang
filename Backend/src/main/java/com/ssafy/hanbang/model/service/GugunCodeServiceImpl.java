package com.ssafy.hanbang.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.hanbang.model.GugunCodeDto;
import com.ssafy.hanbang.model.mapper.GugunCodeMapper;

@Service
public class GugunCodeServiceImpl implements GugunCodeService {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<GugunCodeDto> getGugun() throws Exception {
		return sqlSession.getMapper(GugunCodeMapper.class).getGugun();
	}

}
