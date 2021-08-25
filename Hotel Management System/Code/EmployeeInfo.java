import java.awt.BorderLayout;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.proteanit.sql.DbUtils;
import javax.swing.JTable;
import java.sql.*;	
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class EmployeeInfo extends JFrame implements ActionListener
{
	private JPanel contentPane;
	private JTable table;
	private JLabel lblNewLabel;
	private JLabel lblJob;
	private JLabel lblName;
	private JLabel lblDepartment;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeInfo frame = new EmployeeInfo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void close()
	{
		this.dispose();
	} 
	
	public EmployeeInfo() throws SQLException 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(160, 40, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setVisible(true);
		
		table = new JTable();
		table.setBounds(0, 34, 1000, 450);
		contentPane.add(table);
		
		JButton btnLoadData = new JButton("Load Data");
		btnLoadData.setBounds(350, 500, 120, 30);
		btnLoadData.setBackground(Color.BLACK);
        btnLoadData.setForeground(Color.WHITE);
		contentPane.add(btnLoadData);
		btnLoadData.addActionListener(this);
		
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Reception().setVisible(true);
                                setVisible(false);
			}
		});
		btnExit.setBounds(510, 500, 120, 30);
		btnExit.setBackground(Color.BLACK);
		btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);
		
		lblNewLabel = new JLabel("Employee Id");
		lblNewLabel.setBounds(25, 11, 73, 14);
		contentPane.add(lblNewLabel);
		
		lblJob = new JLabel("Name");
		lblJob.setBounds(159, 11, 46, 14);
		contentPane.add(lblJob);
		
		lblName = new JLabel("Age");
		lblName.setBounds(280, 11, 35, 14);
		contentPane.add(lblName);
		
		lblDepartment = new JLabel("Gender");
		lblDepartment.setBounds(416, 11, 86, 14);
		contentPane.add(lblDepartment);
                
        JLabel l1 = new JLabel("Job");
		l1.setBounds(536, 11, 86, 14);
		contentPane.add(l1);
                
		JLabel l2 = new JLabel("Salary");
		l2.setBounds(656, 11, 86, 14);
		contentPane.add(l2);
                
        JLabel l3 = new JLabel("Phone");
	    l3.setBounds(786, 11, 86, 14);
		contentPane.add(l3);
                
        JLabel l4 = new JLabel("Email");
		l4.setBounds(896, 11, 86, 14);
		contentPane.add(l4);
                
		getContentPane().setBackground(Color.WHITE);
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		try
		{
            Connection con = new MyConnection().getConnection();
            Statement st=con.createStatement();
            String displayCustomersql="select * from employee";
			ResultSet rs =st.executeQuery(displayCustomersql);
		    table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch(Exception e1)
		{
				e1.printStackTrace();
		}
		
	}
}