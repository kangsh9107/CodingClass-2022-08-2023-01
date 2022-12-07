package com.example.Spring202208.di_step2;

public class Mysql implements Sql {

	@Override
	public void crud() {
		System.out.println("Mysql.crud");
	}

}
