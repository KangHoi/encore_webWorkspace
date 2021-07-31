package servlet.model;

public class ProductVO {
	private String name;
	private String price;
	private String desc;
	
	public ProductVO() {}
	
	public ProductVO(String name, String price, String desc) {
		super();
		this.name = name;
		this.price = price;
		this.desc = desc;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	@Override
	public String toString() {
		return "ProductVO [name=" + name + ", price=" + price + ", desc=" + desc + "]";
	}
	

}
