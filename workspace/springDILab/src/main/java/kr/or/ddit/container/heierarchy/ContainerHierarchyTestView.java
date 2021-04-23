package kr.or.ddit.container.heierarchy;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.or.ddit.container.heierarchy.controller.HierarchyController;
import kr.or.ddit.container.heierarchy.service.HierarchyService;

public class ContainerHierarchyTestView {
	
	
	public static void main(String[] args) {
		ConfigurableApplicationContext parent =
				new ClassPathXmlApplicationContext("kr/or/ddit/container/conf/hierarchy/root-context.xml");
		ConfigurableApplicationContext child = new ClassPathXmlApplicationContext(new String[] {
				"kr/or/ddit/container/conf/hierarchy/child-context.xml"
		}, parent);
		
		child.registerShutdownHook();
		HierarchyController controller = child.getBean(HierarchyController.class);
		HierarchyService service1 = parent.getBean(HierarchyService.class);
		HierarchyService service2 = child.getBean(HierarchyService.class);
		System.out.println(service1==service2);
	}
}
