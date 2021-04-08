package kr.or.ddit.annotation;

import java.io.File;
import java.io.FilenameFilter;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
  Annotation : 사람과 시스템에게 일정 정보를 전달하기 위한 방법
	종류
	1. Marker annotation	  ,ex) @Override
	2. SingleValue annotation ,ex) @WebServlet("")
	3. MultiValue annotation  ,ex) @WebServlet(value="",loadOnsStartup =1)
  	커스텀 어노테이션 방법
  1. @interface 키워드로 생성 : Annotation의(인터페이스임) 구현체의 형태로정의됨
  2. 필수 정책
    1) 어노테이션의 사용위치 : @Target : elementtype(사용위치)
    2) 어노테이션의 생존범위 : @Retention (SOURCE,COMPILE,RUNTIME)
 	
 */
public class AnnotationDesc {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		String basePakage = "kr.or.ddit.designpattern.commandpattern";
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		URL baseFolderURL = loader.getResource(basePakage.replace('.', '/'));
		File baseFolder = new File(baseFolderURL.getFile());
		
		String baseFoderAP = baseFolder.getAbsolutePath();
		
//		System.out.println(baseFolder.getAbsolutePath());
		File[] files = baseFolder.listFiles(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith("class");
			}
		});
		//annotation 있
		List<Class<?>> withGroup = new ArrayList<>();
		//annotation 없
		List<Class<?>> withoutGroup = new ArrayList<>();
		
		
		for(File classFile : files) {
			System.out.println(classFile.getAbsolutePath());
			String clzAP = classFile.getAbsolutePath();
			int lastIndx = clzAP.lastIndexOf(".");
			String className = clzAP.substring(baseFoderAP.length()+1,lastIndx);
//			System.out.println(basePakage + "." + className);
			String qualified = basePakage + "." + className;
			try {
				Class<?> clz = Class.forName(qualified);
				FirstAnnotation annotation = clz.getAnnotation(FirstAnnotation.class);
				if(annotation==null) {
					withoutGroup.add(clz);
				}else {
					withGroup.add(clz);
				}
				System.out.println(clz);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}// for end
		
		System.out.println(withGroup);
		
		Map<String,Object> instanceMap = new HashMap<>();
		for(Class<?> tmp : withGroup) {
			Object instance =tmp.newInstance();
			FirstAnnotation anntation = tmp.getAnnotation(FirstAnnotation.class);
			String key = anntation.value();
			instanceMap.put(key,instance);
		}
		
		System.out.println(instanceMap);
		System.out.println("\n========================================================\n");
		for(Entry<String,Object> entry :instanceMap.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();
			System.out.printf("%s : %s \n",key,value);
		}
		
	}
}
