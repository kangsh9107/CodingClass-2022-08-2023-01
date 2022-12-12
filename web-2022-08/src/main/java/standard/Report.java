package standard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Report {
	
	public static void main(String[] args) {
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
		int k = 2;
//		String[] id_list = {"con", "ryan"};
//		String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
//		int k = 3;
		List<Integer> answer = new ArrayList<>();
		
		LinkedHashMap<String, Integer> mail = new LinkedHashMap<>();
		for(String id : id_list) {
			mail.put(id, 0);
		}
		
		HashMap<String, String> realReport = new HashMap<>();
		HashMap<String, Integer> reported = new HashMap<>();
		HashSet<String> hs = new HashSet<>();
		StringTokenizer st;
		String reporter;
		String suspect;
		for(String r : report) {
			if(hs.add(r)) {
				st = new StringTokenizer(r);
				reporter = st.nextToken();
				suspect = st.nextToken();
				
				if(realReport.get(reporter) == null) {
					realReport.put(reporter, suspect + ":");
				} else {
					realReport.put(reporter, realReport.get(reporter) + suspect + ":");
				}
				
				if(reported.get(suspect) == null) {
					reported.put(suspect, 1);
				} else {
					reported.put(suspect, reported.get(suspect)+1);
				}
			}
		}
		
		for(String key : reported.keySet()) {
			if(reported.get(key) >= k) {
				for(String key2 : realReport.keySet()) {
					st = new StringTokenizer(realReport.get(key2), ":");
					
					while(st.hasMoreTokens()) {
						if(st.nextToken().equals(key)) {
							mail.put(key2, mail.get(key2)+1);
						}
					}
				}
			}
		}
		
		for(String key : mail.keySet()) {
			answer.add(mail.get(key));
		}
		
		System.out.println(answer);
	}

}









