package com.example.Spring202208.di_step1;

public class Main {
	
	public Main(Mysql m) {
		m.crud();
	}
	
	public static void main(String[] args) {
		Mysql mysql = new Mysql();
		Main m = new Main(mysql);
		
		//외부 환경의 변화
		//Oracle oracle = new Oracle();
		//m = new Main(oracle); //생성자의 매개변수 타입을 바꾸던가 생성자를 중복선언 해야한다.
		
		//Mssql mssql = new Mssql();
		//m = new Main(mssql);  //마찬가지다.
		
		/* di 개념이 없는 코드 */
		/* 이 코드의 문제는 외부환경을 바꾸면 내부환경도 바꿔야한다. */
	}

}
