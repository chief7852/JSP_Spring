package kr.or.ddit.designpattern.builder;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
// 자바 빈규약에따라 vo만들기
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TestVO implements Serializable{
	private String prop1;
	private String prop2;
	private String prop3;
	
	
}
	
	
	
	

