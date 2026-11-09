package Question1;

import java.util.ArrayList;

//Uses the Thread class...
public class Chef extends Thread{

	public static void main(String[] args) {
		
		//Creates the 1st Thread which will call the Restaurant class...
		Thread t1 = new Thread() {
			public void run() {
				Chef chef = new Chef();
				chef.read();
			}
		};
		
		//Creates the 2nd Thread that will run first and then rests and executes its last line until the read() finishes executing...
		Thread t2 = new Thread() {
			public void run() {
				Chef chef = new Chef();
				chef.display();
			}
		};
		
		//Starts both Threads
		t1.start();
		t2.start();
	}
	
	//Using a synchronized method...
	synchronized void read() {
		//Calls the Restaurant class and starts executing and then stays in rest...
		Restaurant rest = new Restaurant();
		
		//wait() gets called and executes the last part of the print()...
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	//Using a synchronized method...
	synchronized void display()
	{
		notify();
		//First line that gets out-puted in the Chef Class...
		System.out.println("\nChef is picking up the order from the waiter!");	
		
		//The method sleeps for 2000 milliseconds and then read() starts executing...
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//The last things in the Thread that are executed
		System.out.println("\n\nYour order has been taken by a waiter");
		System.out.println("\nThe chef has received your order, your order will take 5 minutes!");
	}

}
