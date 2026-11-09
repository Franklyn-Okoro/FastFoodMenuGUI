package Question1;

import java.util.ArrayList;
 
//Uses the Thread class...
public class Waiter extends Thread {

	public static void main(String[] args) {
		//Creates the 1st Thread...
		Thread t1 = new Thread() {
			public void run() {
				Waiter wait = new Waiter();
				wait.read();
			}
		};
		
		//Creates the 2nd Thread that will be in rest until its notified in the synchronized method...
		Thread t2 = new Thread() {
			public void run() {
				Waiter wait = new Waiter();
				wait.display();
			}
		};
		
		//Starts both Threads...
		t1.start();
		t2.start();
	}
	
	//Using a synchronized method...
	synchronized void read() {
		//Calls the Restaurant class and starts executing and then stays in rest...
		Restaurant rest = new Restaurant();
		
		//wait() gets called and executes the last part of the display()...
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
		//First line that gets out-puted in the Waiter Class...
		System.out.println("\nWaiter is taking your order!\n");
		
		//The method sleeps for 2000 milliseconds and then read() starts executing...
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Once display() has finished, this last line is out-puted showing that the Waiter has picked up the Order from the user...
		System.out.println("\nWaiter has taking the order from the customer...\n");
	}
}
