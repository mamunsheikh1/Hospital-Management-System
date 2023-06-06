package Hospital_Management;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import com.mysql.jdbc.Connection;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PatientList extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private DefaultTableModel model;
    Connection cn = null;

    // Database column names
    private static final String[] COLUMN_NAMES = { "Name", "Email", "Gender", "Age" };
    private JLabel lblNewLabel;
    private JLabel lblHereAllRegister;
    private JButton btnNewButton;
    private JButton btnRefresh;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PatientList frame = new PatientList();
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
    public PatientList() {
    	setTitle("Patient List and info");
    	setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Mamun Sheikh\\Downloads\\medical-icon.png"));
        cn = (Connection) SQLConnection.ConnecrDb(); // Establish database connection

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 702, 553);
        contentPane = new JPanel();
        contentPane.setBackground(Color.BLACK);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 117, 666, 386);
        contentPane.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);

        // Define table columns
        model = new DefaultTableModel();
        model.setColumnIdentifiers(COLUMN_NAMES);
        table.setModel(model);
        
        lblNewLabel = new JLabel("Anam Medical College");
        lblNewLabel.setForeground(SystemColor.menu);
        lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
        lblNewLabel.setBounds(250, 0, 205, 32);
        contentPane.add(lblNewLabel);
        
        lblHereAllRegister = new JLabel("Here all registered patient information :");
        lblHereAllRegister.setForeground(Color.WHITE);
        lblHereAllRegister.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblHereAllRegister.setBounds(10, 92, 303, 25);
        contentPane.add(lblHereAllRegister);
        
        btnNewButton = new JButton("Back");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		OfficialHome.main(null);
        		dispose();
        	}
        });
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnNewButton.setBounds(587, 83, 89, 23);
        contentPane.add(btnNewButton);
        
        btnRefresh = new JButton("Refresh");
        btnRefresh.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		PatientList.main(null);
        		dispose();
        	}
        });
        btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnRefresh.setBounds(488, 84, 89, 23);
        contentPane.add(btnRefresh);

        loadData(); // Load data from the database and populate the table
    }

    // Load data from the database and populate the table
    private void loadData() {
        model.setRowCount(0); // Clear existing rows

        String sql = "SELECT * FROM user";
        try {
            java.sql.PreparedStatement ps = cn.prepareStatement(sql);
            java.sql.ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String gender = rs.getString("gender");
                int age = rs.getInt("age");
                
                model.addRow(new Object[] { name, email, gender, age });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
