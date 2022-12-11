package standard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class P221211 {

	public static void main(String[] args) {
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
//		String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
		int k = 2;
        List<Integer> list = new ArrayList<>();
        
        //중복 신고 제거
        Set<String> realReport = new HashSet<>();
        for(int i=0; i<report.length; i++) {
        	realReport.add(report[i]);
        }
        
        //중복을 제외하고 신고 받은 횟수
        HashMap<String, Integer> reported = new HashMap<>();
        StringTokenizer st;
        String temp1;
        for(int i=0; i<id_list.length; i++) {
        	reported.put(id_list[i], 0);
        }
        for(String s : realReport) {
        	st = new StringTokenizer(s);
        	st.nextToken();
        	temp1 = st.nextToken();
        	reported.put(temp1, reported.get(temp1)+1);
        }
        
        //중복을 제외하고 신고 받은 횟수가 k 이상인 사용자를 신고한 사용자들에게 메일 발송
        HashMap<String, Integer> mail = new HashMap<>();
        for(int i=0; i<id_list.length; i++) {
        	mail.put(id_list[i], 0);
        }
        
        Collection<String> keys = reported.keySet();
        String temp2;
        for(String key : keys) {
        	if(reported.get(key) >= k) {
        		for(String s : realReport) {
        			st = new StringTokenizer(s);
        			temp1 = st.nextToken();
        			temp2 = st.nextToken();
        			
        			if(key.equals(temp2)) {
        				mail.put(temp1, mail.get(temp1)+1);
        			}
        		}
        	}
        }
        
        keys = mail.keySet();
        for(String id : id_list) {
        	for(String key : keys) {
        		if(id.equals(key)) {
        			list.add(mail.get(id));
        		}
        	}
        }
        
        System.out.println(list);
	}

}
