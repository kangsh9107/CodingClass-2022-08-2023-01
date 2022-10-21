package standard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P221020 {
	
	public static void main(String[] args) throws IOException {
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
		
		
		
		System.out.println(sb);
		
		/* 시간초과
		for(int i=0; i<list2.size(); i++) {
			boolean b = false;
			for(int j=0; j<list1.size(); j++) {
				if(list2.get(i) == list1.get(j)) b = true;
			}
			
			if(b) sb.append(1).append(' ');
			else sb.append(0).append(' ');
		}
		*/
	}

}
