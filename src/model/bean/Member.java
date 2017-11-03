package model.bean;

public class Member {
	private String id;
	private String avatar;
	private String fullName;
	private String nationalId;
	private String birthday;
	private String address;
	private String phone;
	
	
	public Member(String id, String avatar, String fullName, String nationalId, String birthday, String address,
			String phone) {
		super();
		this.id = id;
		this.avatar = avatar;
		this.fullName = fullName;
		this.nationalId = nationalId;
		this.birthday = birthday;
		this.address = address;
		this.phone = phone;
	}
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getNationalId() {
		return nationalId;
	}
	public void setNationalId(String nationalId) {
		this.nationalId = nationalId;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
}
