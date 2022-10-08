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
		JSONArray scoreJA = (JSONArray)jParser.parse(score);
		long sum = 0l;
		
		for(int i=0; i<scoreJA.size(); i++) {
			sum += (long)scoreJA.get(i);
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
		
		/* 세형씨 풀이. 향상된 for문이랑 cnt만 증가시키는 방법
		JSONArray jArray = (JSONArray)jParser.parse(member);
		for(int i=0; i<jArray.size(); i++) {
			JSONObject jObject = (JSONObject)jArray.get(i);
			Object value1 = jObject.get("담임");
			Object value2 = jObject.get("학생");
			
			JSONArray jArray2 = (JSONArray)value2;
			int cnt =0;
			for(Object ob : jArray2) {
				cnt++;
			}
			System.out.println(value1 + " : " + cnt);
		}
		*/
		
		/*
			String score3="[ {'a반' : [3,4,5,6,7]},{'b반' : [6,5,6,7,8]},   {'c반' : [1,3,4,5,4,3,2,3,4]}]";
      		score3 = score3.replace("'", "\"");
      		JSONArray bban = (JSONArray)jParser.parse(score3);
      		JSONObject oa = (JSONObject)bban.get(0);
			JSONArray oa1 = (JSONArray)oa.get("a반");
			   
			System.out.println(oa);
			System.out.println(oa.size());
			System.out.println(oa1);
			System.out.println(oa1.size());
			for(int i=0; i<bban.size(); i++) {
			JSONObject oa = (JSONObject)bban.get(i);
			Iterator<String> iter = oa.keySet().iterator();
			while(iter.hasNext()) {
			String key = (String)iter.next();
			JSONArray values = (JSONArray)oa.get(key);
			System.out.println(values.toJSONString());
			long sum1 = 0;
            for(int k=0; k<values.size(); k++) {
               sum1 += (long)values.get(k);
            }
            System.out.println("합계:" + sum1);
            System.out.println("평균:" + (double)sum1/values.size());
         }
		*/
		
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
				String key = iter.next();
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
		
		/*
		long sumA = 0l;
		sumA += (long)values.get(i);
		*/
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
