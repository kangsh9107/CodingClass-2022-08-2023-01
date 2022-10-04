package begin;

import java.io.UnsupportedEncodingException;

public class StringEx {
	public static void main(String[] args) {
//		String s1 = "홍길동";
//		String s2 = "홍길동";
//		System.out.println(s1==s2);
		/* "홍길동" 이라는 값을 비교하는게 아니라
		 * heap memory에 "홍길동"을 가리키는
		 * 주소가 같은지 비교 한다.
		 */
//		System.out.println(s1.equals(s2));
		/* "홍길동" 이라는 값(문자열)을 비교하려면
		 * equals를 사용한다.
		 */
		
//		String s3 = new String("일지매");
//		String s4 = new String("일지매");
//		System.out.println(s3==s4);
//		System.out.println(s3.equals(s4));
		
		
		
//		System.out.println("----------");
//		String jumin = "123456-1";
		
//		char c = jumin.charAt(7);
//		System.out.println(c);
		
//		int r = Character.getNumericValue(c);
//		String str = null;
//		if(r%2==0) str = "여자";
//		else       str = "남자";
//		System.out.println("c=" + c);
//		System.out.println("성별=" + str);
		
//		if(c=='1' || c=='3') str = "진짜 남자 !!";
//		else                 str = "진짜 여자 !!";
//		System.out.println(str);
		
		/* String pn='123R456'인 경우 4번째 값은
		 * R:red, B:blue, G:green 색을 나타내고 있다.
		 * 위의 pn을 확인하여 어떤색의 제품인지 출력
		 */
		String pn = "123R456";
//		int r = pn.charAt(3);
		
		int pnLength = pn.length();
		System.out.println(pnLength);
		String pnStr = null;
		
		for(int i=0; i<pnLength; i++) {
			char pnFindColor = pn.charAt(i);
			if(pnFindColor=='R')      pnStr = "빨간색 제품 입니다.";
			else if(pnFindColor=='G') pnStr = "초록색 제품 입니다.";
			else if(pnFindColor=='B') pnStr = "파란색 제품 입니다.";
		}
		
		System.out.println(pnStr);
		
		/* getBytes */
		String strGet = "abc 123 가나다";
		try {
			byte[] euc = strGet.getBytes("euc-kr");
			byte[] ksc = strGet.getBytes("ksc5601");
			byte[] iso = strGet.getBytes("iso8859-1");
			byte[] utf = strGet.getBytes("utf-8");
			
			System.out.println("----------");
			System.out.println("euc-kr : " + new String(euc));
			System.out.println("ksc : " + new String(ksc));
			System.out.println("iso : " + new String(iso));
			System.out.println("utf : " + new String(utf));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}









