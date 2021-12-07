package com.ssafy.hanbang.model.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.hanbang.model.BoardHouseLinkDto;

@Mapper
public interface BoardHouseLinkMapper {
	int insert(BoardHouseLinkDto nhldto);
	BoardHouseLinkDto select(int boardno);
}
