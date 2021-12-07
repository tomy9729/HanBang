package com.ssafy.hanbang.model.service;

import com.ssafy.hanbang.model.BaseAddressDto;

public interface BaseAddressService {

	BaseAddressDto select(String dongCode) throws Exception;
}
