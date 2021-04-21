package kr.or.ddit.board.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.or.ddit.board.dao.AttatchDAOImpl;
import kr.or.ddit.board.dao.IAttatchDAO;
import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.mvc.annotation.Controller;
import kr.or.ddit.mvc.annotation.RequestMapping;
import kr.or.ddit.mvc.annotation.RequestMethod;
import kr.or.ddit.mvc.annotation.resolvers.RequestParam;
import kr.or.ddit.mvc.annotation.resolvers.RequestPart;
import kr.or.ddit.mvc.filter.wrapper.MultipartFile;
import kr.or.ddit.vo.AttatchVO;

@Controller
public class BoardFileController {
	
	private IBoardService service = new BoardServiceImpl();
	
	@RequestMapping("/board/download.do")
	// 필수파라미터 보고
	// 모델에서 attatch위치정보나 크기 등등을 받아와서 
	// 파일의 위치에있는 2진데이터를 찾아내서 출력한다
	public String download(
			@RequestParam("what")int att_no
			, HttpServletRequest req
			, HttpServletResponse resp
			) throws IOException {
		
			AttatchVO attatch = service.download(att_no);
			File saveFolder =  new File("D:/attatches");
			String findName = attatch.getAtt_savename();
			File saveFile = new File(saveFolder,findName);
			
			
			String agent = req.getHeader("User-Agent");
			String filename = attatch.getAtt_filename();
			if(StringUtils.containsIgnoreCase(agent, "trident")) {
				filename = URLEncoder.encode(filename, "UTF-8").replaceAll("\\+", " ");
			}else {
				byte[] bytes = filename.getBytes();
				filename = new String(bytes, "ISO-8859-1");
			}
			
			//브라우저마다 처리방식이다르다
			resp.setHeader("Content-Disposition", "attatchment;filename=\""+filename+"\"");
			resp.setHeader("Content-Length", attatch.getAtt_size()+"");
			resp.setContentType("application/octet-stream");
			try(
				OutputStream os = resp.getOutputStream();
			){
				FileUtils.copyFile(saveFile, os);
			}
		
		return null;
	}
	
	@RequestMapping(value="/board/boardImage.do", method=RequestMethod.POST)
	public String imageUpload(
		@RequestPart("upload") MultipartFile upload
		, HttpServletRequest req
		, HttpServletResponse resp
	) throws IOException {
		String saveFolderURL= "/boardImages";
		String saveFolderPath = req.getServletContext().getRealPath(saveFolderURL);
		File saveFolder = new File(saveFolderPath);
		Map<String, Object> resultMap = new HashMap<>();
		if(!upload.isEmpty()) {
			upload.saveTo(saveFolder);
			int uploaded = 1;
			String fileName = upload.getOriginalFilename();
			String saveName = upload.getUniqueSaveName();
			String url = req.getContextPath() + saveFolderURL + "/" + saveName;
			resultMap.put("uploaded", uploaded);
			resultMap.put("fileName", fileName);
			resultMap.put("url", url);
		}
		
		resp.setContentType("application/json;charset=UTF-8");
		try(
			PrintWriter out = resp.getWriter();	
		){
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(out, resultMap);
		}
		
		return null;
	}
}



















