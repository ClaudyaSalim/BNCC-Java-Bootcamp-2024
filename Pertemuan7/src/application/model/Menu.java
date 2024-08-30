package application.model;

public class Menu { // buat bikin objectnya

	private String id;
	private String name;
	private String category;
	private int price;

	public Menu(String name, String category, int price) { // id ga diset krn mau digenerate otomatis saat "add"
		this.name = name;
		this.category = category;
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}



}
