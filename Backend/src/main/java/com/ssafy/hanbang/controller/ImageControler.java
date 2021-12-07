package com.ssafy.hanbang.controller;

import java.io.IOException;
import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.hanbang.model.ImageDto;
import com.ssafy.hanbang.model.service.ImageService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/image")
@Api("이미지 컨트롤러")
public class ImageControler {

	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	ImageService service;
	
	@ApiOperation(value = "사진 저장", notes = "새로운 board 정보를 입력한다.성공 여부에 따라 success 또는 fail을 반환한다.", response = String.class)
	@PostMapping
	public ResponseEntity<String> insertImage(@RequestBody ImageDto imagedto) throws IOException{
		String encodedString = imagedto.getImageName();
		int bno = imagedto.getBno();
		int hno = imagedto.getHno();
		if(service.saveImage(encodedString, bno, hno)==1) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@PutMapping
	public ResponseEntity<String> updateImage(@RequestBody ImageDto imagedto) throws IOException{
		if(service.update(imagedto)==1) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/{imageno}")
	public ResponseEntity<String> selectImage(@PathVariable int imageno){
		return new ResponseEntity<String>(service.select(imageno), HttpStatus.OK);
	}
	
	@GetMapping("/bno/{bno}")
	public ResponseEntity<List<String>> selectBybno(@PathVariable int bno){
		return new ResponseEntity<List<String>>(service.selectBybno(bno), HttpStatus.OK);
	}
	
	@DeleteMapping("/bno/{bno}")
	public ResponseEntity<String> deleteBybno(@PathVariable int bno){
		if(service.deleteBybno(bno)==1) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/hno/{hno}")
	public ResponseEntity<List<String>> selectByhno(@PathVariable int hno){
		return new ResponseEntity<List<String>>(service.selectByhno(hno), HttpStatus.OK);
	}
	@DeleteMapping("/hno/{hno}")
	public ResponseEntity<String> deleteByhno(@PathVariable int hno){
		if(service.deleteByhno(hno)==1) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/imageno")
	public ResponseEntity<String> getImageno(){
		return new ResponseEntity<String>(Integer.toString(service.getImageno()), HttpStatus.OK);
	}
	
}
