package com.example.Spring202208.di_step2;

public class Assembler {
	
	public Sql getSql() {
		return new Mssql();
	}

}
