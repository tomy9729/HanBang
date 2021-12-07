package com.ssafy.hanbang.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.hanbang.model.BoardHouseLinkDto;
import com.ssafy.hanbang.model.mapper.BoardHouseLinkMapper;

@Service
public class BoardHouseLinkServiceImpl implements BoardHouseLinkService{

	@Autowired
	BoardHouseLinkMapper mapper;
	
	@Override
	public int insert(BoardHouseLinkDto nhldto) {
		return mapper.insert(nhldto);
	}

	@Override
	public BoardHouseLinkDto select(int boardno) {
		return mapper.select(boardno);
	}

}
