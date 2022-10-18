package standard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P221018 {
	
	public static void main(String[] args) throws IOException {
		/*
		List<String> li = new ArrayList<>();
		li.add("강아지");
		li.add("고양이");
		li.add("햄스터");
		
		li.forEach(x -> System.out.println(x));
		*/
		
		/* 자바 8버전 이후에 추가된 Stream은 map구조에서 forEach를 활용하면 정말 좋다 */
		/*
		Map<String, String> hm = new HashMap<>();
		hm.put("a001", "kim");
		hm.put("b001", "han");
		hm.put("c001", "park");
		
		hm.forEach((key, value) -> {
			System.out.println(key + " " + value);
		});
		*/
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Integer> li = new ArrayList<>();
		System.out.println(n);
		
	}

}









