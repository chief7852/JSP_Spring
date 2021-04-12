package kr.or.ddit.mvc.annotation.resolvers;

import java.io.IOException;
import java.lang.reflect.Parameter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.ClassUtils;

/** 여러개의 값을 받았을때 처리할놈
 * @ModelAttribute 어노테이션으로 설정된 핸들러 메소드 아규먼트를 처리할 처리자
 *
 */
public class ModelAttributeArgumentResolver implements IHandlerMethodArgumentResolver {

	@Override
	public boolean isSupported(Parameter parameter) {
		Class<?> parameterType = parameter.getType();
		//1. 어노테이션 있는지 체크
		ModelAttribute annotation = parameter.getAnnotation(ModelAttribute.class);
		
		//2. 아규먼트가있는지 봐야하는데 그 값을 잘 체크해야함
		boolean supported = annotation!=null
				&& !(
						String.class.equals(parameterType)
						|| ClassUtils.isPrimitiveOrWrapper(parameterType) //lang3에 들어있는 모든 타입체크
					);
		
		return supported;
	}

	@Override
	public Object argumentResolve(Parameter parameter, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Class<?> parameterType = parameter.getType();
		ModelAttribute annotation =parameter.getAnnotation(ModelAttribute.class);
		try {
		Object parameterValue = parameterType.newInstance();
		String attributeName = annotation.value();
		
		req.setAttribute(attributeName, parameterValue);

			BeanUtils.populate(parameterValue, req.getParameterMap());
			return parameterValue;
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

}
