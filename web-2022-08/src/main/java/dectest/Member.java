package dectest;

public class Member implements Human {
	
	public Member() {
		System.out.println("Member.constructor");
	}

	@Override
	public void select() {
		System.out.println("Member.select");
	}

	@Override
	public void update() {
		System.out.println("Member.update");
	}

	@Override
	public void delete() {
		System.out.println("Member.delete");
	}

	@Override
	public void insert() {
		System.out.println("Member.insert");
	}

}
