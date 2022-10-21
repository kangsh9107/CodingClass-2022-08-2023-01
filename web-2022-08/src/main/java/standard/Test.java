package standard;

import java.util.Arrays;

public class Test {
	Integer[] arr;
	
	public Test() {
		System.out.println(Arrays.toString(arr));
		System.out.println("생성자시작");
		System.out.println("생성자시작");
		System.out.println("생성자시작");
		arr = new Integer[1];
		arr[0] = 1;
		System.out.println("생성자종료");
		System.out.println("생성자종료");
		System.out.println("생성자종료");
	}
	
	public void test2() {
		System.out.println("테스트......시작");
		System.out.println("테스트......시작");
		System.out.println("테스트......시작");
		System.out.println(Arrays.toString(arr));
		System.out.println("테스트......종료");
		System.out.println("테스트......종료");
		System.out.println("테스트......종료");
	}
	
	public static void main(String[] args) {
		Test t1 = new Test();
		t1.test2();
	}

}
