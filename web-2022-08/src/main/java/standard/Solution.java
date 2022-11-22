package standard;

import java.util.Arrays;
import java.util.HashSet;

public class Solution {
	
	public static void main(String[] args) {
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
		int k = 2;
		// result = {2, 1, 1, 0};
		
		HashSet<String> hs = new HashSet<>();
		hs.addAll(Arrays.asList(report));
		System.out.println(hs);
	}

}









