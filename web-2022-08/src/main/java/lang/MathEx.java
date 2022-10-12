package lang;

public class MathEx {
	
	public void test() {
		int a = -10;
		System.out.println(Math.abs(a));
	}
	
	public void test1() {
		int value = 12345;
		System.out.println("절상 전 : " + (value*.045));
		System.out.println("절상 후 : " + Math.ceil(value*.045));
		System.out.println("절상 후(10단위로) : " + Math.ceil(value*.045/10)*10);
	}
	
	public void test2() {
		int totAmt = 45450;
		int tax = (int)Math.floor(totAmt/11.0);
		int price = totAmt - tax;
		System.out.println(tax);
		System.out.println(price);
		System.out.println(price+tax);
	}
	
	public void test3() {
		int r = (int)(Math.random()*45) + 1;
		System.out.println(r);
	}
	
	public static void main(String[] args) {
		MathEx me = new MathEx();
		me.test();
		me.test1();
		me.test2();
		me.test3();
	}

}
