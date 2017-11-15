package todo.View;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;
import todo.Controller.LoginModel;

import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JList;

public class ShowPage {
	  
	  private String listNameString;
	  private String userlogname;
	  private String listItemString;
	 
	
	  private Connection connect = null;
	  private Statement statement = null;
	  private PreparedStatement preparedStatement = null;
	  private ResultSet resultSet = null;
	  
	  final private String user = "root"; 
	  final private String passwd = "root";

	  private JFrame frame;
	  private JButton btnLoadData;
	  private JButton logoutbtn;
	  private JButton mainbtn;
	  private JLabel label;
	  private JLabel label_1;
	  private JList listname;
	  private JList listitem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowPage window = new ShowPage();
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
	public ShowPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().setBackground(new Color(143, 188, 143));
		frame.getContentPane().setForeground(new Color(0, 128, 128));
		frame.setForeground(new Color(0, 128, 128));
		frame.setBounds(100, 100, 637, 443);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnLoadData = new JButton("Show");
		btnLoadData.setFont(new Font("Sitka Subheading", Font.BOLD, 16));
		btnLoadData.setForeground(new Color(0, 0, 128));
		btnLoadData.setBackground(new Color(0, 128, 128));
		btnLoadData.setBounds(205, 323, 158, 23);
		frame.getContentPane().add(btnLoadData);
		btnLoadData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                try {
					
					ShowPageMethod();
				}catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		
		logoutbtn = new JButton("Logout");
		logoutbtn.setForeground(new Color(0, 0, 128));
		logoutbtn.setFont(new Font("Sitka Subheading", Font.BOLD, 16));
		logoutbtn.setBackground(new Color(0, 128, 128));
		logoutbtn.setBounds(348, 368, 93, 25);
		frame.getContentPane().add(logoutbtn);
		logoutbtn.addActionListener(e->System.exit(0));
		
		mainbtn = new JButton("<- Main Menu");
		mainbtn.setForeground(new Color(0, 0, 128));
		mainbtn.setFont(new Font("Sitka Subheading", Font.BOLD, 16));
		mainbtn.setBackground(new Color(0, 128, 128));
		mainbtn.setBounds(127, 368, 139, 24);
		frame.getContentPane().add(mainbtn);
		mainbtn.addActionListener(e->OptionsPage.main(null));
		
		label = new JLabel("**  Welcome to ToDo List  **");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(128, 0, 0));
		label.setFont(new Font("Sitka Subheading", Font.BOLD, 20));
		label.setBounds(184, 11, 278, 27);
		frame.getContentPane().add(label);
		
		label_1 = new JLabel("< Show >");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(new Color(25, 25, 112));
		label_1.setFont(new Font("Sitka Subheading", Font.BOLD, 20));
		label_1.setBounds(215, 49, 194, 23);
		frame.getContentPane().add(label_1);
		
	    listname = new JList();
		listname.setForeground(new Color(0, 128, 128));
		listname.setFont(new Font("Tahoma", Font.BOLD, 14));
		listname.setBackground(new Color(224, 255, 255));
		listname.setBounds(38, 94, 166, 221);
		frame.getContentPane().add(listname);
		
		listitem = new JList();
		listitem.setForeground(new Color(0, 128, 128));
		listitem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		listitem.setBackground(new Color(224, 255, 255));
		listitem.setBounds(366, 94, 245, 221);
		frame.getContentPane().add(listitem);
		
		JLabel label_2 = new JLabel("ListNames");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(new Color(0, 0, 128));
		label_2.setFont(new Font("Sitka Subheading", Font.PLAIN, 18));
		label_2.setBounds(52, 69, 120, 23);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("ListItems");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(new Color(0, 0, 128));
		label_3.setFont(new Font("Sitka Subheading", Font.PLAIN, 18));
		label_3.setBounds(431, 65, 114, 18);
		frame.getContentPane().add(label_3);
		
		
		
	}
	
	/* Retrieve all list names in to listname jList, all list items in to itemlist JList*/
	private void ShowPageMethod()throws Exception{
		
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
         
         preparedStatement = connect
                 .prepareStatement("select items  from todo_db.list_table WHERE username=?");
	      preparedStatement.setString(1, userlogname);
	      resultSet=preparedStatement.executeQuery();
	      
	      DefaultListModel dlmobj2=new DefaultListModel();
	      
             while(resultSet.next()) {
   	      listItemString = resultSet.getString("items");
   	      dlmobj2.addElement(listItemString);
   	     
   	      
          }
     
        listitem.setModel(dlmobj2);
         
    
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
