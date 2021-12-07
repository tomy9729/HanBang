package com.ssafy.hanbang.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.hanbang.model.FollowDto;

@Mapper
public interface FollowMapper {
	
	public int insertFollow(FollowDto followDto) throws SQLException;
	public int deleteFollow(FollowDto followDto) throws SQLException;
	
	// 사용자"가" 구독한 사용자들은?
	public List<FollowDto> listFollowFromuser(String fromuser) throws SQLException;
	// 사용자"가" 구독한 사용자들 수	
	public int getCountFromuser(String fromuser) throws SQLException;
	
	// 사용자"를" 구독한 사용자들은?
	public List<FollowDto> listFollowTouser(String touser) throws SQLException;
	// 사용자"를" 구독한 사용자들 수
	public int getCountTouser(String touser) throws SQLException;
	
	int getFromTo(FollowDto followDto);
	
}
