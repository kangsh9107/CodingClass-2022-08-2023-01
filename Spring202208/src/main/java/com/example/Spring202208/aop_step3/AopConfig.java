package com.example.Spring202208.aop_step3;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@Aspect
public class AopConfig {
	
	@Bean
	public AopDao getAopDao() {
		return new AopDao();
	}
	
	/*
	 * 프로세스를 가로채서 가로챈걸 매개변수 JoinPoint로 던진다.
	 * JoinPoint는 Aop가 구현되기 위한 장소다.
	 * 
	 * @Before("execution(접근자 반환형 패키지명.클래스명.메서드명(매개변수))")
	 * 처음*는 모든 걸 다 가져온다는 뜻
	 * 뒤에*는 어떤것이든 실행된다면이라는 뜻
	 * 
	 * @Before("execution(* kr.hush.springboot.AopDao.*(..))")
	 * --> AopDao클래스의 어떤 메서드가 실행되더라도 실행되기전에
	 */
	@Before("execution(* com.example.Spring202208.aop_step3.AopDao.*(..))")
	public void beforeAdivce(JoinPoint jp) {
		System.out.println("log..........");
		//실행될 메서드명
		System.out.println(jp.getSignature().getName());
	}

}
