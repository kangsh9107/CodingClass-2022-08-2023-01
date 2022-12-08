package com.example.Spring202208.aop_step3;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/* 
 * 스프링 서버를 실행한다면 main에 해주지만
 * 단일 이라서 여기에 EnableAspectJAutoProxy를 해줘야한다.
 */
//@Configuration
//@EnableAspectJAutoProxy
//@Aspect
public class AopConfig3 {
	
	public AopConfig3() {
		System.out.println("AopConfig.constructor");
	}
	
	@Bean
	public StudentDao getStudentDao() {
		return new StudentDao();
	}
	
//	@Bean
//	public AopDao getAopDao() {
//		return new AopDao();
//	}
	
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
	 * (..)종류와 개수 무관한 매개변수, ()는 매개변수 없음
	 */
	@Before("execution(* com.example.Spring202208.aop_step3.StudentDao.select(..))")
	public void beforeAdvice(JoinPoint jp) {
//		StopWatch stopWatch = new StopWatch();
//		stopWatch.start();
//		System.out.println("Before : " + jp.getSignature().getName()); //실행될 메서드 명
//		stopWatch.stop();
//		System.out.println(stopWatch.prettyPrint());
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E) hh:mm:ss:SS");
		Date d = Calendar.getInstance().getTime();
		String nal = sdf.format(d);
		String log = (nal + " >>> " + jp.getSignature().getName());
		System.out.println(log);
		writeLog(log); //log를 파일로 저장
	}
	
//	@After("execution(* com.example.Spring202208.aop_step3.AopDao.*(..))")
//	public void afterAdvie(JoinPoint jp) {
//		//실행될 메서드명
//		System.out.println("After : " + jp.getSignature().getName());
//	}
	
//	@Bean
//	public AroundTest getAroundTest() {
//		return new AroundTest();
//	}
	

//	@Around("execution(* com.example.Spring202208.aop_step3.StudentDao.*R(..))")
	@Around("execution(* com.example.Spring202208.aop_step3.StudentDao.insertR(..))"
			+ " || execution(* com.example.Spring202208.aop_step3.StudentDao.updateR(..))"
			+ " || execution(* com.example.Spring202208.aop_step3.StudentDao.deleteR(..))")
	public void aroundAdvice(ProceedingJoinPoint jp) {
//		System.out.println("비즈니스 로직 처리 전");
//		try {
//			jp.proceed();
//		} catch(Throwable e) {
//			e.printStackTrace();
//		}
//		System.out.println("비즈니스 로직 처리 후");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E) hh:mm:ss:SS");
		Date d = Calendar.getInstance().getTime();
		String nal = sdf.format(d);
		String log = "login pass : "
				   + (nal + " >>> " + jp.getSignature().getName());
		try {
			jp.proceed();
		} catch(Throwable e) {
			e.printStackTrace();
		}
		log += "...end of around aop...";
		System.out.println(log);
		writeLog(log); //log를 파일로 저장
	}
	
	public void writeLog(String log) {
		//log를 파일로 저장
		FileWriter fw;
		SimpleDateFormat fileNameFrm = new SimpleDateFormat("yyyy-MM-dd");
		String logFile = fileNameFrm.format(new Date()) + ".log";
		
		try {
			fw = new FileWriter(logFile, true);
			fw.write(log);
			fw.write("\n");
			fw.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
