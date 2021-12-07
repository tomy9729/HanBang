package com.ssafy.hanbang.model;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="BoardDto : 사진게시글정보", description = "사진 게시글의 정보를 나타낸다.")
public class BoardDto {
    
	@ApiModelProperty(value = "사진게시글번호")
    private int boardno;
	@ApiModelProperty(value = "평수")
	private String sqft;
	@ApiModelProperty(value = "주거형태")
	private String housetype;
	@ApiModelProperty(value = "인테리어스타일")
	private String style;
	@ApiModelProperty(value = "집공간")
	private String space;
	@ApiModelProperty(value = "제목")
	private String subject;
	@ApiModelProperty(value = "내용")
	private String content;
	@ApiModelProperty(value = "좋아요수")
	private int heartcount;
	@ApiModelProperty(value = "사진")
	private int img;
	@ApiModelProperty(value = "회원이메일")
	private String email;
	@ApiModelProperty(value = "회원닉네임")
	private String nickname;
	
	public int getBoardno() {
		return boardno;
	}
	public void setBoardno(int boardno) {
		this.boardno = boardno;
	}
	public String getSqft() {
		return sqft;
	}
	public void setSqft(String sqft) {
		this.sqft = sqft;
	}
	public String getHousetype() {
		return housetype;
	}
	public void setHousetype(String housetype) {
		this.housetype = housetype;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getSpace() {
		return space;
	}
	public void setSpace(String space) {
		this.space = space;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getHeartcount() {
		return heartcount;
	}
	public void setHeartcount(int heartcount) {
		this.heartcount = heartcount;
	}
	public int getImg() {
		return img;
	}
	public void setImg(int img) {
		this.img = img;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	
}
