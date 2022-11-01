package jsp;

public class BeanTestVo2 {
	String id;
	double kor;
	double eng;
	double mat;
	double tot;
	double avg;
	
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
		tot = kor + eng + mat;
		return tot;
	}
	public void setTot(double tot) {
		this.tot = tot;
	}
	public double getAvg() {
		avg = Math.round(tot / 3.0 * 100) / 100.0;
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}

}
