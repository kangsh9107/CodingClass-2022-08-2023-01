package begin;

public class WhileTest {

	public void test1() {
		System.out.println("-----예제1-----");
		int su = 3;
		while(su<=100) {
			if(su%5==0) System.out.println(su);
			su += 3;
		}
	}
	
	public void test2() {
		System.out.println("\n-----예제2-----");
		int i =0;
		while(i<=10) {
			i++;
			if(i%2==1) continue;
			System.out.println(i);
		}
	}
	
	public void test3() {
		System.out.println("\n-----예제3-----");
		int i =0;
		while(i<100) {
			i++;
			System.out.println(i);
			if(i>=10) break;
		}
	}
	
	public static void main(String[] args) {
		WhileTest wt = new WhileTest();
		wt.test1();
		wt.test2();
		wt.test3();
	}
	
}
