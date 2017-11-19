package todo.View;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
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


public class ShowListNamesPage {
	
	  private String userlogname;
	  private String itemNameString;
	  private String listNameString;
	  
		
	  private Connection connect = null;
	  private Statement statement = null;
	  private PreparedStatement preparedStatement = null;
	  private ResultSet resultSet = null;
	  
	  final private String user = "root"; 
	  final private String passwd = "root";
	
      private JFrame frame;
      private JList listname;
      private JList itemlist;
      

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowListNamesPage window = new ShowListNamesPage();
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
	public ShowListNamesPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(143, 188, 143));
		frame.getContentPane().setForeground(new Color(0, 128, 128));
		frame.setForeground(new Color(0, 128, 128));
		frame.setBounds(100, 100, 637, 443);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		listname = new JList();
		listname.setFont(new Font("Tahoma", Font.BOLD, 14));
		listname.setForeground(new Color(0, 128, 128));
		listname.setBackground(new Color(224, 255, 255));
		listname.setBounds(20, 104, 166, 221);
		frame.getContentPane().add(listname);
		
		JButton showListNameButton = new JButton("Show ListNames");
		showListNameButton.setBackground(new Color(0, 128, 128));
		showListNameButton.setForeground(new Color(0, 0, 128));
		showListNameButton.setFont(new Font("Sitka Subheading", Font.BOLD, 16));
		showListNameButton.setBounds(20, 329, 166, 23);
		frame.getContentPane().add(showListNameButton);
		showListNameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					ShowListNamesPageMethod();
				}catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		
		JLabel lblShowList = new JLabel("< Show List >");
		lblShowList.setForeground(new Color(25, 25, 112));
		lblShowList.setHorizontalAlignment(SwingConstants.CENTER);
		lblShowList.setFont(new Font("Sitka Subheading", Font.BOLD, 20));
		lblShowList.setBounds(183, 51, 194, 23);
		frame.getContentPane().add(lblShowList);
		
		JLabel lblListnames = new JLabel("ListNames");
		lblListnames.setHorizontalAlignment(SwingConstants.CENTER);
		lblListnames.setFont(new Font("Sitka Subheading", Font.PLAIN, 18));
		lblListnames.setForeground(new Color(0, 0, 128));
		lblListnames.setBounds(37, 73, 120, 23);
		frame.getContentPane().add(lblListnames);
		
		JLabel lblListitems = new JLabel("ListItems");
		lblListitems.setHorizontalAlignment(SwingConstants.CENTER);
		lblListitems.setForeground(new Color(0, 0, 128));
		lblListitems.setFont(new Font("Sitka Subheading", Font.PLAIN, 18));
		lblListitems.setBounds(392, 75, 114, 18);
		frame.getContentPane().add(lblListitems);
		
		JButton showListItemButton = new JButton("Show List Items");
		showListItemButton.setBackground(new Color(0, 128, 128));
		showListItemButton.setForeground(new Color(0, 0, 128));
		showListItemButton.setFont(new Font("Sitka Subheading", Font.BOLD, 16));
		showListItemButton.setBounds(353, 329, 217, 22);
		frame.getContentPane().add(showListItemButton);
		showListItemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					ShowListItemsPageMethod();
				}catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		
		itemlist = new JList();
		itemlist.setBackground(new Color(224, 255, 255));
		itemlist.setFont(new Font("Tahoma", Font.PLAIN, 14));
		itemlist.setForeground(new Color(0, 128, 128));
		itemlist.setBounds(328, 104, 245, 221);
		frame.getContentPane().add(itemlist);
		
		JButton logoutbtn= new JButton("Logout");
		logoutbtn.setForeground(new Color(0, 0, 128));
		logoutbtn.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		logoutbtn.setBackground(new Color(0, 128, 128));
		logoutbtn.setBounds(307, 368, 93, 25);
		frame.getContentPane().add(logoutbtn);
		logoutbtn.addActionListener(e->System.exit(0));
		
		JButton mainbtn = new JButton("<- Main Menu");
		mainbtn.setForeground(new Color(0, 0, 128));
		mainbtn.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		mainbtn.setBackground(new Color(0, 128, 128));
		mainbtn.setBounds(145, 368, 139, 24);
		frame.getContentPane().add(mainbtn);
		
		JLabel label = new JLabel("**  Welcome to ToDo List  **");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(128, 0, 0));
		label.setFont(new Font("Sitka Subheading", Font.BOLD, 20));
		label.setBounds(145, 11, 278, 27);
		frame.getContentPane().add(label);
		mainbtn.addActionListener(e->OptionsPage.main(null));
		
	}
	
	/* getting list names when listnames button pressed*/
	private void ShowListNamesPageMethod()throws Exception{
		
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
	                  .prepareStatement("select distinct listname  from todo_db.list_table WHERE username=?");
	 	      preparedStatement.setString(1, userlogname);
	 	      resultSet=preparedStatement.executeQuery();
	 	      
	 	      DefaultListModel dlmobj1=new DefaultListModel();
	 	      
	              while(resultSet.next()) {
	    	      listNameString = resultSet.getString("listname");
	    	      dlmobj1.addElement(listNameString);
	    	     
	    	      
	           }
	      
	         listname.setModel(dlmobj1);
	    
	      
	  }
	  catch(Exception e) {
         throw e;
      }//catch close 
      finally {
 	
       close();
      }
}
	/* getting list items when one list name selcted*/
	private void ShowListItemsPageMethod()throws Exception{
		
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
	      //System.out.println((String) listname.getSelectedValue());
	      
	      if(((String) listname.getSelectedValue())==null) {
	    	  JOptionPane.showMessageDialog(null, "First press *Show ListNames* button then Select some ListName to see its Items");
	      }
	      
	      if(((String) listname.getSelectedValue())!=null) {
          preparedStatement = connect
	                  .prepareStatement("select * from todo_db.list_table WHERE username=? AND listname=?");
	  	      preparedStatement.setString(1, userlogname);
	  	      preparedStatement.setString(2, (String) listname.getSelectedValue());
	  	      //System.out.println(listname.getSelectedValue());
	  	      resultSet=preparedStatement.executeQuery();
	  	      DefaultListModel dlmobj2=new DefaultListModel();
	  	      while(resultSet.next()) {
	    	      itemNameString = resultSet.getString("items");
	    	      dlmobj2.addElement(itemNameString);
	    	      
	    	      
	           }
	    	   itemlist.setModel(dlmobj2);
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
	        statement.close();
	      }

	      if (connect != null) {
	        connect.close();
	      }
	     } catch (Exception e) {

	       }
	}
	
	
}