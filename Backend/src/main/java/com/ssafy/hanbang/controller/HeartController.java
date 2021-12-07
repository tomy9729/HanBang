package com.ssafy.hanbang.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.hanbang.model.HeartDto;
import com.ssafy.hanbang.model.service.HeartService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/heart")
@Api("좋아요 컨트롤러 API V1")
public class HeartController {

	private static final Logger logger = LoggerFactory.getLogger(HeartController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private HeartService heartService;
	
	@ApiOperation(value = "좋아요", notes = "좋아요 정보를 입력한다. 성공 여부에 따라 success 또는 fail을 반환한다.", response = String.class)
	@PostMapping
	public ResponseEntity<String> insertHeart(@RequestBody HeartDto heartDto) throws Exception{
		if(heartService.insertHeart(heartDto)==1) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value = "좋아요 취소", notes = "사용자(email)와 보드번호(boardno)를 넣으면 좋아요를 삭제한다. 성공 여부에 따라 success 또는 fail을 반환한다.", response = String.class)
	@DeleteMapping
	public ResponseEntity<String> deleteHeart(@RequestBody HeartDto heartDto) throws Exception{
		if(heartService.deleteHeart(heartDto)==1) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	// 사용자가 좋아요한 게시글 수
	@ApiOperation(value = "좋아요게시글", notes = "사용자가 좋아요한 게시글의 수를 반환한다.", response = Integer.class)
	@GetMapping("/board/{email}")
	public ResponseEntity<Integer> countHeartUser(@PathVariable String email) throws Exception{
		return new ResponseEntity<Integer>(heartService.countHeartUser(email), HttpStatus.OK);
	}
	
	// 사용자가 좋아요한 게시글 목록
	@ApiOperation(value = "좋아요게시글목록", notes = "사용자가 좋아요한 게시글의 목록을 반환한다.", response = List.class)
	@GetMapping("/boardlist/{email}")
	public ResponseEntity<List<HeartDto>> listHeartUser(@PathVariable String email) throws Exception{
		return new ResponseEntity<List<HeartDto>>(heartService.listHeartUser(email), HttpStatus.OK);
	}
	
	// 게시글의 좋아요한 사용자 수
	@ApiOperation(value = "좋아요사용자수", notes = "게시글의 좋아요한 사용자 수를 반환한다.", response = Integer.class)
	@GetMapping("/user/{boardno}")
	public ResponseEntity<Integer> countHeartBoard(@PathVariable int boardno) throws Exception{
		return new ResponseEntity<Integer>(heartService.countHeartBoard(boardno), HttpStatus.OK);
	}
	
	// 게시글의 좋아요한 사용자 목록
	@ApiOperation(value = "좋아요사용자목록", notes = "게시글의 좋아요한 사용자의 목록을 반환한다.", response = List.class)
	@GetMapping("/userlist/{boardno}")
	public ResponseEntity<List<HeartDto>> listHeartBoard(@PathVariable int boardno) throws Exception{
		return new ResponseEntity<List<HeartDto>>(heartService.listHeartBoard(boardno), HttpStatus.OK);
	}
	
	@GetMapping("/isHeart/{boardno}/{email}")
	public ResponseEntity<String> isHeart(@PathVariable int boardno, @PathVariable String email) {
		HeartDto heartdto = new HeartDto();
		heartdto.setBoardno(boardno);
		heartdto.setEmail(email);
		heartdto.setHeartno(0);
		return new ResponseEntity<String>(Integer.toString(heartService.getHeart(heartdto)), HttpStatus.OK);
	}
}
