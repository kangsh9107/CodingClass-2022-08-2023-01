package iostream;

import java.io.Serializable;
import java.util.Vector;

public class ScoreVo implements Serializable {
	public static long serialVersionUID = 300L;
	
	int serial, score; // 하나씩 적는게 정석인데 코드 짧게하려고 나열함.
	String id, mDate, subject;

	public ScoreVo() {} // ScoreDao에서 delete메서드에서 사용하기 위해서 중복선언.
						// 아니면 ScoreVo vo = new ScoreVo(serial, null, null, null, 0)으로 해도 괜찮다
	
	public ScoreVo(int s, String id, String md, String sub, int score) {
		this.serial = s;
		this.id = id;
		this.mDate = md;
		this.subject = sub;
		this.score = score;
	}
	
	public Vector getVector() {
		Vector v = new Vector();
		v.add(serial);
		v.add(id);
		v.add(mDate);
		v.add(subject);
		v.add(score);
		return v;
	}

	@Override
	public int hashCode() { // 여기서 실제로 hashCode를 재정의할 필요는 
		return this.serial;
	}

	@Override
	public boolean equals(Object obj) {
		boolean b = false;
		
		if(obj instanceof ScoreVo) { // obj가 ScoreVo 타입이니?
			ScoreVo vo = (ScoreVo)obj;
			b = vo.getSerial() == this.serial; // serial은 숫자라서 equals 안쓴다
		}
		
		return b;
	}

	public int getSerial() {
		return serial;
	}

	public void setSerial(int serial) {
		this.serial = serial;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getmDate() {
		return mDate;
	}

	public void setmDate(String mDate) {
		this.mDate = mDate;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
}
