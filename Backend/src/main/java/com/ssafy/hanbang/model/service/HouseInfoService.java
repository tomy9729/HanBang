package com.ssafy.hanbang.model.service;

import java.util.List;

import com.ssafy.hanbang.model.HouseInfoDto;

public interface HouseInfoService {

	List<HouseInfoDto> list(String dongCode) throws Exception;
	HouseInfoDto select(int aptCode) throws Exception;
}
