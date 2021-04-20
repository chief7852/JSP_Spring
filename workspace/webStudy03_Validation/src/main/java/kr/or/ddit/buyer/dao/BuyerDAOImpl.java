package kr.or.ddit.buyer.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.member.dao.MemberDAOImpl;
import kr.or.ddit.vo.BuyerVO;
import kr.or.ddit.vo.PagingVO;

public class BuyerDAOImpl implements IBuyerDAO {
	private static BuyerDAOImpl self;
	private BuyerDAOImpl() {}
	public static BuyerDAOImpl getInstance() {
		if(self==null) self = new BuyerDAOImpl();
		return self;
	}
	
	@Override
	public List<BuyerVO> selectListBuyer(PagingVO<BuyerVO> paging) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectBuyerCount(PagingVO<BuyerVO> pagingVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BuyerVO selectBuyer(BuyerVO search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertBuyer(BuyerVO buyer, SqlSession session) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateBuyer(BuyerVO buyer, SqlSession session) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBuyer(BuyerVO search) {
		// TODO Auto-generated method stub
		return 0;
	}

}
