package todo.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.swing.JOptionPane;

import todo.Controller.LoginModel;
import todo.Controller.OptionsCall;

public class AssignTask {
	
	private Connection connect = null;
	  private Statement statement = null;
	  private PreparedStatement preparedStatement = null;
	  private ResultSet resultSet = null;
	  private String fromUser;
	  private String listNameString;
	  private int flag;
	 

//	  final private String host = "localhost:3306/";
	  final private String user = "root"; 
	  final private String passwd = "root";
	  
	  /** creating new list**/
	  public void assignTaskMethod(String fromUser,String toUser,String listName,String listItems) throws Exception{
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
		      
		      
		      statement = connect.createStatement();
		      
		      
		    	  
		      preparedStatement = connect
	                  .prepareStatement("insert into todo_db.assign_task values(?,?,?,?)");
		      preparedStatement.setString(1, fromUser);
		      preparedStatement.setString(2, listName);
		      preparedStatement.setString(3, listItems);
		      preparedStatement.setString(4, toUser);
		      preparedStatement.executeUpdate();
		      JOptionPane.showMessageDialog(null, "Task Assigned sucessfully....");
		      
		      
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
