package entity;

public class Book {
	private int id;
	private String title;
	private String image;
	private double price;
	private int soLuongTon;
	
	
	public Book() {
		// TODO Auto-generated constructor stub
	}
	
	public Book(int id, String title, String image, double price, int soLuongTon) {
		
		this.id = id;
		this.title = title;
		this.image = image;
		this.price = price;
		this.soLuongTon = soLuongTon;
	}
	
	
	public Book(String title, String image, double price, int soLuongTon) {
		this.title = title;
		this.image = image;
		this.price = price;
		this.soLuongTon = soLuongTon;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getSoLuongTon() {
		return soLuongTon;
	}

	public void setSoLuongTon(int soLuongTon) {
		this.soLuongTon = soLuongTon;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", image=" + image + ", price=" + price + ", soLuongTon="
				+ soLuongTon + "]";
	}
	
	

}
