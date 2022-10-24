package standard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P221023 {
	public static void main(String[] args) throws IOException {
		/*
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<String> list1 = new ArrayList<>();
		List<String> list2 = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			list1.add(br.readLine());
		}
		
		for(int i=0; i<M; i++) {
			list2.add(br.readLine());
		}
		
		list2.retainAll(list1);
		
		System.out.println(list2.size());
		br.close();
		*/
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<String> list1 = new ArrayList<>();
		list1.add("");
		
		for(int i=1; i<=N; i++) {
			list1.add(br.readLine());
		}
		
		List<String> list2 = new ArrayList<>();
		list2.add("");
		
		for(int i=1; i<=M; i++) {
			list2.add(br.readLine());
			
			if(isNumeric(list2.get(i))) System.out.println(list1.get(Integer.parseInt(list2.get(i))));
			else System.out.println(list1.indexOf(list2.get(i)));
		}
	}
	
	public static boolean isNumeric(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch(Exception ex) {
			return false;
		}
	}
}
