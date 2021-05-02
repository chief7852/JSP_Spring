package kr.or.ddit.employee.service;

import org.springframework.stereotype.Repository;

import kr.or.ddit.enums.Results;
import kr.or.ddit.vo.EmployeeVO;


public interface IEmployeeService {
	
	//create
	public int createEmployee(EmployeeVO employee);
	//retrieve
	public Results retrieveEmployeechek(EmployeeVO employee);
	public EmployeeVO retrieveEmployee(EmployeeVO employee);
	//retrieveList
	
	//retrieveCount
	
	//Revise
	
	//erase
	
}
