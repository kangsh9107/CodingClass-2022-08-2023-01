package iostream;

import java.io.Serializable;
import java.text.DecimalFormat;

public class Score implements Serializable {

	public static long serialVersionUID = 1l;
	String id;
	double kor, eng, mat, tot, avg;
	
	public Score(String id, double kor, double eng, double mat) {
		this.id = id;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.tot = kor + eng + mat;
		this.avg = tot / 3;
	}
	
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,###.0");
		
		String temp = "id : "  + this.id  + "\n"
					+ "kor : " + this.kor + "\n"
					+ "eng : " + this.eng + "\n"
					+ "mat : " + this.mat + "\n"
					+ "tot : " + this.tot + "\n"
					+ "avg : " + df.format(this.avg) + "\n";
		return temp;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getKor() {
		return kor;
	}

	public void setKor(double kor) {
		this.kor = kor;
	}

	public double getEng() {
		return eng;
	}

	public void setEng(double eng) {
		this.eng = eng;
	}

	public double getMat() {
		return mat;
	}

	public void setMat(double mat) {
		this.mat = mat;
	}

	public double getTot() {
		return tot;
	}

	public void setTot(double tot) {
		this.tot = tot;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}
}
