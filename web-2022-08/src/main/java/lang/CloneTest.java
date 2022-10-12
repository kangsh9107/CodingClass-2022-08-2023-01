package lang;

public class CloneTest {
	
	public static void main(String[] args) {
		
		/* 얕은 복사 */
		Member a = new Member(10);
		Member b = a; // a가 저장하고 있는 주소값만 b에 대입된다.
		
		System.out.println("수정전");
		System.out.println(a.su + "," + b.su);
		
		a.su = 100;
		System.out.println("수정후");
		System.out.println(a.su + "," + b.su);
		
		b.su = 300;
		System.out.println("수정후");
		System.out.println(a.su + "," + b.su);
		
		/* implements Cloneable을 사용한 깊은 복사 */
		System.out.println("-".repeat(50));
		Member c = (Member)a.clone();
		c.su = 400;
		System.out.println(a.su + "," + c.su);
	}

}









