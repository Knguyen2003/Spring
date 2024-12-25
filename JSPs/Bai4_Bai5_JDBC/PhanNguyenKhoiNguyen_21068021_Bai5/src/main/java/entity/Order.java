package entity;

public class Order {
	private int orderID;
    private String fullName;
    private String address;
    private double toTal;
    private int payment;
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getToTal() {
		return toTal;
	}
	public void setToTal(double toTal) {
		this.toTal = toTal;
	}
	public int getPayment() {
		return payment;
	}
	public void setPayment(int payment) {
		this.payment = payment;
	}
	
	
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public Order(int orderID, String fullName, String address, double toTal, int payment) {
		super();
		this.orderID = orderID;
		this.fullName = fullName;
		this.address = address;
		this.toTal = toTal;
		this.payment = payment;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Order(String fullName, String address, double toTal, int payment) {
		super();
		this.fullName = fullName;
		this.address = address;
		this.toTal = toTal;
		this.payment = payment;
	}
	@Override
	public String toString() {
		return "Order [orderID=" + orderID + ", fullName=" + fullName + ", address=" + address + ", toTal=" + toTal
				+ ", payment=" + payment + "]";
	}
	
    
    
    
}
