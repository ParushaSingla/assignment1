package assignment2.nagarro1;

public class EnterDetails {
	private String name;
	private String type;
	 private int quant;
	 private int price;
    EnterDetails(String name ,String type,int price,int quant)
    {
    	this.setName(name);
    	this.setType(type);
    	this.setQuant(quant);
    	this.setPrice(price);
    }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuant() {
		return quant;
	}
	public void setQuant(int quant) {
		this.quant = quant;
	}
}
