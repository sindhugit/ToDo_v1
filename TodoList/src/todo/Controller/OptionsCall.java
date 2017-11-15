package todo.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
//import java.sql.Date;
import java.util.Properties;
import javax.swing.JOptionPane;


import todo.Model.AddList;
import todo.Model.AssignTask;
import todo.Model.DeleteList;
import todo.Model.EditList;
import todo.Model.Registration;


/** Calling Model methods**/
public class OptionsCall {
	
	  private String userlogname;
	  private String listNameString;
	
	  private Connection connect = null;
	  private Statement statement = null;
	  private PreparedStatement preparedStatement = null;
	  private ResultSet resultSet = null;
	
	  final private String user = "root"; 
	  final private String passwd = "root";

	  /** calling AddList method**/
	public void callAddList(String listName,String listItems) throws Exception{
		  int flag=0;
		  try {
		      // This will load the MySQL driver, each DB has its own driver
		      Class.forName("com.mysql.jdbc.Driver");
		      
		      Properties properties = new Properties();
		      properties.setProperty("user", user);
		      properties.setProperty("password", passwd);
		      properties.setProperty("useSSL", "false");
		      properties.setProperty("autoReconnect", "true");
		      
		      // Setup the connection with the DB
		      connect = DriverManager
		          .getConnection("jdbc:mysql://localhost:3306/todo_db", properties);
		      
		      
		      statement = connect.createStatement();
		      
		      LoginModel objLoginModel=new LoginModel();
		      userlogname= objLoginModel.getUsername();
		      
		      preparedStatement = connect
	                  .prepareStatement("select * from todo_db.list_table WHERE username=?");
		      preparedStatement.setString(1, userlogname);
		      resultSet=preparedStatement.executeQuery();
		      
		      while(resultSet.next())
		      {
		    	   listNameString = resultSet.getString("listname");
					  if(listNameString.equalsIgnoreCase(listName)) {
						    	flag=1;
						         break;
						     } 
		      }
		      /*if list name not existed*/
		      if(flag==0) {
		       AddList objAddList = new AddList();
		   
		       try {
						
			      objAddList.addListMethod(listName,listItems,userlogname);
					
		       } 
		       catch (Exception e) {
		         e.printStackTrace();
					
		       }
		    }
		    /*if list name already existed*/  
		   if(flag==1) {
        	 
    	    int choice=JOptionPane.showConfirmDialog(null,"ListName Already existed, Do you want to continue with edit list option??",null, JOptionPane.YES_NO_OPTION);
    	    if(choice == JOptionPane.YES_OPTION) {
    		  
    		 
    		    callEditAdd(userlogname, listNameString, listItems);
    		 
    	    }
    	    else if(choice == JOptionPane.NO_OPTION) {
    		  JOptionPane.showMessageDialog(null, "List not created!!");  
    	    }
         }
    	  
      
      }
       catch(Exception e) {
          throw e;
       }//catch close 
      finally {
	
         close();
      }
	}
	
	
	/**calling assign task method after checking assigning user existed or not**/
	public void callAssignTask(String toUser,String listName,String listItems) throws Exception{
		 
		  try {
		      // This will load the MySQL driver, each DB has its own driver
		      Class.forName("com.mysql.jdbc.Driver");
		      
		      Properties properties = new Properties();
		      properties.setProperty("user", user);
		      properties.setProperty("password", passwd);
		      properties.setProperty("useSSL", "false");
		      properties.setProperty("autoReconnect", "true");
		      
		      // Setup the connection with the DB
		      connect = DriverManager
		          .getConnection("jdbc:mysql://localhost:3306/todo_db", properties);
		      
		     
		      statement = connect.createStatement();
		      
		      LoginModel objLoginModel=new LoginModel();
		      String fromUser= objLoginModel.getUsername();
		      
		      resultSet = statement.executeQuery("select * from todo_db.todo_user_details");
		      
		      int isValidAssign = 0;
		      
		      while (resultSet.next()) {
		            String toUserString = resultSet.getString("email");
		            //System.out.println("ToUser:"+ toUserString);
		            if(toUserString.equals(toUser)) {
		            	//System.out.println("User found");
		            	isValidAssign=1;
		            }
		       }
		      
		      
		      if(isValidAssign==1) {
		         AssignTask objAssignTask = new AssignTask();
		   
		        try {
						
			       objAssignTask.assignTaskMethod(fromUser,toUser,listName,listItems);
					
		        } 
		        catch (Exception e) {
		           e.printStackTrace();
					
		        }
              }
		      
		      if(isValidAssign==0) {
		    	  
		    	  JOptionPane.showMessageDialog(null, "Assign task failed!! Selected user not existed in ToDo system");
		      }
		      
		 }
		  catch(Exception e) {
	            throw e;
	       }//catch close 
	      finally {
	    	
	        close();
	      }
	
	}
	
	/** calling Registration method**/
	public void callRegistration(String userName,String password,String profileName,String question,String answer ) throws Exception {
		boolean flag=true;
		
		try {
			  Class.forName("com.mysql.jdbc.Driver");
			  
			  Properties properties = new Properties();
		      properties.setProperty("user", user);
		      properties.setProperty("password", passwd);
		      properties.setProperty("useSSL", "false");
		      properties.setProperty("autoReconnect", "true");
		      
		      connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/todo_db", properties);
			      
			      
			      statement = connect.createStatement();
		      
			    resultSet = statement.executeQuery("select * from todo_db.todo_user_details");
			    
			/* checking user name already existed in system(achieving unique user name)*/
			 while (resultSet.next()) {
		         String usernameString = resultSet.getString("email");
				 //System.out.println("UserName:"+ usernameString);
					    if(usernameString.equals(userName)) {
					    	flag=false;
					         break;
					     }
		      }
			 
			/* when unique user name entered save the details into database */
		    if(flag) {	
		       
		
		          Registration objRegistration = new Registration();
		   
		         try {
						
			         objRegistration.createRegistration(userName,password,profileName,question,answer);
					
		         } 
		         catch (Exception e) {
		             e.printStackTrace();
			     }
		    }
		    else {
	    	   JOptionPane.showMessageDialog(null, "Username already exists. Please choose a different one.");
	        }
	    
         }
	      catch(Exception e) {
		    throw e;
	       }
	      finally {
		    close();
	      }
		
	}
	
	
	/** calling editing method**/
	 public void callEditAdd(String userlogname,String listNameString,String listItems) {
		 
		EditList objEditList= new EditList();
		
		 try {
			 
		  objEditList.EditByAdd(userlogname,listNameString,listItems);
		 }
		 catch (Exception e) {
		  e.printStackTrace();
		 }
	 }
	
	 
	 /** calling deletion method**/
	public void callDelete(String selectedListName,String SelectedListItem) {
		
		LoginModel objLoginModel=new LoginModel();
		userlogname= objLoginModel.getUsername();
		
		DeleteList objDeleteList=new DeleteList();
		try {
			 
			  objDeleteList.EditByDelete(userlogname,selectedListName,SelectedListItem);
			 }
			 catch (Exception e) {
			  e.printStackTrace();
			 }
		 }
		
	
	  /* closing all connections*/  
		 private void close() {
			    try {
			    	
			      if (resultSet != null) {
			        resultSet.close();
			        }
			      
		         if (statement != null) {
			        statement.close();
			      }

			      if (connect != null) {
			        connect.close();
			      }
			    } 
			     catch (Exception e) {

			      }
		   } 
	

}
