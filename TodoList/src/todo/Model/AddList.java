package todo.Model;
import todo.Controller.LoginModel;
import todo.Controller.OptionsCall;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Date;
import java.sql.Statement;
import java.util.Properties;
import javax.swing.JOptionPane;
import java.sql.Connection;
import javax.swing.JFrame;


public class AddList {
	
	  private Connection connect = null;
	  private Statement statement = null;
	  private PreparedStatement preparedStatement = null;
	  private ResultSet resultSet = null;
	  private String userlogname;
	  private String listNameString;
	  private int flag;
	 

//	  final private String host = "localhost:3306/";
	  final private String user = "root"; 
	  final private String passwd = "root";
	  
	  /** creating new list**/
	  public void addListMethod(String listName,String listItems) throws Exception{
		  flag=0;
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
		      
		      System.out.println("Connection Successful");
		      statement = connect.createStatement();
		      
		      LoginModel objLoginModel=new LoginModel();
		      userlogname= objLoginModel.getUsername();
		      
		      preparedStatement = connect
	                  .prepareStatement("select * from todo_db.list_table WHERE username=?");
		      preparedStatement.setString(1, userlogname);
		      resultSet=preparedStatement.executeQuery();
		      
		      System.out.println("resultset "+resultSet);
		      
		      System.out.println("Username "+userlogname);
		      System.out.println("ListName "+listName);
		      System.out.println("list itemes "+listItems);
		      
		      
		      while(resultSet.next())
		      {
		    	   listNameString = resultSet.getString("listname");
					 System.out.println("listName:"+ listNameString);
						    if(listNameString.equalsIgnoreCase(listName)) {
						    	flag=1;
						         break;
						     } 
		      }
		      /*Adding new list name*/
		            if(flag==0) {
		            	preparedStatement = connect
		                  .prepareStatement("insert into  todo_db.list_table values (?, ?, ?)");
			          preparedStatement.setString(1, userlogname);
			          preparedStatement.setString(2, listName);
			          preparedStatement.setString(3, listItems);
			          preparedStatement.executeUpdate();
			          JOptionPane.showMessageDialog(null, "Data inserted sucessfully....");
		            }
		            /*Adding items to existed list name*/   
		         if(flag==1) {
		        	 System.out.println("existed listName:"+ listNameString);
		    	  int choice=JOptionPane.showConfirmDialog(null,"ListName Already existed, Do you want to continue with edit list option??",null, JOptionPane.YES_NO_OPTION);
		    	  if(choice == JOptionPane.YES_OPTION) {
		    		  
		    		  OptionsCall objOptionsCall=new OptionsCall();
		    		  objOptionsCall.callEditAdd(userlogname, listName, listItems);
		    		 
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
	  
	  /* closing all connections*/  
	 private void close() {
		    try {
		    	
		      if (resultSet != null) {
		        resultSet.close();
		        }
		      
	         if (statement != null) {
		        //statement.close();
		      }

		      if (connect != null) {
		        connect.close();
		      }
		    } 
		     catch (Exception e) {

		      }
	   } 

}
