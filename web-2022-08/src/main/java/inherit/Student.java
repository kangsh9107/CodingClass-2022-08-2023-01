package inherit;

public class Student extends Data {
	
	double kor;
	double eng;
	double mat;
	double tot;
	double avg;
	
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
	
	Student() {}
	
	Student(String name, String address, String phone,
			double kor, double eng, double mat) {
		this.name    = name;
		this.address = address;
		this.phone   = phone;
		this.kor     = kor;
		this.eng     = eng;
		this.mat     = mat;
		this.tot     = kor + eng + mat;
		this.avg     = tot / 3;
	}
	
	@Override
	public String toString() {
		String str = "name : "    + this.name    + "\n"
				   + "address : " + this.address + "\n"
				   + "phone : "   + this.phone   + "\n"
				   + "kor : "     + this.kor     + "\n"
				   + "eng : "     + this.eng     + "\n"
				   + "mat : "     + this.mat     + "\n"
				   + "tot : "     + this.tot     + "\n"
				   + "avg : "     + this.avg     + "\n";
		return str;
	}
	
}
