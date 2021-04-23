package kr.or.ddit.buyer.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.buyer.dao.BuyerDAOImpl;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.vo.BoardVO;
import kr.or.ddit.vo.BuyerVO;
import kr.or.ddit.vo.PagingVO;

public class BuyerServiceImpl implements IBuyerService {
	
	private static BuyerServiceImpl self;
	private BuyerServiceImpl() {}
	public static BuyerServiceImpl getInstance() {
		if(self==null) self = new BuyerServiceImpl();
		return self;
	}
	
	@Override
	public boolean boardAuthenticate(BoardVO search) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<BuyerVO> retrieveListBuyer(PagingVO<BuyerVO> paging) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int retrieveBuyerCount(PagingVO<BuyerVO> pagingVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BuyerVO retrieveBuyer(BuyerVO search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServiceResult createBuyer(BuyerVO buyer, SqlSession session) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServiceResult modifyBuyer(BuyerVO buyer, SqlSession session) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServiceResult removeBuyer(BuyerVO search) {
		// TODO Auto-generated method stub
		return null;
	}

}
