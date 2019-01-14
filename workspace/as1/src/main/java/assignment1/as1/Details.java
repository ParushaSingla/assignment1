package assignment1.as1;

public class Details {
	private String name;
	private String type;
	 private int quant;
	 private int price;
    Details(String name ,String type,int quant,int price)
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
