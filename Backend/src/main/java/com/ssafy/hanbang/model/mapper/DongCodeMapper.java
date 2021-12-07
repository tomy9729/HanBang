package com.ssafy.hanbang.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.hanbang.model.DongCodeDto;

@Mapper
public interface DongCodeMapper {
	
	List<DongCodeDto> getDong(String gugunName) throws SQLException;
}
