package kr.or.ddit.board.controller;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.vo.AttatchVO;

@Controller
public class BoardFileController {
	
	@Inject
	private WebApplicationContext container;
	
	@Inject
	private ServletContext application;
	
//	
//	public void setContainer(WebApplicationContext container) {
//		this.container = container;
//		application = container.getServletContext();
//	}
	@Value("#{appInfo.boardImages}")
	private String saveFolderURL;
	private File saveFolder;
	private String saveFolderPath;
	// 생성한 이후에 실행되는 어노테이션
	@PostConstruct
	public void init() {
		application = container.getServletContext();
		saveFolderPath = application.getRealPath(saveFolderURL);
		saveFolder = new File(saveFolderPath);
	}
	@Inject
	private IBoardService service;
	
	
	//servletcontext
	
	
	
	@RequestMapping("/board/download.do")
	// 필수파라미터 보고
	// 모델에서 attatch위치정보나 크기 등등을 받아와서 
	// 파일의 위치에있는 2진데이터를 찾아내서 출력한다
	public String download(
			@RequestParam("what")int att_no
			, Model model
			) throws IOException {
		
			AttatchVO attatch = service.download(att_no);
			model.addAttribute("attatch", attatch);
		
		return "downloadView";
	}
	
	@RequestMapping(value="/board/boardImage.do",
			method=RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)//accept header조건사용
	@ResponseBody		//마샬링 끝(핸들러어뎁터가 처리해줌)
	public Map<String, Object> imageUpload(
		@RequestPart("upload") MultipartFile upload
		
	) throws IllegalStateException, IOException {
		String saveFolderURL= "/boardImages";
		String saveFolderPath = application.getRealPath(saveFolderURL);//servletcontext
		File saveFolder = new File(saveFolderPath);//얘를 언제만들지(어플리케이션 만들고)
		Map<String, Object> resultMap = new HashMap<>();
		if(!upload.isEmpty()) {
			
//			String saveName = upload.getUniqueSaveName();
//			
//			upload.saveTo(saveFolder);
			// savename을 만드는 다양성을 보장해주기위해 spring에서는 유니크네임을 지원안해줌
			String saveName = UUID.randomUUID().toString();
			
			upload.transferTo(new File(saveFolder,saveName));
			int uploaded = 1;
			String fileName = upload.getOriginalFilename();
			String url = application.getContextPath() + saveFolderURL + "/" + saveName;
			resultMap.put("uploaded", uploaded);
			resultMap.put("fileName", fileName);
			resultMap.put("url", url);
		}
		
		
		return resultMap;
	}
}



















