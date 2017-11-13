package todo.Model;

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


public class EditList {
	
	  private String listNameString;
	 
	
	  private Connection connect = null;
	  private Statement statement = null;
	  private PreparedStatement preparedStatement = null;
	  private ResultSet resultSet = null;
	  
	  final private String user = "root"; 
	  final private String passwd = "root";
	  
	 /* Adding elements to existed list name */ 
	public void EditByAdd(String userlogname,String listName,String listItems)throws Exception{
	
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
		      System.out.println("EditByAdd called");
		      System.out.println("Connection Successful");
		      
		      statement = connect.createStatement(); 
		      preparedStatement = connect
		                          .prepareStatement("insert into  todo_db.list_table values (?, ?, ?)");
		      preparedStatement.setString(1, userlogname);
		      preparedStatement.setString(2, listName);
              preparedStatement.setString(3, listItems);
              preparedStatement.executeUpdate();
              JOptionPane.showMessageDialog(null, "Data inserted sucessfully....");
	   }
	    catch(Exception e) {
          throw e;
         }//catch close 
        finally {
  	
          close();
        }
	
	
	}
	
	/* close all database connections*/
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
