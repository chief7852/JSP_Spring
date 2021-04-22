package kr.or.ddit.container.resource;

import java.io.IOException;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

//스마트 리소스 로더 = 컨테이너
//
public class ResourceLoadingDesc {
	public static void main(String[] args) throws IOException {
		//클래스패스리소스
		Resource cpr = new ClassPathResource("log4j2.xml");
		System.out.println(cpr.getFile().exists());
		//파일시스템리소스 읽기
		Resource fsr = new FileSystemResource("d:/contents/오래된 노래_utf8.txt");
		System.out.println(fsr.exists());
		//웹리소스(Url리소스)
		UrlResource urlr = new UrlResource("https://www.google.com//logos/doodles/2021/earth-day-2021-6753651837108909-vacta.gif");
		System.out.println(urlr.contentLength());
		
		ConfigurableApplicationContext container = 
				new ClassPathXmlApplicationContext();
		
		cpr = container.getResource("classpath:log4j2.xml");
		System.out.println(cpr);
		fsr = container.getResource("file://d:/contents/오래된 노래_utf8.txt");
		System.out.println(fsr);
		urlr = (UrlResource)container.getResource("https://www.google.com//logos/doodles/2021/earth-day-2021-6753651837108909-vacta.gif");
		System.out.println(urlr);
	}
}
