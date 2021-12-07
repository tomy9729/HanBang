package com.ssafy.hanbang.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.hanbang.model.FollowDto;

public interface FollowService {

	public int insertFollow(FollowDto followDto) throws Exception;
	public int deleteFollow(FollowDto followDto) throws Exception;
	
	// 사용자"가" 구독한 사용자들은?
	public List<FollowDto> listFollowFromuser(String fromuser) throws Exception;
	// 사용자"가" 구독한 사용자들 수	
	public int getCountFromuser(String fromuser) throws Exception;
	
	// 사용자"를" 구독한 사용자들은?
	public List<FollowDto> listFollowTouser(String touser) throws Exception;
	// 사용자"를" 구독한 사용자들 수
	public int getCountTouser(String touser) throws Exception;
	
	int getFromTo(FollowDto followDto);
	
}
