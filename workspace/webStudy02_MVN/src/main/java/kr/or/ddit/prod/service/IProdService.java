package kr.or.ddit.prod.service;

import kr.or.ddit.vo.ProdVO;


/**
 * 상품 상세 조회
 * @param prod_id
 * @return 해당상품이 존재하지않는경우 ,RuntimeError발생
 *
 */
public interface IProdService {
	public ProdVO retrieveProd(String prod_id);
}
