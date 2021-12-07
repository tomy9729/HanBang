package com.ssafy.hanbang.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="CommentDto : 코멘트정보", description = "코멘트 정보를 나타낸다.")
public class CommentDto {
	
	@ApiModelProperty(value = "코멘트번호")
    private int comno;
	@ApiModelProperty(value = "사진게시글번호")
	private int boardno;
	@ApiModelProperty(value = "집들이게시글번호")
	private int houseno;
	@ApiModelProperty(value = "회원이메일")
	private String email;
	@ApiModelProperty(value = "코멘트내용")
	private String content;
	
	public int getComno() {
		return comno;
	}
	public void setComno(int comno) {
		this.comno = comno;
	}
	public int getBoardno() {
		return boardno;
	}
	public void setBoardno(int boardno) {
		this.boardno = boardno;
	}
	public int getHouseno() {
		return houseno;
	}
	public void setHouseno(int houseno) {
		this.houseno = houseno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
		
}
