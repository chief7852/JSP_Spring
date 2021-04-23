package kr.or.ddit.example.service;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import kr.or.ddit.example.dao.ExampleDAOFactory;
import kr.or.ddit.example.dao.ExampleDAO_MySql;
import kr.or.ddit.example.dao.ExampleDAO_Oracle;
import kr.or.ddit.example.dao.IExampleDAO;

@Service
@Scope(scopeName = "prototype")
public class ExampleServiceImpl implements IExampleService{
//	1. new 키원드로 인스턴스 직접 생성
//	private IExampleDAO dao = new ExampleDAO_Oracle();
//	private IExampleDAO dao = new ExampleDAO_MySql();
//	2. Factory Object Pattern : service와 dao의 결합력을 낮춰버림 (단점 :
//								결합력은 그대로라서 dao랑 factory사이에 결합력이생겨버림
//	private IExampleDAO dao = ExampleDAOFactory.getExapleDAO();
//	3.startegy pattern :전략패턴 (디펜던시 인젝션 DI(defendency injection))
//	:생성자 주입, setter 주입 ,전략의 주입자 필요
	private IExampleDAO dao;
	
	
	
	public ExampleServiceImpl() {
		super();
		System.out.println(getClass().getSimpleName()+"객체 생성 - 기본생성자");
	}

//	기본생성자가 없어짐 생성하기위해 필수전략인  ExampleServiceImpl생성해야함
	
	public ExampleServiceImpl(IExampleDAO dao) {
	super();
	this.dao = dao;
	System.out.println(getClass().getSimpleName()+"객체 생성 - argument있는 생성자");
}
	@Resource(name="mysql")
	@Required
	public void setDao(IExampleDAO dao){
		this.dao = dao;
		System.out.println(getClass().getSimpleName()+"에서 setter");
	}
	
	public void init() {
		System.out.println(getClass().getSimpleName()+"객체 초기화");
	}
	
	public void destroy() {
		System.out.println(getClass().getSimpleName()+"객체 소멸");
	}
	@Override
	public String readData(String pk) {
		String rawData = dao.selectData(pk);
		String info = rawData+"를 가공한 information";
		return info;
	}

}
