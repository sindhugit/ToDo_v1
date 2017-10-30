package todo.View;
import todo.Model.CreateBase;
import todo.Controller.AddItems;
import java.util.Scanner;



public class MainClass {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 *@flag is checking for list creation and adding items
		 *@status is checking the session/program finished or not
		 */
		boolean flag=false;
		boolean status=false;
		
		AddItems item=new AddItems();
		
		
		System.out.println("Welcome to TODO");
        System.out.println("Your CommandWords to access the Application are:");
        System.out.println("CREATELIST-To create new list name");
        System.out.println("ADDITEMS - To add items into list");
        System.out.println("DONE-Choose when you list items added");
        System.out.println("SHOWLIST- To see List names ");
        System.out.println("SHOW- To see all List names and subitems");
        System.out.println("END-To end the session");
        while(!status)
        {
        	System.out.println("Enter your command word:");
            Scanner in=new Scanner(System.in);
            String word=in.nextLine();
            switch(word)
            {
               case "CREATELIST": item.createNewList();
                                  break;
               case "ADDITEMS": item.createSubList();
                                  break;
               case "DONE": item.addToMap();
            	            flag=true;
                             
                            break;
               case "SHOWLIST": if(flag) {
            	                item.showLists();
            	                }
                                else {
                                System.out.println("List is empty");
                                }
                                break;
               case "SHOW": if(flag) {
            	             item.showListItems();
                             }
                            else {
                             System.out.println("List is empty");
                            }
                            break;
               case "END": status=true;
                           flag=true;
                           break;
               default: System.out.println("Select a valid command");             
            }
        }
	}

}
