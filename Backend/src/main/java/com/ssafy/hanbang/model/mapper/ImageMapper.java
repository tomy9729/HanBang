package com.ssafy.hanbang.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.hanbang.model.ImageDto;

@Mapper
public interface ImageMapper {
	int insert(ImageDto imagedto);
	int deleteBybno(int bno);
	int deleteByhno(int hno);
	int update(ImageDto imagedto);
	
	List<ImageDto> selectBybno(int bno);
	List<ImageDto> selectByhno(int hno);
	ImageDto select(int imageno);
	int getImageno();
}
