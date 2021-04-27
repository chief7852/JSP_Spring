package kr.or.ddit.Reply.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.ReplyVO;


public interface IReplyService {
	
	public ServiceResult createReply(ReplyVO reply)                   ;
	public int retrieveReplyCount(int bo_no)         ;
	public ReplyVO retrieveReply(ReplyVO search);                     ;
	public List<ReplyVO> retrieveReplyList(PagingVO<ReplyVO> pagingVO); 
	public int modifyReply(ReplyVO reply)                                   ;
	public int removeReply(ReplyVO reply)                                   ;
}
