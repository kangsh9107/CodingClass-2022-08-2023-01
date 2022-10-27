package standard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class P221026 {
	public static void main(String[] args) throws IOException {
		/*
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashSet<String> hs = new HashSet<>();
		List<String> list = new ArrayList<>();
		int cnt = 0;
		
		for(int i=0; i<N+M; i++) {
			String temp = br.readLine();
			
			if(hs.add(temp) == false) {
				list.add(temp);
				cnt++;
			}
		}
		
		Collections.sort(list);
		
		sb.append(cnt + "\n");
		for(int i=0; i<list.size(); i++) {
			sb.append(list.get(i) + "\n");
		}
		System.out.println(sb);
		*/
		
		/*
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashSet<Integer> hs = new HashSet<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			hs.add(Integer.parseInt(st.nextToken()));
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int temp = Integer.parseInt(st.nextToken());
			
			if(hs.add(temp) == false) {
				hs.remove(temp);
			}
		}
		
		System.out.println(hs.size());
		*/
		
		/*
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		HashSet<String> hs = new HashSet<>();
		
		for(int i=1; i<=S.length(); i++) {
			int length = i;
			while(length<=S.length()) {
				hs.add(S.substring(length-i, length));
				length++;
			}
		}
		
		System.out.println(hs.size());
		*/
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[4];
		int[] ans = new int[4];
		
		for(int i=0; i<4; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int x = arr[0];
		int y = arr[1];
		int wx = arr[2] - x;
		int hy = arr[3] - y;
		
		ans[0] = x;
		ans[1] = y;
		ans[2] = wx;
		ans[3] = hy;
		
		Arrays.sort(ans);
		
		System.out.println(ans[0]);
	}
}









