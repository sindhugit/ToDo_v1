package todo.View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import todo.Controller.OptionsCall;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class AssignTaskPage {

	private JFrame frame;
	private JTextField toUserField;
	private JTextField listNameField;
	private JTextArea listItemsArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AssignTaskPage window = new AssignTaskPage();
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
	public AssignTaskPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(143, 188, 143));
		frame.getContentPane().setForeground(new Color(128, 0, 0));
		frame.setBounds(100, 100, 714, 433);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("**  Welcome to ToDo List  **");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(128, 0, 0));
		label.setFont(new Font("Sitka Subheading", Font.BOLD, 20));
		label.setBounds(213, 21, 278, 27);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("< Assign Task>");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(new Color(25, 25, 112));
		label_1.setFont(new Font("Sitka Subheading", Font.BOLD, 18));
		label_1.setBounds(254, 71, 214, 23);
		frame.getContentPane().add(label_1);
		
		toUserField = new JTextField();
		toUserField.setForeground(new Color(0, 128, 128));
		toUserField.setColumns(10);
		toUserField.setBounds(332, 117, 188, 27);
		frame.getContentPane().add(toUserField);
		
		listNameField = new JTextField();
		listNameField.setForeground(new Color(0, 128, 128));
		listNameField.setColumns(10);
		listNameField.setBounds(332, 171, 188, 27);
		frame.getContentPane().add(listNameField);
		
		JLabel label_2 = new JLabel(" LISTNAME");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(new Color(0, 0, 128));
		label_2.setFont(new Font("Sitka Subheading", Font.PLAIN, 14));
		label_2.setBounds(216, 174, 89, 21);
		frame.getContentPane().add(label_2);
		
		JLabel lblAssignTo = new JLabel(" ASSIGN TO");
		lblAssignTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblAssignTo.setForeground(new Color(0, 0, 128));
		lblAssignTo.setFont(new Font("Sitka Subheading", Font.PLAIN, 14));
		lblAssignTo.setBounds(216, 123, 89, 21);
		frame.getContentPane().add(lblAssignTo);
		
		JLabel label_3 = new JLabel("LISTITEMS");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(new Color(0, 0, 128));
		label_3.setFont(new Font("Sitka Subheading", Font.PLAIN, 14));
		label_3.setBounds(226, 229, 79, 21);
		frame.getContentPane().add(label_3);
		
	    listItemsArea = new JTextArea();
		listItemsArea.setForeground(new Color(0, 128, 128));
		listItemsArea.setBounds(332, 227, 188, 86);
		frame.getContentPane().add(listItemsArea);
		
		JButton assignBtn = new JButton("Assign");
		assignBtn.setBackground(new Color(0, 128, 128));
		assignBtn.setForeground(new Color(25, 25, 112));
		assignBtn.setFont(new Font("Sitka Subheading", Font.BOLD, 16));
		assignBtn.setBounds(321, 342, 89, 23);
		frame.getContentPane().add(assignBtn);
		assignBtn.addActionListener(e->AssignTaskPageMethod());
		
		JButton mainBtn = new JButton("<-Main Menu");
		mainBtn.setForeground(new Color(25, 25, 112));
		mainBtn.setFont(new Font("Sitka Subheading", Font.BOLD, 16));
		mainBtn.setBackground(new Color(0, 128, 128));
		mainBtn.setBounds(87, 328, 146, 23);
		frame.getContentPane().add(mainBtn);
		mainBtn.addActionListener(e->OptionsPage.main(null));
		
		JButton logoutBtn = new JButton("Logout");
		logoutBtn.setBackground(new Color(0, 128, 128));
		logoutBtn.setFont(new Font("Sitka Subheading", Font.BOLD, 16));
		logoutBtn.setForeground(new Color(25, 25, 112));
		logoutBtn.setBounds(574, 329, 89, 23);
		frame.getContentPane().add(logoutBtn);
		logoutBtn.addActionListener(e->System.exit(0));
	}
	
/* Checking fields are empty or not,if not empty call assign task method to assign task to another existed user */
	
	private void AssignTaskPageMethod()
	{
		
           if(toUserField.getText().toString().isEmpty()) {
			
			JOptionPane.showMessageDialog(null, "User name not entered!! Unable to assign task");
					
			}
            else if(listNameField.getText().toString().isEmpty()) {
			
			JOptionPane.showMessageDialog(null, "ListName field is empty. Please create List name");
					
			}
					
			else if(listItemsArea.getText().toString().isEmpty()) {
						
			JOptionPane.showMessageDialog(null, "ListItems field is empty. Please add items to the List");
					
			}
			else {
				OptionsCall objOptions=new OptionsCall();
				
				try {
				objOptions.callAssignTask(toUserField.getText().toString(),listNameField.getText().toString(),listItemsArea.getText().toString());
				}
				 catch (Exception e) {
			         e.printStackTrace();
						
			       }
				}
	}
}
