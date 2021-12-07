package com.ssafy.hanbang.model.service;

import java.io.IOException;
import java.util.List;

import com.ssafy.hanbang.model.ImageDto;

public interface ImageService {
	int saveImage(String encodedString, int bno, int hno) throws IOException;
	String select(int imageno);
	List<String> selectBybno(int bno);
	List<String> selectByhno(int hno);
	
	int deleteBybno(int bno);
	int deleteByhno(int hno);
	
	int getImageno();
	int update(ImageDto imagedto);
}
