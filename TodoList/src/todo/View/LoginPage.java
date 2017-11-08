package todo.View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.SwingConstants;

import todo.Controller.LoginModel;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class LoginPage {

	private JFrame frame;
	private JTextField usernameField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage window = new LoginPage();
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
	public LoginPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(128, 0, 0));
		frame.getContentPane().setBackground(new Color(143, 188, 143));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 434, 0);
		frame.getContentPane().add(label);
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setForeground(new Color(0, 0, 128));
		lblUsername.setFont(new Font("Sitka Subheading", Font.PLAIN, 14));
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setBounds(107, 61, 79, 14);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblWelcomeToTodo = new JLabel("Welcome to ToDo List");
		lblWelcomeToTodo.setForeground(new Color(165, 42, 42));
		lblWelcomeToTodo.setFont(new Font("Sitka Subheading", Font.BOLD, 20));
		lblWelcomeToTodo.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToTodo.setBounds(94, 11, 254, 25);
		frame.getContentPane().add(lblWelcomeToTodo);
		
		usernameField= new JTextField();
		usernameField.setForeground(new Color(0, 128, 128));
		usernameField.setBounds(208, 58, 127, 26);
		frame.getContentPane().add(usernameField);
		usernameField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("PASSWORD");
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("Sitka Subheading", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(107, 102, 79, 14);
		frame.getContentPane().add(lblNewLabel);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(new Color(0, 128, 128));
		passwordField.setBounds(208, 90, 127, 26);
		frame.getContentPane().add(passwordField);
		
		JButton loginButton = new JButton("Login");
		loginButton.setBackground(new Color(0, 128, 128));
		loginButton.setForeground(new Color(0, 0, 128));
		loginButton.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		loginButton.setBounds(193, 147, 89, 23);
		frame.getContentPane().add(loginButton);
		loginButton.addActionListener(e->loginButtonMethod());

		
		JButton regButton = new JButton("Register");
		regButton.setBackground(new Color(0, 128, 128));
		regButton.setForeground(new Color(0, 0, 128));
		regButton.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		regButton.setBounds(272, 192, 89, 23);
		frame.getContentPane().add(regButton);
		regButton.addActionListener(e->RegistrationPage.main(null));
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBackground(new Color(0, 128, 128));
		btnReset.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		btnReset.setForeground(new Color(0, 0, 128));
		btnReset.setBounds(130, 192, 89, 23);
		frame.getContentPane().add(btnReset);
		btnReset.addActionListener(e->ResetPage.main(null));
	}

	private void loginButtonMethod(){
		
		System.out.println("Login Button Method Called.");
					
			if(usernameField.getText().toString().isEmpty()) {
						
			JOptionPane.showMessageDialog(null, "Username field is empty. Please choose username.");
					
			}
					
			else if(passwordField.getPassword().length == 0) {
						
			JOptionPane.showMessageDialog(null, "Password field is empty. Please choose password.");
					
			}
					
			else {
						
			LoginModel objLoginModel = new LoginModel();
					   
			 try {
							
				 objLoginModel.loginMethod(usernameField.getText().toString(), String.valueOf(passwordField.getPassword()));
						
			} 
			catch (Exception e) {
			e.printStackTrace();
						
			}
			}
	}
}
				

