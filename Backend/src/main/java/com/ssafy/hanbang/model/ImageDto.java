package com.ssafy.hanbang.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="ImageDto : 사진정보", description = "사진.")
public class ImageDto {
	@ApiModelProperty(value = "이미지 번호")
	int imageno;
	@ApiModelProperty(value = "게시글 번호")
	int bno;
	@ApiModelProperty(value = "집들이 번호")
	int hno;
	@ApiModelProperty(value = "서버에 저장되는 이미지 이름")
	String imageName;
	@ApiModelProperty(value = "서버에 저장되는 이미지의 경로")
	String imagePath;
	
	public int getImageno() {
		return imageno;
	}
	public void setImageno(int imageno) {
		this.imageno = imageno;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public int getHno() {
		return hno;
	}
	public void setHno(int hno) {
		this.hno = hno;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
}
