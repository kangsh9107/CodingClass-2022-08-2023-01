package member;

public class MemberVo {
	String id      = "";
	String name    = "";
	String gender  = "";
	String phone   = "";
	String mDate   = "";
	String sysFile = "";
	String oriFile = "";
	String delFile = "";
	
	
	public String getmDate() { return mDate; }
	public void setmDate(String mDate) { this.mDate = mDate; }
	
	public String getId() { return id; }
	public void setId(String id) { this.id = id; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public String getGender() { return gender; }
	public void setGender(String gender) { this.gender = gender; }
	public String getPhone() { return phone; }
	public void setPhone(String phone) { this.phone = phone; }
	public String getSysFile() { return sysFile; }
	public void setSysFile(String sysFile) { this.sysFile = sysFile; }
	public String getOriFile() { return oriFile; }
	public void setOriFile(String oriFile) { this.oriFile = oriFile; }
	public String getDelFile() { return delFile; }
	public void setDelFile(String delFile) { this.delFile = delFile; }
	
}
