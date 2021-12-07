package com.ssafy.hanbang.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="InterestDto : 관심지역", description = "관심지역을 나타낸다.")
public class InterestDto {
	
	@ApiModelProperty(value = "관심지역번호")
	private int interno;
	@ApiModelProperty(value = "아파트코드")
	private int aptCode;
	@ApiModelProperty(value = "회원번호")
	private int userno;
	
	public int getInterno() {
		return interno;
	}
	public void setInterno(int interno) {
		this.interno = interno;
	}
	public int getAptCode() {
		return aptCode;
	}
	public void setAptCode(int aptCode) {
		this.aptCode = aptCode;
	}
	public int getUserno() {
		return userno;
	}
	public void setUserno(int userno) {
		this.userno = userno;
	}
	
	
}
