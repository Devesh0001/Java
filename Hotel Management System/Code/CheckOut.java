import java.awt.BorderLayout;
import java.awt.*;
import java.awt.EventQueue;
import java.sql.*;	
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.*;
import java.awt.event.ActionEvent;
public class CheckOut extends JFrame
{	
	PreparedStatement pst = null;
	private JPanel contentPane;
	private JTextField t1;
    Choice c1;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckOut frame = new CheckOut();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void close(){
		this.dispose();
	}
	public CheckOut() throws SQLException 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(240, 150, 800, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
		setResizable(false);
                
		JLabel lblCheckOut = new JLabel(" Check Out ");
		lblCheckOut.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblCheckOut.setBounds(70, 33, 140, 35);
		contentPane.add(lblCheckOut);
		
		JLabel lblName = new JLabel("Number :");
		lblName.setBounds(20, 119, 80, 14);
		contentPane.add(lblName);
         c1 = new Choice();
                try{
                    Connection con = new MyConnection().getConnection();
                    Statement st=con.createStatement();
                    ResultSet rs=st.executeQuery("select * from customertable");
                    while(rs.next()){
                        c1.add(rs.getString("number"));    
                    }
                }catch(Exception e){ }
         c1.setBounds(130, 119, 150, 20);
		 contentPane.add(c1);
                
		JLabel lblRoomNumber = new JLabel("Room Number:");
		lblRoomNumber.setBounds(20, 165, 86, 20);
		contentPane.add(lblRoomNumber);
		
		t1 = new JTextField();
        t1.setBounds(130, 165, 150, 20);
		contentPane.add(t1);
                
		JButton btnCheckOut = new JButton("Check Out");
		btnCheckOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                String id = c1.getSelectedItem();
                String s1 = t1.getText();
				String deleteSQL = "Delete from customertable where number = "+id;
                String q2 = "update roomtable set availability = 'Available' where roomno = "+s1;    
				try
	    		{
					Connection con = new MyConnection().getConnection();
					Statement st=con.createStatement();
	    			st.executeUpdate(deleteSQL);
	    			st.executeUpdate(q2);
	    			JOptionPane.showMessageDialog(null, "Check Out Successful");
	    			new Reception().setVisible(true);
                                setVisible(false);
	    		}catch(SQLException e1){
	    			System.out.println(e1.getMessage());
	    		}
			}
		});
		btnCheckOut.setBounds(51, 225, 100, 25);
		btnCheckOut.setBackground(Color.BLACK);
        btnCheckOut.setForeground(Color.WHITE);
		contentPane.add(btnCheckOut);
		
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Reception().setVisible(true);
                                setVisible(false);
			}
		});
		btnExit.setBounds(161, 225, 100, 25);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);
                
        getContentPane().setBackground(Color.WHITE);
        
        JLabel lblNewLabel = new JLabel("");
        Image img=new ImageIcon(this.getClass().getResource("/check-out.jpg")).getImage();
        lblNewLabel.setIcon(new ImageIcon(img));
        lblNewLabel.setBounds(288, 24, 473, 263);
        contentPane.add(lblNewLabel);
	}
}