package com.ssafy.hanbang.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="HeartDto : 좋아요정보", description = "좋아요 정보를 나타낸다.")
public class HeartDto {
    
	@ApiModelProperty(value = "좋아요번호")
    private int heartno;
	@ApiModelProperty(value = "회원번호")
	private String email;
	@ApiModelProperty(value = "사진게시글번호")
	private int boardno;
	
	public int getHeartno() {
		return heartno;
	}
	public void setHeartno(int heartno) {
		this.heartno = heartno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getBoardno() {
		return boardno;
	}
	public void setBoardno(int boardno) {
		this.boardno = boardno;
	}
	
	
}
