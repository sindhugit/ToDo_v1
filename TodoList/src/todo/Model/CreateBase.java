package todo.Model;

import java.util.ArrayList;
import java.util.HashMap;


public class CreateBase{
	
	/** create HashMap for storing list type as key and list items as ArrayList 	
	 */
	private ArrayList<String> listarray;
	private ArrayList<String> temparray;
	private HashMap<String,ArrayList<String>> listMap;
	
	public CreateBase() {
		listMap = new HashMap<>();
		//listarray = new ArrayList<>();
		temparray=new ArrayList<>();
		}
	
	/** adding sub items like(milk,butter) to key like(grocery)
	 */
	public void addSubItems(String item){
		
		listarray.add(item);
		//System.out.println("Addeditem");
	}
	
	/**
	 adding items to HashMap which takes name as key and list array like(grocery) as value
	 */
	public void addListName(String name){
	    temparray.add(name);
	    listarray = new ArrayList<>();
	    //System.out.println("list created");
		
	}
	
	/**
	  storing elements in to HashMap key(grocery) and values as grocery list
	 */
	public void storeList(int i){
		listMap.put(temparray.get(i),listarray);
		//System.out.println("Stored in to map");
		
	}
	
	/**
	 * Show only list names without sub items
	 */
	public void showListNames(){
		for(int i=0;i<temparray.size();i++) {
			System.out.println(temparray.get(i));
		}
		
	}
		
	/**
	 * Show all list names with sub items
	 */
	public void showAll()
	{
		for (HashMap.Entry<String, ArrayList<String>> entry : listMap.entrySet()) {
			 System.out.println( entry.getKey());     
			 System.out.println( entry.getValue());//Returns the list of values
	      }
	 }
	
}
	