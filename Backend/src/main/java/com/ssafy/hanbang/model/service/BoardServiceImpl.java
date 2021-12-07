package com.ssafy.hanbang.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ssafy.hanbang.model.BoardDto;
import com.ssafy.hanbang.model.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insertBoard(BoardDto boardDto) throws Exception {
		return sqlSession.getMapper(BoardMapper.class).insertBoard(boardDto);
	}

	@Override
	public List<BoardDto> listBoard() throws Exception {
		return sqlSession.getMapper(BoardMapper.class).listBoard();
	}

	@Override
	public BoardDto selectBoard(int boardno) throws Exception {
		return sqlSession.getMapper(BoardMapper.class).selectBoard(boardno);
	}

	@Override
	public int updateBoard(BoardDto boardDto) throws Exception {
		return sqlSession.getMapper(BoardMapper.class).updateBoard(boardDto);
	}

	@Override
	public int deleteBoard(int boardno) throws Exception {
		return sqlSession.getMapper(BoardMapper.class).deleteBoard(boardno);
	}

	@Override
	public int getBoardno() {
		return sqlSession.getMapper(BoardMapper.class).getBoardno();
	}

	@Override
	public List<Integer> getBoardByEmail(String email) {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(BoardMapper.class).getBoardByEmail(email);
	}

	@Override
	public List<BoardDto> getRank3() {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(BoardMapper.class).getRank3();
	}

	
	
//	@Override
//	@Transactional
//	public void registerBoard(BoardDto boardDto) throws Exception {
//		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
//		boardMapper.registerBoard(boardDto);
//		List<FileInfoDto> fileInfos = boardDto.getFileInfos();
//		if(fileInfos != null && !fileInfos.isEmpty()) {
//			boardMapper.registerFile(boardDto);
//		}
//	}
	
//	@Override
//	@Transactional
//	public void deleteBoard(int boardno, String path) throws Exception {
//		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
//		List<FileInfoDto> fileList = boardMapper.fileInfoList(boardno);
//		boardMapper.deleteFile(boardno);
//		boardMapper.deleteBoard(boardno);
//		for(FileInfoDto fileInfoDto : fileList) {
//			File file = new File(path + File.separator + fileInfoDto.getSaveFolder() + File.separator + fileInfoDto.getSaveFile());
//			file.delete();
//		}
//	}
	

}
