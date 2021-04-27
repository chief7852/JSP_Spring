package kr.or.ddit.Reply.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import kr.or.ddit.Reply.dao.IReplyDAO;
import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.ReplyVO;

@Service
public class ReplyServiceImpl implements IReplyService {
	private static final Logger logger =
			LoggerFactory.getLogger(ReplyServiceImpl.class);
	
	private IReplyDAO dao;
	@Inject
	public void setDao(IReplyDAO dao) {
		this.dao = dao;
		logger.info("주입된 replyDAO: {}", dao.getClass().getName());
	}
	
	@PostConstruct
	public void init() {
		logger.info("{}초기화.",getClass().getSimpleName());
	}
	
	@Override
	public ServiceResult createReply(ReplyVO reply) {
		ServiceResult result = ServiceResult.FAIL;
		int cnt = dao.insertReply(reply);
		if(cnt>0) {
			result = ServiceResult.OK;
		}
		return result;
	}

	@Override
	public int retrieveReplyCount(int bo_no) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ReplyVO retrieveReply(ReplyVO search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReplyVO> retrieveReplyList(PagingVO<ReplyVO> pagingVO) {
		return dao.selectReplyList(pagingVO);
	}

	@Override
	public int modifyReply(ReplyVO reply) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeReply(ReplyVO reply) {
		// TODO Auto-generated method stub
		return 0;
	}

}
