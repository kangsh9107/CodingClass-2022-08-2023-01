package begin;

public class StringEx3 {
	
	/* 
	 * 생성자 : 객체가 생성될 때 객체를 초기화 하는 역할.
	 *        객체 생성 전 사전 준비작업 느낌.
	 *        
	 * 생성자 특징
	 * (1) 반환형이 없다.
	 * (2) 클래스명과 똑같아야 한다.
	 * (3) 해당 클래스에 생성자가 1개도 없다면 자바 가상 머신이
	 *     기본 생성자를 하나 빌려준다.
	 */
	
	public StringEx3() {
		System.out.println("-----생성자-----");
		StringBuilder b1 = new StringBuilder("abc");
		StringBuilder b2 = new StringBuilder("abc");
		if(b1==b2) System.out.println("b1과 b2는 같다");
		else       System.out.println("b1과 b2는 다르다");
		
		String s1 = b1.toString();
		String s2 = b2.toString();
		if(s1==s2) System.out.println("s1과 s2는 같다");
		else       System.out.println("s1가 s2는 다르다");
		
		if(s1.equals(s2)) System.out.println("같다...");
		else              System.out.println("다르다...");
	}
	
	public void test() {
		System.out.println("-----미션1-----");
		System.out.println("StringEx3.test");
		
		System.out.println("-----미션2-----");
		StringBuilder name = new StringBuilder("hong");
		StringBuilder addr = new StringBuilder("서울대입구");
		StringBuilder phone = new StringBuilder("010");
		
		String mName = name.toString();
		String mAddr = addr.toString();
		String mPhone = phone.toString();
		
		System.out.println("이름 : " + mName);
		System.out.println("주소 : " + mAddr);
		System.out.println("연락처 : " + mPhone);
		
		System.out.println("-----미션2 강사님-----");
		StringBuilder sb = new StringBuilder(512);
		sb.append("이름:hong gill dong\n");
		sb.append("주소:봉천\n");
		sb.append("연락처:010-1111\n");
		String str = sb.toString();
		
		System.out.println(sb);
		System.out.println(str);
	}

	public static void main(String[] abc) {
		StringEx3 ex3 = new StringEx3();
		ex3.test();
	}
}









