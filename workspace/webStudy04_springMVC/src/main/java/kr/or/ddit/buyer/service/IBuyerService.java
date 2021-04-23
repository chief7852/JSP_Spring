package kr.or.ddit.buyer.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.vo.AttatchVO;
import kr.or.ddit.vo.BoardVO;
import kr.or.ddit.vo.BuyerVO;
import kr.or.ddit.vo.PagingVO;

public interface IBuyerService {
	
	public boolean boardAuthenticate(BoardVO search);
	// 거래처리스트
	public List<BuyerVO> retrieveListBuyer(PagingVO<BuyerVO> paging);
	
	// 페이징처리용 카운트
	public int retrieveBuyerCount(PagingVO<BuyerVO> pagingVO);
	// 거래처 상세조회
	public BuyerVO retrieveBuyer(BuyerVO search);
	// 거래처추가
	public ServiceResult createBuyer(BuyerVO buyer, SqlSession session);
	// 거래처 수정
	public ServiceResult modifyBuyer(BuyerVO buyer, SqlSession session);

	// 거래처 제거
	public ServiceResult removeBuyer(BuyerVO search);

}
