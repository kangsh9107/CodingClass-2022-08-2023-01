package com.example.Spring202208.aop_step2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
		AopDao dao = (AopDao)context.getBean("getAopDao");
		Logout logout = (Logout)context.getBean("getLogout");
		
		logout.run(dao, "select");
		logout.run(dao, "insert");
		logout.run(dao, "update");
		logout.run(dao, "delete");
	}

}
