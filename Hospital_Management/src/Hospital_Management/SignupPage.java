package Hospital_Management;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class SignupPage extends JFrame {

	private JPanel contentPane;
	private JTextField fullname;
	private JTextField phone;
	private JTextField gender;
	private JTextField age;
	private JPasswordField rpass;

	/**
	 * Launch the application.
	 */
	Connection cn= null;
	PreparedStatement ps= null;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignupPage frame = new SignupPage();
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
	public SignupPage() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Mamun Sheikh\\Downloads\\medical-icon.png"));
		setTitle("Sign-UP");
		
		
		cn= SQLConnection.ConnecrDb();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 495, 410);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Anam Medical College");
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		lblNewLabel.setBounds(136, 26, 192, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Full Name");
		lblNewLabel_1.setLabelFor(this);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(81, 111, 89, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel bgf = new JLabel("Email or Phone");
		bgf.setFont(new Font("Tahoma", Font.BOLD, 12));
		bgf.setBounds(55, 149, 106, 14);
		contentPane.add(bgf);
		
		JLabel lblNewLabel_1_2 = new JLabel("Age");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_2.setBounds(99, 215, 46, 14);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Gender");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_3.setBounds(89, 183, 46, 14);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(81, 246, 80, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Please give information carefully");
		lblNewLabel_3.setBounds(25, 86, 211, 14);
		contentPane.add(lblNewLabel_3);
		
		fullname = new JTextField();
		fullname.setBounds(155, 109, 160, 20);
		contentPane.add(fullname);
		fullname.setColumns(10);
		
		phone = new JTextField();
		phone.setBounds(155, 147, 160, 20);
		contentPane.add(phone);
		phone.setColumns(10);
		
		gender = new JTextField();
		gender.setBounds(165, 181, 137, 20);
		contentPane.add(gender);
		gender.setColumns(10);
		
		age = new JTextField();
		age.setBounds(191, 213, 86, 20);
		contentPane.add(age);
		age.setColumns(10);
		
		rpass = new JPasswordField();
		rpass.setBounds(155, 244, 160, 20);
		contentPane.add(rpass);
		
		JButton register = new JButton("Register");
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			String name= fullname.getText();
			String ph= phone.getText();
			String gd= gender.getText();
			String ag= age.getText();
			String pass=rpass.getText();
			
			 if (name.isEmpty() || ph.isEmpty() || gd.isEmpty() || ag.isEmpty() || pass.isEmpty()) {
                 JOptionPane.showMessageDialog(null, "Please fill in all information", "Error", JOptionPane.ERROR_MESSAGE);
                 return; // Exit the action if any field is empty
             }

				
			String sql= "INSERT INTO user (name, email, gender, age, password) VALUES(?,?,?,?,?)";
			
			try {
				PreparedStatement ps = cn.prepareStatement(sql);
				ps.setString(1, name);
				ps.setString(2,ph);
				ps.setString(3,gd);
				ps.setString(4,ag);
				ps.setString(5, pass);
			    ps.execute();
				
			    System.err.println("Resigtation done");
			    JOptionPane.showMessageDialog(null, "Welcome, " + name + "! Registration successful", "Welcome", JOptionPane.INFORMATION_MESSAGE);
               
			    LHome nextPage = new LHome();
                nextPage.setVisible(true);
                dispose();
			} 
			catch (Exception ex) {
				System.out.println(ex);
			}
				
				
			
			}
		});
		register.setFont(new Font("Tahoma", Font.BOLD, 12));
		register.setBounds(191, 275, 89, 23);
		contentPane.add(register);
		
		JLabel lblNewLabel_4 = new JLabel("I have already an account");
		lblNewLabel_4.setBounds(10, 321, 160, 14);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Sign-in");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPage.main(null);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(25, 339, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Home");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage.main(null);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(380, 340, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\Mamun Sheikh\\Downloads\\medical_cc-removebg-preview.png"));
		lblNewLabel_5.setBounds(55, 11, 370, 351);
		contentPane.add(lblNewLabel_5);
	}
}
