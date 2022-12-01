package member;

public class MybatisPageVo {
	String findStr = "";
	int    nowPage = 1;
	int    totSize;
	int    listSize = 10;
	int    blockSize = 5;
	int    totPage, startPage, endPage;
	int    startNo, endNo;
	
	public void setDate(int nowPage, int totSize) {
		this.nowPage = nowPage;
		this.totSize = totSize;

		compute();
	}
	
	public void compute() {
		totPage = (int)Math.ceil( (double)totSize / listSize );
		endPage = (int)Math.ceil( (double)nowPage / blockSize ) * blockSize;
		startPage = endPage - blockSize + 1;
		if(endPage > totPage) endPage = totPage;
		
		endNo = nowPage * listSize;
		startNo = endNo - listSize;
		if(endNo > totSize) endNo = totSize;
	}
	
	public String getFindStr() { return findStr; }
	public int getNowPage() { return nowPage; }
	public int getTotSize() { return totSize; }
	public int getListSize() { return listSize; }
	public int getBlockSize() { return blockSize; }
	public int getTotPage() { return totPage; }
	public int getStartPage() { return startPage; }
	public int getEndPage() { return endPage; }
	public int getStartNo() { return startNo; }
	public int getEndNo() { return endNo; }
	public void setFindStr(String findStr) { this.findStr = findStr; }
	public void setNowPage(int nowPage) { this.nowPage = nowPage; }
	public void setTotSize(int totSize) { this.totSize = totSize; }
	public void setListSize(int listSize) { this.listSize = listSize; }
	public void setBlockSize(int blockSize) { this.blockSize = blockSize; }
	public void setTotPage(int totPage) { this.totPage = totPage; }
	public void setStartPage(int startPage) { this.startPage = startPage; }
	public void setEndPage(int endPage) { this.endPage = endPage; }
	public void setStartNo(int startNo) { this.startNo = startNo; }
	public void setEndNo(int endNo) { this.endNo = endNo; }

}
