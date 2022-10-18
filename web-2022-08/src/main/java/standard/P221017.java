package standard;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class P221017 {

	public static void main(String[] args) throws IOException {
		/*
		StringBuilder sb = new StringBuilder();
		Integer[][] arr = { {0,4 }, {1,2},
							{1,-1}, {2,2},
							{3,3 } };
		
		Arrays.sort(arr, new Comparator<Integer[]>() {
			@Override
			public int compare(Integer[] o1, Integer[] o2) {
				if( o1[1].equals(o2[1]) ) {
					return o1[0] - o2[0];
				} else {
					return o1[1] - o2[1];
				}
			}
		});
		
		for(int i=0; i<5; i++) {
			sb.append(arr[i][0] + " " + arr[i][1]).append("\n");
		}
		System.out.println(sb);
		*/
		
		/*
		int temp = 0;
		char[] arr = {'a','b','c'};
		
		for(int i=0; i<arr.length; i++) {
			temp += arr[i];
		}
		System.out.println(temp);
		*/
		
		/*
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String a = "abc";
		String b = "def";
		System.out.println(a.compareTo(b));
		
		int N = 13;
		String[] arr = new String[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = br.readLine();
		}

		Arrays.sort(arr, new Comparator<String>() {
			public int compare(String s1, String s2) {
				if(s1.length() == s2.length()) {
					return s1.compareTo(s2);
				} else {
					return s1.length() - s2.length();
				}
			}
		});

		bw.write(arr[0]);
		bw.newLine();
		for(int i=1; i<N; i++) {
			if( !arr[i].equals(arr[i-1]) ) {
				bw.write(arr[i]);
			}
		}
		bw.flush();
		bw.close();
		*/
		
		int N = 10;
		int factorial = 1;

		while(N>0) {
			factorial = factorial * N;
			N--;
		}

	}
	
}
