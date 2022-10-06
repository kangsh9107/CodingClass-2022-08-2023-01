package array;

public class Data2 implements Comparable<Data2> {
	
	private String mid;
	private int score;
	
	Data2(String mid, int score) {
		this.mid = mid;
		this.score = score;
	}
	
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}

	// 양수값 리턴하면 오름차순, 음수값 리턴하면 내림차순.
	@Override
	public int compareTo(Data2 o) {
		// 이름을 오름차순으로
		int r = this.mid.compareTo(o.mid);
		
		// 성적을 오름차순으로
		// int r = this.score - o.score;
		
		// 이름을 내림차순으로
		// int r = o.mid.compareTo(this.mid);
		
		// 성적을 내림차순으로
		// int r = o.score - this.score;
		return r;
	}

	// return super.toString();은 상위 클래스가 가진
	// toString 메소드의 원형이 리턴된다. 배열 출력시 해시주소 출력.
	@Override
	public String toString() {
		String str = "mid:" + this.mid
					+" , score:" + this.score;
		return str;
	}
	
}









