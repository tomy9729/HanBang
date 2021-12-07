package com.ssafy.hanbang.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.ssafy.hanbang.exception.UnAuthorizedException;
import com.ssafy.hanbang.model.service.JwtService;

@Component
public class JwtInterceptor implements HandlerInterceptor{
	
	private static final Logger logger = LoggerFactory.getLogger(JwtInterceptor.class);
	
	private static final String HEADER_AUTH = "auth-token";
	
	@Autowired
	private JwtService jwtService;
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		
		// request의 parameter에서 auth_token으로 넘어온 녀석을 찾아본다.
		final String token = request.getHeader(HEADER_AUTH);
		
		// 유효한 토큰이면 진행, 그렇지 않으면 예외를 발생시킨다.
		if(token != null && jwtService.isUsable(token)) {
			logger.info("토큰 사용 가능 : {}", token);
			return true;
		}else {
			logger.info("토큰 사용 불가능 : {}", token);
			throw new UnAuthorizedException();
		}
		
	}
}
