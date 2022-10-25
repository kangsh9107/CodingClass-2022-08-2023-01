package standard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class P221025 {
	public static void main(String[] args) throws IOException {
		/* 시간초과
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(br.readLine());
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			list1.add(Integer.parseInt(st.nextToken()));
		}
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<M; i++) {
			list2.add(Integer.parseInt(st.nextToken()));
		}
		
		HashSet<Integer> hs = new HashSet<>(list1);
		Iterator<Integer> iter = hs.iterator();
		HashMap<Integer, Integer> tempMap = new HashMap<>();
		
		while(iter.hasNext()) {
			Integer temp = iter.next();
			int cnt = Collections.frequency(list1, temp);
			
			tempMap.put(temp, cnt);
		}
		
		for(int i=0; i<list2.size(); i++) {
			if(tempMap.get(list2.get(i)) != null) {
				sb.append( tempMap.get(list2.get(i)) + " ");
			} else {
				sb.append("0 ");
			}
		}
		
		System.out.println(sb);
		*/
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<M; i++) {
			int key = Integer.parseInt(st.nextToken());
			
			sb.append(upperBound(arr, key) - lowerBound(arr, key)).append(' ');
		}
		
		System.out.println(sb);
	}
	
	public static int lowerBound(int[] arr, int key) {
		int lo = 0;
		int hi = arr.length;
		
		while(lo < hi) {
			int mid = (lo+hi) / 2;
			
			if(key <= arr[mid]) {
				hi = mid;
			} else {
				lo = mid + 1;
			}
		}
		
		return lo;
	}
	
	public static int upperBound(int[] arr, int key) {
		int lo = 0;
		int hi = arr.length;
		
		while(lo < hi) {
			int mid = (lo+hi) / 2;
			
			if(key < arr[mid]) {
				hi = mid;
			} else {
				lo = mid + 1;
			}
		}
		
		return lo;
	}
}









