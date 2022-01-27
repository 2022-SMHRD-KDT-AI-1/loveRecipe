package model;

public class MemberDTO {
	private String id;
    private String pw;
    private String nickname;
    private String email;
    private String phone;
	public MemberDTO(String id, String pw, String nickname, String email, String phone) {
		super();
		this.id = id;
		this.pw = pw;
		this.nickname = nickname;
		this.email = email;
		this.phone = phone;
	}
	


	public MemberDTO(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}



	public MemberDTO(String pw, String nickname, String email, String phone) {
		
		this.pw = pw;
		this.nickname = nickname;
		this.email = email;
		this.phone = phone;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
