package com.ssafy.hanbang.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.hanbang.model.CommentDto;
import com.ssafy.hanbang.model.mapper.CommentMapper;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insertComment(CommentDto commentDto) {
		return sqlSession.getMapper(CommentMapper.class).insertComment(commentDto);
	}

	@Override
	public List<CommentDto> listComment(int boardno) {
		return sqlSession.getMapper(CommentMapper.class).listComment(boardno);
	}

	@Override
	public CommentDto selectComment(int comno) {
		return sqlSession.getMapper(CommentMapper.class).selectComment(comno);
	}

	@Override
	public int updateComment(CommentDto commentDto) {
		return sqlSession.getMapper(CommentMapper.class).updateComment(commentDto);
	}

	@Override
	public int deleteComment(int comno) {
		return sqlSession.getMapper(CommentMapper.class).deleteComment(comno);
	}

	@Override
	public int deleteBoardComment(int boardno) {
		return sqlSession.getMapper(CommentMapper.class).deleteBoardComment(boardno);
	}

}
