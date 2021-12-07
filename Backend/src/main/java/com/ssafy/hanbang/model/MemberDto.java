package com.ssafy.hanbang.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="MemberDto : 회원정보", description="회원의 상세 정보를 나타낸다.")
public class MemberDto {
	
	@ApiModelProperty(value="회원 번호")
	private int userno;
	@ApiModelProperty(value="회원 이메일")
	private String email;
	@ApiModelProperty(value="회원 비밀번호")
	private String pwd;
	@ApiModelProperty(value="회원 닉네임")
	private String nickname;
	@ApiModelProperty(value="회원 팔로잉카운트")
	private int followingcount;
	@ApiModelProperty(value="회원 팔로우카운트")
	private int followercount;
	@ApiModelProperty(value = "회원상태")
	private int status;
	
	public int getUserno() {
		return userno;
	}
	public void setUserno(int userno) {
		this.userno = userno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getFollowingcount() {
		return followingcount;
	}
	public void setFollowingcount(int followingcount) {
		this.followingcount = followingcount;
	}
	public int getFollowercount() {
		return followercount;
	}
	public void setFollowercount(int followercount) {
		this.followercount = followercount;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
}
