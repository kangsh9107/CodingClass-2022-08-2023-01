package standard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.StringTokenizer;

public class P221212 {

	public static void main(String[] args) {
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
		int k = 2;
//		String[] id_list = {"con", "ryan"};
//		String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
//		int k = 3;
		List<Integer> answer = new ArrayList<>();
		
		HashMap<String, Integer> reported = new HashMap<>();
		HashSet<String> chkDuplicate = new HashSet<>();
		StringTokenizer st;
		String suspect;
		for(String r : report) {
			if(chkDuplicate.add(r)) {
				st = new StringTokenizer(r);
				st.nextToken();
				suspect = st.nextToken();
				
				if(reported.get(suspect) == null) {
					reported.put(suspect, 1);
				} else {
					reported.put(suspect, reported.get(suspect)+1);
				}
			}
		}
		
		LinkedHashMap<String, Integer> mail = new LinkedHashMap<>();
		for(String id : id_list) {
			mail.put(id, 0);
		}
		
		String reporter;
		for(String key : reported.keySet()) {
			if(reported.get(key) >= k) {
				for(String c : chkDuplicate) {
					st = new StringTokenizer(c);
					reporter = st.nextToken();
					suspect = st.nextToken();
					
					if(key.equals(suspect)) {
						mail.put(reporter, mail.get(reporter)+1);
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
