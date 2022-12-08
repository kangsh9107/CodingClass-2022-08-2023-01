package com.example.Spring202208.aop_step2;

public class Logout {
	AopDao2 dao;
	
	public void run(AopDao2 dao, String job) {
		this.dao = dao;

		System.out.println("log.....AopDao.....around1 or before");
		switch(job) {
		case "select":
			this.dao.select();
			break;
		case "insert":
			this.dao.insert();
			break;
		case "update":
			this.dao.update();
			break;
		case "delete":
			this.dao.delete();
			break;
		}
		System.out.println("log.....AopDao.....around2 or after");
	}

}
