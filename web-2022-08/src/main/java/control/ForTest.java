package control;

public class ForTest {
	
	/* 파라메터로 전달된 정수까지 1부터 출력 */
	public void test1(int su) {
		System.out.println("-----for미션1-----");
		for(int i=1; i<=su; i++) {
			System.out.println(i);
		}
		
		// 강사님
		int i = 0;
		for(i=1; i<=su; i++) {
			System.out.print(i + " ");
		}
	}
	/* 파라메터로 전달된 정수까지의 홀수의 합 */
	public void test2(int su) {
		System.out.println("-----for미션2-----");
		int sum = 0;
		for(int i=1; i<=su; i++) {
			if(i%2!=0) sum += i;
		}
		System.out.println(sum);
		
		// 강사님
		int i = 0;
		int hap = 0;
		for(i=1; i<=su; i=i+2) {
			hap += i;
		}
		System.out.printf("1~%d까지 홀수의 합=%d\n", su, hap);
	}
	/* 파라메터로 전달된 수에 해당하는 구구단 출력 */
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
		
		// 강사님
		int r2 = 0;
		for(int i=1; i<=9; i++) {
			r2 = dan * i;
			System.out.printf("%2d * %d = %2d\n", dan, i, r2);
		}
	}
	/* 1부터 파라메터로 전달된 n까지의 합계가 1500이상인
	   시점의 값과 합계 출력 */
	public void test4(int n) {
		System.out.println("-----for미션4-----");
		int sum = 0;
		for(int i=1; i<=n; i++) {
			sum += i;
			if(sum>=1500) {
				System.out.println("i = " + i + ", sum = " + sum);
				break;
			}
		}
		
		// 강사님
		int i = 0;
		int hap2 = 0;
		for(i=1; i<=n; i++) {
			hap2 += i;
			if(hap2>=1500) break;
		}
		System.out.printf("1부터 %d까지의 합이 1500이 넘는 시점의 값은 %d이고,\n"
						+ "합계는 %d이다.", n, i, hap2);
	}
	
	public static void main(String[] args) {
		ForTest ft = new ForTest();
		ft.test1(10);
		ft.test2(10);
		ft.test3(5);
		ft.test4(1500);
	}
	
}









