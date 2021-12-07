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

import com.ssafy.hanbang.model.FollowDto;
import com.ssafy.hanbang.model.service.FollowService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/follow")
@Api("팔로우 컨트롤러 API V1")
public class FollowController {

	private static final Logger logger = LoggerFactory.getLogger(FollowController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private FollowService followService;
	
	
	@ApiOperation(value = "팔로우", notes = "팔로우 정보를 입력한다. 성공 여부에 따라 success 또는 fail을 반환한다.", response = String.class)
	@PostMapping
	public ResponseEntity<String> insertFollow(@RequestBody FollowDto followDto) throws Exception{
		if(followService.insertFollow(followDto)==1) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value = "언팔로우", notes = "fromuser와 touser의 정보를 입력하면 팔로우 정보를 삭제한다. 성공 여부에 따라 success 또는 fail을 반환한다.", response = String.class)
	@DeleteMapping()
	public ResponseEntity<String> deleteFollow(@RequestBody FollowDto followDto) throws Exception {
		if(followService.deleteFollow(followDto) == 1) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	// 사용자"가" 구독한 사용자들은?
	@ApiOperation(value = "팔로잉", notes = "사용자가! 구독한 사용자 목록을 반환한다.", response = List.class)
	@GetMapping("/from/{fromuser}")
	public ResponseEntity<List<FollowDto>> listFollowFromuser(@PathVariable String fromuser) throws Exception{
		return new ResponseEntity<List<FollowDto>>(followService.listFollowFromuser(fromuser), HttpStatus.OK);
	}
	
	// 사용자"가" 구독한 사용자들 수
	@ApiOperation(value = "팔로잉수", notes = "사용자가! 구독한 사용자의 수를 반환한다.", response = Integer.class)
	@GetMapping("/fromcount/{fromuser}")
	public ResponseEntity<Integer> getCountFromuser(@PathVariable String fromuser) throws Exception{
		return new ResponseEntity<Integer>(followService.getCountFromuser(fromuser), HttpStatus.OK);
//		if(followService.getCountFromuser(fromuser) >= 1) {
//			return new ResponseEntity<Integer>()
//		}
	}
	
	// 사용자"를" 구독한 사용자들은?
	@ApiOperation(value = "팔로워", notes = "사용자를! 구독한 사용자 목록을 반환한다.", response = List.class)
	@GetMapping("/to/{touser}")
	public ResponseEntity<List<FollowDto>> listFollowTouser(@PathVariable String touser) throws Exception{
		return new ResponseEntity<List<FollowDto>>(followService.listFollowTouser(touser), HttpStatus.OK);
	}
	
	// 사용자"를" 구독한 사용자들 수
	@ApiOperation(value = "팔로워수", notes = "사용자를! 구독한 사용자의 수를 반환한다.", response = Integer.class)
	@GetMapping("/tocount/{touser}")
	public ResponseEntity<Integer> getCountTouser(@PathVariable String touser) throws Exception{
		return new ResponseEntity<Integer>(followService.getCountTouser(touser), HttpStatus.OK);
	}
	
	@GetMapping("/{fromuser}/{touser}")
	public ResponseEntity<Integer> getFromTo(@PathVariable String fromuser, @PathVariable String touser) throws Exception{
		FollowDto follodto = new FollowDto();
		follodto.setFromuser(fromuser);
		follodto.setTouser(touser);
		return new ResponseEntity<Integer>(followService.getFromTo(follodto), HttpStatus.OK);
	}
}
