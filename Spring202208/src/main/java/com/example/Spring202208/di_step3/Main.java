package com.example.Spring202208.di_step3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		/* 비지니스 로직이 들어간 중요한 메인코드 */
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Assembler.class);
		Sql sql = (Sql)context.getBean("getSql");
		sql.crud();
	}

	public String toString() {
		String str = "";
		return str;
	}
	
	

}
