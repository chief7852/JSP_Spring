package kr.or.ddit.container.auto.view;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import kr.or.ddit.container.auto.service.ISampleService;

@Component
public class SampleView {
	
	// 컨테이너에 sampleview와 dao, service를 등록하고 dao를 service에 넣고 service를 view에다가 넣는다
	private ISampleService service;
	@Resource(name = "sampleService")// 그래서 얘를 씀 검색조건까지 달수있음
//	@Autowired	//단점 : 타입으로만 검색하니깐 같은타입bean이 여러개면 찾을수없음
	@Required
	public void setService(ISampleService service) {
		this.service = service;
	}
	
	public void view() {
		System.out.println(service.readData("a001"));
	}
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("kr/or/ddit/container/conf/autoDI-context.xml");
		context.registerShutdownHook();
		
		SampleView sampleView = context.getBean(SampleView.class);
		sampleView.view();
	}
}
