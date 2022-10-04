package begin;

// import javax.xml.transform.Source;

/* 메소드 : 접근제한자 반환형 메소드명(매개변수들){} */
public class StringEx2 {

	public void test() {
		System.out.println("----------");
		String str1 = "abcdefabc";
		String str2 = "abc가나다abc";
		int len1 = str1.length();
		int len2 = str2.length();
		int index1 = str1.indexOf("c");
		int index2 = str2.indexOf("나");
		int index3 = str2.indexOf("ab", 3); // 3번째 자리부터 찾아라.

		System.out.println("len1=" + len1);
		System.out.println("len2=" + len2);
		System.out.println("index1=" + index1);
		System.out.println("index2=" + index2);
		System.out.println("index3=" + index3);
	}
	
	public void replaceTest() {
		System.out.println("replace-----");
		String source = "abc def 123 가나다 abc 123";
		String r1 = source.replace("123", "하나둘셋");
		String r2 = source.replaceAll("[12]", "헛둘");
		String r22 = source.replaceAll("[1||2]", "헛둘");
		
		System.out.println("r1=" + r1);
		System.out.println("r2=" + r2);
		System.out.println("r22=" + r22);
	}
	
	public void substringTest() {
		String source = "abc def 123 가나다 abc 123";
		String sub1 = source.substring(0, 3);
		
		System.out.println("sub1=" + sub1);
	}
	
	public void lowerTest() {
		String source = "Abc def 123 가나다 abc 123";
		String lower = source.toLowerCase();
		String upper = source.toUpperCase();
		
		System.out.println("lower=" + lower);
		System.out.println("upper=" + upper);
	}
	
	public void trimTest() {
		String source = "   abc   ";
		
		System.out.println(source);
		System.out.println(source.trim() + "abc");
	}
	
	public void valueOfTest() {
		int v1 = 123;
		double v2 = 123.45;
		String v3 = "12345";
		
		System.out.println("string으로 저장하겠다 int를 넣어서");
		System.out.println("string.int=" + String.valueOf(v1));
		System.out.println("string.double=" + String.valueOf(v2));
		System.out.println("int.string=" + Integer.valueOf(v3));
		System.out.println("double.int=" + Double.valueOf(v1));
		System.out.println("double.string=" + Double.valueOf(v3));
	}
	
	public void splitTest() {
		String source = "123,456.789/012";
		String[] sp1 = source.split(",|\\.|/");
		
		for(String s : sp1) {
			System.out.println(s);
		}
	}
	
	public static void main(String[] kkk) {
		StringEx2 ex2 = new StringEx2();
		ex2.test();
		System.out.println("**********");
		ex2.replaceTest();
		System.out.println("**********");
		ex2.substringTest();
		System.out.println("**********");
		ex2.lowerTest();
		System.out.println("**********");
		ex2.trimTest();
		System.out.println("**********");
		ex2.valueOfTest();
		System.out.println("**********");
		ex2.splitTest();
	}
}
