package kr.or.ddit.alba.dao;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.vo.AlbaVO3;
import kr.or.ddit.vo.LicenseVO;

public interface ILicenseDAO {
	public int insertLicenses(AlbaVO3 alba, SqlSession session);
	public int deleteLicenses(AlbaVO3 alba, SqlSession session);
	public LicenseVO selectLicense(LicenseVO licAlba);
}
