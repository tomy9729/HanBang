package com.ssafy.hanbang.model.mapper;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.hanbang.model.BoardDto;
import com.ssafy.hanbang.model.HeartDto;

public interface HeartMapper {

	public int insertHeart(HeartDto heartDto) throws SQLException;
	public int deleteHeart(HeartDto heartDto) throws SQLException;
	
	// 사용자가 좋아요한 게시글 수 
	public int countHeartUser(String email) throws SQLException;
	// 사용자가 좋아요한 게시글 목록
	public List<HeartDto> listHeartUser(String email) throws SQLException;
	// 사용자가 좋아요한 게시글 목록 상세 조회 가 되나.....
//	public List<BoardDto> listBoardHeartUser(String email) throws SQLException;

	
	// 게시글의 좋아요한 수
	public int countHeartBoard(int boardno) throws SQLException;
	// 게시글의 좋아요한 사용자 목록
	public List<HeartDto> listHeartBoard(int boardno) throws SQLException;
	
	int getHeart(HeartDto heartDto);
}
