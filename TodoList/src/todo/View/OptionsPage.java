package todo.View;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OptionsPage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OptionsPage window = new OptionsPage();
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
	public OptionsPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(143, 188, 143));
		frame.getContentPane().setLayout(null);
		
		JLabel lblWelcomeTo = new JLabel("**  Welcome to ToDo List  **");
		lblWelcomeTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeTo.setForeground(new Color(128, 0, 0));
		lblWelcomeTo.setFont(new Font("Sitka Subheading", Font.BOLD, 20));
		lblWelcomeTo.setBounds(189, 22, 278, 27);
		frame.getContentPane().add(lblWelcomeTo);
		
		JButton btncreatelist = new JButton("+Createlist");
		btncreatelist.setForeground(new Color(0, 0, 128));
		btncreatelist.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		btncreatelist.setBackground(new Color(0, 128, 128));
		btncreatelist.setBounds(246, 102, 183, 27);
		frame.getContentPane().add(btncreatelist);
		btncreatelist.addActionListener(e->CreateListPage.main(null));
		
		JButton btnshowlist = new JButton("+Showlist");
		btnshowlist.setForeground(new Color(0, 0, 128));
		btnshowlist.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		btnshowlist.setBackground(new Color(0, 128, 128));
		btnshowlist.setBounds(246, 140, 183, 27);
		frame.getContentPane().add(btnshowlist);
		btnshowlist.addActionListener(e->ShowListNamesPage.main(null));
		
		JButton btneditlist = new JButton("+Editlist");
		btneditlist.setForeground(new Color(0, 0, 128));
		btneditlist.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		btneditlist.setBackground(new Color(0, 128, 128));
		btneditlist.setBounds(246, 216, 183, 27);
		frame.getContentPane().add(btneditlist);
		btneditlist.addActionListener(e->EditListPage.main(null));
		
		JButton btnShow = new JButton("+Show");
	    btnShow.setForeground(new Color(0, 0, 128));
		btnShow.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		btnShow.setBackground(new Color(0, 128, 128));
		btnShow.setBounds(246, 178, 183, 27);
		frame.getContentPane().add(btnShow);
		btnShow.addActionListener(e->ShowPage.main(null));
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setForeground(new Color(0, 0, 128));
		btnLogout.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		btnLogout.setBackground(new Color(0, 128, 128));
		btnLogout.setBounds(289, 330, 93, 25);
		frame.getContentPane().add(btnLogout);
		
		JButton btndeletelist = new JButton("+Deletelist");
		btndeletelist.setForeground(new Color(0, 0, 128));
		btndeletelist.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		btndeletelist.setBackground(new Color(0, 128, 128));
		btndeletelist.setBounds(246, 254, 183, 27);
		frame.getContentPane().add(btndeletelist);
		btndeletelist.addActionListener(e->DeleteListPage.main(null));
		
		JButton btntasksAssignedTo = new JButton("+Tasks Assigned to me");
		btntasksAssignedTo.setForeground(new Color(0, 0, 128));
		btntasksAssignedTo.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		btntasksAssignedTo.setBackground(new Color(0, 128, 128));
		btntasksAssignedTo.setBounds(233, 292, 208, 27);
		frame.getContentPane().add(btntasksAssignedTo);
		
		JLabel lblNewLabel = new JLabel("<<  Main Menu  >>");
		lblNewLabel.setBackground(new Color(0, 128, 128));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Sitka Subheading", Font.BOLD, 18));
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setBounds(246, 66, 183, 25);
		frame.getContentPane().add(lblNewLabel);
		btnLogout.addActionListener(e->System.exit(0));
		frame.setBounds(100, 100, 674, 418);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	}
