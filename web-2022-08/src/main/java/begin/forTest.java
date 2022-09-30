package begin;

public class forTest {
	
	// 파라메터로 전달된 정수까지 1부터 출력
	public void test1(int su) {
		System.out.println("-----for미션1-----");
		for(int i=1; i<=su; i++) {
			System.out.println(i);
		}
	}
	// 파라메터로 전달된 정수까지의 홀수의 합
	public void test2(int su) {
		System.out.println("-----for미션2-----");
		int sum = 0;
		for(int i=1; i<=su; i++) {
			if(i%2!=0) sum += i;
		}
		System.out.println(sum);
	}
	// 파라메터로 전달된 수에 해당하는 구구단 출력
	public void test3(int dan) {
		System.out.println("-----for미션3-----");
		for(int i=1; i<=9; i++) {
			System.out.println(dan + " * " + i + " = " + dan*i);
		}
		
		String r = "";
		for(int i=2; i<=9; i++) {
			System.out.println(i + "단");
			r = "";
			for(int k=1; k<=9; k++) {
				r += i + " * " + k + " = " + (i * k) + "\n";
			}
			System.out.println(r);
		}
	}
	// 1부터 파라메터로 전달된 n까지의 합계가 1500이상인
	// 시점의 값과 합계 출력
	public void test4(int n) {
		System.out.println("-----for미션4-----");
		int sum = 0;
		for(int i=1; i<=n; i++) {
			if(sum>=1500) {
				System.out.println("i = " + i + ", sum = " + sum);
				break;
			}
			sum += i;
		}
	}
	
	public static void main(String[] args) {
		forTest ft = new forTest();
		ft.test1(10);
		ft.test2(10);
		ft.test3(5);
		ft.test4(1500);
	}
	
}









