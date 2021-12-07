package com.ssafy.hanbang.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.hanbang.model.HouseInfoDto;
import com.ssafy.hanbang.model.mapper.HouseInfoMapper;

@Service
public class HouseInfoServiceImpl implements HouseInfoService {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<HouseInfoDto> list(String dongCode) throws Exception {
		return sqlSession.getMapper(HouseInfoMapper.class).list(dongCode);
	}

	@Override
	public HouseInfoDto select(int aptCode) throws Exception {
		return sqlSession.getMapper(HouseInfoMapper.class).select(aptCode);
	}

}
