package com.ssafy.hanbang.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.hanbang.model.InterestDto;

@Mapper
public interface InterestMapper {
	
	public int insertInterest(InterestDto interestDto);
	public List<InterestDto> listInterest(int userno);
	public InterestDto selectInterest(int interno);
	public int updateInterest(InterestDto interestDto);
	public int deleteInterest(int interno);
	
	int delete(InterestDto interestDto);
	int get(InterestDto interestDto);

}
