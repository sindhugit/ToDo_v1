package todo.Controller;
import todo.Model.CreateBase;
import java.util.Scanner;

public class AddItems {
	
	private String listName;
	private String itemName;
	private int number;
	private CreateBase create=new CreateBase();
	private int index=-1;
	
	
	/** 
	 Creating list names and adding them to temparray of CreateBase 
	 */
	public void createNewList()
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter list name to create new list of items:");
		listName=in.nextLine();
		//System.out.println(listName);
		create.addListName(listName);
		index++;
	}
	
	/**
	 Adding items to the list
	 */
	public void createSubList()
	{
		// Checking whether listname created or not
		if(index==-1)
		{
			System.out.println("First create Listname to store items by selecting CREATELIST command");
		}
		else {
		int i=0;
		Scanner in=new Scanner(System.in);
		System.out.println("How many items you want to add??? Enter number:");
		number=in.nextInt();
		while(i<number)
		{
			Scanner word=new Scanner(System.in);
			System.out.println("enter list items:");
		  itemName=word.nextLine();
		  create.addSubItems(itemName);
		  i++;
		}
		}
		
	}
	
	/**
	 When adding items done then add them to HashMap
	 */
	public void addToMap()
	{
		if(index >= 0) {
		create.storeList(index);
		}
		else
		{
			System.out.println("First create list");
		}
	}
	
	/**
	 SHOW METHODS TESTING
	 */
	public void showLists() {
	      System.out.println("LISTNAMES ARE:");
	      create.showListNames();

    }

   /**
    * Showing all list names with sub items
    */
   public void showListItems() {
   System.out.println("All LISTNAMES and LISTSUBITEMS Are:");
   create.showAll();
   }

}
