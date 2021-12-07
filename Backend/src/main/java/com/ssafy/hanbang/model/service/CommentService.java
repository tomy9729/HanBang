package com.ssafy.hanbang.model.service;

import java.util.List;

import com.ssafy.hanbang.model.CommentDto;

public interface CommentService {

	public int insertComment(CommentDto commentDto);
	public List<CommentDto> listComment(int boardno);
	public CommentDto selectComment(int comno);
	public int updateComment(CommentDto commentDto);
	public int deleteComment(int comno);
	public int deleteBoardComment(int boardno);
}
