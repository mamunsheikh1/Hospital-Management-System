package Hospital_Management;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class LHome extends JFrame {

	protected static final LHome DoctorList = null;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LHome frame = new LHome();
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
	public LHome() {
		setTitle("Anam Medical College");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 503, 377);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.infoText);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton doctor = new JButton("Doctor appointment");
		doctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				TestDeleteDoctor.main(null);
				dispose();
			}
		});
		doctor.setFont(new Font("Tahoma", Font.BOLD, 12));
		doctor.setBounds(154, 116, 168, 23);
		contentPane.add(doctor);
		
		JButton balance = new JButton("Balance");
		balance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Balance.main(null);
				dispose();
			}
		});
		balance.setFont(new Font("Tahoma", Font.BOLD, 12));
		balance.setBounds(181, 161, 112, 23);
		contentPane.add(balance);
		
		JButton myinfo = new JButton("My info");
		myinfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Myinfo.main(null);
				dispose();
			}
		});
		myinfo.setFont(new Font("Tahoma", Font.BOLD, 11));
		myinfo.setBounds(181, 207, 112, 23);
		contentPane.add(myinfo);
		
		JButton logout = new JButton("Logout");
		logout.setFont(new Font("Tahoma", Font.BOLD, 12));
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage.main(null);
				dispose();
			}
		});
		logout.setBounds(388, 301, 89, 23);
		contentPane.add(logout);
		
		JLabel lblNewLabel = new JLabel("Welcome to");
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
		lblNewLabel.setForeground(SystemColor.menu);
		lblNewLabel.setBounds(39, 30, 112, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Anam Medical College");
		lblNewLabel_1.setForeground(SystemColor.menu);
		lblNewLabel_1.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		lblNewLabel_1.setBounds(144, 41, 205, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Mamun Sheikh\\Downloads\\images-removebg-preview.png"));
		lblNewLabel_2.setBounds(0, 113, 275, 211);
		contentPane.add(lblNewLabel_2);
	}

}
