package kr.or.ddit.prod.service;

import kr.or.ddit.member.UserNotFoundException;
import kr.or.ddit.prod.dao.IProdDAO;
import kr.or.ddit.prod.dao.ProdDAOImpl;
import kr.or.ddit.vo.ProdVO;

public class ProdServiceImpl implements IProdService {
	private IProdDAO dao = ProdDAOImpl.getInstance();
	@Override
	public ProdVO retrieveProd(String prod_id) {
		ProdVO prodvo = dao.selectProd(prod_id);
		if(prodvo.getBuyer().getBuyer_id() == null) {
			throw new UserNotFoundException("값없음");
		}
		return prodvo;
	}

}
