package kr.or.ddit.board.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.validator.BoardInsertGroup;
import kr.or.ddit.validator.CommonValidator;
import kr.or.ddit.validator.UpdateGroup;
import kr.or.ddit.vo.AttatchVO;
import kr.or.ddit.vo.BoardVO;

@Controller
@RequestMapping("/board")
public class BoardUpdateController {
	private static Logger logger = LoggerFactory.getLogger(BoardUpdateController.class);
	@Inject
	private IBoardService service ;
	
	
	
	  @RequestMapping(value="{numeringType}.do") 
	  @ResponseBody
	  public String updateRec(
			 @RequestParam(required = true) int bo_no,
			 @PathVariable String numberingType
	  ) {
		  ServiceResult result = null;
		  BoardVO board = new BoardVO();
		  logger.info("{}번호출력\n\n\n\n",bo_no);
		  board.setBo_no(bo_no);
		  if("upRec".equals(numberingType)) {
			  result =service.upRec(board);
		  }else if("report".equals(numberingType)) {
			  result =service.report(board);
		  }
		  
		  Map<String, Object> resultMap = new HashMap<>();
		  boolean success = result.equals(ServiceResult.OK);
		  
		  String message = "실패";
		  if(result.equals(ServiceResult.OK)) {
			  message = "성공";
		  }
		  
		  return message;
	  }
	 
	
	@RequestMapping("boardUpdate.do")
	public String updateForm(
			@RequestParam("what")int bo_no
			,Model model
			) {
		//비밀번호 검증
		BoardVO board = new BoardVO();
		board.setBo_no(bo_no);
		board = service.retrieveBoard(board);
		model.addAttribute("board", board);
		logger.info("{} board 담는지",board);
		return "/board/boardForm";
	}
	
	@RequestMapping(value="boardUpdate.do", method=RequestMethod.POST)
	public String updateBoard(
			@ModelAttribute("board")BoardVO board
			,Model model
			) {
		
		Map<String, List<String>> errors = new LinkedHashMap<>();
		model.addAttribute("errors", errors);
	      
	      // 검증 시 groupType 넘기기.
//	      Class<?> groupHint = (Class<?>) model.getAttribute("groupHint");
//	      if(groupHint==null)groupHint=BoardInsertGroup.class;
		boolean valid = new CommonValidator<BoardVO>()
				.validate(board, errors, UpdateGroup.class);
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
	      
	      model.addAttribute("message", message);
	      return view;

	}
}
