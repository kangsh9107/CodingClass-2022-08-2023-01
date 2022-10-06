package standard;

import java.util.Arrays;

public class P221005 implements Comparable<P221005> {
	int eng;
	int kor;
	
	public P221005(int eng, int kor) {
		this.eng = eng;
		this.kor = kor;
	}
	
	@Override
	public String toString() {
		return "영어:" + eng + "/국어:" + kor + "\n";
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
	public int compareTo(P221005 o) {
		// 영어 점수 내림차순 정렬
		if(this.eng!=o.eng) {
			return o.eng - this.eng;
		}
		return o.kor - this.kor;
	}
	
	public static void main(String[] args) {
		P221005[] score = { new P221005(80, 100),
							new P221005(100, 100),
							new P221005(70, 80),
							new P221005(100, 90) };
		
		Arrays.sort(score);
		System.out.println(Arrays.toString(score));
	}
}









