package com.ssafy.hanbang.model.service;

import java.util.List;

import com.ssafy.hanbang.model.InterestDto;

public interface InterestService {

	public int insertInterest(InterestDto interestDto);
	public List<InterestDto> listInterest(int userno);
	public InterestDto selectInterest(int interno);
	public int updateInterest(InterestDto interestDto);
	public int deleteInterest(int interno);
	int delete(InterestDto interestDto);
	int get(InterestDto interestDto);
}
