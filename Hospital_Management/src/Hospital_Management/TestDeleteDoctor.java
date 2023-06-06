package Hospital_Management;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.mysql.jdbc.Connection;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Toolkit;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class TestDeleteDoctor extends JFrame {

    private JPanel contentPane;
    private JTextField tf9;
    Connection cn = null;
    java.sql.PreparedStatement pp = null;
    private JTable table;
    private DefaultTableModel model;

    // Database column names
    private static final String[] COLUMN_NAMES = { "Doctor ID", "Doctor Name", "Department", "Fees","Schedule" };
    private JButton btnRefresh;
    private JButton btnBack;
    private JLabel lblNewLabel;
    private JLabel lblToTakeA;
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel_2;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TestDeleteDoctor frame = new TestDeleteDoctor();
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
    public TestDeleteDoctor() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Mamun Sheikh\\Downloads\\medical-icon.png"));
    	setTitle("Doctor appointment system");

        cn = (Connection) SQLConnection.ConnecrDb();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 788, 459);
        contentPane = new JPanel();
        contentPane.setBackground(Color.BLACK);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        tf9 = new JTextField();
        tf9.setBounds(521, 291, 181, 20);
        contentPane.add(tf9);
        tf9.setColumns(10);

        JButton btnNewButton = new JButton("Confirm");
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnNewButton.addActionListener(new ActionListener() {
        	  public void actionPerformed(ActionEvent e) {
        	        String bid = tf9.getText();

        	        if (bid.isEmpty()) {
        	            JOptionPane.showMessageDialog(null, "Please fill the doctor ID");
        	            return; // Stop further execution
        	        }

        	        try {
        	            pp = cn.prepareStatement("delete from list where id=?");
        	            pp.setString(1, bid);
        	            pp.executeUpdate();

        	            JOptionPane.showMessageDialog(null, "Doctor appointment done");

        	            tf9.requestFocus();
        	            AppoinmentNotic.main(null);
        	            dispose();
        	        } catch (Exception e2) {
        	            System.out.println("Data not inserted");
        	        }
        	    }
        });
        btnNewButton.setBounds(575, 322, 89, 23);
        contentPane.add(btnNewButton);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 56, 446, 353);
        contentPane.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);

        // Define table columns
        model = new DefaultTableModel();
        model.setColumnIdentifiers(COLUMN_NAMES);
        table.setModel(model);
        
        btnRefresh = new JButton("Refresh");
        btnRefresh.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		TestDeleteDoctor.main(null);
        		dispose();
        		
        	}
        });
        btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnRefresh.setBounds(466, 386, 89, 23);
        contentPane.add(btnRefresh);
        
        btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		LHome.main(null);
        		dispose();
        	}
        });
        btnBack.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnBack.setBounds(661, 386, 71, 23);
        contentPane.add(btnBack);
        
        JLabel lblHereYouCan = new JLabel("Here you can see current available doctor info:");
        lblHereYouCan.setForeground(Color.WHITE);
        lblHereYouCan.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblHereYouCan.setBounds(10, 39, 303, 14);
        contentPane.add(lblHereYouCan);
        
        lblNewLabel = new JLabel("Anam Medical College");
        lblNewLabel.setForeground(SystemColor.menu);
        lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
        lblNewLabel.setBounds(280, 0, 205, 32);
        contentPane.add(lblNewLabel);
        
        lblToTakeA = new JLabel("To take an appointment enter the doctor's id");
        lblToTakeA.setForeground(Color.WHITE);
        lblToTakeA.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblToTakeA.setBounds(466, 266, 296, 14);
        contentPane.add(lblToTakeA);
        
        lblNewLabel_1 = new JLabel("Easy to appointment if you needed");
        lblNewLabel_1.setBackground(new Color(240, 240, 240));
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setBounds(484, 35, 236, 23);
        contentPane.add(lblNewLabel_1);
        
        lblNewLabel_2 = new JLabel("Easy to appointment i you needed");
        lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Mamun Sheikh\\Downloads\\images-removebg-preview.png"));
        lblNewLabel_2.setForeground(Color.PINK);
        lblNewLabel_2.setFont(new Font("Tempus Sans ITC", Font.BOLD, 13));
        lblNewLabel_2.setBounds(506, 56, 236, 194);
        contentPane.add(lblNewLabel_2);

        loadData(); // Load data from the database and populate the table
    }

    // Load data from the database and populate the table
 // Load data from the database and populate the table
    private void loadData() {
        model.setRowCount(0); // Clear existing rows

        String sql = "SELECT * FROM list";
        try {
            java.sql.PreparedStatement ps = cn.prepareStatement(sql);
            java.sql.ResultSet rs = ps.executeQuery();
            if (!rs.isBeforeFirst()) {
                // If the result set is empty, add a single row with the message
                model.addRow(new Object[] { "", "", "", "", "All doctors are booked" });
            } else {
                while (rs.next()) {
                    String id = rs.getString("id");
                    String name = rs.getString("name");
                    String department = rs.getString("department");
                    String fees = rs.getString("fees");
                    String schedule = rs.getString("schedule"); // Retrieve the schedule data

                    model.addRow(new Object[] { id, name, department, fees, schedule }); // Add the schedule data to the table model
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
