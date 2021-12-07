package com.ssafy.hanbang.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.hanbang.model.BaseAddressDto;
import com.ssafy.hanbang.model.DongCodeDto;
import com.ssafy.hanbang.model.GugunCodeDto;
import com.ssafy.hanbang.model.HouseDealDto;
import com.ssafy.hanbang.model.HouseInfoDto;
import com.ssafy.hanbang.model.service.BaseAddressService;
import com.ssafy.hanbang.model.service.DongCodeService;
import com.ssafy.hanbang.model.service.GugunCodeService;
import com.ssafy.hanbang.model.service.HouseDealService;
import com.ssafy.hanbang.model.service.HouseInfoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/apt")
@Api("House Map Controller API V1")
public class HouseMapController {
	private static final Logger logger = LoggerFactory.getLogger(HouseMapController.class);
	
	@Autowired
	private GugunCodeService ggservice;
	@Autowired
	private DongCodeService dcservice;
	@Autowired
	private BaseAddressService baservice;
	@Autowired
	private HouseInfoService hiservice;
	@Autowired
	private HouseDealService hdservice;
	
	
	@ApiOperation(value= "구군 정보", notes = "구군의 정보를 반환한다.", response = List.class)
	@GetMapping("/gugunlist")
	public List<GugunCodeDto> gugun() throws Exception{
		logger.info("gugun - 호출");
		return ggservice.getGugun();
	}
	
	@ApiOperation(value="동리스트 정보", notes="동 전체 정보를 반환한다.", response = List.class)
	@GetMapping("/donglist/{gugunName}")
	public List<DongCodeDto> donglist(@PathVariable String gugunName) throws Exception{
		logger.info("donglist - 호출");
		return dcservice.getDong(gugunName);
	}
	
	@ApiOperation(value = "동 정보", notes = "동 정보를 반환한다.", response = BaseAddressDto.class)
	@GetMapping("/{dongCode}")
	public BaseAddressDto dong(@PathVariable String dongCode) throws Exception {
		logger.info("dong - 호출");
		return baservice.select(dongCode);
	}
	
	@ApiOperation(value = "아파트 리스트", notes = "아파트 리스트를 반환한다.", response = List.class)
	@GetMapping("/dong/{dongCode}")
	public List<HouseInfoDto> aptlist(@PathVariable String dongCode) throws Exception{
		return hiservice.list(dongCode);
	}
	
	@ApiOperation(value = "아파트 정보", notes = "아파트 정보를 반환한다.", response = HouseInfoDto.class)
	@GetMapping("/info/{aptCode}")
	public HouseInfoDto apt(@PathVariable int aptCode) throws Exception {
		return hiservice.select(aptCode);
	}
	
	@ApiOperation(value = "아파트 거래 정보", notes = "아파트 거래 정보를 반환한다.", response = List.class)
	@GetMapping("/deal/{aptCode}")
	public List<HouseDealDto> aptdeal(@PathVariable int aptCode) throws Exception{
		return hdservice.list(aptCode);
	}
}
