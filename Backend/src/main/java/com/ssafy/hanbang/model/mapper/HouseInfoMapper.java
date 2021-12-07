package com.ssafy.hanbang.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.hanbang.model.HouseInfoDto;

@Mapper
public interface HouseInfoMapper {
	
	List<HouseInfoDto> list(String dongCode) throws SQLException;
	HouseInfoDto select(int aptCode) throws SQLException;
}
