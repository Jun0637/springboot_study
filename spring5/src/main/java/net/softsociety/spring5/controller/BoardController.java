package net.softsociety.spring5.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.spring5.domain.Board;
import net.softsociety.spring5.service.BoardService;
import net.softsociety.spring5.util.FileService.FileService;

/**
 * 게시판 관련 처리 콘트롤러
 */
@Slf4j
@RequestMapping("board")
@Controller
public class BoardController {

	@Autowired
	BoardService service;
	//"/board/list" 경로의 요청을 처리하는 메소드 "/boardView/list.html"로 포워딩
	
	//설정파일에 정의된 업로드할 경로를 읽어서 아래 변수에 대입
	@Value("${spring.servlet.multipart.location}")
	String uploadPath;
	
	//글목록
	@GetMapping("/list")
	//가서 출력하고 끝내는 것은 model에 담는다. 
	//복잡하게 하면 세션이 넣어야한다. 
	public String list(String type, String searchWord, Model model) {
		ArrayList<Board> list = service.list(type, searchWord );
		model.addAttribute("list", list);
		
		for(Board n : list) {
			log.debug("출력 : {}",n);
		}
	//게시판의 모든글 읽어서 화면에 출력
	return "boardView/list";
	}		
	
	//글 쓰기 폼
	@GetMapping("/write")
	public String write() {
		return "boardView/writeForm";
	}
	//글 저장
	@PostMapping("write")
	//board안에 글쓰기 폼에 name인 title, contents가 들어감. 
	//파일첨부쪽 name="upload"의 부분이  MultipartFile upload가 됨..
	public String write(
			Board board
			, @AuthenticationPrincipal UserDetails user
			, MultipartFile upload) {
		
//		log.debug("파일 정보:{}", upload.getContentType());
//		log.debug("파일 정보:{}", upload.getOriginalFilename());
//		log.debug("파일 정보:{}", upload.getSize());
//		log.debug("파일 정보:{}", upload.isEmpty());
		
		//첨부파일이 있으면 지정한 경로에 저장하고 파일명을 board객체에 추가
		//upload!=null이 먼저 와야한다. 
		//upload!=null가 false이면 &&뒤에는 안한다. 
		//upload!=null가 true이면 ||뒤에는 안한다. 
		if( upload!=null && !upload.isEmpty()) {
			String filename = FileService.saveFile(upload, uploadPath);
			board.setOriginalfile(upload.getOriginalFilename());
			board.setSavedfile(filename);
		}
				
		
		//로그인한 아이디 읽어서 board 객체에 추가
		board.setMemberid(user.getUsername());
		log.debug("저장할 글 정보 : ", board);
		
		//DB에 저장
		service.insertboard(board);
		   log.debug("");
		return "redirect:/board/list";
	}
	//글 클릭해서 읽기
	@GetMapping("/read")
	//int num만 쓰기는 위험하다. 
	//요청 파라미터를 넣어서 넣어달라.
	public String read(
			@RequestParam(name = "num", defaultValue="0") int num
			, Model model) {
		
		//num이라는 이름의 글번호를 전달받음
		//전달받은 글번호를 서비스로 전달
		Board board = service.selectboard(num);
		//서비스가 리턴한 Board객체를 Model에 저장
		model.addAttribute("Board", board);
		//HTML파일로 포워딩하여 출력
		return "boardView/readForm";
	}
	
	//첨부파일 다운로드
	@GetMapping("/download")
	public String download(
			@RequestParam(name = "num", defaultValue="0") int num,
			HttpServletResponse response) {
		
		Board board = service.selectboard(num);
		
		log.debug("selectboard:{}", board);
		
		
		if(board == null || board.getSavedfile() == null) {
			return "redirect:/list";
		}
		String file = uploadPath + "/" + board.getSavedfile();
		
		FileInputStream in = null;
		ServletOutputStream out = null;
		
		try {
		
		//응답 정보의 헤더 세팅
		response.setHeader("Content-Disposition", 
		" attachment;filename=" + URLEncoder.encode(board.getOriginalfile(),"UTF-8"));
		in = new FileInputStream(file);
		out = response.getOutputStream();
		
		//in으로 읽어서 out으로 내보내라
		FileCopyUtils.copy(in, out);
		
		in.close();
		out.close();
		
		}
		catch(IOException e) {
			//예외 메세지 출력
			e.printStackTrace();
		}
		return "redirect:/";
	}
	//글 삭제
	//@GetMapping("delete")
	//public String delete(int num) {
		//글 읽기 화면에서 글번호가 전달됨s
		//로그인한 사용자의 아이디를 읽음
		//글번호로 DB에서 글 내용을 읽음
		//첨부된 파일이 있으면 파일 삭제
		//실제 글 DB에서 작제
		//글 목록으로 리다이렉트
	//}
	
}
