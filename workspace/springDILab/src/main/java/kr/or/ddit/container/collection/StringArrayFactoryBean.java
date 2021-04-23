package kr.or.ddit.container.collection;

import org.springframework.beans.factory.FactoryBean;

//cooletionDI에서 array bean객체를 넣기위해만듬
public class StringArrayFactoryBean implements FactoryBean<String[]> {

	@Override
	public String[] getObject() throws Exception {
		// TODO Auto-generated method stub
		return new String[] {"value1", "value2"};
	}

	@Override
	public Class<?> getObjectType() {
		return String[].class;
	}

	@Override
	public boolean isSingleton() {
		// false : 만들때마다 주입 , true : 싱글턴이됨
		return false;
	}

}
