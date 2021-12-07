package com.ssafy.hanbang.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="FollowDto : 팔로우 정보", description = "팔로우 정보를 나타낸다.")
public class FollowDto {
	
	@ApiModelProperty(value = "팔로우번호")
	private int follno;
	@ApiModelProperty(value = "구독하는사용자")
	private String fromuser;
	@ApiModelProperty(value = "구독당하는사용자")
	private String touser;
	
	
	public int getFollno() {
		return follno;
	}
	public void setFollno(int follno) {
		this.follno = follno;
	}
	public String getFromuser() {
		return fromuser;
	}
	public void setFromuser(String fromuser) {
		this.fromuser = fromuser;
	}
	public String getTouser() {
		return touser;
	}
	public void setTouser(String touser) {
		this.touser = touser;
	}
	
	
}
