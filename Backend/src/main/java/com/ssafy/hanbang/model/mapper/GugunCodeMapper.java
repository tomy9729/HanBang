package com.ssafy.hanbang.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.hanbang.model.GugunCodeDto;

@Mapper
public interface GugunCodeMapper {
	
	List<GugunCodeDto> getGugun() throws SQLException;
}
