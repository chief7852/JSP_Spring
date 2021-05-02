package kr.or.ddit.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode(of="employee_id")
@ToString(exclude = "employee_pwd")
@NoArgsConstructor
public class EmployeeVO{
	
	private String employee_id;
	
	private String employee_pwd;
	
	private String employee_name;
	
	private String employee_phone;
	
	private String employee_email;
	
	private String employee_authority;
	
	private String employee_picture;
	
}
