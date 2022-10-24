package jdbc;

public class MemberVo {
	String id, irum, gender, phone, picture;
	
	public MemberVo() {}
	
	// 보통 Vo는 한 건의 데이터를 저장하도록 구성한다
	
	public MemberVo(String id, String irum, String gender,
					String phone, String picture) {
		this.id = id;
		this.irum = irum;
		this.gender = gender;
		this.phone = phone;
		this.picture = picture;
	}
	
	// 검색 같은 경우 Object에서 찾는게 아니라 DB에서 찾는거라서
	// 굳이 HashCode나 equals를 재정의 하지 않는다.

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIrum() {
		return irum;
	}

	public void setIrum(String irum) {
		this.irum = irum;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

}
