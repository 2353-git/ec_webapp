package bean;

public class CartBean implements java.io.Serializable{
	public CartBean(int id, int quantity) {
		super();
		this.id = id;
		this.quantity = quantity;
	}
	private int id;
	private int quantity;


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
