package com.example.Spring202208.aop_step3;

public class StudentDao {
	
	public StudentDao() {
		System.out.println("StudentDao.constructor");
	}
	
	public void insertR() {
		System.out.println("StudentDao.insertR");
	}
	
	public void updateR() {
		System.out.println("StudentDao.updateR");
	}
	
	public void select() {
		System.out.println("StudentDao.select");
	}
	
	public void deleteR() {
		System.out.println("StudentDao.deleteR");
	}

}
