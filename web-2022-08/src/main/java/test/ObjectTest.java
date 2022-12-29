package test;

public class ObjectTest {
	
//	static Object o;
	
	public static void main(String[] args) {
		Object o = null;
		ObjectTest oo = new ObjectTest();
		oo.testMethod(o);
//		testMethod(o);
	}
	
	void testMethod(Object o) {
		System.out.println("hi");
	}

}
