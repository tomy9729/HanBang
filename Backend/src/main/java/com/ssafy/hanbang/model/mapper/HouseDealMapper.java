package com.ssafy.hanbang.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.hanbang.model.HouseDealDto;

@Mapper
public interface HouseDealMapper {
	
	List<HouseDealDto> list(int aptCode) throws SQLException;
}
