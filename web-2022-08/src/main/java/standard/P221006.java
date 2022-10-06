package standard;

public class P221006 implements Comparable<P221006> {
	int eng;
	int kor;
	
	public P221006(int eng, int kor) {
		this.eng = eng;
		this.kor = kor;
	}
	
	public int getEng() {
		return eng;
	}
	
	public void setEng(int eng) {
		this.eng = eng;
	}
	
	public int getKor() {
		return kor;
	}
	
	public void setKor(int kor) {
		this.kor = kor;
	}
	
	@Override
	public int compareTo(P221006 o) {
		if(this.eng==o.eng) return o.kor - this.kor;
		else                return o.eng - this.eng;
	}
	
	@Override
	public String toString() {
		return "eng:" + eng + "/kor:" + kor;
	}
	
}









