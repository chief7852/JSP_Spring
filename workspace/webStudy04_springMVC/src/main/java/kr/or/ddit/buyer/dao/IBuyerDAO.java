package kr.or.ddit.buyer.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.vo.BoardVO;
import kr.or.ddit.vo.BuyerVO;
import kr.or.ddit.vo.PagingVO;

public interface IBuyerDAO {
	
	//거래처리스트
	public List<BuyerVO> selectListBuyer(PagingVO<BuyerVO> paging);
	//페이징처리용 카운트
	public int selectBuyerCount(PagingVO<BuyerVO> pagingVO);
	
	// 거래처 상세조회
	public BuyerVO selectBuyer(BuyerVO search);
	
	// 거래처추가
	public int insertBuyer(BuyerVO buyer, SqlSession session);
	
	//거래처 수정
	public int updateBuyer(BuyerVO buyer, SqlSession session);
	
	// 거래처 제거
	public int deleteBuyer(BuyerVO search);
}
