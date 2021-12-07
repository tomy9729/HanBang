package com.ssafy.hanbang.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.hanbang.model.CommentDto;
import com.ssafy.hanbang.model.service.CommentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/comment")
@Api("comment 컨트롤러 API V1")
public class CommentController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	private CommentService commentService;

	// comment start
	@ApiOperation(value = "새로운 댓글 입력", notes = "새로운 댓글을 입력한다. DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping
	public ResponseEntity<String> insertComment(@RequestBody CommentDto commentDto){
		if (commentService.insertComment(commentDto) == 1) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "boardno 즉, 해당 보드의 댓글 목록 조회", notes = "해당 보드의 댓글 정보를 반환한다.", response = List.class)
	@GetMapping("/list/{boardno}")
	public ResponseEntity<List<CommentDto>> listComment(@PathVariable int boardno) {
		return new ResponseEntity<List<CommentDto>>(commentService.listComment(boardno), HttpStatus.OK);
	}

	@ApiOperation(value = "comno 즉, 코멘트 번호에 해당하는 댓글 조회", notes = "해당 댓글의 정보를 반환한다.", response = CommentDto.class)
	@GetMapping("/{comno}")
	public ResponseEntity<CommentDto> selectComment(@PathVariable int comno) {
		return new ResponseEntity<CommentDto>(commentService.selectComment(comno), HttpStatus.OK);
	}

	@ApiOperation(value = "comno 즉, 코멘트 번호에 해당하는 댓글 수정", notes = "해당 댓글의 정보를 수정한다. DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PutMapping("/{comno}")
	public ResponseEntity<String> updateComment(@RequestBody CommentDto commentDto) {
		if (commentService.updateComment(commentDto) == 1) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "comno 즉, 코멘트 번호에 해당하는 댓글 삭제", notes = "해당 댓글을 삭제한다. DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@DeleteMapping("/{comno}")
	public ResponseEntity<String> deleteComment(@PathVariable int comno) {
		if (commentService.deleteComment(comno) == 1) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "boardno 즉, 보드가 삭제되면 해당되는 comment다 삭제", notes = "보드에 해당하는 모든 comment를 삭제한다. DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@DeleteMapping("/boardcom/{boardno}")
	public ResponseEntity<String> deleteBoardComment(@PathVariable int boardno){
		if(commentService.deleteBoardComment(boardno) >= 1) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@GetMapping
	public String dontUse() {
		return "stop";
	}
	// comment end
}
