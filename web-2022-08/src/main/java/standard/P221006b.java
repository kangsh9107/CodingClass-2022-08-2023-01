package standard;

import java.util.Arrays;

public class P221006b {
	public static void main(String[] args) {
		P221006[] score = new P221006[3];
		int[] eng = {50,70,70};
		int[] kor = {80,100,90};
		
		for(int i=0; i<score.length; i++) {
			score[i] = new P221006(eng[i],kor[i]);
		}
		
		System.out.println("정렬 전:" + Arrays.toString(score));
		Arrays.sort(score);
		System.out.println("정렬 후:" + Arrays.toString(score));
	}
}
