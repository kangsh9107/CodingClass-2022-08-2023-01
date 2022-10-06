package json;

import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonExam {

	public void jsonExam() throws ParseException {
		
		System.out.println("미션1----------");
		String score = "[44,33,55,65,78]";
		JSONParser jParser = new JSONParser();
		Object scoreJO = jParser.parse(score);
		JSONArray scoreJA = (JSONArray)scoreJO;
		long sum = 0l;
		for(int i=0; i<scoreJA.size(); i++) {
			long s = (long)scoreJA.get(i);
			sum += s;
		}
		System.out.println("평균:" + sum/scoreJA.size());
		
		// ------------------------------------------------------------
		
		System.out.println("\n" + "미션2----------");
		String info = "{'id':'hong', 'name':'길동', 'phone':'010-2222'}";
		info = info.replace("'","\"");
		JSONObject infoJO = (JSONObject)jParser.parse(info);
		System.out.println("name:" + infoJO.get("name"));
		System.out.println("phone:" + infoJO.get("phone"));
		
		// ------------------------------------------------------------

		System.out.println("\n" + "미션3----------");
		String member = "[ {'담임':'홍', '학생':['김','이','박']},"
					  + "  {'담임':'김', '학생':['남','최']}    ,"
					  + "  {'담임':'남', '학생':['김','가','나','마','사','이']} ]";
		member = member.replace("'","\"");
		JSONArray memberJA = (JSONArray)jParser.parse(member);
		
		for(int obj=0; obj<memberJA.size(); obj++) {
			JSONObject memberJO = (JSONObject)memberJA.get(obj);
			JSONArray temp = (JSONArray)memberJO.get("학생");
			System.out.println(memberJO.get("담임") + ":" + temp.size() + "명");
		}
		
		// ------------------------------------------------------------
		
		System.out.println("\n" + "미션4----------");
		String score2 = "[ {'a반':[3,4,5,6,7]},"
					  + "  {'b반':[6,5,6,7,8]},"
					  + "  {'c반':[1,3,4,5,4,3,2,3,4]} ]";
		score2 = score2.replace("'","\"");
		JSONArray score2JA = (JSONArray)jParser.parse(score2);
		
		int sumA = 0;
		int sumB = 0;
		int sumC = 0;
		double cntA = 0d;
		double cntB = 0d;
		double cntC = 0d;
		
		for(int obj=0; obj<score2JA.size(); obj++) {
			JSONObject score2JO = (JSONObject)score2JA.get(obj);
			Iterator<String> iter = score2JO.keySet().iterator();
			while(iter.hasNext()) {
				String key = (String)iter.next();
				JSONArray values = (JSONArray)score2JO.get(key);
				for(int i=0; i<values.size(); i++) {
					if(key.equals("a반")) {
						sumA += Integer.parseInt(values.get(i).toString());
						cntA++;
					} else if(key.equals("b반")) {
						sumB += Integer.parseInt(values.get(i).toString());
						cntB++;
					} else {
						sumC += Integer.parseInt(values.get(i).toString());
						cntC++;
					}
				}
			}
		}
		System.out.printf("a반 평균:%.2f\n", sumA/cntA);
		System.out.printf("b반 평균:%.2f\n", sumB/cntB);
		System.out.printf("c반 평균:%.2f"  , sumC/cntC);
	}
	
	public static void main(String[] args) {
		JsonExam je = new JsonExam();
		try {
			je.jsonExam();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
