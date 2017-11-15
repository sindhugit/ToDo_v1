package todo.Controller;
import todo.View.OptionsPage;
import todo.View.RegistrationPage;
import todo.View.ResetPage;

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


public class LoginModel {
	  private Connection connect = null;
	  private Statement statement = null;
	  private PreparedStatement preparedStatement = null;
	  private ResultSet resultSet = null;
	  private static String userlogname;
	 

//	  final private String host = "localhost:3306/";
	  final private String user = "root"; 
	  final private String passwd = "root";
	  
	 
		 
		   /**login method**/ 
	/** Checking Valid user or not, if user valid logged in to the System **/  
   public void loginMethod(String userName, String password) throws Exception {
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
		      
		    
		      
	      resultSet = statement.executeQuery("select * from todo_db.todo_user_details");
	      
	      int isValidLogin = 0;
	      
	      while (resultSet.next()) {
	            String usernameString = resultSet.getString("email");
	            //System.out.println("UserName:"+ usernameString);
	            if(usernameString.equals(userName)) {
	            	//System.out.println("User found");
	            	String passwordString = resultSet.getString("password");
	            	//System.out.println("Password:"+ passwordString);
	            	//System.out.println("Password:"+ password);
	            	if(passwordString.equals(password)) {
	            		isValidLogin = 1;
	            	}
	            	else {
	            		isValidLogin = 2;
	            	}
	            	break;
	            	
	            }
	       }
	      
	        if(isValidLogin == 0){
	    	  JOptionPane.showMessageDialog(null,"User doesnt exist!!! Continue to registration");
	    	  	
	    	  RegistrationPage.main(null);
	    	  
	    	 }
	         else  if(isValidLogin == 1) {
			      JOptionPane.showMessageDialog(null, "Logged in successfully.");
			      userlogname=userName;
			      OptionsPage.main(null);
		      }
		         else if(isValidLogin == 2){
		    	      JOptionPane.showMessageDialog(null, "Password is wrong. Please check and re-enter or Use forgot password to recover.");
		    	     // ResetPage.main(null);
		         }
	     }
	        catch(Exception e) {
	            throw e;
	       }//catch close 
	    finally {
	    	
	        close();
	    }
	}
   
   public String getUsername() {
	   return userlogname;
   }
   
   /*closing database connections*/
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
	 