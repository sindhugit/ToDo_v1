package todo.View;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;
import todo.Controller.OptionsCall;



public class DeleteListPage {
	
	  private Connection connect = null;
	  private Statement statement = null;
	  private PreparedStatement preparedStatement = null;
	  private ResultSet resultSet = null;
	  
	  final private String user = "root"; 
	  final private String passwd = "root";

	private JFrame frame;
	private JTable loadTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteListPage window = new DeleteListPage();
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
	public DeleteListPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(143, 188, 143));
		frame.setBounds(100, 100, 670, 386);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("**  Welcome to ToDo List  **");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(128, 0, 0));
		label.setFont(new Font("Sitka Subheading", Font.BOLD, 20));
		label.setBounds(179, 11, 278, 27);
		frame.getContentPane().add(label);
		
		JLabel lblNewLabel = new JLabel("< DeleteList >");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(25, 25, 112));
		lblNewLabel.setFont(new Font("Sitka Subheading", Font.BOLD, 18));
		lblNewLabel.setBounds(240, 49, 141, 27);
		frame.getContentPane().add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setForeground(new Color(0, 128, 128));
		scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane.setBackground(new Color(224, 255, 255));
		scrollPane.setBounds(114, 87, 371, 214);
		frame.getContentPane().add(scrollPane);
		
		loadTable = new JTable();
		scrollPane.setViewportView(loadTable);
		
		JButton mainbtn = new JButton("<- Main Menu");
		mainbtn.setForeground(new Color(0, 0, 128));
		mainbtn.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		mainbtn.setBackground(new Color(0, 128, 128));
		mainbtn.setBounds(10, 317, 139, 24);
		frame.getContentPane().add(mainbtn);
		mainbtn.addActionListener(e->OptionsPage.main(null));
		
		JButton logoutbtn = new JButton("Logout");
		logoutbtn.setForeground(new Color(0, 0, 128));
		logoutbtn.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		logoutbtn.setBackground(new Color(0, 128, 128));
		logoutbtn.setBounds(488, 318, 93, 25);
		frame.getContentPane().add(logoutbtn);
		logoutbtn.addActionListener(e->System.exit(0));
		
		JButton loaddatabtn = new JButton("Load Data");
		loaddatabtn.setForeground(new Color(0, 0, 128));
		loaddatabtn.setFont(new Font("Sitka Subheading", Font.BOLD, 16));
		loaddatabtn.setBackground(new Color(0, 128, 128));
		loaddatabtn.setBounds(512, 142, 113, 27);
		frame.getContentPane().add(loaddatabtn);
		loaddatabtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                try {
					
					DeletePageLoadMethod();
				}catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setForeground(new Color(0, 0, 128));
		btnDelete.setFont(new Font("Sitka Subheading", Font.BOLD, 16));
		btnDelete.setBackground(new Color(0, 128, 128));
		btnDelete.setBounds(512, 200, 113, 27);
		frame.getContentPane().add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                try {
					
					DeletePageDeleteMethod();
				}catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}
	
	
	/* show all list names and list items in JTable */
	private void DeletePageLoadMethod()throws Exception{
		
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
	      
	      resultSet = statement.executeQuery("select listname,items from todo_db.list_table");
	      loadTable.setModel(DbUtils.resultSetToTableModel(resultSet));
		 }
		  catch(Exception e) {
	         throw e;
	      }//catch close 
	      finally {
	 	
	       close();
	      }
	}
	
	
	/*Selecting one row from JTable passing that to delete method*/
	private void DeletePageDeleteMethod() {
		
		DefaultTableModel dtm=(DefaultTableModel) loadTable.getModel();
		//get index of selected row
		int selectedRow=loadTable.getSelectedRow();
		
		/*checking any row is selected or not*/
		// if no row selected
		if(selectedRow<0) {
			JOptionPane.showMessageDialog(null, "First press *Load Data* then Please select some Row to delete");
		}
		//if row selected
		if(selectedRow>=0) {
		//get list name and list item of selected row
		String selectedListName=(String) dtm.getValueAt(selectedRow,0);
		String selectedListItem=(String) dtm.getValueAt(selectedRow, 1);
		OptionsCall objOptionsCall=new OptionsCall();
		//calling delete method to remove the data in data base table
		objOptionsCall.callDelete(selectedListName, selectedListItem);
		
		//delete data in user interface view
		 dtm.removeRow(selectedRow);
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

