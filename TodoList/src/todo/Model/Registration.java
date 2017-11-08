package todo.Model;
import todo.View.LoginPage;

import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Date;
import java.sql.Statement;
import java.util.Properties;
import javax.swing.JOptionPane;
import java.sql.Connection;

import javax.swing.JOptionPane;

public class Registration {
	
	private PreparedStatement preparedStatement=null;
	private Statement statement = null;
	private Connection connect=null;
	private ResultSet resultSet = null;
	final private String user = "root"; 
	 final private String passwd = "root";
	
	public void createRegistration(String userName,String password,String profileName,String question,String answer)throws Exception {
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
			      
			      System.out.println("Connection Successful");
			      statement = connect.createStatement();
		      
			    resultSet = statement.executeQuery("select * from todo_db.todo_user_details");
			    
			/* checking user name already existed in system(achieving unique user name)*/
			 while (resultSet.next()) {
		         String usernameString = resultSet.getString("email");
				 System.out.println("UserName:"+ usernameString);
					    if(usernameString.equals(userName)) {
					    	flag=false;
					         break;
					     }
		      }
			/* when unique user name entered save the details into database */
		    if(flag) {	
		       
		      preparedStatement = connect
	             .prepareStatement("insert into  todo_db.todo_user_details values (?, ?, ?,?,?)");
	          preparedStatement.setString(1, userName);
	          preparedStatement.setString(2, password);
	          preparedStatement.setString(3, profileName);
	          preparedStatement.setString(4, question);
	          preparedStatement.setString(5, answer);
	          preparedStatement.executeUpdate();
	          JOptionPane.showMessageDialog(null, "User Data inserted successfully.Please Log in to create your list");
	          LoginPage.main(null);
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

	// You need to close the resultSet
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