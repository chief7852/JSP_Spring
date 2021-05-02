package kr.or.ddit.employee.dao;

import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.EmployeeVO;

@Repository
public interface IEmployeeDAO {
	
	//insert
	public int insertEmployee(EmployeeVO employee);
	//select
	public EmployeeVO selectEmployee(EmployeeVO employee);
	//selectList
	
	//selectCount
	
	//update
	
	//delete
}
