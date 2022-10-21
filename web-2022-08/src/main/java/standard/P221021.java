package standard;

import java.io.IOException;
import java.util.Arrays;

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
		
		String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        String temp = survey[0];
        String[] arr = temp.split("");
        System.out.println(arr[0]);
        System.out.println(arr[0].equals("A"));
	}

}
