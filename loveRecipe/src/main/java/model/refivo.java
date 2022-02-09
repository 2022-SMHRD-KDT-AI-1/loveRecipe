package model;

public class refivo {
	private int ingre_amount;
	private String ingre_temp;
	private String ingre_name;

	public refivo(int ingre_amount, String ingre_temp, String ingre_name) {
		this.ingre_amount = ingre_amount;
		this.ingre_temp = ingre_temp;
		this.ingre_name = ingre_name;
	}

	public int getIngre_amount() {
		return ingre_amount;
	}

	public void setIngre_amount(int ingre_amount) {
		this.ingre_amount = ingre_amount;
	}

	public String getIngre_temp() {
		return ingre_temp;
	}

	public void setIngre_temp(String ingre_temp) {
		this.ingre_temp = ingre_temp;
	}

	public String getIngre_name() {
		return ingre_name;
	}

	public void setIngre_name(String ingre_name) {
		this.ingre_name = ingre_name;
	}

}