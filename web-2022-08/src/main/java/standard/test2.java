package standard;

import java.util.Vector;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

public class Test2 {

	public static void main(String[] args) {
		Vector<Vector> list = new Vector<>();
		Vector v = new Vector();
		v.add(1);
		v.add("a001");
		v.add("kor");
		v.add(100);
		v.add("2022-10-26");
		list.add(v);
		
		System.out.println("v:" + v);
		System.out.println("list:" + list);
		
		System.out.println(v.get(0));
		try {
			JSONParser jParser = new JSONParser();
			JSONArray jArray = (JSONArray)jParser.parse(list.toString());
			System.out.println("jArray:" + jArray.get(1));
		} catch(Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
	}

}
