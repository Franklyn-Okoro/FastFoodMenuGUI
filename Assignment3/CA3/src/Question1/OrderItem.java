package Question1;

/* User-Defined class that will hold the values of the users inputs and creates a collection of Orders */

public class OrderItem {
	
	//Appropriate instance variables
	private int receiptNo;
	private String main;
	private String side;
	private String drink;
	private String dessert;
	private double price;
	
	//Constructor that passes in the values as parameters....
	public OrderItem(int receiptNo, String main, String side, String dessert, String drink, double price)
	{
		this.receiptNo = receiptNo;
		this.main = main;
		this.side = side;
		this.dessert = dessert;
		this.drink = drink;
		this.price = price;
	}

	/*Implementing all the appropriate getters and setters ....*/
	public int getReceiptNo() {
		return receiptNo;
	}

	public void setReceiptNo(int receiptNo) {
		this.receiptNo = receiptNo;
	}

	public String getMain() {
		return main;
	}

	public void setMain(String main) {
		this.main = main;
	}

	public String getSide() {
		return side;
	}

	public void setSide(String side) {
		this.side = side;
	}

	public String getDessert() {
		return dessert;
	}

	public void setDessert(String dessert) {
		this.dessert = dessert;
	}
	
	public String getDrink() {
		return drink;
	}

	public void setDrink(String drink) {
		this.drink = drink;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	//toString()....
	public String toString()
	{
		return "\n\nReceipt Number: " + this.receiptNo + "\nMain Dish: " + this.main + "\nSide dish: " + this.side + "\nDessert: " + this.dessert + 
				"\nDrink: " + this.drink + "\nPrice of Meal: " + this.price;
	}

}
