package array;

import java.util.Arrays;

public class ArrayTest4 {
	public ArrayTest4() {
		int[][] arr = { {1,2,3}, {4,5,6}, {7,8,9} };
//		prn(arr[1][1]);
		prn(arr[0], arr[1], arr[2]);
		prn(arr);
		
		int[][] score = {
				{1,2,3,10},
				{4,5,6},
				{7,8,9},
				{3,4,2,1,3}
		};
		System.out.println("dd" + score.length);
		tot(score);
		for(int r=0; r<score.length; r++) {
			hap(score[r]);
		}
	}
	
//	public void prn(int array) {
//		System.out.println("-----배열의 요소값 하나를 매개변수로 전달-----");
//		System.out.println(array);
//	}
	
	public void prn(int[] array1, int[] array2, int[] array3) {
//		System.out.println("-----1차원 배열을 매개변수로 전달-----");
//		System.out.println(Arrays.toString(array));
		
		System.out.println("-----(7) 배열의 각 행의 합계와 평균을 출력-----");
		System.out.println(Arrays.toString(array1));
		System.out.println(Arrays.toString(array2));
		System.out.println(Arrays.toString(array3));
		int tot = 0;
		double avg = 0;
		for(int i=0; i<array1.length; i++) {
			tot += array1[i];
		}
		avg = tot / array1.length;
		System.out.printf("1행 = 합계 : %2d, 평균 : %6.2f\n", tot, avg);
		for(int i=0; i<array2.length; i++) {
			tot += array2[i];
		}
		avg = tot / array2.length;
		System.out.printf("2행 = 합계 : %2d, 평균 : %6.2f\n", tot, avg);
		for(int i=0; i<array3.length; i++) {
			tot += array3[i];
		}
		avg = tot / array3.length;
		System.out.printf("3행 = 합계 : %2d, 평균 : %6.2f\n", tot, avg);
	}
	
	public void prn(int[][] array) {
//		System.out.println("-----2차원 배열을 매개변수로 전달-----");
		
		System.out.println("-----(8) 배열의 합계와 평균을 출력-----");
		for(int i=0; i<array.length; i++) {
			System.out.println(Arrays.toString(array[i]));
		}
		int tot = 0;
		double avg = 0;
		for(int i=0; i<array.length; i++) {
			for(int k=0; k<array[i].length; k++) {
				tot += array[i][k];
			}
		}
		avg = tot / array.length;
		System.out.printf("전체 = 합계 : %2d, 평균 : %2.2f\n", tot, avg);
	}
	
	// (7) 강사님
	void tot(int[][] s) {
		System.out.println("-----(7) 강사님-----");
		int sum = 0;
		int cnt = 0; // 데이터의 갯수
		for(int r=0; r<s.length; r++) {
			for(int c=0; c<s[r].length; c++) {
				sum += s[r][c];
				cnt++;
			}
		}
		System.out.println("sum = " + sum);
		System.out.println("avg = " + (sum/(double)cnt));
	}
	
	// (8) 강사님
	void hap(int[] s) {
		System.out.println("-----(8) 강사님-----");
		int sum = 0;
		double avg = 0;
		for(int i=0; i<s.length; i++) {
			sum += s[i];
		}
		// 계산 후에 double로 바꾸면 이미 소수점 사라진 상태다.
		// 계산 중에 double로 바꿔야 한다.
		avg = sum / (double)s.length;
		System.out.println("합계=" + sum);
		System.out.println("평균=" + avg);
	}
	
	public static void main(String[] args) {
		new ArrayTest4();
	}
}
