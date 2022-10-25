package standard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class P221024 {
	public static void main(String[] args) throws IOException {
		/*
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		HashSet<Integer> hs = new HashSet<>(list);
		Iterator<Integer> iter = hs.iterator();
		int ans = 0;
		
		while(iter.hasNext()) {
			Integer i = iter.next();
			if(i == v) ans = Collections.frequency(list, i);
		}
		
		System.out.println(ans);
		*/
		
		/*
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashSet<Integer> hs = new HashSet<>();
		
		for(int i=0; i<28; i++) {
			hs.add(Integer.parseInt(br.readLine()));
		}
		
		for(int i=1; i<=30; i++) {
			if(hs.add(i)) System.out.println(i);
		}
		*/
		
		/*
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> list = new ArrayList<>();
		double sum = 0;
		
		for(int i=0; i<5; i++) {
			int temp = Integer.parseInt(br.readLine());
			list.add(temp);
			sum += temp;
		}
		
		Collections.sort(list);
		
		System.out.printf("%.0f", sum / 5);
		System.out.println("\n" + list.get(2));
		*/
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
	}
}
