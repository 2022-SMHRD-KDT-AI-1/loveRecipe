package model;

public class viewrefVO {
	private String rname;
	private String ingre;
	private int calory;
	private String type;
	private String sequence;
	private String href;

	public viewrefVO(String rname, String ingre, int calory, String type) {
		this.rname = rname;
		this.ingre = ingre;
		this.calory = calory;
		this.type = type;
	}

	public viewrefVO(String sequence, String href) {
		this.sequence = sequence;
		this.href = href;
	}

	public viewrefVO(String href) {
		this.href = href;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getIngre() {
		return ingre;
	}

	public void setIngre(String ingre) {
		this.ingre = ingre;
	}

	public int getCalory() {
		return calory;
	}

	public void setCalory(int calory) {
		this.calory = calory;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSequence() {
		return sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

}