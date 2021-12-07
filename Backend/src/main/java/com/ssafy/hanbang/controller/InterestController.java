package com.ssafy.hanbang.controller;

import java.util.List;

import javax.lang.model.type.IntersectionType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.hanbang.model.InterestDto;
import com.ssafy.hanbang.model.service.InterestService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/interest")
@Api("interest 컨트롤러 API V1")
public class InterestController {

	private static final Logger logger = LoggerFactory.getLogger(HeartController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private InterestService interestService;
	
	@ApiOperation(value = "새로운 관심지역 등록", notes = "새로운 관심지역을 등록한다. DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping
	public ResponseEntity<String> insertInterest(@RequestBody InterestDto interestDto){
		if(interestService.insertInterest(interestDto)==1) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value = "userno 즉, 해당 사용자번호를통해 관심지역 목록 조회", notes = "해당 관심지역 정보를 반환한다.", response = List.class)
	@GetMapping("/list/{userno}")
	public ResponseEntity<List<InterestDto>> listInterest(@PathVariable int userno){
		return new ResponseEntity<List<InterestDto>>(interestService.listInterest(userno), HttpStatus.OK);
	}
	
	@ApiOperation(value = "interno 즉, 하나의 관심지역 번호에 해당하는 정보 조회", notes = "해당 관심지역의 정보를 반환한다.", response = InterestDto.class)
	@GetMapping("/{interno}")
	public ResponseEntity<InterestDto> selectInterest(@PathVariable int interno){
		return new ResponseEntity<InterestDto>(interestService.selectInterest(interno), HttpStatus.OK);
	}
	
	@ApiOperation(value = "interno 즉, 관심지역 번호에 해당하는 정보 수정", notes = "해당 관심지역의 정보를 수정한다. DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PutMapping
	public ResponseEntity<String> updateInterest(@RequestBody InterestDto interestDto){
		if(interestService.updateInterest(interestDto) == 1) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value = "interno 즉, 관심지역 번호에 해당하는 정보 삭제", notes = "해당 정보를 삭제한다. DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@DeleteMapping("/{interno}")
	public ResponseEntity<String> deleteInterest(@PathVariable int interno){
		if(interestService.deleteInterest(interno)==1) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/delete")
	public int delete(@RequestBody InterestDto interestDto){
		return interestService.delete(interestDto);
	}
	
	@GetMapping("/get/{userno}/{aptCode}")
	public int get(@PathVariable int userno, @PathVariable int aptCode){
		InterestDto interestDto = new InterestDto();
		interestDto.setAptCode(aptCode);
		interestDto.setUserno(userno);
		return interestService.get(interestDto);
	}
}
