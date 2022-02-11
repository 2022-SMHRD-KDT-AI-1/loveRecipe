package model;

public class menuvo {

			private String name;	
			private String foodtype	;
			private String country	;
			private String calory	;
			private String ingre	;
			private String method	;
			private String image	;
			
			public menuvo(String name, String foodtype, String country, String calory, String ingre, String method,
					String image) {
				
				this.name = name;
				this.foodtype = foodtype;
				this.country = country;
				this.calory = calory;
				this.ingre = ingre;
				this.method = method;
				this.image = image;
			}
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
			public String getFoodtype() {
				return foodtype;
			}
			public void setFoodtype(String foodtype) {
				this.foodtype = foodtype;
			}
			public String getCountry() {
				return country;
			}
			public void setCountry(String country) {
				this.country = country;
			}
			public String getCalory() {
				return calory;
			}
			public void setCalory(String calory) {
				this.calory = calory;
			}
			public String getIngre() {
				return ingre;
			}
			public void setIngre(String ingre) {
				this.ingre = ingre;
			}
			public String getMethod() {
				return method;
			}
			public void setMethod(String method) {
				this.method = method;
			}
			public String getImage() {
				return image;
			}
			public void setImage(String image) {
				this.image = image;
			}
}
