package com.ssafy.hanbang.model.service;

import org.springframework.stereotype.Service;

import com.ssafy.hanbang.model.BoardHouseLinkDto;


public interface BoardHouseLinkService {
	int insert(BoardHouseLinkDto nhldto);
	BoardHouseLinkDto select(int boardno);
}
