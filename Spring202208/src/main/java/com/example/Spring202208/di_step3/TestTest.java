package com.example.Spring202208.di_step3;

public class TestTest implements Test {
	
	public TestTest() {
		System.out.println("Test");
	}

	@Override
	public void test() {
		System.out.println("Test.test");
	}

}
