package entity;

public class CartItem {
  private Book book;
  private int quantity;
  private int OrderId;
  
  
	public CartItem() {
	}
	
	public CartItem(Book book, int quantity) {
		this.book = book;
		this.quantity = quantity;
		
	}

	public CartItem(Book book, int quantity, int orderId) {
		super();
		this.book = book;
		this.quantity = quantity;
		OrderId = orderId;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getOrderId() {
		return OrderId;
	}

	public void setOrderId(int orderId) {
		OrderId = orderId;
	}

	@Override
	public String toString() {
		return "CartItem [book=" + book + ", quantity=" + quantity + ", OrderId=" + OrderId + "]";
	}
	
	

}
