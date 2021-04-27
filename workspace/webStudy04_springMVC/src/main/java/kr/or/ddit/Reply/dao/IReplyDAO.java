package kr.or.ddit.Reply.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.ReplyVO;

@Repository
public interface IReplyDAO {
	public int insertReply(ReplyVO reply)                                   ;
	public int selectReplyCount(PagingVO<ReplyVO> pagingVO)               ;
	public ReplyVO selectReply(ReplyVO search);                       ;
	public List<ReplyVO> selectReplyList(PagingVO<ReplyVO> pagingVO)  ;
	public int updateReply(ReplyVO reply)                                   ;
	public int deleteReply(ReplyVO reply)                                   ;
}                                                                     ;
