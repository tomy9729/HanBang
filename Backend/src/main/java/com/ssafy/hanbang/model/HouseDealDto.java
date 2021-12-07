package com.ssafy.hanbang.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="HouseDealDto : 아파트 거래 정보", description = "아파트 거래 정보를 나타낸다.")
public class HouseDealDto {

	@ApiModelProperty(value = "아파트번호")
	private int no;
	@ApiModelProperty(value = "아파트코드")
	private int aptCode;
	@ApiModelProperty(value = "아파트가격")
	private String dealAmount;
	@ApiModelProperty(value = "건축년도")
	private int dealYear;
	@ApiModelProperty(value = "건축월")
	private int dealMonth;
	@ApiModelProperty(value = "건축일")
	private int dealDay;
	@ApiModelProperty(value = "전용면적")
	private String area;
	@ApiModelProperty(value = "층")
	private int floor;
	@ApiModelProperty(value = "해제여부")
	private int type;
	@ApiModelProperty(value = "랜트비용")
	private String rentMoney;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getAptCode() {
		return aptCode;
	}
	public void setAptCode(int aptCode) {
		this.aptCode = aptCode;
	}
	public String getDealAmount() {
		return dealAmount;
	}
	public void setDealAmount(String dealAmount) {
		this.dealAmount = dealAmount;
	}
	public int getDealYear() {
		return dealYear;
	}
	public void setDealYear(int dealYear) {
		this.dealYear = dealYear;
	}
	public int getDealMonth() {
		return dealMonth;
	}
	public void setDealMonth(int dealMonth) {
		this.dealMonth = dealMonth;
	}
	public int getDealDay() {
		return dealDay;
	}
	public void setDealDay(int dealDay) {
		this.dealDay = dealDay;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getRentMoney() {
		return rentMoney;
	}
	public void setRentMoney(String rentMoney) {
		this.rentMoney = rentMoney;
	}
	
}
