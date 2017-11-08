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
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ShowPage {
	
	  private Connection connect = null;
	  private Statement statement = null;
	  private PreparedStatement preparedStatement = null;
	  private ResultSet resultSet = null;
	  
	  final private String user = "root"; 
	  final private String passwd = "root";

	  private JFrame frame;
	
	  private JTable showTable;
	  private JButton btnLoadData;
	  private JButton logoutbtn;
	  private JButton mainbtn;
	  private JLabel label;
	  private JLabel label_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowPage window = new ShowPage();
					window.frame.setVisible(true);
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane.setForeground(new Color(0, 128, 128));
		scrollPane.setBackground(new Color(224, 255, 255));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(127, 91, 371, 214);
		frame.getContentPane().add(scrollPane);
		
		showTable = new JTable();
		scrollPane.setViewportView(showTable);
		
		btnLoadData = new JButton("Load Data");
		btnLoadData.setFont(new Font("Sitka Subheading", Font.BOLD, 16));
		btnLoadData.setForeground(new Color(0, 0, 128));
		btnLoadData.setBackground(new Color(0, 128, 128));
		btnLoadData.setBounds(231, 316, 158, 23);
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
		logoutbtn.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		logoutbtn.setBackground(new Color(0, 128, 128));
		logoutbtn.setBounds(390, 368, 93, 25);
		frame.getContentPane().add(logoutbtn);
		logoutbtn.addActionListener(e->System.exit(0));
		
		mainbtn = new JButton("<- Main Menu");
		mainbtn.setForeground(new Color(0, 0, 128));
		mainbtn.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		mainbtn.setBackground(new Color(0, 128, 128));
		mainbtn.setBounds(147, 368, 139, 24);
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
		label_1.setBounds(225, 60, 194, 23);
		frame.getContentPane().add(label_1);
		
		
		
	}
	
	
	public void ShowPageMethod()throws Exception{
		
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
	      
	      resultSet = statement.executeQuery("select listname,items from todo_db.list_table");
	      //creating view in jtable
	      showTable.setModel(DbUtils.resultSetToTableModel(resultSet));
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
			     } catch (Exception e) {

			       }
			}
}
