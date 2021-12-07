package com.ssafy.hanbang.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.hanbang.model.DongCodeDto;
import com.ssafy.hanbang.model.mapper.DongCodeMapper;

@Service
public class DongCodeServiceImpl implements DongCodeService {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<DongCodeDto> getDong(String gugunName) throws Exception {
		return sqlSession.getMapper(DongCodeMapper.class).getDong(gugunName);
	}

}
