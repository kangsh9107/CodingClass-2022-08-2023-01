package dectest;

public class Test {
	
	public Test() {
		System.out.println("Test.constructor");
	}
	
	public Human getHuman() {
		Member m = new Member();
		return m;
	}
	
	public Human setStudent(Human s) {
		return s;
	}
	
	public static void main(String[] args) {
		Test t = new Test();
		t.getHuman();
		System.out.println("-".repeat(20));
		
		Student s = new Student();
		t.setStudent(s);
	}
	
}
