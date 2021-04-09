package kr.or.ddit.mvc.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.spi.LocationAwareLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.utils.ReflectionUtils;

public class HandlerMapping implements IHandlerMapping {
	private static final Logger logger =  LoggerFactory.getLogger(HandlerMapping.class);
	private Map<RequestMappingCondition,RequestMappingInfo> handlerMap;
	
	public HandlerMapping(String...basePackages) {
		handlerMap = new LinkedHashMap<>();
		if(basePackages==null|| basePackages.length==0) {
			return;
		}
		Map<Class<?>,Annotation> controllerclasses 
		=ReflectionUtils.getClassesWithAnnotationAtBasePackages(Controller.class,basePackages);
		for(Entry<Class<?>, Annotation> entry: controllerclasses.entrySet()) {
			Class<?> controllerClass =  entry.getKey();
			Object commandHadler = null;
			try {
				commandHadler = controllerClass.newInstance();
			} catch (Exception e) {
				logger.error("컨트롤러 객체 생성 문제 발생", e);
				continue;
			}
			//핸들러조건 POJO를 찾는 방법(트레이싱과정에서)
			Map<Method,Annotation> handlerMethods =
					ReflectionUtils.getMethodsWithAnnotationAtClass
			(controllerClass, RequestMapping.class, String.class);
			
			if(handlerMethods.size() == 0) {
				continue;
			}
			Iterator<Method> it = handlerMethods.keySet().iterator();
			while(it.hasNext()) {
				Method handlerMethod = (Method) it.next();
				RequestMapping requestMapping = (RequestMapping)handlerMethods.get(handlerMethod);
				RequestMappingCondition mappingCondition = new RequestMappingCondition(requestMapping);
				RequestMappingInfo mappingInfo= new RequestMappingInfo(mappingCondition, commandHadler, handlerMethod);
				handlerMap.put(mappingCondition,mappingInfo);
				logger.info("{}",mappingInfo);
			}
		}
	}
	
	@Override
	public RequestMappingInfo findCommandHandler(HttpServletRequest req) {
		String uri = req.getRequestURI();
		uri = uri.substring(req.getContextPath().length()).split(";")[0];
		RequestMethod method = RequestMethod.valueOf(req.getMethod().toUpperCase());
		
		RequestMappingCondition key = new RequestMappingCondition(uri,method);
		return handlerMap.get(key);

	}

}
