package kr.or.ddit.example.view;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import kr.or.ddit.example.service.IExampleService;

@Component
public class ExampleAutoView {
	
	

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("kr/or/ddit/container/conf/exampleAuto-context.xml");
		context.registerShutdownHook();
		
		IExampleService service1 = context.getBean(IExampleService.class);
		IExampleService service2 = context.getBean(IExampleService.class);
		System.out.println(service1==service2);
	}
}
