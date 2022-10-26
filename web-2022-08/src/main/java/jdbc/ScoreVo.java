package jdbc;

public class ScoreVo {
	int serial;
	String id;
	String subject;
	double score;
	String mdate;
	
	public ScoreVo() {}
	public ScoreVo(int serial, String id, String subject,
				   double score, String mdate) {
		this.serial = serial;
		this.id = id;
		this.subject = subject;
		this.score = score;
		this.mdate = mdate;
	}

	public int getSerial() { return serial; }
	public void setSerial(int serial) { this.serial = serial; }
	public String getId() { return id; }
	public void setId(String id) { this.id = id; }
	public String getSubject() { return subject; }
	public void setSubject(String subject) { this.subject = subject; }
	public double getScore() { return score; }
	public void setScore(double score) { this.score = score; }
	public String getMdate() { return mdate; }
	public void setMdate(String mdate) { this.mdate = mdate; }
}
