package standard;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P221107 {
	static StringBuilder sb = new StringBuilder();
	static int n, m;
	static boolean[] visit;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		/*
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		visit = new boolean[n];
		arr = new int[m];
		dfs(0, 0);
		System.out.println(sb);
		*/
		
		String[] ani = {"강아지", "고양이", "호랑이"};
		List<String> list = new ArrayList<>(Arrays.asList(ani));
		System.out.println(list);
	}
	/*
	public static void dfs(int depth, int start) {
		if(depth == m) {
			for(int val : arr) {
				sb.append(val).append(" ");
			}
			
			sb.append("\n");
			
			return;
		}
		
		for(int i=start; i<n; i++) {
			if(!visit[i]) {
				visit[i] = true;
				arr[depth] = i + 1;
				dfs(depth+1, i+1);
				visit[i] = false;
			}
		}
	}
	*/

}
