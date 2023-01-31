package standard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SortStrings {

	public static void main(String[] args) {
		SortStrings ss = new SortStrings();
		
		String[] strings1 = {"sun", "bed", "car"};
		int n1 = 1;
		System.out.println(ss.solution(strings1, n1));
		
//		String[] strings2 = {"abce", "abcd", "cdx"};
//		int n2 = 2;
//		System.out.println(ss.solution(strings2, n2));
	}
	
	public List<String> solution(String[] strings, int n) {
		List<String> answer = new ArrayList<>();
		
		Map<String, String> sort = new LinkedHashMap<>();
		for(String s: strings) {
			sort.put(s, s.substring(n, n+1));
		}
		System.out.println(sort);
		
		//value 내림차순으로 정렬하고, value가 같으면 key 오름차순으로 정렬
        List<Map.Entry<String, Integer>> list = new LinkedList<>(countHashTag.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() > o2.getValue())      return -1;
                else if (o1.getValue() < o2.getValue()) return 1;
                
                return o1.getKey().compareTo(o2.getKey());
            }
        });
        //순서유지를 위해 LinkedHashMap을 사용
        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        for(Iterator<Map.Entry<String, Integer>> iter = list.iterator(); iter.hasNext();) {
            Map.Entry<String, Integer> entry = iter.next();
            sortedMap.put(entry.getKey(), entry.getValue());
        }
		
		return answer;
	}

}
