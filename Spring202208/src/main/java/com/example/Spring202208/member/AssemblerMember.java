package com.example.Spring202208.member;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.Spring202208.member.Member;
import com.example.Spring202208.member.RegisterMember;

@Configuration
public class AssemblerMember {
	
	@Bean
	public Member getMember() {
		return new RegisterMember();
	}
	
}
