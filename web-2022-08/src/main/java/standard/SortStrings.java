package standard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortStrings {

	public static void main(String[] args) {
		SortStrings ss = new SortStrings();
		
		String[] strings1 = {"sun", "bed", "car"};
		System.out.println(ss.solution(strings1));
		
//		String[] strings2 = {"abce", "abcd", "cdx"};
//		System.out.println(ss.solution(strings2));
	}
	
	List<String> solution(String[] strings) {
		List<String> answer = new ArrayList<>();
		
		List<String> list = new ArrayList<>();
		for(String s: strings) {
			list.add(s.substring(1));
		}
		Collections.sort(list);
		System.out.println(list);
		
		return answer;
	}

}
