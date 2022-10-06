package array;

import java.util.Arrays;
// import java.util.*; java.util 안에 있는 모든 클래스 가져온다.
// 필요한 것만 가져오는 것보다 느리다.
import java.util.Collections;

public class ArraySort {
	void test1() {
		int[] su = {3 , 4, 3 , 2 , 4 ,
					76, 7, 87, 56, 54,
					3 , 3, 2 , 11};
		System.out.println("-----오름차순 정렬-----");
		System.out.println("정렬 전=" + Arrays.toString(su));
		Arrays.sort(su);
		System.out.println("정렬 후=" + Arrays.toString(su));
	}
	
	void test2() {
		int[] su = {3 , 4, 3 , 2 , 4 ,
					76, 7, 87, 56, 54,
					3 , 3, 2 , 11};
		System.out.println("-----부분 정렬-----");
		System.out.println("정렬 전=" + Arrays.toString(su));
		Arrays.sort(su, 4, 14);
		System.out.println("정렬 후=" + Arrays.toString(su));
	}
	
	void test3() {
		// Integer : int형의 객체를 생성해 auto boxing.
		Integer[] su = {3 , 4, 3 , 2 , 4 ,
						76, 7, 87, 56, 54,
						3 , 3, 2 , 11};
		System.out.println("-----내림차순 정렬-----");
		System.out.println("정렬 전=" + Arrays.toString(su));
		Arrays.sort(su, Collections.reverseOrder());
		System.out.println("정렬 후=" + Arrays.toString(su));
	}
	
	// 배열에 저장된 수는 5의 배수 개
	// 배열을 5개 잘라서 정렬하고 출력하고 하는 식으로 정렬
	void test4() {
		System.out.println("-----응용-----");
		int[] su = {123, 124, 5, 25, 26,
					7  , 6  , 3, 2 , 52,
					45 , 45 , 6, 7 , 34634};
		int[] s1 = new int[5];
		int[] s2 = new int[5];
		int[] s3 = new int[5];
		System.arraycopy(su, 0, s1, 0, 5);
		System.arraycopy(su, 5, s2, 0, 5);
		System.arraycopy(su, 10, s3, 0, 5);
		Arrays.sort(s1);
		Arrays.sort(s2);
		Arrays.sort(s3);
		System.out.println(Arrays.toString(s1));
		System.out.println(Arrays.toString(s2));
		System.out.println(Arrays.toString(s3));
		
		// 강사님
		System.out.println("-----응용 강사님-----");
		int[] temp = new int[5];
		
		for(int i=0; i<su.length; i=i+5) {
			System.arraycopy(su, i, temp, 0, 5);
			System.out.println(Arrays.toString(temp));
		}
	}
	
	public static void main(String[] args) {
		ArraySort as = new ArraySort();
		as.test1();
		as.test2();
		as.test3();
		as.test4();
	}
}









