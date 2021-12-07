package com.ssafy.hanbang.model.service;

import java.util.List;

import com.ssafy.hanbang.model.DongCodeDto;

public interface DongCodeService {

	List<DongCodeDto> getDong(String gugunName) throws Exception;
}
