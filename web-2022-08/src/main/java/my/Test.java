package my;

public class Test {
	
	public static void main(String[] args) {
		PrivateClass c = new PrivateClass();
//		c.score = 100; // private 접근 제한자를 사용해서 여기서 사용할 수 없다.
		c.tot = 200;
		c.hap();
//		c.k();
	}

}
