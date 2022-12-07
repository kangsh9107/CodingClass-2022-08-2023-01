package com.example.Spring202208.member;

public class RegisterMember implements Member {
	
	public RegisterMember() {
		System.out.println("RegisterMember");
	}

	@Override
	public void crud() {
		System.out.println("RegisterMember.crud");
	}

}
