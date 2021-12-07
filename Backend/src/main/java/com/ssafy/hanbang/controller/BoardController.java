package com.ssafy.hanbang.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ssafy.hanbang.model.BoardDto;
import com.ssafy.hanbang.model.CommentDto;
import com.ssafy.hanbang.model.MemberDto;
import com.ssafy.hanbang.model.service.BoardService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/board")
@Api("게시판 컨트롤러 API V1")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private ServletContext servletContext;
	
	@Autowired
	private BoardService boardService;
	
	@ApiOperation(value = "board 글 작성", notes = "새로운 board 정보를 입력한다.성공 여부에 따라 success 또는 fail을 반환한다.", response = String.class)
	@PostMapping
	public ResponseEntity<String> insertBoard(@RequestBody BoardDto boardDto) throws Exception{
		if(boardService.insertBoard(boardDto) == 1) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
			
	@ApiOperation(value = "board 글목록", notes = "모든 board list의 정보를 반환한다.", response = List.class)
	@GetMapping
	public ResponseEntity<List<BoardDto>> listBoard() throws Exception{
		return new ResponseEntity<List<BoardDto>>(boardService.listBoard(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "board 글보기", notes = "해당 board 글의 정보를 반환한다.", response = BoardDto.class)
	@GetMapping("/{boardno}")
	public ResponseEntity<BoardDto> selectBoard(@PathVariable int boardno) throws Exception{
		return new ResponseEntity<BoardDto>(boardService.selectBoard(boardno), HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "board 글수정", notes = "해당 board 글의 정보를 수정한다. 성공 여부에 따라 success 또는 fail을 반환한다.", response = String.class)
	@PutMapping
	public ResponseEntity<String> updateBoard(@RequestBody BoardDto boardDto) throws Exception{
		if(boardService.updateBoard(boardDto) == 1) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value = "board 글삭제", notes = "해당 board 글의 정보를 삭제한다. 성공 여부에 따라 success 또는 fail을 반환한다.", response = String.class)
	@DeleteMapping("/{boardno}")
	public ResponseEntity<String> deleteBoard(@PathVariable int boardno) throws Exception{
		if(boardService.deleteBoard(boardno)==1) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/no")
	public ResponseEntity<String> getBoardno(){
		return new ResponseEntity<String>(Integer.toString(boardService.getBoardno()), HttpStatus.OK);
	}
	
	@GetMapping("/email/{email}")
	public ResponseEntity<List<Integer>> getBoardByEmail(@PathVariable String email){
		return new ResponseEntity<List<Integer>>(boardService.getBoardByEmail(email), HttpStatus.OK);
	}
	
	@GetMapping("/rank3")
	public ResponseEntity<List<BoardDto>> getRank3(){
		return new ResponseEntity<List<BoardDto>>(boardService.getRank3(), HttpStatus.OK);
	}
	
	
	
	
//	@ApiOperation(value = "board 글작성", notes = "새로운 board 정보를 입력한다. 그리고 DB입력 성공여부에 따라 문자열을 반환한다.", response = String.class)
//	@PostMapping("/register")
//	public String register(BoardDto boardDto, @RequestParam("upfile") MultipartFile[] files, Model model,
//			HttpSession session, RedirectAttributes redirectAttributes) throws Exception {
//		MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
//		memberDto.setUserno(memberDto.getUserno());
//		
//		// FileUpload 관련 설정
//		if(!files[0].isEmpty()) {
//			String realPath = servletContext.getRealPath("/upload");
//			String today = new SimpleDateFormat("yyMMdd").format(new Date());
//			String saveFolder = realPath + File.pathSeparator + today;
//			File folder = new File(saveFolder);
//			if(!folder.exists())
//				folder.mkdirs();
//			List<FileInfoDto> fileInfos = new ArrayList<FileInfoDto>();
//			for(MultipartFile mfile : files) {
//				FileInfoDto fileInfoDto = new FileInfoDto();
//				String originalFileName = mfile.getOriginalFilename();
//				if(!originalFileName.isEmpty()) {
//					String saveFileName = UUID.randomUUID().toString() + originalFileName.substring(originalFileName.lastIndexOf('.'));
//					fileInfoDto.setSavefolder(today);
//					fileInfoDto.setOriginfile(originalFileName);
//					fileInfoDto.setSavefile(saveFileName);
//					mfile.transferTo(new File(folder, saveFileName));
//				}
//				fileInfos.add(fileInfoDto);
//			}
//			boardDto.setFileInfos(fileInfos);
//		}
//		
//		boardService.registerBoard(boardDto);
//		redirectAttributes.addFlashAttribute("msg", "글작성 성공");
//		return "redirect:/board/list";
//		
//	}
	
	
//	@ApiOperation(value = "파일 다운로드", notes = "파일을 다운로드한다.")
//	@RequestMapping("/download")
//	@ResponseBody
//	public ResponseEntity<Resource> download(@RequestParam Map<String, Object> param, HttpServletRequest request){
//		String filePath = servletContext.getRealPath("/upload") + File.separator + param.get("sfolder") + File.separator + param.get("sfile");
//		File target = new File(filePath);
//		HttpHeaders header = new HttpHeaders();
//		Resource rs = null;
//		if(target.exists()) {
//			try {
//				String mimeType = Files.probeContentType(Paths.get(target.getAbsolutePath()));
//				if(mimeType == null) {
//					mimeType = "apllication/download; charset=UTF-8";
//				}
//				rs = new UrlResource(target.toURI());
//				String userAgent = request.getHeader("User-Agent");
//				boolean isIE = userAgent.indexOf("MSIE") > -1 || userAgent.indexOf("Trident") > -1;
//				String fileName = null;
//				String originalFile = (String) param.get("ofile");
//				// IE는 다르게 처리
//				if (isIE) { 
//					fileName = URLEncoder.encode(originalFile, "UTF-8").replace("\\+", "%20");
//				}else {
//					fileName = new String(originalFile.getBytes("UTF-8"), "ISO-8859-1");
//				}
//				header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+ fileName +"\"");
//				header.setCacheControl("no-cache");
//				header.setContentType(MediaType.parseMediaType(mimeType));
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		return new ResponseEntity<Resource>(rs, header, HttpStatus.OK);
//	}
	
	
}
