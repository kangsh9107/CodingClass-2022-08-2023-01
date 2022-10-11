package interface_ex;

public class TestRun {
	
	public static void main(String[] args) {
		// 인터페이스를 쓰지 않으면 따로따로 만들어야 한다.
		Member m = new Member();
		AscMember am = new AscMember();
		Main main = new Main(m);
		Main main2 = new Main(am);
		
		// 다형성 예시
		MemberInterface mf1 = new AfterMember();
		MemberInterface mf2 = new AfterAscMember();
		Main main3 = new Main(mf1); // MemberInterface inter = new AfterMember();
		Main main4 = new Main(mf2); // MemberInterface inter = new AfterAscMember();
		System.out.println(main3);
	}
	
}









