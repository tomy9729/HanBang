package com.ssafy.hanbang.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="GugunCodeDto : 구군 정보", description = "구군의 이름을 나타낸다.")
public class GugunCodeDto {
	
	@ApiModelProperty(value = "구군코드")
	private String gugunCode;
	@ApiModelProperty(value = "구군이름")
	private String gugunName;
	
	public String getGugunCode() {
		return gugunCode;
	}
	public void setGugunCode(String gugunCode) {
		this.gugunCode = gugunCode;
	}
	public String getGugunName() {
		return gugunName;
	}
	public void setGugunName(String gugunName) {
		this.gugunName = gugunName;
	}
	
}
