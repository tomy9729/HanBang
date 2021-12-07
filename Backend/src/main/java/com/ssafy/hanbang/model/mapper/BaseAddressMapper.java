package com.ssafy.hanbang.model.mapper;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.hanbang.model.BaseAddressDto;

@Mapper
public interface BaseAddressMapper {
	
	BaseAddressDto select(String dongCode) throws SQLException;
}
