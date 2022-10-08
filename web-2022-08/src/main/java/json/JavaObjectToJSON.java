package json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class JavaObjectToJSON {

	JavaObjectToJSON() {
		JSONObject obj = new JSONObject();
		obj.put("name", "홍길동");
		obj.put("score", 90);
		obj.put("addre", "봉천동");
		/* 
		 * 오브젝트 타입이 아닌데 숫자 90이 들어 가는 이유는
		 * 오토박싱 기능으로 new Integer(90)이 되어 들어간다.
		 * 숫자는 기본이 Integer다.
		 */
		System.out.println(obj.toJSONString());
		
		// key를 알고 있는 경우
		System.out.println("name : " + obj.get("name"));
		System.out.println("score : " + obj.get("score"));
		System.out.println("addre : " + obj.get("addre"));
		
		// key를 알 수 없는 경우
		Set<String> set = obj.keySet();
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()) {
			String key = iter.next();
			System.out.println(key + "=>" + obj.get(key));
		}
		
		// --------------------------------------------------
		System.out.println("-".repeat(50));
//		Test t1 = new Test();
//		Test t2 = new Test();
//		t1.setIrum("길동");
//		t1.setScore(90);
//		t2.setIrum("지매");
//		t2.setScore(80);
		
//		obj = new JSONObject();
//		obj.put("o1", t1);
//		obj.put("o2", t2);
		
//		System.out.println(obj.toJSONString());
		
		// obj에 저장된 Test객체를 가져와 출력
//		System.out.println();
//		Test t3 = (Test)obj.get("o1");
//		System.out.println(t3);
//		System.out.println(t3.getIrum());
//		System.out.println(t3.getScore());
		
//		Test t4 = (Test)obj.get("o2");
//		System.out.println(t4);
//		System.out.println(t4.getIrum());
//		System.out.println(t4.getScore());
		
		// --------------------------------------------------
		// JSON array object
		System.out.println("-".repeat(50));
		JSONArray array = new JSONArray();
		obj = new JSONObject();
		obj.put("name", "치킨");
		obj.put("phone", "010-1111-1111");
		array.add(obj);
		array.add(obj);
		array.add(obj);
		
		for(Object o : array) {
			System.out.println(o);
		}
		System.out.println("전체 데이터를 map으로 출력:" + array);
		
		// --------------------------------------------------
		// map to JSONObject
		System.out.println("-".repeat(50));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "hong");
		map.put("age", 20);
		obj = new JSONObject(map);
		
		System.out.println(obj.get("name"));
		System.out.println(obj.get("age"));
		System.out.println("전체 데이터를 map으로 출력:" + obj);
		
		List<String> li = new ArrayList<String>();
		li.add("A");
		li.add("B");
		li.add("C");
		
		array.clear();
		array.addAll(li);
		for(Object o : array) {
			System.out.println(o);
		}
		System.out.println(array.toJSONString());
		
		// --------------------------------------------------
		// JavaObject to JSONArray
		List<Test> listTest = new ArrayList<>();
		listTest.add(new Test("kim",20));
		listTest.add(new Test("hong",30));
		
		array.clear();
		array.addAll(listTest);
		for(Object o : array) {
			Test t = (Test)o;
			System.out.println(t.getIrum() + "," + t.getScore());
			System.out.println(JSONValue.toJSONString(t));
		}
	}
	
	public static void main(String[] args) {
		new JavaObjectToJSON();
	}
	
}









