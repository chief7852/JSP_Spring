package kr.or.ddit.employee.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.employee.dao.IEmployeeDAO;
import kr.or.ddit.enums.Results;
import kr.or.ddit.vo.EmployeeVO;
@Service
public class EmployeeServiceImpl implements IEmployeeService {
	
	@Inject
	private IEmployeeDAO dao;
	
	

	@Override
	public int createEmployee(EmployeeVO employee) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public Results retrieveEmployeechek(EmployeeVO employee) {
		EmployeeVO retriEmp = dao.selectEmployee(employee);
		Results result = Results.FAIL;
		
		if(retriEmp.getEmployee_pwd().equals(employee.getEmployee_pwd())) {
			result = Results.OK;
		}
		return result;
	}

	@Override
	public EmployeeVO retrieveEmployee(EmployeeVO employee) {
		EmployeeVO retriEmp = dao.selectEmployee(employee);
		return null;
	}

}
