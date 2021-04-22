package kr.or.ddit.example.view;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.or.ddit.example.service.IExampleService;

public class ExampleSpringView {
	
	public static void main(String[] args) {
		
		ApplicationContext container = new ClassPathXmlApplicationContext("kr/or/ddit/exaple/conf/example-context.xml");
//		1.IExampleService service = (IExampleService)container.getBean("exampleServiceImpl");
//		2.IExampleService service = container.getBean(IExampleService.class);
//		3.가장안전하게 주입받는 방법
		IExampleService service = container.getBean("exampleServiceImpl",IExampleService.class);
		
		String info = service.readData("a001");
		System.out.println(info);
		
		
	}
}
