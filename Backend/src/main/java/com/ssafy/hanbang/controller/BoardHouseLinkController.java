package com.ssafy.hanbang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.hanbang.model.BoardHouseLinkDto;
import com.ssafy.hanbang.model.service.BoardHouseLinkService;

@RestController
@RequestMapping("/link")
public class BoardHouseLinkController {
	@Autowired
	BoardHouseLinkService service;
	
	@PostMapping
	public String insert(@RequestBody BoardHouseLinkDto bhldto) {
		if(service.insert(bhldto)==1) {
			return "success";
		}
		return "fail";
	}
	
	@GetMapping("/{boardno}")
	public BoardHouseLinkDto select(@PathVariable int boardno) {
		return service.select(boardno);
	}
}
