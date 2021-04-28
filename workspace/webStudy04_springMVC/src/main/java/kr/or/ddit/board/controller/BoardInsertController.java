package kr.or.ddit.board.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.utils.RegexUtils;
import kr.or.ddit.validator.BoardInsertGroup;
import kr.or.ddit.validator.NoticeInsertGroup;
import kr.or.ddit.vo.BoardVO;

@Controller
public class BoardInsertController {
	private String[] filteringTokens = new String[] {"말미잘", "해삼"};
	
	@Inject
	private IBoardService service;
		
	@RequestMapping("/board/noticeInsert.do")
	public String noticeForm(@ModelAttribute("board") BoardVO board) {
		board.setBo_type("NOTICE");
		return "board/boardForm";
	}
	//공지글
	@RequestMapping(value="/board/noticeInsert.do", method=RequestMethod.POST)
	public String noticeInsert(
			@Validated(NoticeInsertGroup.class) @ModelAttribute("board") BoardVO board
			, BindingResult errors
		//순서바뀌지않게 주의할것 
			, Model model
			) {
//		req.setAttribute("groupHint", NoticeInsertGroup.class);
		return insert(board, errors, model);
	}
	
	@RequestMapping("/board/boardInsert.do")
	public String form(@ModelAttribute("board") BoardVO board
			, @RequestParam(value="parent", required=false, defaultValue="0") int parent
			) {
		board.setBo_type("BOARD");
		board.setBo_parent(parent);
		return "board/boardForm";
	}
	
	
	@RequestMapping(value="/board/boardInsert.do", method=RequestMethod.POST)
	public String insert(
//			@RequestParam(required = true) int bo_no,
			//객체검증을 하되 그룹힌트?
			@Validated(BoardInsertGroup.class) @ModelAttribute("board") BoardVO board
			, Errors errors
//			, HttpServletRequest req
			, Model model
			) {
				//errors를 대신해서 3. 어떻게 핸들러어뎁터가 검증했을때 내가 그결과를 받아써먹느냐
//		Map<String, List<String>> errors = new LinkedHashMap<>();
//		req.setAttribute("errors", errors);
		
//		쓸일없어짐
//		Class<?> groupHint = (Class<?>) req.getAttribute("groupHint");
//		if(groupHint==null)
//			groupHint = BoardInsertGroup.class;
		
		//에러가있으면 true가뜬다 - ! 로 반대개념 에러가없으면 
		boolean valid = !errors.hasErrors();
		
		String view = null;
		String message = null;
		if(valid) {
			
			String replaceText = 
					RegexUtils.filteringTokens(board.getBo_content(), 'ㅁ', filteringTokens);
			board.setBo_content(replaceText);
			
			ServiceResult result = service.createBoard(board);
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









