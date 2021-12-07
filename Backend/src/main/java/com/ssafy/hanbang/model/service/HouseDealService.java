package com.ssafy.hanbang.model.service;

import java.util.List;

import com.ssafy.hanbang.model.HouseDealDto;

public interface HouseDealService {

	List<HouseDealDto> list(int aptCode) throws Exception;
}
