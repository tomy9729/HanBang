package com.ssafy.hanbang.model.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.hanbang.model.BaseAddressDto;
import com.ssafy.hanbang.model.mapper.BaseAddressMapper;

@Service
public class BaseAddressServiceImpl implements BaseAddressService {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public BaseAddressDto select(String dongCode) throws Exception {
		return sqlSession.getMapper(BaseAddressMapper.class).select(dongCode);
	}

}
