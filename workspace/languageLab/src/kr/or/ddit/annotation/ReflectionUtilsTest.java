package kr.or.ddit.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import kr.or.ddit.utils.ReflectionUtils;

//센세가만든것
public class ReflectionUtilsTest {
	public static void main(String[] args) {
		String basePackages = "kr.or.ddit";
		List<Class<?>> clzList = ReflectionUtils.getAllClassesAtBasePackages(basePackages);
		for(Class<?> tmp : clzList) {
			System.out.println(tmp.getName());
		}
		Map<Class<?>,Annotation> withGroup = ReflectionUtils.getClassesWithAnnotationAtBasePackages(FirstAnnotation.class, basePackages);
		for(Entry<Class<?>, Annotation> entry : withGroup.entrySet()) {
			String keyName =entry.getKey().getName();
			FirstAnnotation value = (FirstAnnotation)entry.getValue();
			System.err.printf("%s : %s \n",keyName,value);
			Class<?> targetClz = entry.getKey();
			Class<? extends Annotation> annotationType = SecondAnnotation.class;
			Map<Method,Annotation> methods = ReflectionUtils.getMethodsWithAnnotationAtClass(targetClz, annotationType,void.class);
			System.out.println(methods);
		}
	}
	
}
