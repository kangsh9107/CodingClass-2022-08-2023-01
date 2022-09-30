package begin;

public class WhileTest2 {
	// 1~10까지 출력
	public void test1() {
		System.out.println("-----미션1-----");
		int su = 1;
		while(su<=10) {
			System.out.println(su);
			su++;
		}
	}
	// 1~100사이 수 중 3,5의 공배수
	public void test2() {
		System.out.println("-----미션2-----");
		int su2 = 3;
		while(su2<=100) {
			if(su2%5==0) System.out.println(su2);
			su2 += 3;
		}
	}
	// 1~10을 1씩 증가시키면서 홀수이면 continue, 짝수이면 출력
	public void test3() {
		System.out.println("-----미션3-----");
		int su3 = 1;
		while(su3<=10) {
			su3++;
			if(su3%2!=0) continue;
			System.out.println(su3);
		}
	}
	// 1~100까지 while을 반복할 때 10 이상이면 break;
	public void test4() {
		System.out.println("-----미션4-----");
		int su4 = 1;
		while(su4<=100) {
			if(su4>=10) break;
			System.out.println(su4);
			su4++;
		}
	}
	/* while 응용 */
	// 변수 i는 1에서부터 1씩 증가되고 있을 때
	// i의 값의 합계가 1000이상이 될 때 i값을 출력하시오
	public void test5() {
		System.out.println("-----미션5-----");
		int su5 = 1;
		int hap = 0;
		while(su5<=1000) {
			su5++;
			hap += su5;
			if(hap>=1000) {
				System.out.println(su5);
				break;
			}
		}
		
		System.out.println("-----미션5 강사님-----");
		int i = 0;
		int sum = 0;
		while(sum<1000) {
			i++;
			sum += i;
		}
		System.out.printf("i=%d, sum=%d\n", i, sum);
	}
	// 124의 공약수들을 나열하시오
	public void test6() {
		System.out.println("-----미션6-----");
		int su6 = 124;
		int yak = 1;
		String str = "";
		while(yak<=124) {
			if(yak==124)        str += yak;
			else if(su6%yak==0) str += yak + ",";
			yak++;
		}
		System.out.println(str);
		
		System.out.println("-----미션6 강사님-----");
		int i = 1;
		int su = 124;
		while(i<su) {
			i++;
			if(su%i==0) {
				System.out.println(i);
			}
		}
	}
	// y=2x+10 방정식의 해를 구하시오
	// (단, x>=1, y<=33, x,y는 정수)
	public void test7() {
		System.out.println("-----미션7-----");
		int x = 1;
		int y = 0;
		while(x<=11) {
			y = (2 * x) + 10;
			System.out.println("(" + x + ", " + y + ")");
			x++;
		}
		
		System.out.println("-----미션7 강사님-----");
		int i = 0;
		x = 0;
		y = 0;
		while(true) {
			x++;
			y = (2 * x) + 10;
			if(y>=33) break;
			else System.out.printf("(%d, %d)%n", x, y);
		}
	}
	
	public static void main(String[] args) {
		WhileTest2 wt2 = new WhileTest2();
		wt2.test1();
		wt2.test2();
		wt2.test3();
		wt2.test4();
		wt2.test5();
		wt2.test6();
		wt2.test7();
	}
}
