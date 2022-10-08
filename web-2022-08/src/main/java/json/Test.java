package json;

public class Test {
	
	String irum;
	int score;

	public String getIrum() {
		return irum;
	}

	public void setIrum(String irum) {
		this.irum = irum;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	Test(String irum, int score) {
		this.irum = irum;
		this.score = score;
	}

	@Override
	public String toString() {
		String p = "{'irum':%s,'score':%d}";
		String str = 
			String.format(p, this.irum, this.score);
		str = str.replace("'", "\"");
		return str;
	}
	
}
