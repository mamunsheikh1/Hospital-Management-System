package Hospital_Management;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Odoctor extends JFrame {

	private JPanel contentPane;
	private JTextField dname;
	private JTextField dept;
	private JTextField fee;
	private JTextField did;
	private JTable table;
	private DefaultTableModel model;
	Connection cn = null;
	java.sql.PreparedStatement ss = null;
	private JTextField time;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Odoctor frame = new Odoctor();
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
	public Odoctor() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Mamun Sheikh\\Downloads\\medical-icon.png"));
		cn = (Connection) SQLConnection.ConnecrDb();
		setTitle("Doctor add portal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 711, 443);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Doctor Name:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(26, 126, 104, 14);
		contentPane.add(lblNewLabel);

		JLabel lblAddDoctorHere = new JLabel("Add Doctor here");
		lblAddDoctorHere.setForeground(Color.PINK);
		lblAddDoctorHere.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAddDoctorHere.setBounds(65, 60, 104, 14);
		contentPane.add(lblAddDoctorHere);

		dname = new JTextField();
		dname.setBounds(26, 146, 189, 20);
		contentPane.add(dname);
		dname.setColumns(10);

		JLabel lblDepartment = new JLabel("Department:");
		lblDepartment.setForeground(Color.WHITE);
		lblDepartment.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDepartment.setBounds(26, 174, 104, 14);
		contentPane.add(lblDepartment);

		dept = new JTextField();
		dept.setColumns(10);
		dept.setBounds(26, 198, 189, 20);
		contentPane.add(dept);

		JLabel lblFees = new JLabel("Fees:");
		lblFees.setForeground(Color.WHITE);
		lblFees.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFees.setBounds(26, 221, 104, 14);
		contentPane.add(lblFees);

		fee = new JTextField();
		fee.setColumns(10);
		fee.setBounds(26, 240, 189, 20);
		contentPane.add(fee);

		JLabel lblCurrentA = new JLabel("Current available doctor list");
		lblCurrentA.setForeground(Color.WHITE);
		lblCurrentA.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCurrentA.setBounds(404, 43, 213, 14);
		contentPane.add(lblCurrentA);

		JLabel lblNewLabel_1 = new JLabel("Anam Medical College");
		lblNewLabel_1.setForeground(SystemColor.menu);
		lblNewLabel_1.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		lblNewLabel_1.setBounds(214, 0, 205, 32);
		contentPane.add(lblNewLabel_1);

		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String ddid = did.getText();
				String ddname = dname.getText();
				String ddept = dept.getText();
				String dfee = fee.getText();
				String sh = time.getText();

				String sql = "INSERT INTO list (id ,name, department, fees,schedule) VALUES (?,?,?,?,?)";
				try {
					ss = cn.prepareStatement(sql);
					ss.setString(1, ddid);
					ss.setString(2, ddname);
					ss.setString(3, ddept);
					ss.setString(4, dfee);
					ss.setString(5, sh);
					ss.execute();
					JOptionPane.showMessageDialog(null, "Doctor add successful");
					loadData(); // Refresh the table
					
					// Clear input fields
					dname.setText("");
					dept.setText("");
					fee.setText("");
					did.setText("");
					
				} catch (Exception e2) {
					System.out.println("Data not inserted");
				}

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(65, 327, 89, 23);
		contentPane.add(btnNewButton);

		did = new JTextField();
		did.setColumns(10);
		did.setBounds(26, 104, 189, 20);
		contentPane.add(did);

		JLabel lblDoctorId = new JLabel("Doctor ID:");
		lblDoctorId.setForeground(Color.WHITE);
		lblDoctorId.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDoctorId.setBounds(26, 88, 104, 14);
		contentPane.add(lblDoctorId);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(266, 60, 419, 303);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		// Define table columns
		model = new DefaultTableModel();
		model.addColumn("Doctor ID");
		model.addColumn("Doctor Name");
		model.addColumn("Department");
		model.addColumn("Fees");
		model.addColumn("Schedule");
		
		table.setModel(model);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OfficialHome.main(null);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(10, 370, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Exit");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.setBounds(596, 374, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_1_1 = new JButton("Refersh");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Odoctor.main(null);
				dispose();
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1_1.setBounds(120, 370, 89, 23);
		contentPane.add(btnNewButton_1_1);
		
		JLabel lblTime = new JLabel("Time schedule");
		lblTime.setForeground(Color.WHITE);
		lblTime.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTime.setBounds(26, 271, 104, 14);
		contentPane.add(lblTime);
		
		time = new JTextField();
		time.setColumns(10);
		time.setBounds(26, 296, 189, 20);
		contentPane.add(time);

		loadData(); // Load initial data from the database
	}

	// Load data from the database and populate the table
	// Load data from the database and populate the table
	private void loadData() {
	    model.setRowCount(0); // Clear existing rows

	    String sql = "SELECT * FROM list";
	    try {
	        java.sql.PreparedStatement ps = cn.prepareStatement(sql);
	        java.sql.ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            String id = rs.getString("id");
	            String name = rs.getString("name");
	            String department = rs.getString("department");
	            String fees = rs.getString("fees");
	            String schedule = rs.getString("schedule"); // Retrieve the schedule data
	            
	            model.addRow(new Object[] { id, name, department, fees, schedule }); // Add the schedule data to the table model
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	
}
