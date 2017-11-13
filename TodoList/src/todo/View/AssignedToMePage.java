package todo.View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.swing.SwingConstants;

import todo.Controller.LoginModel;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class AssignedToMePage {
	
	  private String userlogname;
	  private String userNameString;
	  private String itemNameString;
	  private String listNameString;
	  
	  

	  private Connection connect = null;
	  private Statement statement = null;
	  private PreparedStatement preparedStatement = null;
	  private ResultSet resultSet = null;
	  
	  final private String user = "root"; 
	  final private String passwd = "root";

	  private JFrame frame;
	  private JList userList;
	  private JList listNames;
	  private JList listItems;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AssignedToMePage window = new AssignedToMePage();
					window.frame.setVisible(true);
					window.frame.setExtendedState(window.frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AssignedToMePage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(143, 188, 143));
		frame.setBounds(100, 100, 693, 463);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("**  Welcome to ToDo List  **");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(128, 0, 0));
		label.setFont(new Font("Sitka Subheading", Font.BOLD, 20));
		label.setBounds(213, 22, 278, 27);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("< Assigned To Me >");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(new Color(25, 25, 112));
		label_1.setFont(new Font("Sitka Subheading", Font.BOLD, 18));
		label_1.setBounds(243, 60, 214, 23);
		frame.getContentPane().add(label_1);
		
		JLabel lblFromUser = new JLabel("FROM USER");
		lblFromUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblFromUser.setForeground(new Color(0, 0, 128));
		lblFromUser.setFont(new Font("Sitka Subheading", Font.PLAIN, 18));
		lblFromUser.setBounds(72, 99, 120, 23);
		frame.getContentPane().add(lblFromUser);
		
		JLabel lblListNames = new JLabel("LIST NAMES");
		lblListNames.setHorizontalAlignment(SwingConstants.CENTER);
		lblListNames.setForeground(new Color(0, 0, 128));
		lblListNames.setFont(new Font("Sitka Subheading", Font.PLAIN, 18));
		lblListNames.setBounds(285, 99, 120, 23);
		frame.getContentPane().add(lblListNames);
		
		JLabel lblListItems = new JLabel("LIST ITEMS");
		lblListItems.setHorizontalAlignment(SwingConstants.CENTER);
		lblListItems.setForeground(new Color(0, 0, 128));
		lblListItems.setFont(new Font("Sitka Subheading", Font.PLAIN, 18));
		lblListItems.setBounds(489, 99, 120, 23);
		frame.getContentPane().add(lblListItems);
		
	    userList = new JList();
	    userList.setFont(new Font("Tahoma", Font.BOLD, 12));
	    userList.setForeground(new Color(0, 0, 128));
		userList.setBackground(new Color(224, 255, 255));
		userList.setBounds(63, 133, 140, 171);
		frame.getContentPane().add(userList);
		
	    listNames = new JList();
	    listNames.setForeground(new Color(0, 128, 128));
	    listNames.setFont(new Font("Tahoma", Font.PLAIN, 12));
		listNames.setBackground(new Color(224, 255, 255));
		listNames.setBounds(278, 133, 140, 171);
		frame.getContentPane().add(listNames);
		
		listItems = new JList();
		listItems.setForeground(new Color(0, 128, 128));
		listItems.setFont(new Font("Tahoma", Font.PLAIN, 12));
		listItems.setBackground(new Color(224, 255, 255));
		listItems.setBounds(487, 133, 140, 171);
		frame.getContentPane().add(listItems);
		
		JButton loadUsersBtn = new JButton("LOAD USERS");
		loadUsersBtn.setBackground(new Color(0, 128, 128));
		loadUsersBtn.setFont(new Font("Sitka Subheading", Font.BOLD, 16));
		loadUsersBtn.setForeground(new Color(0, 0, 128));
		loadUsersBtn.setBounds(63, 315, 140, 23);
		frame.getContentPane().add(loadUsersBtn);
		loadUsersBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					getUsersMethod();
				}catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		
		
		
		JButton showTasksBtn = new JButton("SHOW TASKS");
		showTasksBtn.setForeground(new Color(0, 0, 128));
		showTasksBtn.setFont(new Font("Sitka Subheading", Font.BOLD, 16));
		showTasksBtn.setBackground(new Color(0, 128, 128));
		showTasksBtn.setBounds(386, 315, 151, 23);
		frame.getContentPane().add(showTasksBtn);
		showTasksBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					getTasksMethod();
				}catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		
		JButton mainMenuBtn = new JButton("<-Main Menu");
		mainMenuBtn.setForeground(new Color(0, 0, 128));
		mainMenuBtn.setBackground(new Color(0, 128, 128));
		mainMenuBtn.setFont(new Font("Sitka Subheading", Font.BOLD, 16));
		mainMenuBtn.setBounds(139, 373, 140, 23);
		frame.getContentPane().add(mainMenuBtn);
		mainMenuBtn.addActionListener(e->OptionsPage.main(null));
		
		JButton logoutBtn = new JButton("Logout");
		logoutBtn.setForeground(new Color(0, 0, 128));
		logoutBtn.setFont(new Font("Sitka Subheading", Font.BOLD, 16));
		logoutBtn.setBackground(new Color(0, 128, 128));
		logoutBtn.setBounds(448, 374, 89, 23);
		frame.getContentPane().add(logoutBtn);
		logoutBtn.addActionListener(e->System.exit(0));
	}
	
	
	/* getting user names who assigned tasks to current user when Load Users button pressed*/
	private void getUsersMethod()throws Exception{
		
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
	                  .prepareStatement("select fromuser from todo_db.assign_task WHERE touser=?");
	 	      preparedStatement.setString(1, userlogname);
	 	      resultSet=preparedStatement.executeQuery();
	 	      
	 	     // checking any user assigned tasks to current user or not
	 	     if(!resultSet.isBeforeFirst()) {
            	 JOptionPane.showMessageDialog(null, "No other users assigned task for you...");
             }
	 	      
	 	     //if other users assigned tasks then view those tasks
	 	       DefaultListModel dlmobj1=new DefaultListModel();
	 	      
	              while(resultSet.next()) {
	    	      userNameString = resultSet.getString("fromuser");
	    	      dlmobj1.addElement(userNameString);
	    	      System.out.println("dlmobj1    "+dlmobj1);
	    	      
	              }
	      
	             userList.setModel(dlmobj1);
	         
	  }
	  catch(Exception e) {
         throw e;
      }//catch close 
      finally {
 	
       close();
      }
	}
	
	/* getting list names and list items when one user name selected*/
	private void getTasksMethod()throws Exception{
		
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
	                  .prepareStatement("select * from todo_db.assign_task WHERE fromuser=?");
	  	      preparedStatement.setString(1,(String) userList.getSelectedValue());
	  	      System.out.println(userList.getSelectedValue());
	  	      resultSet=preparedStatement.executeQuery();
	  	      
	  	      DefaultListModel dlmobj2=new DefaultListModel();
	  	      DefaultListModel dlmobj3=new DefaultListModel();
	  	      
	  	      while(resultSet.next()) {
	    	      listNameString = resultSet.getString("taskname");
	    	      itemNameString = resultSet.getString("taskdetails");
	    	      dlmobj2.addElement(listNameString);
	    	      dlmobj3.addElement(itemNameString);
	    	      System.out.println("dlmobj2    "+dlmobj2);
	    	      System.out.println("dlmobj3    "+dlmobj3);
	           }
	    	   listNames.setModel(dlmobj2);
	    	   listItems.setModel(dlmobj3);
	    	  
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
			     } catch (Exception e) {

			       }
			}
			
	
}
