import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class List {
static ArrayList<Item> items;
static String name;
	public List() {
		
	}
	
	public static void main(String[] args)
	{
		boolean check = true;
		items = new ArrayList<Item>();
		readFile();
		System.out.println("Welcome to the To Do List!");
		Scanner sc = new Scanner(System.in);
		while(check)
			{
			try{System.out.println("choose an option:");
		System.out.println("1.  add an item. \n"
				+ "2. remove an Item. \n"
				+ "3.  List all items \n"
				+ "4.  exit");
		int choice = sc.nextInt();
		switch(choice)
		{
		case 1: 
			System.out.println("ADDING ITEM TO LIST");
			sc.nextLine();
			System.out.println("Item Name: ");
			name = sc.nextLine();
			System.out.println("Item Description: ");
			String desc = sc.nextLine();
			Item newItem = new Item(name, desc);
			items.add(newItem);
			System.out.println(items.size());
			break;
		case 2: 
			System.out.println("REMOVING ITEM TO LIST");
			sc.nextLine();
			System.out.println("Item Name: ");
			name = sc.nextLine();
			
			removeItem(getItem(name));
			System.out.println(items.size());
			break;
		case 3: 
			System.out.println("LISTING ALL ITEMS");
			showAllItems();
			break;
		case 4: 
			System.out.println("EXITING THE LIST");
			check = false;
			saveFile();
			break;
		default: 
			System.out.println("Enter NUMBER 1 -4");
			break;
		}
			}
	catch(InputMismatchException e) {
		System.out.println("Invalid input type");
		sc.nextLine();
		}}
	}
	
	/**
	 * To remove items from list
	 * **/
	public static void removeItem(Item aItem)
	{
		items.remove(aItem);
	}
	
	/**
	 * To add items to list
	 * **/
	public void addItem(Item aItem)
	{
		items.add(aItem);
	}
	
	/**
	 * To get an item from list
	 * **/
	 public static Item getItem(String name)
	 {
		 for(Item aItem : items)
		 {
			 if(aItem.getName().equals(name))
			 {
				return aItem;
			 }
		 }
		 
		 return null;
	 }
	 
	 /**
		 * To get all items from list
		 * **/
	public static void showAllItems()
	{
		for(Item aItem: items)
		{
			System.out.println(aItem.getName() + "   :    " + aItem.getDescr());
		}
	}
	
	/**
	 * To read items from file
	 * **/
	public static void readFile()
	{
		try {
		FileInputStream fileIn = new FileInputStream("list.ser");
		ObjectInputStream in = new ObjectInputStream(fileIn);
		items = (ArrayList) in.readObject();
		in.close();
		fileIn.close();
		}catch(IOException | ClassNotFoundException i) {
			i.printStackTrace();
		}
	}
	
	/**
	 * To Save items to file
	 * @throws IOException 
	 */
	public static void saveFile()
	{
		try{
		FileOutputStream fileOut = new FileOutputStream("list.ser");
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(items);
		out.close();
		fileOut.close();
		}catch(IOException i) {
			i.printStackTrace();
		}
	}
}
