package com.ssafy.hanbang.model.service;

import java.util.List;

import com.ssafy.hanbang.model.HeartDto;

public interface HeartService {

	public int insertHeart(HeartDto heartDto) throws Exception;
	public int deleteHeart(HeartDto heartDto) throws Exception;
	
	// 사용자가 좋아요한 게시글 수 
	public int countHeartUser(String email) throws Exception;
	// 사용자가 좋아요한 게시글 목록
	public List<HeartDto> listHeartUser(String email) throws Exception;
	// 사용자가 좋아요한 게시글 목록 상세 조회 가 되나.....
//	public List<BoardDto> listBoardHeartUser(String email) throws SQLException;

	
	// 게시글의 좋아요한 수
	public int countHeartBoard(int boardno) throws Exception;
	// 게시글의 좋아요한 사용자 목록
	public List<HeartDto> listHeartBoard(int boardno) throws Exception;
	
	int getHeart(HeartDto heartDto);
}
