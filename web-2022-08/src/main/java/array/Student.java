package array;

public class Student {
	String name;
	int score;
	double weight;
	
	/* 생성자를 통해 변수를 전달받아 필드에 저장 */
	Student(String name, int score, double weight) {
		this.name = name;
		this.score = score;
		this.weight = weight;
	}

	@Override
	public String toString() {
		String str = "name : " + this.name
				   + "\nscore : " + this.score
				   + "\nweight : " + this.weight;
		return str;
	}
	
	/* n, s, w로 사용하면 나중에 Student를 다시 사용할 때
	 * 알아보기 어려우니 직관적으로 필드명하고 같게 쓴다.
	 * 단, 필드명하고 같을 때는 this를 쓴다.
	 * this는 멤버라는 의미로 이해하면 좋다.
	 * 또 this를 사용하면 . 이후에 자동완성이 가능해서
	 * 작업속도가 빨라지고 오탈자를 낼 확률이 줄어든다.
	Student(String n, int s, double w) {
		name = n;
		score = s;
		weight = w;
	}
	 */
}
