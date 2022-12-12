package dectest;

public class Student implements Human {
	
	public Student() {
		System.out.println("Student.constructor");
	}

	@Override
	public void select() {
		System.out.println("Student.select");
	}

	@Override
	public void update() {
		System.out.println("Student.update");
	}

	@Override
	public void delete() {
		System.out.println("Student.delete");
	}

	@Override
	public void insert() {
		System.out.println("Student.insert");
	}

}
