package kr.or.ddit.board.service;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.vo.BoardVO;
import kr.or.ddit.vo.MemberVO;

public interface IAuthenticateService {
	public ServiceResult authenticate(BoardVO board);
}
