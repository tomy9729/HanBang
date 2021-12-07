package com.ssafy.hanbang.model.service;

import java.util.List;

import com.ssafy.hanbang.model.BoardDto;

public interface BoardService {

	public int insertBoard(BoardDto boardDto) throws Exception;
	public List<BoardDto> listBoard() throws Exception;
	public BoardDto selectBoard(int boardno) throws Exception;
	public int updateBoard(BoardDto boardDto) throws Exception;
	public int deleteBoard(int boardno) throws Exception;
	int getBoardno();
	List<Integer> getBoardByEmail(String email);
	
	List<BoardDto> getRank3();
		
}
