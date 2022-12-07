package com.example.Spring202208.di_step3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Assembler {

	@Bean
	public Sql getSql() {
		return new Mssql();
	}
	/* 다른 작업을 추가로 하지 않아도 스프링 서버가 실행되면 객체가 만들어진다. */
	/* 메모리에 올라간 객체를 스프링에서는 Bean이라고 한다. */
	/* 여기서는 getSql이 Bean의 이름이다. */
	/* 같은 인터페이스를 사용하는 Bean이 2개면 같은 인터페이스를 동시에 각각 호출해서 오류가 난다. */
	/* 같은 클래스네임을 가진 클래스가 서로 다른 패키지에 있어도 오류가 난다. */
}
