package Hospital_Management;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class OfficialHome extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OfficialHome frame = new OfficialHome();
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
	public OfficialHome() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Mamun Sheikh\\Downloads\\medical-icon.png"));
		setTitle("Official Protal");
		setBackground(SystemColor.desktop);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 583, 408);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBackground(Color.BLACK);
		contentPane_1.setBounds(10, 11, 547, 347);
		contentPane.add(contentPane_1);
		
		JButton doctor = new JButton("Update Doctor List");
		doctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Odoctor.main(null);
				dispose();
			}
		});
		doctor.setFont(new Font("Tahoma", Font.BOLD, 12));
		doctor.setBounds(159, 226, 173, 23);
		contentPane_1.add(doctor);
		
		JButton balance = new JButton("Balance");
		balance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		balance.setFont(new Font("Tahoma", Font.BOLD, 12));
		balance.setBounds(193, 137, 112, 23);
		contentPane_1.add(balance);
		
		JButton myinfo = new JButton("Patient List");
		myinfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PatientList.main(null);
				dispose();
			}
		});
		myinfo.setFont(new Font("Tahoma", Font.BOLD, 11));
		myinfo.setBounds(193, 182, 112, 23);
		contentPane_1.add(myinfo);
		
		JButton logout = new JButton("Logout");
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage.main(null);
				dispose();
			}
		});
		logout.setFont(new Font("Tahoma", Font.BOLD, 12));
		logout.setBounds(448, 324, 89, 23);
		contentPane_1.add(logout);
		
		JLabel lblNewLabel = new JLabel("Welcome to");
		lblNewLabel.setForeground(SystemColor.menu);
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
		lblNewLabel.setBounds(39, 30, 112, 23);
		contentPane_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Anam Medical College");
		lblNewLabel_1.setForeground(SystemColor.menu);
		lblNewLabel_1.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		lblNewLabel_1.setBounds(144, 41, 205, 32);
		contentPane_1.add(lblNewLabel_1);
		
		JLabel lblOfficialProtal = new JLabel("Official protal");
		lblOfficialProtal.setForeground(SystemColor.menu);
		lblOfficialProtal.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
		lblOfficialProtal.setBounds(348, 48, 112, 23);
		contentPane_1.add(lblOfficialProtal);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnExit.setBounds(0, 324, 76, 23);
		contentPane_1.add(btnExit);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Mamun Sheikh\\Downloads\\images-removebg-preview (1).png"));
		lblNewLabel_2.setBounds(315, 55, 236, 258);
		contentPane_1.add(lblNewLabel_2);
	}
}
