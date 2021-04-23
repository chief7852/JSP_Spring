package kr.or.ddit.board.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.validator.BoardInsertGroup;
import kr.or.ddit.validator.CommonValidator;
import kr.or.ddit.vo.AttatchVO;
import kr.or.ddit.vo.BoardVO;

@Controller
public class BoardUpdateController {
	private static Logger logger = LoggerFactory.getLogger(BoardUpdateController.class);
	IBoardService service = new BoardServiceImpl();
	
	@RequestMapping("/board/boardUpdate.do")
	public String updateForm(
			@RequestParam("what")int bo_no
			,HttpServletRequest req
			) {
		//비밀번호 검증
		BoardVO board = new BoardVO();
		board.setBo_no(bo_no);
		board = service.retrieveBoard(board);
		req.setAttribute("board", board);
		logger.info("{} board 담는지",board);
		return "/board/boardForm";
	}
	
	@RequestMapping(value="/board/boardUpdate.do", method=RequestMethod.POST)
	public String updateBoard(
			@ModelAttribute("board")BoardVO board
			,@RequestPart(value="bo_files", required=false)MultipartFile[] bo_files
			,HttpServletRequest req
			) {
		
		
		List<AttatchVO> attatchList = new ArrayList<>();
		if(bo_files != null) {
			for(MultipartFile file :bo_files) {
				if(file.isEmpty())continue;
				attatchList.add(new AttatchVO(file));
			}
			if(attatchList.size()>0)
				board.setAttatchList(attatchList);
		}
		Map<String, List<String>> errors = new LinkedHashMap<>();
	      req.setAttribute("errors", errors);
	      
	      // 검증 시 groupType 넘기기.
	      Class<?> groupHint = (Class<?>) req.getAttribute("groupHint");
	      if(groupHint==null)groupHint=BoardInsertGroup.class;
	      boolean valid = new CommonValidator<BoardVO>().validate(board, errors, groupHint);
	      
	      String view = null;
	      String message = null;
	      if(valid) {

	         ServiceResult result = service.modifyBoard(board);
	         if(ServiceResult.OK.equals(result)) {
	            view = "redirect:/board/boardView.do?what="+board.getBo_no();
	         }else {
	            message = "서버 오류";
	            view = "board/boardForm";
	         }
	      }else {
	         view = "board/boardForm";
	      }
	      
	      req.setAttribute("message", message);
	      return view;

	}
}
