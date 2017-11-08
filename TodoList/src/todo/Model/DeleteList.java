package todo.Model;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Date;
import java.sql.Statement;
import java.util.Properties;
import javax.swing.JOptionPane;

import todo.Controller.LoginModel;

import java.sql.Connection;
import javax.swing.JFrame;

public class DeleteList {
	
	  private String userlogname;
	  private Connection connect = null;
	  private Statement statement = null;
	  private PreparedStatement preparedStatement = null;
	  private ResultSet resultSet = null;
	  
	  final private String user = "root"; 
	  final private String passwd = "root";
	  
	  public void EditByDelete(String selectedListName,String selectedListItem)throws Exception{
		  
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
			      
			      LoginModel objLoginModel=new LoginModel();
			      userlogname= objLoginModel.getUsername();
			      
			      statement = connect.createStatement(); 
			      preparedStatement = connect
			                          .prepareStatement("delete from todo_db.list_table where username=? AND listname=? AND items=?");
			      preparedStatement.setString(1, userlogname);
			      preparedStatement.setString(2, selectedListName);
	              preparedStatement.setString(3, selectedListItem);
	              preparedStatement.executeUpdate();
	              JOptionPane.showMessageDialog(null, "Data deleted sucessfully....");
		   }
		    catch(Exception e) {
	          throw e;
	         }//catch close 
	        finally {
	  	
	          close();
	        }
		}
		
		
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
