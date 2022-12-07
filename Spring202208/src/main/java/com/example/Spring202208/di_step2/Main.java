package com.example.Spring202208.di_step2;

public class Main {
	
	public Main(Sql sql) {
		sql.crud();
	}

	public static void main(String[] args) {
		Assembler ab = new Assembler();
		Main m = new Main(ab.getSql());
		
		/* 자바로 di 구현한 코드 */
		/* 외부환경을 바꿔도 내부환경을 바꿀 필요가 없다. */
		/* 외부환경이 바뀌면 Assembler만 바꾸거나 갈아끼면 된다. */
	}
	
}
