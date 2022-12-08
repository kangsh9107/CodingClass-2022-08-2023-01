package com.example.Spring202208.aop_step3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig3.class);
//		AopDao dao = (AopDao)context.getBean("getAopDao");
//		dao.select();
//		dao.insert();
//		dao.update();
//		dao.delete();
		
//		AroundTest at = (AroundTest)context.getBean("getAroundTest");
//		at.crud(); //jp.proceed(); 에 의해 실행 되었다.
		
		StudentDao sDao = (StudentDao)context.getBean("getStudentDao");
		sDao.select();
		sDao.insertR();
		sDao.updateR();
		sDao.deleteR();
	}

}
