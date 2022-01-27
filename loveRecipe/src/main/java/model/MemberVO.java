package model;

public class MemberVO {
		private String id;
	    private String pw;
	    private String nickname;
	    private String email;
	    private String phone;
	  
		public MemberVO(String id, String pw, String nickname, String phone, String email) {
			this.id = id;
			this.pw = pw;
			this.nickname = nickname;
			this.phone = phone;
			this.email = email;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public MemberVO(String id, String pw) {
			
			this.id = id;
			this.pw = pw;
		}
		public MemberVO(String id, String pw, String nickname) {
			
			this.id = id;
			this.pw = pw;
			this.nickname = nickname;
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
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
			
		}
		public String getemail() {
			return email;
		}
		public void setemail(String email) {
			this.email = email;
	    
}
}