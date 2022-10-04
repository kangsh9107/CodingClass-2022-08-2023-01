package control;

public class ForExam {
	
	/* 1) 두 수를 매개변수로 전달받아 두 수와 두 수 사이의 솟수를 출력
	 * test1(int x, int y)
	 */
	public void test1(int x, int y) {
		System.out.println("-----미션1-----");
		int r1 = 0;
		for(int i=Math.min(x,y); i<=Math.max(x,y); i++) {
			r1 = 0;
			for(int k=1; k<=Math.max(x,y); k++) {
				if(i%k==0) r1 += 1;
			}
			if(r1==2) System.out.println(i);
		}
	}
	
	/* 2) 정수를 입력 받아 아래와 같이 출력하시오. test2(int x) */
	public void test2(int x) {
		System.out.println("-----미션2-----");
		for(int i=1; i<=x; i++) {
			for(int k=1; k<=i; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i=1; i<=x; i++) {
			for(int k=1; k<=x-i; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	/* 3) 세 정수 x,y,z를 매개변수로 전달 받아 x~y까지의 수중
	 *    z배수의 값을 출력 하시오.
	 *    test(int x, int y, int z) 단, z<=y
	 */
	public void test3(int x, int y, int z) {
		System.out.println("-----미션3-----");
		for(int i=Math.min(x,y); i<=Math.max(x,y); i++) {
			if(i%z==0) System.out.println(i);
		}
	}
	
	/* 4) 두 정수 x,y를 매개변수로 전달 받아 아래와 같이 출력 하시오.
	 * test4(int x, int y)
	 */
	public void test4(int x, int y) {
		System.out.println("-----미션4-----");
		for(int i=Math.min(x,y); i<=Math.max(x,y); i++) {
			for(int k=i; k<=Math.max(x,y); k++) {
				System.out.print(k + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		ForExam fe = new ForExam();
		fe.test1(10, 20);
		fe.test2(5);
		fe.test3(10, 20, 3);
		fe.test4(1, 5);
	}
	
}
