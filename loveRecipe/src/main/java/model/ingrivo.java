package model;

public class ingrivo {
	private String type;
	private String season;
	private String tempt;
	private int expire;
	private int carloy;

	public ingrivo(String type, String season, String tempt, int expire, int carloy) {
		super();
		this.type = type;
		this.season = season;
		this.tempt = tempt;
		this.expire = expire;
		this.carloy = carloy;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public String getTempt() {
		return tempt;
	}

	public void setTempt(String tempt) {
		this.tempt = tempt;
	}

	public int getExpire() {
		return expire;
	}

	public void setExpire(int expire) {
		this.expire = expire;
	}

	public int getCarloy() {
		return carloy;
	}

	public void setCarloy(int carloy) {
		this.carloy = carloy;
	}

}