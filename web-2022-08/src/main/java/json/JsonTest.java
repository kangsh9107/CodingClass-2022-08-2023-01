package json;

import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonTest {
	
	// 배열은 list 구조로 map은 map 구조로
	public void stringToJSON() throws ParseException {
		System.out.println("(1) 정수형 배열을 JSONArray----------");
		String jsonInt = "[1,2,3,4,5]";
		JSONParser jParser = new JSONParser();
		Object o = jParser.parse(jsonInt);
		JSONArray jArray = (JSONArray)o;
		
		System.out.println(jArray.toJSONString());
		
		for(int i=0; i<jArray.size(); i++) {
			Long s = (Long)jArray.get(i);
			System.out.printf("%d : %d\n", i, s);
		}
		
		System.out.println("(2) 문자열 배열을 JSONObject----------");
		// "안에 "를 쓰려면 \를 써야해서 그냥 '로 표현했다.
		// 하지만 문자가 아니라 문자열이다.
		// 파싱하면 ''로 인식해서 파싱이 안된다.
		// 그래서 '를 "로 바꾸라는 명령어를 추가해야 한다.
		String jsonString = "['a','b','c','d','e']";
		jsonString = jsonString.replace("'","\"");
		jArray = (JSONArray)jParser.parse(jsonString);
		
		System.out.println(jArray.toJSONString());
		
		for(int i=0; i<jArray.size(); i++) {
			System.out.printf("%d : %s\n", i, jArray.get(i));
		}
		
		System.out.println("(3) map 구조를 JSONObject----------");
		String jsonMap = "{'name':'hong', 'age':'20'}";
		jsonMap = jsonMap.replace("'", "\"");
		JSONObject jObject = (JSONObject)jParser.parse(jsonMap);
		
		System.out.println("name:" + jObject.get("name"));
		System.out.println("age:" + jObject.get("age"));
		
		System.out.println("(4) 혼합 구조를 JSONObject----------");
		String jsonListMap = "[{'nnme':'hong', 'addr':'서울'}, "
							+ "{'name':'kim', 'addr':'부산'}]";
		jsonListMap = jsonListMap.replace("'", "\"");
		jArray = (JSONArray)jParser.parse(jsonListMap);
		// 향상된 for문. js의 for of랑 비슷하다.
		for(Object o2 : jArray) {
			JSONObject job = (JSONObject)o2;
			System.out.println("name : " + job.get("name"));
			System.out.println("addr : " + job.get("addr"));
		}
		
		System.out.println("(5) 혼합 구조를 JSONObject----------");
		// [a,b,c,d]로 적으면 아무것도 아닌 a,b,c,d가 나온다.
		// 만약 a,b,c,d가 선언되어 있다면 걔네가 되겠지만 그렇게 쓰지 않는다.
		String mix = "{ 'names' : ['a','b','c','d'] }";
		mix = mix.replace("'","\"");
		// (JSONObeject)로 캐스팅하지 않으면 데이터 타입이 맞지 않는다.
		jObject = (JSONObject)jParser.parse(mix);
		// 68~69를 합치면 jArray = (JSONArray)jObject.get("names");
		Object mixValue = jObject.get("names");
		jArray = (JSONArray)mixValue;
		for(Object obj : jArray) {
			System.out.println(obj);
		}
		
		System.out.println("(6) 혼합 구조를 JSONObject----------");
		String mix3 = "[ { 'names' : ['a','b','c'] }, "
					+ "  { 'ages'  : [5,6,7]       } ]";
		mix3 = mix3.replace("'","\"");
		jArray = (JSONArray)jParser.parse(mix3);
		System.out.println(jArray.toJSONString());
		for(int obj=0; obj<jArray.size(); obj++) {
			jObject = (JSONObject)jArray.get(obj);
			Iterator<String> iter = jObject.keySet().iterator();
			while(iter.hasNext()) {
				String key = (String)iter.next();
				JSONArray values = (JSONArray)jObject.get(key);
				System.out.println(values.toJSONString());
			}
		}
		/* 
		 * 	for(int obj=0; obj<jArray.size(); obj++) {
			jObject = (JSONObject)jArray.get(obj);
			Iterator<String> iter = jObject.keySet().iterator();
			while(iter.hasNext()) {
				String key = (String)iter.next();
				JSONArray values = (JSONArray)jObject.get(key);
				for(int k=0; k<values.size(); k++) {
					System.out.println(key + "/" + values.get(k));
				}
			}
		}
		 */
	}
	
	public static void main(String[] args) {
		JsonTest jt = new JsonTest();
		try {
			jt.stringToJSON();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}









