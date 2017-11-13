package todo.Controller;

import todo.Model.AddList;
import todo.Model.AssignTask;
import todo.Model.DeleteList;
import todo.Model.EditList;
import todo.Model.Registration;


/** Calling Model methods**/
public class OptionsCall {
	
	public void callAddList(String listName,String listItems) {
		AddList objAddList = new AddList();
		   
		 try {
						
			 objAddList.addListMethod(listName,listItems);
					
		} 
		catch (Exception e) {
		e.printStackTrace();
					
		}
	}
	
	public void callAssignTask(String toUser,String listName,String listItems) {
		AssignTask objAssignTask = new AssignTask();
		   
		 try {
						
			 objAssignTask.assignTaskMethod(toUser,listName,listItems);
					
		} 
		catch (Exception e) {
		e.printStackTrace();
					
		}
	}
	
	
	public void callRegistration(String userName,String password,String profileName,String question,String answer ) {
		
		Registration objRegistration = new Registration();
		   
		 try {
						
			 objRegistration.createRegistration(userName,password,profileName,question,answer);
					
		} 
		catch (Exception e) {
		e.printStackTrace();
					
		}
	}
	
	 public void callEditAdd(String userlogname,String listNameString,String listItems) {
		 
		EditList objEditList= new EditList();
		System.out.println("Options call edit add called");
		 try {
			 
		  objEditList.EditByAdd(userlogname,listNameString,listItems);
		 }
		 catch (Exception e) {
		  e.printStackTrace();
		 }
	 }
	
	public void callDelete(String selectedListName,String SelectedListItem) {
		
		DeleteList objDeleteList=new DeleteList();
		try {
			 
			  objDeleteList.EditByDelete(selectedListName,SelectedListItem);
			 }
			 catch (Exception e) {
			  e.printStackTrace();
			 }
		 }
		
	
	
	

}
