package com.example.Spring202208.aop_step2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class AopConfig2 {
	
	@Bean
	public AopDao2 getAopDao2() {
		return new AopDao2();
	}
	
	@Bean
	public Logout getLogout() {
		return new Logout();
	}

}
