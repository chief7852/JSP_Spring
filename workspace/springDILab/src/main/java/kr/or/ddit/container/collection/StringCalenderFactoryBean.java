package kr.or.ddit.container.collection;

import java.util.Calendar;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.AbstractFactoryBean;

public class StringCalenderFactoryBean extends AbstractFactoryBean<Calendar> {
	
	public StringCalenderFactoryBean(){
		setSingleton(false);
	}
	
	@Override
	public Class<?> getObjectType() {
		
		return Calendar.class;
	}

	@Override
	protected Calendar createInstance() throws Exception {
		
		return Calendar.getInstance();
	}



}
