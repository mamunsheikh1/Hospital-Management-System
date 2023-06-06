package Hospital_Management;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class AppoinmentNotic extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppoinmentNotic frame = new AppoinmentNotic();
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
	public AppoinmentNotic() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Mamun Sheikh\\Downloads\\medical-icon.png"));
		setTitle("Appointment confirmation");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 497, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Your appointment was successfully received");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(28, 132, 386, 29);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LHome.main(null);
				dispose();
			}
		});
		btnNewButton.setBounds(10, 227, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Logout");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage.main(null);
				dispose();
				
				
			}
		});
		btnNewButton_1.setBounds(182, 227, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblPleaseMakeSure = new JLabel("Please make sure come to the scheduled time exactly");
		lblPleaseMakeSure.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblPleaseMakeSure.setBounds(28, 158, 443, 29);
		contentPane.add(lblPleaseMakeSure);
		
		JLabel lblSirmam = new JLabel("Dear sir/mam,");
		lblSirmam.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblSirmam.setBounds(28, 105, 386, 36);
		contentPane.add(lblSirmam);
		
		JLabel lblAnamMedicalCollege = new JLabel("Anam Medical College");
		lblAnamMedicalCollege.setForeground(Color.DARK_GRAY);
		lblAnamMedicalCollege.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblAnamMedicalCollege.setBounds(140, 11, 208, 36);
		contentPane.add(lblAnamMedicalCollege);
		
		JLabel lblThankYouFor = new JLabel("Thank you for being with us!");
		lblThankYouFor.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblThankYouFor.setBounds(28, 186, 443, 29);
		contentPane.add(lblThankYouFor);
		
		JLabel lblThankYouFor_1 = new JLabel("");
		lblThankYouFor_1.setIcon(new ImageIcon("C:\\Users\\Mamun Sheikh\\Downloads\\icons-390s-removebg-preview.png"));
		lblThankYouFor_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblThankYouFor_1.setBounds(52, 0, 399, 142);
		contentPane.add(lblThankYouFor_1);
		
		JButton btnNewButton_1_1 = new JButton("Exit");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1_1.setBounds(382, 228, 89, 23);
		contentPane.add(btnNewButton_1_1);
	}

}
