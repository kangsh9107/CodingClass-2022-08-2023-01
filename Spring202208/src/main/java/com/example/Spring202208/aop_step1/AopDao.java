package com.example.Spring202208.aop_step1;

// public class AopDao implements Aop {} 이런식으로 인터페이스를 구현했다고 가정한다. 우선 수업을 위해 이렇게 가정한다.
public class AopDao {

	public void select() {
		System.out.println("AdopDao.select");
		System.out.println("log.select");
	}
	
	public void insert() {
		System.out.println("AdopDao.insert");
		System.out.println("log.insert");
	}
	
	public void update() {
		System.out.println("AdopDao.update");
		System.out.println("log.update");
	}
	
	public void delete() {
		System.out.println("AdopDao.delete");
		System.out.println("log.delete");
	}
	
}
