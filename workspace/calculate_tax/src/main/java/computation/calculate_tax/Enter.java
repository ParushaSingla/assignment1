package computation.calculate_tax;

public class Enter {
	private String name;
	private Type type;
	 private int quant;
	 private int price;
    Enter(String name ,Type type,int price,int quant)
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
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
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
