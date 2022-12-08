package com.example.Spring202208.aop_step1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class AopConfig {
	
	@Bean
	public AopDao getAopDao() {
		return new AopDao();
	}
	
}
