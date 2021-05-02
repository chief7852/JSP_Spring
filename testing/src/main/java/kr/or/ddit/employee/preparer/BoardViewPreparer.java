package kr.or.ddit.employee.preparer;

import java.util.Map;

import javax.inject.Inject;

import org.apache.tiles.AttributeContext;
import org.apache.tiles.preparer.ViewPreparer;
import org.apache.tiles.request.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.employee.dao.IEmployeeDAO;
import kr.or.ddit.vo.EmployeeVO;

@kr.or.ddit.annotation.ViewPreparer
public class BoardViewPreparer implements ViewPreparer {
	private static final Logger logger =
			LoggerFactory.getLogger(BoardViewPreparer.class);
	
	IEmployeeDAO dao;
	@Inject
	public void setDao(IEmployeeDAO dao) {
		this.dao = dao;
		logger.info("{} 주입되었음. ", dao.getClass().getName());
	}

	@Override
	public void execute(Request tilesContext, AttributeContext attributeContext) {
		EmployeeVO menu1 = new EmployeeVO();
		
		Map<String, Object> requestScope = 
				tilesContext.getContext(Request.REQUEST_SCOPE);
		requestScope.put("menu", menu1);

	}

}
