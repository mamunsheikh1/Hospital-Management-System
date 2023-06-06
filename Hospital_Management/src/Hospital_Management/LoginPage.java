package Hospital_Management;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class LoginPage extends JFrame {

	private JPanel contentPane;
	private JPasswordField pass;
	Connection cn= null;
	PreparedStatement ps= null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
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
	public LoginPage() {
		cn= SQLConnection.ConnecrDb();
		setTitle("Login Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 502, 367);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("email or phone");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(98, 126, 91, 14);
		contentPane.add(lblNewLabel);
		
		JFormattedTextField email = new JFormattedTextField();
		email.setBounds(199, 124, 152, 20);
		contentPane.add(email);
		
		JLabel lblNewLabel_1 = new JLabel("password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(113, 171, 76, 14);
		contentPane.add(lblNewLabel_1);
		
		pass = new JPasswordField();
		pass.setBounds(199, 169, 152, 20);
		contentPane.add(pass);
		
		JButton login = new JButton("Login");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
	                String inputName = email.getText();
	                String inputPassword = pass.getText();

	                // Validate if any field is empty
	                if (inputName.isEmpty() || inputPassword.isEmpty()) {
	                    JOptionPane.showMessageDialog(null, "Please give email & password", "Error", JOptionPane.ERROR_MESSAGE);
	                    return;
	                }

	                // Query to check if the name and password exist in the database
	                String sql = "SELECT * FROM user WHERE name = ? AND password = ?";

	                try {
	                    PreparedStatement ps = cn.prepareStatement(sql);
	                    ps.setString(1, inputName);
	                    ps.setString(2, inputPassword);
	                    ResultSet rs = ps.executeQuery();

	                    Component userName;
						if(inputName.contains("mamun@gmail.com") && inputPassword.contains("mamun5530")) {
	                        JOptionPane.showMessageDialog(null,"Welcome Anam Medical College");
	                        LHome.main(null);
	                        dispose();
	                      }
	                      else
	                      {
	                        JOptionPane.showInternalMessageDialog(null,"Invalid username or password",null ,JOptionPane.ERROR_MESSAGE);
	                      }

	                    // Clear the input fields
	                    
	                    //passwordField.setText("");
	                } catch (SQLException ex) {
	                    System.out.println(ex);
	                }   
	                   
				
				
			}	
		});
		login.setFont(new Font("Tahoma", Font.BOLD, 12));
		login.setBounds(246, 207, 76, 23);
		contentPane.add(login);
		
		JLabel lblNewLabel_2 = new JLabel("If you don't have account go");
		lblNewLabel_2.setBounds(10, 285, 181, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("sign-up");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignupPage.main(null);
				dispose();
			}
		});
		btnNewButton.setForeground(SystemColor.windowText);
		btnNewButton.setBackground(SystemColor.inactiveCaptionBorder);
		btnNewButton.setBounds(167, 281, 76, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Home");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage.main(null);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(378, 280, 83, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("Anam Medical College");
		lblNewLabel_3.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		lblNewLabel_3.setBounds(143, 11, 236, 23);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Mamun Sheikh\\Downloads\\icons-390s-removebg-preview.png"));
		lblNewLabel_4.setBounds(52, -18, 410, 190);
		contentPane.add(lblNewLabel_4);
	}
}
