package Hospital_Management;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class HomePage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
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
	public HomePage() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Mamun Sheikh\\Downloads\\medical-icon.png"));
		setTitle("Anam Medical College");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 519, 413);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Anam Medical College");
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 20));
		lblNewLabel.setBounds(138, 32, 200, 22);
		contentPane.add(lblNewLabel);
		
		JButton signin = new JButton("Sign in");
		signin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//login  button work
				
				LoginPage.main(null);
				dispose();
			}
		});
		signin.setFont(new Font("Tahoma", Font.BOLD, 12));
		signin.setBounds(122, 147, 89, 23);
		contentPane.add(signin);
		
		JButton signup = new JButton("Sign Up");
		signup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//sing up button work 
				SignupPage.main(null);
				dispose();
			}
		});
		signup.setFont(new Font("Tahoma", Font.BOLD, 12));
		signup.setBounds(253, 148, 89, 23);
		contentPane.add(signup);
		
		JButton exit = new JButton("Exit");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//exit  button work
				dispose();
			}
		});
		exit.setFont(new Font("Tahoma", Font.BOLD, 12));
		exit.setBounds(419, 340, 62, 23);
		contentPane.add(exit);
		
		JLabel lblNewLabel_1 = new JLabel("or");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(221, 151, 22, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Official");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Official.main(null);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(190, 243, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Mamun Sheikh\\Downloads\\medical_cc-removebg-preview.png"));
		lblNewLabel_2.setBounds(54, 11, 373, 363);
		contentPane.add(lblNewLabel_2);
	}
}
