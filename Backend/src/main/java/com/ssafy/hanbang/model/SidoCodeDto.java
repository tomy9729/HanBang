package com.ssafy.hanbang.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="SidoCodeDto : 시도 정보", description="시도의 이름을 나타낸다.")
public class SidoCodeDto {
	
	@ApiModelProperty(value="시도코드")
	private String sidoCode;
	@ApiModelProperty(value="시도이름")
	private String sidoName;
	
	public String getSidoCode() {
		return sidoCode;
	}
	public void setSidoCode(String sidoCode) {
		this.sidoCode = sidoCode;
	}
	public String getSidoName() {
		return sidoName;
	}
	public void setSidoName(String sidoName) {
		this.sidoName = sidoName;
	}
		
}
