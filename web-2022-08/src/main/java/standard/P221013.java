package standard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ChoiceFormat;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class P221013 {

	public static void main(String[] args) throws IOException {
		/*
		long a = (long) 10E9;
		System.out.println(a);
		*/
		
		/*
		double[] limit = {60,70,80,90};
		String[] grade = {"D","C","B","A"};
		int[] score = {55,60,70,88,100};
		
		ChoiceFormat cf = new ChoiceFormat(limit, grade);
		for(int v : score) {
			System.out.println(v + " : " + cf.format(v));
		}
		*/
		
		/*
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		int[] arr = new int[c];
		
		for(int i=0; i<c; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		System.out.println(arr[0] + " " + arr[c-1]);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int max = -1000001;
		int min = 1000001;
		
		while(st.hasMoreTokens()) {
			int v = Integer.parseInt(st.nextToken());
			if(v>max) max = v;
			if(v<min) min = v;
		}
		System.out.print(min + " " + max);
		*/
		
		// --------------------------------------------------
		
		/*
		Scanner sc = new Scanner(System.in);
		int cnt = 0;
		int index = 0;
		int max = 0;

		while(sc.hasNext()) {
			int v = sc.nextInt();
			cnt++;
			if(v>max) {
				max = v;
				index = cnt;
			}
		}
		System.out.println(max);
		System.out.print(index);
		*/
		
		/*
		int[] temp = {39,40,41,42,43,44,82,83,84,85};
		int[] arr = new int[10];
		
		for(int i=0; i<10; i++) {
			arr[i] = temp[i] % 42;
		}
		
		int cnt2 = 0;
		int r = 1;
		System.out.println(Arrays.toString(arr));

		for(int i=0; i<10; i++) {
			cnt2 = 0;
			for(int k=0; k<10; k++) {
				if(arr[i] == arr[k]) cnt2++;
			}
			if(cnt2==1) {
				r++;
				System.out.println(i);
			}
		}
		System.out.println(r);
		*/
		
		int n = 3;
		double[] arr = {40,80,60};

		Arrays.sort(arr);
		double max = arr[n-1];
		double sum = 0d;

		for(int i=0; i<n; i++) {
			arr[i] = (arr[i] / max) * 100;
		}
		
		System.out.println(Arrays.toString(arr));

		for(int i=0; i<n; i++) {
			sum += arr[i];
		}
		System.out.print(sum / n);
		
	}
	
}









