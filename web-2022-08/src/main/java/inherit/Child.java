package inherit;

public class Child extends ParentsClass implements FatherInter {
	
	Child() {
		prn();
	}
	
	public static void main(String[] args) {
		Child c = new Child();
		c.age();
	}
	
	// 상속받은 추상 메서드 재정의
	@Override
	public void age() {
		System.out.println("18세");
	}
	
}









