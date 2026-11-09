package Question2;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Question1.OrderItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

public class MenuGUI extends JFrame implements ActionListener{

	JPanel mDish, sDish, mDessert, mDrink, pButton, pTop;
	JComboBox<String> cbSize,cbMain, cbSide, cbDrink;
	JList listMain, listSide, listDessert, listDrink;
	JButton cancel, add, complete;
	JTextArea details;
	String sizelist[] = {"Medium", "Large", "Small"};
	
	JLabel label1 = new JLabel("Order Details: ");
	
	DefaultListModel<String> mainDish = new DefaultListModel<String>();
	DefaultListModel<String> sideDish = new DefaultListModel<String>();
	DefaultListModel<String> drink = new DefaultListModel<String>();
	DefaultListModel<String> dessert = new DefaultListModel<String>(); 
	
	ArrayList<OrderItem>menu = new ArrayList<OrderItem>();
	
	public MenuGUI()
	{
		super("Menu Order");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//all my JPanels
		mDish = new JPanel();
		sDish = new JPanel();
		mDessert = new JPanel();
		mDrink = new JPanel();
		pButton = new JPanel();
		pTop = new JPanel();
		
		//Calls my GridLayout...
		GridLayout g1 = new GridLayout(0,1);
		
		pTop = new JPanel();
		pTop.setLayout(g1);
		
		//JComboBox of different portion sizes(S,M,L)...
		cbSize = new JComboBox(sizelist);
		mDish.add(new JLabel("Protein Portion: "));
		mDish.add(cbSize);
		
		//JList of my Protein options in my menu...
		mainDish.addElement("Chicken");
		mainDish.addElement("Fish");
		mainDish.addElement("Beef");
		mainDish.addElement("Pork");
		listMain = new JList<String>(mainDish);
		listMain.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		listMain.setVisibleRowCount(4);
		listMain.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		
		//Adds it to my JPanel that holds the main dish...
		mDish.add(new JLabel("Main Dish: "));
		mDish.add(listMain);
		
		//JList of Side Dishes...
		sideDish.addElement("Chips");
		sideDish.addElement("Rice");
		listSide = new JList<String>(sideDish);
		listSide.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		listSide.setVisibleRowCount(4);
		listSide.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		
		//JComboBox of Side Portion Sizes...
		cbSide = new JComboBox(sizelist);
		sDish.add(new JLabel("Side sizes"));
		sDish.add(cbSide);
		
		//Adds it to my JPanel of Side dishes...
		sDish.add(new JLabel("Side Dish: "));
		sDish.add(listSide);
		
		drink.addElement("Fanta");
		drink.addElement("Coke");
		drink.addElement("Sprite");
		listDrink = new JList<String>(drink);
		listDrink.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		listDrink.setVisibleRowCount(4);
		listDrink.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		
		cbDrink = new JComboBox(sizelist);
		
		mDrink.add(new JLabel("Drinks Size: "));
		mDrink.add(cbDrink);
		mDrink.add(new JLabel("Drinks: "));
		mDrink.add(listDrink);
		
		dessert.addElement("Oreo Ice-cream");
		dessert.addElement("Lemon Cheesecake");
		dessert.addElement("Choc Brownie");
		listDessert = new JList<String>(dessert);
		listDessert.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		listDessert.setVisibleRowCount(4);
		listDessert.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		
		mDessert.add(new JLabel("Desserts: "));
		mDessert.add(listDessert); 
	
		//Creates a textarea at the bottom of the GUI to show the Order Details...
		details = new JTextArea(5, 40);
		//Line bOrder yellow
		details.setBorder(new LineBorder(Color.YELLOW));
		
		//Implementing a scrollpane...
		JScrollPane pane = new JScrollPane(details);
		pane.setBorder(new EmptyBorder(15, 15, 15, 15));
		
		//Add Cancel and Complete Buttons created		
		cancel = new JButton("Cancel Order");
		add = new JButton("Add Item");
		complete = new JButton("Complete Order");
		
		pButton.add(cancel);
		pButton.add(add);
		pButton.add(complete);
		
		//Instantiates them so they can work....
		cancel.addActionListener(this);
		add.addActionListener(this);
		complete.addActionListener(this);
		
		//Adds them all to my top panel...
		pTop.add(mDish);
		pTop.add(sDish);
		pTop.add(mDrink);
		pTop.add(mDessert);
		pTop.add(pButton);
		
		this.add(pTop, BorderLayout.NORTH);
		this.add(pane, BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MenuGUI win = new MenuGUI();
		win.setVisible(true);
		win.setSize(400,600);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
				int receipt = 0;
				double price = 14.99;
				String command = e.getActionCommand();
				if(command.equals("Cancel Order"))
				{
					details.setText("Orders Cancelled");
				}
				else if(command.equals("Add Item"))
				{
					receipt++;
					String str = "Order Number " + receipt + "\n";
					List<String> values = listMain.getSelectedValuesList();
					String main = "";
					for(Object value: values)
					{
						main = main + value + "";
					}
					str = str + "Main Dish: " + (String) cbSize.getSelectedItem() + " " + main + "";
					
					List<String> values2 = listSide.getSelectedValuesList();
					String side = "";
					for(Object value: values2)
					{
						side = side + value + "";
					}
					str = str + "\nSide Dish: " + (String) cbSide.getSelectedItem() + " " + side + "";
					
					List<String> values3 = listDessert.getSelectedValuesList();
					String dessert = "";
					for(Object value: values3)
					{
						dessert = dessert + value + "";
					}
					str = str + "\nDessert: " + dessert + "";
					
					List<String> values4 = listDrink.getSelectedValuesList();
					String drink = "";
					for(Object value: values4)
					{
						drink = drink + value + "";
					}
					str = str + "\nDrink: " + (String) cbDrink.getSelectedItem() + " " + drink + "";
					
					str = str + "\nPrice of Meal: €" + price + "";
					details.append(str + "\n\n");
					
					OrderItem item = new OrderItem(receipt, main, side, dessert, drink, price);
				}	
				else
				{
					listDetails();
				}	
	}
	
	public void listDetails()
	{
		/*JDialog dl = new JDialog();
		dl.setLayout(new BorderLayout());
		dl.setTitle("View Order");*/
		String str = "";
		double price = 14.99;
		int orderNo = 1;
		/*JTextArea textarea = new JTextArea(5, 50);
		JScrollPane pane = new JScrollPane(textarea);*/
		details.setText("The Waiter has taken the Order!" + "\nChef is picking up the order from the waiter!"
				+ "\nThe chef has received your order, your order will take 5 minutes!" 
				+ "\n\n\nYour order has been prepared");
		
		/*for(OrderItem order1 :menu) {
			str = str + order.getReceiptNo();
			
			if(order.getReceiptNo() == 1)
			{
				textarea.setText("The Waiter has taken the Order!");
				textarea.append(order.toString() + "\n");
				System.out.println("\nOrder Details: " + order.toString());
			}
		}*/
		
		List<String> values = listMain.getSelectedValuesList();
		String main = "";
		for(Object value: values)
		{
			main = main + value + "";
		}
		str = str + "\nOrder Number: " + orderNo + "\nMain Dish: " + (String) cbSize.getSelectedItem() + " " + main + "";
		List<String> values2 = listSide.getSelectedValuesList();
		String side = "";
		for(Object value: values2)
		{
			side = side + value + "";
		}
		str = str + "\nSide Dish: " + (String) cbSide.getSelectedItem() + " " + side + "";
		
		List<String> values3 = listDessert.getSelectedValuesList();
		String dessert = "";
		for(Object value: values3)
		{
			dessert = dessert + value + "";
		}
		str = str + "\nDessert: " + dessert + "";
		
		List<String> values4 = listDrink.getSelectedValuesList();
		String drink = "";
		for(Object value: values4)
		{
			drink = drink + value + "";
		}
		str = str + "\nDrink: " + (String) cbDrink.getSelectedItem() + " " + drink + "";
		
		str = str + "\nPrice of Meal: €" + price + "";
		details.append(str + "\n");
		
		/*dl.add(pane);
		dl.setVisible(true);
		dl.setSize(500, 200);*/
	}
}
