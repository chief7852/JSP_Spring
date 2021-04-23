package kr.or.ddit.container.collection;

import java.util.Calendar;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CalenderDIView {
	public static void main(String[] args) throws InterruptedException {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("kr/or/ddit/container/conf/calender-context.xml");
		context.registerShutdownHook();
		Calendar now =context.getBean(Calendar.class);
		System.out.printf("%tc\n",now);
		Thread.sleep(1000);
		now =context.getBean(Calendar.class);
		System.out.printf("%tc",now);
	}
}
