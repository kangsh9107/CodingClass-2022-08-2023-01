package com.example.Spring202208.member;

public class GuestMember implements Member {
	
	public GuestMember() {
		System.out.println("GuestMember");
	}

	@Override
	public void crud() {
		System.out.println("GuestMember.crud");
	}

}
