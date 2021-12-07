package com.ssafy.hanbang.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.hanbang.model.MemberDto;
import com.ssafy.hanbang.model.service.JwtServiceImpl;
import com.ssafy.hanbang.model.service.MemberService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/user")
@Api("사용자 컨트롤러 API V1")
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private JwtServiceImpl jwtService;
	
	@Autowired
	private MemberService memberService;
	
	@ApiOperation(value = "회원정보조회", notes = "회원정보를 조회할 수 있다.", response = MemberDto.class)
	@GetMapping("/{email}")
	public ResponseEntity<MemberDto> select(@PathVariable String email) throws SQLException{
		return new ResponseEntity<MemberDto>(memberService.select(email), HttpStatus.OK);
	}
	
	@ApiOperation(value = "회원가입", notes = "회원가입 정보를 입력한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping
	public ResponseEntity<String> insert(@RequestBody MemberDto memberDto) throws Exception{
		if(memberService.insert(memberDto)==1) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value = "회원탈퇴", notes = "이메일에 해당하는 회원의 정보를 삭제한다. 그리고 DB삭제 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@DeleteMapping("/{email}")
	public ResponseEntity<String> delete(@PathVariable String email) throws Exception{
		if(memberService.delete(email)==1) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value = "회원정보수정", notes = "이메일에 해당하는 회원의 정보를 수정한다. 그리고 DB삭제 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PutMapping("/{email}")
	public ResponseEntity<String> update(@RequestBody MemberDto memberDto) throws Exception{
		if(memberService.update(memberDto)==1) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	
	
	
	
//	@ApiOperation(value = "로그인", notes = "Access-token과 로그인 결과 메세지를 반환한다.", response = Map.class)
//	@PostMapping("/login")
//	public ResponseEntity<Map<String, Object>> login(@RequestBody @ApiParam(value = "로그인 시 필요한 회원정보(이메일, 비밀번호)", required = true) MemberDto memberDto){
//		Map<String, Object> resultMap = new HashMap<>();
//		HttpStatus status = null;
//		
//		try {
//			MemberDto loginUser = memberService.login(memberDto);
//			// 로그인 성공했다면 토큰을 생성한다.
//			if(loginUser != null) {
//				String token = jwtService.create("email", loginUser.getEmail(), "access-token"); // key, data, subject
//				logger.debug("로그인 토큰정보 : {}", token);
//				// 토큰 정보는 request의 헤더로 보내고 나머지는 Map에 담아주자. 다르게는 res.setHeader("jwt-auth-token", token);으로 쓸 수 있음
//				resultMap.put("access-token", token);
//				resultMap.put("message", SUCCESS);
//				status = HttpStatus.ACCEPTED;
//			}else {
//				resultMap.put("message", FAIL);
//				status = HttpStatus.ACCEPTED;
//			}
//		} catch (Exception e) {
//			logger.error("로그인 실패 : {}", e);
//			resultMap.put("message", e.getMessage());
//			status = HttpStatus.INTERNAL_SERVER_ERROR;
//		}
//		return new ResponseEntity<Map<String, Object>>(resultMap, status);
//	}
//	
//	@GetMapping("/info/{email}")
//	public ResponseEntity<Map<String, Object>> getInfo(@PathVariable("email") @ApiParam(value = "인증할 회원의 아이디", required = true) String email, HttpServletRequest request){
////		logger.debug("email: {}", email);
//		Map<String, Object> resultMap = new HashMap<>();
//		HttpStatus status = HttpStatus.ACCEPTED;
//		if(jwtService.isUsable(request.getHeader("access-token"))) {
//			logger.info("사용 가능한 토큰!!!");
//			try {
//				// 로그인 사용자 정보
//				MemberDto memberDto = memberService.userInfo(email);
//				resultMap.put("userinfo", memberDto);
//				resultMap.put("message", SUCCESS);
//				status = HttpStatus.ACCEPTED;
//			} catch (Exception e) {
//				logger.error("정보조회 실패 : {}", e);
//				resultMap.put("message", e.getMessage());
//				status = HttpStatus.INTERNAL_SERVER_ERROR;
//			}
//		}else {
//			logger.error("사용 불가능한 토큰!!!");
//			resultMap.put("message", FAIL);
//			status = HttpStatus.ACCEPTED;
//		}
//		return new ResponseEntity<Map<String, Object>>(resultMap, status);
//	}
}
