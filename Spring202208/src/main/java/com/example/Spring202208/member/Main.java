package com.example.Spring202208.member;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AssemblerMember.class);
		Member member = (Member)context.getBean("getMember");
		member.crud();
	}

}
