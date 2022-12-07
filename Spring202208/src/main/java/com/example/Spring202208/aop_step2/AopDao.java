package com.example.Spring202208.aop_step2;

// public class AopDao implements Aop {} 이런식으로 인터페이스를 구현했다고 가정한다. 우선 수업을 위해 이렇게 가정한다.
public class AopDao {

	public void select() {
		//비지니스 로직
		System.out.println("AopDao.select");
	}
	
	public void insert() {
		//비지니스 로직
		System.out.println("AopDao.insert");
	}
	
	public void update() {
		//비지니스 로직
		System.out.println("AopDao.update");
	}
	
	public void delete() {
		//비지니스 로직
		System.out.println("AopDao.delete");
	}
	
}
