package collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapEx {
	
	// Map CRUD
	public void test1() {
		Map<String, String> hm = new HashMap<>();
		
		/* C : 입력 */
		hm.put("k1", "v1");
		hm.put("k2", "v2");
		hm.put("k3", "v3");
		System.out.println(hm);
		
		/* U : 수정 */
		hm.put("k2", "홍길동");
		System.out.println(hm);
		
		/* D : 삭제 */
		hm.remove("k2");
		System.out.println(hm);
		
		/* R : 조회 */
		// key값을 아는 경우
		System.out.println(hm.get("k1"));
		
		// key값을 모르는 경우
		System.out.println("-".repeat(25));
		Set<String> set = hm.keySet(); // key값을 Set 구조로 반환. Set 구조는 입력순서와 출력순서가 관계없다
									   // 인덱스가 없기 때문에 iterator를 사용해야 순차접근 가능
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()) {
			String key = iter.next();
			System.out.println(hm.get(key));
		}
		
		/* value값만 필요한 경우 */
		System.out.println("-".repeat(25));
		Collection<String> values = hm.values(); // value값을 Collection 구조로 반환
		Iterator<String> iter2 = set.iterator();
		while(iter2.hasNext()) {
			System.out.println(iter2.next());
		}
		
		/* Map.Entry 굳이 사용할 필요는 없다. 복잡한 만큼 메리트가 없고, 버려도 다른 방법으로 대체 가능 */
		System.out.println("-".repeat(25));
		Set<Map.Entry<String, String>> set2 = hm.entrySet();
		Iterator<Entry<String, String>> iter3 = set2.iterator();
		while(iter3.hasNext()) {
			Map.Entry entry = iter3.next();
			System.out.println(entry.getKey() + " , " + entry.getValue());
		}
		
		/* value값이 Object 타입 */
		Map<String, Data> hm5 = new HashMap<>();
		hm5.put("a001", new Data("a001", "hong", 18));
		hm5.put("b001", new Data("b001", "kim" , 20));
		hm5.put("c001", new Data("c001", "park", 30));
		System.out.println(hm5);
		
		Set<String> set5 = hm5.keySet();
		Iterator<String> iter5 = set5.iterator();
		while(iter5.hasNext()) {
			String key = iter5.next();
			Data d = hm5.get(key);
			System.out.println(d);
		}
	}

	public static void main(String[] args) {
		new MapEx().test1();
	}
	
}









