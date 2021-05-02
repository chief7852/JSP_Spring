package kr.or.ddit.employee.dao;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.vo.EmployeeVO;

public class IEmployeeDAOTest {
	
	private Logger logger = LoggerFactory.getLogger(IEmployeeDAOTest.class);
	
	@Inject
	private IEmployeeDAO dao;
	
	public void setDao(IEmployeeDAO dao) {
		logger.info("주입됨");
		this.dao = dao;
	}
	
	private EmployeeVO vo;
	
	@Before
	public void setUp() throws Exception {
		vo = new EmployeeVO();
		vo.setEmployeeId("admin");
	}

	@Test
	public void test() {
		EmployeeVO result = dao.selectEmployee(vo);
		System.out.println(vo);
	}

}
