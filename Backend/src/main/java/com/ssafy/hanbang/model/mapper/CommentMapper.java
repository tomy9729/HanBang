package com.ssafy.hanbang.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.hanbang.model.CommentDto;

@Mapper
public interface CommentMapper {

	public int insertComment(CommentDto commentDto);
	public List<CommentDto> listComment(int boardno);
	public CommentDto selectComment(int comno);
	public int updateComment(CommentDto commentDto);
	public int deleteComment(int comno);
	public int deleteBoardComment(int boardno);
}
