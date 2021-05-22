package codejava;



public class product {
	private int id;
	private int quantity;
	private String name;
	
	public product() {
		
		// TODO Auto-generated constructor stub
	}
	public product(int id, int quantity, String name) {
	    this.id = id;
		this.quantity = quantity;
		this.name = name;
	}
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "product [id=" + id + ", quntity=" + quantity + ", name=" + name + "]";
	}
	
	
	

}
