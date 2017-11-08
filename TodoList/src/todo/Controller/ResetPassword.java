package todo.Controller;
import todo.View.LoginPage;

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



  public class ResetPassword {
	  
	  private String returnString=null;
	  
	  private Connection connect = null;
	  private Statement statement = null;
	  private PreparedStatement preparedStatement = null;
	  private ResultSet resultSet = null;
	 

//	  final private String host = "localhost:3306/";
	  final private String user = "root"; 
	  final private String passwd = "root";
	
 public String checkValidUser(String userName) throws Exception {
		  
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
	      //connection();
	      resultSet = statement.executeQuery("select * from todo_db.todo_user_details");
	      
	        int isChangePassword = 0;
	        while (resultSet.next()) {
	            String usernameString = resultSet.getString("email");
	            if(usernameString.equals(userName)) {
	            		isChangePassword = 1;
	            		break;
	             }
	         }
	        if(isChangePassword==1) {
	        	preparedStatement= connect
		                  .prepareStatement("select question from todo_db.todo_user_details where email=?");
	        	  preparedStatement.setString(1, userName);
		 	      resultSet=preparedStatement.executeQuery();
		 	      while(resultSet.next()) {
	        	 returnString=resultSet.getString("question");
		 	      }
	        	 System.out.println(returnString);
	        }
	        else {
	    	  	  JOptionPane.showMessageDialog(null, "UserName not available. Please use Registration page to register.");
	        }
	        
		  }catch(Exception e) {
	            throw e;
	       }//catch close 
	    finally {
	    	
	       close();
	    }
		  return returnString;
 }
	
	  public void changePassword(String userName,String newPassword,String answerField) throws Exception {
		  
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
		      
	      //checking entered security question answer is correct or not
		      preparedStatement = connect
			          .prepareStatement("select answer from todo_db.todo_user_details where email=?");
		      preparedStatement.setString(1, userName);
		      resultSet=preparedStatement.executeQuery();
		      
		        int isAnswer = 0;
		        while (resultSet.next()) {
		            String answerString = resultSet.getString("answer");
		            if(answerString.equals(answerField)) {
		            		isAnswer = 1;
		            		break;
		             }
		         }
	          if(isAnswer==1) {
	    	  preparedStatement = connect
			          .prepareStatement("UPDATE todo_db.todo_user_details SET password=? WHERE email=?");
			      preparedStatement.setString(1, newPassword);
			      preparedStatement.setString(2, userName);
			      preparedStatement.executeUpdate();
		      JOptionPane.showMessageDialog(null, "User Password updated successfully.");
		      LoginPage.main(null);
	          }
	          else {
	        	  JOptionPane.showMessageDialog(null, "Security question Answer is wrong!!!");  
	          }
	          
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



