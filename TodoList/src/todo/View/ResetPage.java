package todo.View;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import todo.Controller.ResetPassword;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class ResetPage extends JFrame {

	private JPanel contentPane;
	private JTextField userNameField;
	private JPasswordField passwordField;
	private JTextField questionfield;
	private JPasswordField answerField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResetPage frame = new ResetPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ResetPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 574, 363);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(143, 188, 143));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("USERNAME");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(0, 0, 128));
		label.setFont(new Font("Sitka Subheading", Font.PLAIN, 14));
		label.setBounds(141, 83, 79, 14);
		contentPane.add(label);
		
		JLabel lblWelcomeTo = new JLabel("**  Welcome to ToDo List  **");
		lblWelcomeTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeTo.setForeground(new Color(165, 42, 42));
		lblWelcomeTo.setFont(new Font("Sitka Subheading", Font.BOLD, 20));
		lblWelcomeTo.setBounds(141, 11, 269, 31);
		contentPane.add(lblWelcomeTo);
		
		userNameField = new JTextField();
		userNameField.setForeground(new Color(0, 128, 128));
		userNameField.setColumns(10);
		userNameField.setBounds(261, 77, 127, 26);
		contentPane.add(userNameField);
		
		JLabel lblNewPassword = new JLabel("NEW PASSWORD");
		lblNewPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewPassword.setForeground(new Color(0, 0, 128));
		lblNewPassword.setFont(new Font("Sitka Subheading", Font.PLAIN, 14));
		lblNewPassword.setBounds(113, 199, 107, 18);
		contentPane.add(lblNewPassword);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(new Color(0, 128, 128));
		passwordField.setBounds(261, 195, 127, 26);
		contentPane.add(passwordField);
		
		JButton resetbtn = new JButton("Reset");
		resetbtn.setForeground(new Color(0, 0, 128));
		resetbtn.setFont(new Font("Sitka Subheading", Font.BOLD, 16));
		resetbtn.setBackground(new Color(0, 128, 128));
		resetbtn.setBounds(261, 258, 89, 23);
		contentPane.add(resetbtn);
		resetbtn.addActionListener(e->ResetPageMethod());
		
		JLabel label_2 = new JLabel("*");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_2.setBounds(211, 82, 20, 14);
		contentPane.add(label_2);
		
		JLabel label_1 = new JLabel("*");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_1.setBounds(214, 200, 20, 14);
		contentPane.add(label_1);
		
		JLabel lblNewLabel = new JLabel("< Reset Password >");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Sitka Subheading", Font.BOLD, 18));
		lblNewLabel.setForeground(new Color(25, 25, 112));
		lblNewLabel.setBounds(194, 40, 177, 26);
		contentPane.add(lblNewLabel);
		
		JButton exitbtn = new JButton("Exit");
		exitbtn.setBackground(new Color(0, 128, 128));
		exitbtn.setFont(new Font("Sitka Subheading", Font.BOLD, 16));
		exitbtn.setForeground(new Color(0, 0, 128));
		exitbtn.setBounds(428, 258, 89, 23);
		contentPane.add(exitbtn);
		exitbtn.addActionListener(e->System.exit(0));
		
		JButton btnLoginPage = new JButton("Login Page");
		btnLoginPage.setForeground(new Color(0, 0, 128));
		btnLoginPage.setFont(new Font("Sitka Subheading", Font.BOLD, 16));
		btnLoginPage.setBackground(new Color(0, 128, 128));
		btnLoginPage.setBounds(76, 259, 117, 23);
		contentPane.add(btnLoginPage);
		btnLoginPage.addActionListener(e->LoginPage.main(null));
		
		JButton btnGetSequrityQuestion = new JButton("GET SEQURITY QUESTION");
		btnGetSequrityQuestion.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		btnGetSequrityQuestion.setForeground(new Color(25, 25, 112));
		btnGetSequrityQuestion.setBackground(new Color(0, 128, 128));
		btnGetSequrityQuestion.setBounds(10, 116, 218, 23);
		contentPane.add(btnGetSequrityQuestion);
		btnGetSequrityQuestion.addActionListener(e->checkUser());
		
		questionfield = new JTextField();
		questionfield.setForeground(new Color(0, 128, 128));
		questionfield.setBounds(261, 114, 287, 26);
		contentPane.add(questionfield);
		questionfield.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("SEQURITY QUESTION'S ANSWER");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Sitka Subheading", Font.PLAIN, 14));
		lblNewLabel_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_1.setBounds(0, 162, 231, 26);
		contentPane.add(lblNewLabel_1);
		
		JLabel label_3 = new JLabel("*");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(Color.RED);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_3.setBounds(215, 168, 20, 14);
		contentPane.add(label_3);
		
		answerField = new JPasswordField();
		answerField.setForeground(new Color(0, 128, 128));
		answerField.setBounds(261, 158, 127, 26);
		contentPane.add(answerField);
		
	}
	
	
	public void checkUser() {
		
		String getReturnString=null;
		
        if(userNameField.getText().toString().isEmpty()) {
			
			JOptionPane.showMessageDialog(null, "Username field is empty. Please choose username.");
					
			}
					
			else {
				ResetPassword objResetModel = new ResetPassword();
				   
				 try {
								
					 getReturnString=objResetModel.checkValidUser(userNameField.getText().toString());
							
				  } 
				  catch (Exception e) {
				  e.printStackTrace();
							
				  }
				}
        if(getReturnString != null) {
        questionfield.setText(getReturnString);
        }
        else {
        	JOptionPane.showMessageDialog(null, "Username no existed in To Do system, Please continue with Registration");
        	RegistrationPage.main(null);
        }
				
	}
		
	
	
	
	/**calling Reset method by passing parameters user name and entered password**/
	public void ResetPageMethod() {
		
           if(userNameField.getText().toString().isEmpty()) {
			
			JOptionPane.showMessageDialog(null, "Username field is empty. Please choose username.");
					
			}
					
			else if(answerField.getPassword().length == 0) {
						
			JOptionPane.showMessageDialog(null, "Answer field is empty. Please write the answer for Sequrity question");
					
			}
			else if(passwordField.getPassword().length == 0) {
				
			JOptionPane.showMessageDialog(null, "Password field is empty. Please choose New password.");
					
			}
			else {
						
			ResetPassword objResetModel = new ResetPassword();
					   
			 try {
							
				 objResetModel.changePassword(userNameField.getText().toString(), String.valueOf(passwordField.getPassword()),String.valueOf(answerField.getPassword()));
						
			} 
			catch (Exception e) {
			e.printStackTrace();
						
			}
			}
	}
}
