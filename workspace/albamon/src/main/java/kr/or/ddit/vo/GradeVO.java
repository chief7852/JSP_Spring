package kr.or.ddit.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GradeVO {
	private String gr_code;
	private String gr_name;
	
	private List<String> grList;
}
