package todo.View;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

import todo.Controller.LoginModel;
import todo.Controller.OptionsCall;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.BorderLayout;

public class EditListPage {

	private JFrame frame;
	private JButton btnSave;
	private JTextField listNameField;
	private JTextArea listItemsArea;
	private JButton logoutbtn;
	private JLabel label;
	private int flag;
	private String userlogname;
	
	
	/**
	 * @wbp.nonvisual location=163,-31
	 */
	private final JTextArea textArea = new JTextArea();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditListPage window = new EditListPage();
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
	public EditListPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(128, 0, 0));
		frame.getContentPane().setBackground(new Color(143, 188, 143));
		frame.setBounds(100, 100, 600, 353);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAdditems = new JLabel("< Edit list >");
		lblAdditems.setForeground(new Color(25, 25, 112));
		lblAdditems.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdditems.setFont(new Font("Sitka Subheading", Font.BOLD, 18));
		lblAdditems.setBounds(194, 59, 214, 23);
		frame.getContentPane().add(lblAdditems);
		
		btnSave = new JButton("Edit & Save");
		btnSave.setBackground(new Color(0, 128, 128));
		btnSave.setForeground(new Color(0, 0, 128));
		btnSave.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		btnSave.setVisible(true);
		btnSave.setBounds(270, 249, 111, 23);
		frame.getContentPane().add(btnSave);
		btnSave.addActionListener(e->EditListPageMethod());
		
		
		
		listNameField = new JTextField();
		listNameField.setForeground(new Color(0, 128, 128));
		listNameField.setBounds(231, 99, 188, 27);
		frame.getContentPane().add(listNameField);
		listNameField.setColumns(10);
		
		 listItemsArea = new JTextArea();
		 listItemsArea.setForeground(new Color(0, 128, 128));
		listItemsArea.setBounds(231, 150, 188, 86);
		frame.getContentPane().add(listItemsArea);
		
		JLabel lblListname = new JLabel(" LISTNAME");
		lblListname.setHorizontalAlignment(SwingConstants.CENTER);
		lblListname.setForeground(new Color(0, 0, 128));
		lblListname.setFont(new Font("Sitka Subheading", Font.PLAIN, 14));
		lblListname.setBounds(110, 102, 89, 21);
		frame.getContentPane().add(lblListname);
		
		JLabel lblNewLabel = new JLabel("LISTITEMS");
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("Sitka Subheading", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(120, 152, 79, 21);
		frame.getContentPane().add(lblNewLabel);
		
		logoutbtn = new JButton("Logout");
		logoutbtn.setForeground(new Color(0, 0, 128));
		logoutbtn.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		logoutbtn.setBackground(new Color(0, 128, 128));
		logoutbtn.setBounds(397, 279, 93, 25);
		frame.getContentPane().add(logoutbtn);
		logoutbtn.addActionListener(e->System.exit(0));
		
		JButton mainbtn = new JButton("<- Main Menu");
		mainbtn.setBackground(new Color(0, 128, 128));
		mainbtn.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		mainbtn.setForeground(new Color(0, 0, 128));
		mainbtn.setBounds(110, 279, 139, 24);
		frame.getContentPane().add(mainbtn);
		
		label = new JLabel("**  Welcome to ToDo List  **");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(128, 0, 0));
		label.setFont(new Font("Sitka Subheading", Font.BOLD, 20));
		label.setBounds(170, 11, 278, 27);
		frame.getContentPane().add(label);
		mainbtn.addActionListener(e->OptionsPage.main(null));
		
	}
	
	public void EditListPageMethod() {
		
	System.out.println("EditListPage method called");
	
	LoginModel objLoginModel=new LoginModel();
    userlogname= objLoginModel.getUsername();
    
	if(listNameField.getText().toString().isEmpty()) {
		
		JOptionPane.showMessageDialog(null, "ListName field is empty. Please create List name");
				
		}
				
		else if(listItemsArea.getText().toString().isEmpty()) {
					
		JOptionPane.showMessageDialog(null, "ListItems field is empty. Please add items to the List");
				
		}
		else {
			OptionsCall objOptions=new OptionsCall();
			
			objOptions.callAddList(listNameField.getText().toString(),listItemsArea.getText().toString());
			}
}
}
