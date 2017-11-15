package todo.View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import todo.Controller.LoginModel;
import todo.Controller.OptionsCall;
import todo.Model.Registration;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;

public class RegistrationPage {

	private JFrame frame;
	private JTextField usernameField;
	private JTextField profileField;
	private JPasswordField passwordField;
	private JPasswordField answerfield;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				RegistrationPage window = new RegistrationPage();
				window.frame.setVisible(true);
				window.frame.setExtendedState(window.frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
			    } 
			 catch (Exception e) {
				e.printStackTrace();
			  }
		 }
	  }
); 
	}

	/**
	 * Create the application.
	 */
	public RegistrationPage() {
	
	initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(143, 188, 143));
		frame.getContentPane().setForeground(new Color(128, 0, 0));
		frame.setBounds(100, 100, 718, 443);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("< Registration Page >");
		lblNewLabel.setFont(new Font("Sitka Subheading", Font.BOLD, 20));
		lblNewLabel.setForeground(new Color(25, 25, 112));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(255, 50, 217, 28);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("USERNAME");
		lblNewLabel_1.setFont(new Font("Sitka Subheading", Font.PLAIN, 14));
		lblNewLabel_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(204, 107, 89, 20);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PASSWORD");
		lblNewLabel_2.setForeground(new Color(0, 0, 128));
		lblNewLabel_2.setFont(new Font("Sitka Subheading", Font.PLAIN, 14));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(202, 145, 91, 20);
		frame.getContentPane().add(lblNewLabel_2);
		
		usernameField = new JTextField();
		usernameField.setForeground(new Color(0, 128, 128));
		usernameField.setBounds(321, 102, 151, 28);
		frame.getContentPane().add(usernameField);
		usernameField.setColumns(10);
		
		JLabel lblProfilename = new JLabel("PROFILENAME");
		lblProfilename.setFont(new Font("Sitka Subheading", Font.PLAIN, 14));
		lblProfilename.setForeground(new Color(0, 0, 128));
		lblProfilename.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfilename.setBounds(188, 184, 105, 20);
		frame.getContentPane().add(lblProfilename);
		
		profileField = new JTextField();
		profileField.setForeground(new Color(0, 128, 128));
		profileField.setBounds(321, 180, 151, 28);
		frame.getContentPane().add(profileField);
		profileField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(new Color(0, 128, 128));
		passwordField.setBounds(321, 141, 151, 28);
		frame.getContentPane().add(passwordField);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBackground(new Color(0, 128, 128));
		btnRegister.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		btnRegister.setForeground(new Color(0, 0, 128));
		btnRegister.setBounds(321, 313, 89, 28);
		frame.getContentPane().add(btnRegister);
		btnRegister.addActionListener(e->regButtonMethod());
		
		JLabel lblNewLabel_3 = new JLabel("*");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setForeground(new Color(255, 0, 0));
		lblNewLabel_3.setBounds(282, 108, 20, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel label = new JLabel("*");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.RED);
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setBounds(280, 147, 20, 14);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("*");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_1.setBounds(283, 184, 20, 14);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("**  Welcome to ToDo List  **");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(new Color(128, 0, 0));
		label_2.setFont(new Font("Sitka Subheading", Font.BOLD, 20));
		label_2.setBounds(229, 11, 278, 27);
		frame.getContentPane().add(label_2);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Sitka Subheading", Font.PLAIN, 14));
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setForeground(new Color(0, 128, 128));
		comboBox.setBounds(321, 219, 316, 28);
		frame.getContentPane().add(comboBox);
		comboBox.addItem("-select-");
	    comboBox.addItem("what is your pet name?");
		comboBox.addItem("what is your favourite place?");
		comboBox.addItem("what is your mother surname?");
		comboBox.addItem("what is your favourite color?");
		comboBox.addItem("what is your favourite food?");
		comboBox.setSelectedItem(0);
		
		JLabel lblNewLabel_4 = new JLabel("SELECT SEQURITY QUESTION");
		lblNewLabel_4.setForeground(new Color(0, 0, 128));
		lblNewLabel_4.setFont(new Font("Sitka Subheading", Font.PLAIN, 14));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(87, 219, 206, 28);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel label_3 = new JLabel("*");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(Color.RED);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_3.setBounds(281, 226, 20, 14);
		frame.getContentPane().add(label_3);
		
		JLabel lblNewLabel_5 = new JLabel("ANSWER");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setForeground(new Color(0, 0, 128));
		lblNewLabel_5.setFont(new Font("Sitka Subheading", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(222, 266, 71, 21);
		frame.getContentPane().add(lblNewLabel_5);
		
		answerfield = new JPasswordField();
		answerfield.setForeground(new Color(0, 128, 128));
		answerfield.setBounds(321, 262, 151, 28);
		frame.getContentPane().add(answerfield);
		
		JLabel label_4 = new JLabel("*");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(Color.RED);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_4.setBounds(280, 269, 20, 14);
		frame.getContentPane().add(label_4);
		
		JButton exitbtn = new JButton("Exit");
		exitbtn.setBackground(new Color(0, 128, 128));
		exitbtn.setForeground(new Color(25, 25, 112));
		exitbtn.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		exitbtn.setBounds(525, 313, 62, 28);
		frame.getContentPane().add(exitbtn);
		exitbtn.addActionListener(e->System.exit(0));
		
		JButton loginPageBtn = new JButton("Login Page");
		loginPageBtn.setBackground(new Color(0, 128, 128));
		loginPageBtn.setForeground(new Color(25, 25, 112));
		loginPageBtn.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		loginPageBtn.setBounds(98, 318, 128, 23);
		frame.getContentPane().add(loginPageBtn);
		loginPageBtn.addActionListener(e->LoginPage.main(null));
		
		
	}
       /* checking for empty fields, if fields or not empty call registration method to register*/
	   private void regButtonMethod(){
		
		
					
			if(usernameField.getText().toString().isEmpty()) {
						
			JOptionPane.showMessageDialog(null, "Username field is empty. Please choose username.");
					
			}
					
			else if(passwordField.getPassword().length == 0) {
						
			JOptionPane.showMessageDialog(null, "Password field is empty. Please choose password.");
					
			}
			else if(profileField.getText().toString().isEmpty()) {
				
				JOptionPane.showMessageDialog(null, "Profile field is empty. Please choose Profile name.");
						
				}
			else if(comboBox.getSelectedItem().equals("-select-")) {
				
				JOptionPane.showMessageDialog(null, "Please choose security question.");
				
			}
			else if(answerfield.getPassword().length == 0) {
				
				JOptionPane.showMessageDialog(null, "Answer field is empty. Please choose Answer.");
			}
					
			else {
					OptionsCall objOptionsCall=new OptionsCall();	
					//get the selected value of comboBox
					String question=(String) comboBox.getSelectedItem();
					try {
				      objOptionsCall.callRegistration(usernameField.getText().toString(), String.valueOf(passwordField.getPassword()),profileField.getText().toString(),question,String.valueOf(answerfield.getPassword()));
					}
					catch (Exception e) {
			             e.printStackTrace();
				     }
			}
	}
}
