package Question1;

import java.util.ArrayList;
import java.util.Scanner;

public class Restaurant {
	//ArrayList of OrderItems that will hold the orders of the user
	ArrayList<OrderItem>menu = new ArrayList<OrderItem>();

	public Restaurant()
	{
		//Askes the user
		//inputOrder();
		//displayOrder();
		
		//Hardcoded values
		enterOrder();
		//displayOrder();
		
		//HardCoded value no.2
		enterOrder2();
		
		//Displays the users order
		displayOrder(); 
		
		/*Added a few Sleep commands to demonstrate wait time between the time when waiter gives order to chef and when the chef finishes creating the meal*/
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("\n\nThe Chef has prepared your order!");
		displayOrder();
	}
	
	public void displayOrder() {
		for(OrderItem order :menu)
		{
			System.out.println("\nOrder Details: " + order.toString());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void enterOrder()
	{
		int receiptNo = 3;
		String main = "Steak";
		String side = "Chips";
		String dessert = "Cheesecake";
		String drink = "Wine";
		double price = 14.99;
		
		OrderItem order = new OrderItem(receiptNo,main,side,dessert,drink,price);
		menu.add(order);
	}
	
	public void enterOrder2()
	{
		int receiptNo = 4;
		String main = "Chicken";
		String side = "Naan Bread";
		String dessert = "Brownie";
		String drink = "Coke";
		double price = 14.99;
		
		OrderItem order = new OrderItem(receiptNo,main,side,dessert,drink,price);
		menu.add(order);
	}

	public void inputOrder()
	{
		Scanner scan = new Scanner(System.in);
		Restaurant rest = null;
		int receiptNo = 0;
		String main = "";
		String side = "";
		String drink = "";
		String dessert = "";
		double price = 14.99;
		
		int i = 0;
		
		System.out.print("How many orders would you like to make: ");
		i = scan.nextInt();
		scan.nextLine();
		
		for(int j = 0; j < i;j++)
		{
			receiptNo = receiptNo + 1;
			System.out.println("\nChoose your main dish: ");
			main = scan.nextLine();
			System.out.println("Choose your side dish: ");
			side = scan.nextLine();
			System.out.println("Choose your dessert: ");
			dessert = scan.nextLine();
			System.out.println("Choose your drink: ");
			drink = scan.nextLine();
			
			OrderItem order = new OrderItem(receiptNo,main,side,dessert,drink,price);
			menu.add(order);
		}
		//If the user orders more than 1 meal, it will calculate and display the total price of the order
		price = price * i;
		
		System.out.println("Your total price for your order is €" + price);
	}
	
	public static void main(String[] args) {
		new Restaurant();
	}

}
