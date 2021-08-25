import java.awt.BorderLayout;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import net.proteanit.sql.DbUtils;
import java.sql.*;	
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Room extends JFrame implements ActionListener
{

	private JPanel contentPane;
	private JTable table;
	private JLabel lblAvailability;
	private JLabel lblCleanStatus;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1; 
	private JLabel lblRoomNumber;
	private JLabel lblId;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try 
				{
					Room frame = new Room();
					frame.setVisible(true);
   				} catch (Exception e) 
				{
   					e.printStackTrace();
       			}
                			}
                		});
		}

	public Room() throws SQLException 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(80, 40, 1125, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
		setResizable(false);
		
		JLabel lblNewLabel_2 = new JLabel("");
		Image img=new ImageIcon(this.getClass().getResource("/rsz_123.jpg")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img));
		lblNewLabel_2.setBounds(517, 11, 574, 503);
		contentPane.add(lblNewLabel_2);
    
		table = new JTable();
		table.setBounds(0, 40, 500, 400);
		contentPane.add(table);
            		
		JButton btnLoadData = new JButton("Load Data");
		btnLoadData.addActionListener(this); 
                	        		
       	btnLoadData.setBounds(100, 470, 120, 30);
       	btnLoadData.setBackground(Color.BLACK);
       	btnLoadData.setForeground(Color.WHITE);
       	contentPane.add(btnLoadData);
                		
       	JButton btnNewButton = new JButton("Back");
       	btnNewButton.addActionListener(new ActionListener() {
       	public void actionPerformed(ActionEvent e) {
       		new Reception().setVisible(true);
       		setVisible(false);
       		}
       	});
       	btnNewButton.setBounds(290, 470, 120, 30);
       	btnNewButton.setBackground(Color.BLACK);
       	btnNewButton.setForeground(Color.WHITE);
       	contentPane.add(btnNewButton);
                		
       	lblAvailability = new JLabel("Availability");
       	lblAvailability.setBounds(119, 15, 69, 14);
       	contentPane.add(lblAvailability);
                		
       	lblCleanStatus = new JLabel("Clean Status");
       	lblCleanStatus.setBounds(216, 15, 76, 14);
       	contentPane.add(lblCleanStatus);
                		
       	lblNewLabel = new JLabel("Price");
       	lblNewLabel.setBounds(330, 15, 46, 14);
       	contentPane.add(lblNewLabel);
                		
       	lblNewLabel_1 = new JLabel("Bed Type");
       	lblNewLabel_1.setBounds(417, 15, 76, 14);
       	contentPane.add(lblNewLabel_1);
        		
       	lblId = new JLabel("Room Number");
       	lblId.setBounds(5, 15, 100, 14);
       	contentPane.add(lblId);
       	                        
       	getContentPane().setBackground(Color.WHITE);
       	                        
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		try
		{
			Connection con = new MyConnection().getConnection();
			Statement st=con.createStatement();
			String displayCustomersql = "select * from roomtable";
			ResultSet rs = st.executeQuery(displayCustomersql);
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
		}
						
	}

}