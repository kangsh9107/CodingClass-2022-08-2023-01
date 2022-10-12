package lang;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class WrapperEx {
	
	public void test1() {
		String x = "123";
		String y = "456";
		System.out.println("x+y=" + (x+y));
		
		int n1 = Integer.parseInt(x);
		int n2 = Integer.parseInt(y);
		System.out.println("n1+n2=" + (n1+n2));
	}
	
	public void test2() {
		String x = "123.456";
		String y = "3.14";
		System.out.println("x+y=" + (x+y));
		
		double d1 = Double.parseDouble(x);
		double d2 = Double.parseDouble(y);
		System.out.println("d1+d2=" + (d1+d2));
	}
	
	public void test3() throws ParseException {
		String score = "[70,80,90,60,60]";
		
		// 1) JSONArray로 파싱
		JSONParser jParser = new JSONParser();
		JSONArray jArray = (JSONArray)jParser.parse(score);
		
		// 2) List 구조의 값을 사용하여 합계와 평균을 계산.
		long sum = 0l;
		
		for(int i=0; i<jArray.size(); i++) {
			sum += (long)jArray.get(i);
		}
		
		double avg = sum / jArray.size();
		
		System.out.printf("sum : %d , avg : %.2f", sum, avg);
		System.out.println();
		System.out.println(jArray.get(1) instanceof Object);
	}
	
	public void test4() throws ParseException {
		System.out.println("\n" + "-----미션-----");
		String score = "['10','20','30','40','50']";
		score = score.replace("'", "\"");
		// ""로 바꾸면 String 으로 바꿀 필요 없이 바로 다른 타입으로 변경 가능
		JSONParser jParser = new JSONParser();
		JSONArray jArray = (JSONArray)jParser.parse(score);
		
		long sum = 0l;
		
		for(int i=0; i<jArray.size(); i++) {
			sum += Long.parseLong(jArray.get(i).toString());
		}
		
		double avg = (double)sum / jArray.size();
		System.out.printf("sum : %d , avg : %.2f", sum, avg);
	}

	public static void main(String[] args) {
			WrapperEx we = new WrapperEx();
			we.test1();
			we.test2();
			try {
				we.test3();
				we.test4();
			} catch(ParseException e) {
				e.printStackTrace();
			}
	}
	
}









