package array;

import java.util.Arrays;

public class ArrayCopy {
	ArrayCopy() {
		System.out.println("-----반복문을 사용한 배열 복사-----");
		int[] a = {1,2,3};
		int[] b = new int[3];
		for(int i=0; i<a.length; i++) {
			b[i] = a[i];
		}
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
		System.out.println(Arrays.equals(a, b));
		
		System.out.println("-----System.arraycopy()를 사용한 배열 복사-----");
		int[] c = new int[3];
		System.arraycopy(a, 0, c, 0, a.length);
		System.out.println(Arrays.toString(c));
		System.out.println(Arrays.equals(a, c));
		
		System.out.println("-----Object.clone()을 사용한 배열 복사-----");
		int[] d = a.clone();
		System.out.println(Arrays.toString(d));
		System.out.println(Arrays.equals(a, d));
	}
	
	// 배열 같은지 확인
	public static boolean isEqual(int[] first, int[] second) {
        if (first == second) {
            return true;
        }
        if (first == null || second == null) {
            return false;
        }
        if (first.length != second.length) {
            return false;
        }

        for (int i = 0; i < first.length; i++) {
            if (first[i] != second[i]) {
                return false;
            }
        }
        return true;
	}
	
	public static void main(String[] args) {
		new ArrayCopy();
		
		int[] first = {1,2,3};
		int[] second = {1,2,3};
		int[] third = {1,2,3,4};
		System.out.println("isEqual? = " + isEqual(first, second));
		System.out.println("isEqual? = " + isEqual(first, third));
	}
}
