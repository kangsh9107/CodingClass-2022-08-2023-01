package student;

public class Page {
	// 페이지와 관련된 필드 선언
	String findStr = "";
	int    nowPage = 1;
	
	public String getFindStr() { return findStr; }
	public void setFindStr(String findStr) { this.findStr = findStr; }
	public int getNowPage() { return nowPage; }
	public void setNowPage(int nowPage) { this.nowPage = nowPage; }
	
}
