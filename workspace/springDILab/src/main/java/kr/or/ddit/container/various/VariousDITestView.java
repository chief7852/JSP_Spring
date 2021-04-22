package kr.or.ddit.container.various;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class VariousDITestView {
	public static void main(String[] args) {
		ConfigurableApplicationContext container = 
				new GenericXmlApplicationContext("classpath:kr/or/ddit/container/conf/variousDI-context.xml");
		container.registerShutdownHook();
		
		VariousDIVO vo1 = container.getBean("vo1",VariousDIVO.class);
	
		System.out.println(vo1);

	}
}
