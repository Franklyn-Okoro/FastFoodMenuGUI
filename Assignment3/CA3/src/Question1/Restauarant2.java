package Question1;

import java.util.ArrayList;

public class Restauarant2 {
	ArrayList<OrderItem>menu = new ArrayList<OrderItem>();

	public static void main(String[] args) {
		Restauarant2 rest = new Restauarant2();
		ArrayList<OrderItem>menu = new ArrayList<OrderItem>();
		int receiptNo = 2;
		String main = "Chicken";
		String side = "Naan Bread";
		String dessert = "Brownie";
		String drink = "Coke";
		double price = 79.99;
		
		OrderItem order = new OrderItem(receiptNo,main,side,dessert,drink,price);
		rest.menu.add(order);
		
		/*for(OrderItem order1 :menu)
		{
			System.out.println("Order Details: " + menu.toString());
		}*/
	}

}
