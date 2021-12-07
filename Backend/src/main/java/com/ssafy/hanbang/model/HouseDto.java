package com.ssafy.hanbang.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="HouseDto : 집들이정보", description = "집들이 정보를 나타낸다.")
public class HouseDto {
    
	@ApiModelProperty(value = "집들이번호")
    private int houseno;
	@ApiModelProperty(value = "평수")
	private String sqft;
	@ApiModelProperty(value = "주거형태")
	private String housetype;
	@ApiModelProperty(value = "가족형태")
	private String familytype;
	@ApiModelProperty(value = "아파트코드")
	private int aptCode;
	@ApiModelProperty(value = "제목")
	private String subject;
	@ApiModelProperty(value = "내용")
	private String content;
	@ApiModelProperty(value = "사진")
	private String img;
	@ApiModelProperty(value = "회원이메일")
	private String email;
	
	public int getHouseno() {
		return houseno;
	}
	public void setHouseno(int houseno) {
		this.houseno = houseno;
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
	public String getFamilytype() {
		return familytype;
	}
	public void setFamilytype(String familytype) {
		this.familytype = familytype;
	}
	public int getAptCode() {
		return aptCode;
	}
	public void setAptCode(int aptCode) {
		this.aptCode = aptCode;
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
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
