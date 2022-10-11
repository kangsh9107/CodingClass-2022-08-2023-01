package inherit;

public class ChildClass extends SuperClass
						implements SuperInterface1, SuperInterface2{

	ChildClass() {
//		System.out.println(privateField);
//		System.out.println(publicField);
//		privateMethod();
//		publicMethod();
	}
	
	public static void main(String[] args) {
		ChildClass cc = new ChildClass();
		cc.absoluteMethod1();
		cc.absoluteMethod2();
	}
	
	@Override
	public void absoluteMethod1() {
		System.out.println("추상 메서드1");
	}
	
	@Override
	public void absoluteMethod2() {
		System.out.println("추상 메서드2");
	}
}
