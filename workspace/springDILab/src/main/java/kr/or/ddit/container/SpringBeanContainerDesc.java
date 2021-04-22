package kr.or.ddit.container;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import kr.or.ddit.example.service.IExampleService;

/**
 Spring Bean Container 사용단계
  : bean의 lifecycle 관리자
  1. Spring container module을 빌드 패스에 추가
  		(beans, core, context, spEL)
  2. bean metadata(spring설정파일)(bean definition metadata) 등록 파일
  		1) bean 등록(bean 엘리먼트)
  		2) 등록된 bean 들간의 의존관계 형성(Defendency injection, 의존성주입)
  			- constructor injection (필수전략 주입)
  				constructior-arg, c namespace(3.1ver부터)
  			- setter injection (optional 전략 주입)
  				property, p namespace(3.0ver부터)
  3. Container 객체 생성
  	 - Application Context의 구현체
  4. getBean으로 의존 객체 주입
  		- type 을 기준으로 한 주입(단점: 두개 이상의 bean이 존재시 exception발생)
  		- id를 기준으로 한 주입(단점: 캐스팅하기 귀찮다)
  5. 컨테이너 종료(shutdownHook 등록 : 남아있는 스레드 확인중에 데몬스레드만 남으면 close해준다)
  	
  	
  	
  	기본적으로 컨테이너는 싱글톤패턴으로 주입되지만 타입(class)이아니라 bean이 대상이다(우리가 아는 싱글톤패턴과 다름)
  	 컨테이너의 빈관리 정책
  	1. 특별한 설정이 없는 한 bean은 singleton으로 관리됨(싱글턴의 대상은 bean)
  		scope => singleton(기본정책) : 하나의 bean은 하나의 객체
  				 prototype : 객체가 주입될때마다 새로운 객체가 생성됨.
  				 request / session	(request스코프와 bean의 생명주기가 같다)/(session스코프와 bean의 생명주기가같다)
  	2. 특별한 설정(lazy-init)이 없는 한 컨테이너가 초기화 될때 등록된 bean의 모든 객체 생성.(객체생성시점)
  		: 객체의 생성 시점을 지연시키거나 생성 순서를 어느정도 제어하 수 있음
  	3. depends-on을 이용하여 bean들간의 순서를 직접 제어도 가능함.
  	4. 생명 주기 콜백 정의 가능
  	 *** init - method는 필요한 injection(주입이 모두 끝난 후에 호출됨)
 */

// runtime시 자원을 찾아주는 역할을하는 smartresource(?) classpath:
public class SpringBeanContainerDesc {
	public static void main(String[] args) {
		ConfigurableApplicationContext container 
			= new GenericXmlApplicationContext("classpath:kr/or/ddit/container/conf/spring-container.xml");
		
		// 남아있는 스레드 확인중에 데몬스레드만 남으면 close해준다
		container.registerShutdownHook();
		
		/*
		 * IExampleService service1 =
		 * container.getBean("service",IExampleService.class); IExampleService
		 * service1_1 = container.getBean("service",IExampleService.class);
		 * IExampleService service2 =
		 * container.getBean("service2",IExampleService.class); IExampleService
		 * service2_2 = container.getBean("service2",IExampleService.class);
		 * System.out.println(service1.readData("a0014")); System.out.println(service1
		 * == service2);//true 싱글톤 패턴이다 System.out.println(service1 == service1_1);
		 * System.out.println(service2 == service2_2);
		 */
	}
}
