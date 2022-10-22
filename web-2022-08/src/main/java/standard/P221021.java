package standard;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P221021 {
	
	public static void main(String[] args) throws IOException {
		/*
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(br.readLine());
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			list1.add( Integer.parseInt(st.nextToken()) );
		}
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<M; i++) {
			list2.add( Integer.parseInt(st.nextToken()) );
		}
		
		List<Integer> list3 = new ArrayList<>(list2);
		list3.removeAll(list1);
		
		for(int i=0; i<list2.size(); i++) {
			boolean b = false;
			for(int j=0; j<list3.size(); j++) {
				if(list2.get(i) == list3.get(j)) b = true;
			}
			
			if(b) sb.append(0).append(' ');
			else sb.append(1).append(' ');
		}
		
		System.out.println(sb);
		*/
		
		/*
		int R = 0;
		int T = 0;
		int C = 0;
		int F = 0;
		int J = 0;
		int M = 0;
		int A = 0;
		int N = 0;
		String answer = "";
		String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
		int[] choices = {5, 3, 2, 7, 5};
		
		for(int i=0; i<survey.length; i++) {
			String temp = survey[i];
			String[] arr = temp.split("");
			
			if(arr[0].equals("R")) {
				if(choices[i] == 1) R += 3;
				else if(choices[i] == 2) R += 2;
				else if(choices[i] == 3) R += 1;
				else if(choices[i] == 5) T += 1;
				else if(choices[i] == 6) T += 2;
				else if(choices[i] == 7) T += 3;
			} else if(arr[0].equals("T")) {
				if(choices[i] == 1) T += 3;
				else if(choices[i] == 2) T += 2;
				else if(choices[i] == 3) T += 1;
				else if(choices[i] == 5) R += 1;
				else if(choices[i] == 6) R += 2;
				else if(choices[i] == 7) R += 3;
			} else if(arr[0].equals("C")) {
				if(choices[i] == 1) C += 3;
				else if(choices[i] == 2) C += 2;
				else if(choices[i] == 3) C += 1;
				else if(choices[i] == 5) F += 1;
				else if(choices[i] == 6) F += 2;
				else if(choices[i] == 7) F += 3;
			} else if(arr[0].equals("F")) {
				if(choices[i] == 1) F += 3;
				else if(choices[i] == 2) F += 2;
				else if(choices[i] == 3) F += 1;
				else if(choices[i] == 5) C += 1;
				else if(choices[i] == 6) C += 2;
				else if(choices[i] == 7) C += 3;
			} else if(arr[0].equals("J")) {
				if(choices[i] == 1) J += 3;
				else if(choices[i] == 2) J += 2;
				else if(choices[i] == 3) J += 1;
				else if(choices[i] == 5) M += 1;
				else if(choices[i] == 6) M += 2;
				else if(choices[i] == 7) M += 3;
			} else if(arr[0].equals("M")) {
				if(choices[i] == 1) M += 3;
				else if(choices[i] == 2) M += 2;
				else if(choices[i] == 3) M += 1;
				else if(choices[i] == 5) J += 1;
				else if(choices[i] == 6) J += 2;
				else if(choices[i] == 7) J += 3;
			} else if(arr[0].equals("A")) {
				if(choices[i] == 1) A += 3;
				else if(choices[i] == 2) A += 2;
				else if(choices[i] == 3) A += 1;
				else if(choices[i] == 5) N += 1;
				else if(choices[i] == 6) N += 2;
				else if(choices[i] == 7) N += 3;
			} else if(arr[0].equals("N")) {
				if(choices[i] == 1) N += 3;
				else if(choices[i] == 2) N += 2;
				else if(choices[i] == 3) N += 1;
				else if(choices[i] == 5) A += 1;
				else if(choices[i] == 6) A += 2;
				else if(choices[i] == 7) A += 3;
			}
		}
		
		answer += (R >= T) ? "R" : "T";
		answer += (C >= F) ? "C" : "F";
		answer += (J >= M) ? "J" : "M";
		answer += (A >= N) ? "A" : "N";
		
		System.out.println(answer);
		*/
	}

}









