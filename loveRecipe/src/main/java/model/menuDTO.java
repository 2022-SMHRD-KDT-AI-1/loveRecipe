package model;

public class menuDTO {

	private String ingrident;
	private String object;
	private String type;
	private String seasonal;
	private String kcal;

	public menuDTO(String ingrident, String object, String type, String seasonal, String kcal) {
		super();
		this.ingrident = ingrident;
		this.object = object;
		this.type = type;
		this.seasonal = seasonal;
		this.kcal = kcal;
	}

	public String getIngrident() {
		return ingrident;
	}

	public void setIngrident(String ingrident) {
		this.ingrident = ingrident;
	}

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSeasonal() {
		return seasonal;
	}

	public void setSeasonal(String seasonal) {
		this.seasonal = seasonal;
	}

	public String getKcal() {
		return kcal;
	}

	public void setKcal(String kcal) {
		this.kcal = kcal;
	}

}