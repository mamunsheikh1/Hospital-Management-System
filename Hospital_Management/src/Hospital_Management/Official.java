package Hospital_Management;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Official extends JFrame {

	private JPanel contentPane;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Official frame = new Official();
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
	public Official() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Mamun Sheikh\\Downloads\\medical-icon.png"));
		setTitle("Official Protal login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 555, 401);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.shadow"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Anam Medical College");
		lblNewLabel_3.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		lblNewLabel_3.setBounds(179, 11, 236, 23);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblEmployeeId = new JLabel("Employee ID");
		lblEmployeeId.setBackground(Color.PINK);
		lblEmployeeId.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmployeeId.setBounds(112, 155, 91, 14);
		contentPane.add(lblEmployeeId);
		
		JFormattedTextField email = new JFormattedTextField();
		email.setBounds(213, 153, 152, 20);
		contentPane.add(email);
		
		JLabel lblNewLabel_1 = new JLabel("password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(127, 200, 76, 14);
		contentPane.add(lblNewLabel_1);
		
		password = new JPasswordField();
		password.setBounds(213, 198, 152, 20);
		contentPane.add(password);
		
		JButton login = new JButton("Login");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String userName = email.getText();
	            String pass = password.getText();
	            
	            if(userName.contains("221155530") && pass.contains("mamun5530")) {
	              JOptionPane.showMessageDialog(null,"Welcome!");
	              OfficialHome.main(null);
	              dispose();
	              
	            }
	            else
	            {
	              JOptionPane.showInternalMessageDialog(null,"Invalid username or password",null ,JOptionPane.ERROR_MESSAGE);
	            }
				
			}
		});
		login.setFont(new Font("Tahoma", Font.BOLD, 12));
		login.setBounds(260, 236, 76, 23);
		contentPane.add(login);
		
		JButton btnNewButton_1 = new JButton("Home");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage.main(null);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(446, 328, 83, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblThisIsOnly = new JLabel("This protal only for official employee");
		lblThisIsOnly.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblThisIsOnly.setBounds(112, 67, 303, 65);
		contentPane.add(lblThisIsOnly);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\Mamun Sheikh\\Downloads\\images-removebg-preview (2).png"));
		lblNewLabel_5.setBounds(364, 15, 165, 199);
		contentPane.add(lblNewLabel_5);
	}

}
