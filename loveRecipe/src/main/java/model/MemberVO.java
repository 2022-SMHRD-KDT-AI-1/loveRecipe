package model;

public class MemberVO {
		private String num;
		private String id;
	    private String pw;
	    private String nickname;
	    private String email;
	    public MemberVO(String num, String id, String pw, String nickname, String email, String phone, String date) {
			super();
			this.num = num;
			this.id = id;
			this.pw = pw;
			this.nickname = nickname;
			this.email = email;
			this.phone = phone;
			this.date = date;
		}
	    
		public MemberVO(String id, String pw, String nickname, String email, String phone) {
			super();
			this.id = id;
			this.pw = pw;
			this.nickname = nickname;
			this.email = email;
			this.phone = phone;
		}

		public MemberVO(String id, String pw, String nickname) {
			super();
			this.id = id;
			this.pw = pw;
			this.nickname = nickname;
			
		}

		private String phone;
	    private String date;
		public String getNum() {
			return num;
		}
		public void setNum(String num) {
			this.num = num;
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
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
	  
		
}