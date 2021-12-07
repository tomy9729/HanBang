package com.ssafy.hanbang.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.hanbang.model.BoardDto;

@Mapper
public interface BoardMapper {
	
	public int insertBoard(BoardDto boardDto) throws SQLException;
	public List<BoardDto> listBoard() throws SQLException;
	public BoardDto selectBoard(int boardno) throws SQLException;
	public int updateBoard(BoardDto boardDto) throws SQLException;
	public int deleteBoard(int boardno) throws SQLException;
	int getBoardno();
	List<Integer> getBoardByEmail(String email);
	List<BoardDto> getRank3();
}
