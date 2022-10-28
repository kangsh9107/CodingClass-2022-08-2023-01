package standard;

import java.util.Vector;

import org.json.simple.JSONObject;

public class VectorToJson {

	public static void main(String[] args) throws Exception {
		Vector<Vector> vector = new Vector<>();
		
		Vector v = new Vector();
		v.add(1);
		v.add("a001");
		v.add("kor");
		v.add(100);
		v.add("2022-10-28");
		
		vector.add(v);
		System.out.println(vector);
		
		//String test = v.toString();
		//System.out.println(test);
		
		/*
		JSONParser jParser = new JSONParser();
		JSONArray jArray = (JSONArray)jParser.parse("\"" + v.toString() + "\"");
		
		for(int i=0; i<jArray.size(); i++) {
			System.out.println(jArray.get(i));
		}
		*/
		
		System.out.println("-".repeat(25));
		JSONObject obj = new JSONObject();
		obj.put("message", "테스트");
		
		System.out.println(obj.get("message"));
	}

}
