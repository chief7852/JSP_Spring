package kr.or.ddit.mvc.annotation.resolvers;

import static java.lang.annotation.ElementType.*;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestParam {
	String value(); //어떤 이름을 가진 파라미터를 꺼내줄지 결정하는역할
	boolean required() default true;
	String defaultValue() default ""; 	// 요청파라미터가 비어있을때 상황
}
