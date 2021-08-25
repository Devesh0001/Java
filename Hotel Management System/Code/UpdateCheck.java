import java.awt.BorderLayout;
import java.awt.*;
import java.sql.*;	 
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class UpdateCheck extends JFrame 
{
	private JPanel contentPane;
  	private JTextField txt_Room;
  	private JTextField txt_Name;
  	private JTextField txt_Date;
  	private JTextField txt_payed;
  	private JTextField txt_Payment;
    Choice c1, c2;            	
    public static void main(String[] args) {
    	EventQueue.invokeLater(new Runnable() {
    		public void run() {
    			try {
    				UpdateCheck frame = new UpdateCheck();
    				frame.setVisible(true);
    				} 
    			catch (Exception e) 
    			{
    				e.printStackTrace();
       			}
    			}
    		});
               	}
    public void close(){
    	this.dispose();
                	}
    public UpdateCheck() throws SQLException {
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setBounds(160, 100, 950, 500);
    	contentPane = new JPanel();
    	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    	setContentPane(contentPane);
    	contentPane.setLayout(null);
    	setVisible(true);
    	setResizable(false);
          		
    	JLabel lblUpdateCheckStatus = new JLabel("Check-In Details");
    	lblUpdateCheckStatus.setFont(new Font("Tahoma", Font.PLAIN, 20));
    	lblUpdateCheckStatus.setBounds(124, 11, 222, 25);
    	contentPane.add(lblUpdateCheckStatus);
                                
    	JLabel lblNewLabel_6 = new JLabel("");
    	Image img=new ImageIcon(this.getClass().getResource("/updatecheck.jpg")).getImage();
    	lblNewLabel_6.setIcon(new ImageIcon(img));
    	lblNewLabel_6.setBounds(504, 51, 231, 315);
    	contentPane.add(lblNewLabel_6);
     
    	JLabel lblNewLabel = new JLabel("ID:");
    	lblNewLabel.setBounds(25, 88, 46, 14);
    	contentPane.add(lblNewLabel);
    	c1 = new Choice();
    	try{
    		Connection con = new MyConnection().getConnection();
    		Statement st=con.createStatement();
    		ResultSet rs = st.executeQuery("select * from customertable");
    		while(rs.next()){
    			c1.add(rs.getString("number"));    
    			}
    		}
    	catch(Exception e){
    		e.printStackTrace();
    	}
    	c1.setBounds(248, 85, 140, 20);
    	contentPane.add(c1);
                		        		
    	JLabel lblNewLabel_1 = new JLabel("Room Number :");
        lblNewLabel_1.setBounds(25, 129, 107, 14);
        contentPane.add(lblNewLabel_1);
        txt_Room = new JTextField();
        txt_Room.setBounds(248, 126, 140, 20);
        contentPane.add(txt_Room);
        
        JLabel lblNewLabel_2 = new JLabel("Name : ");
        lblNewLabel_2.setBounds(25, 174, 97, 14);
        contentPane.add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("Checked-in :");
        lblNewLabel_3.setBounds(25, 216, 107, 14);
        contentPane.add(lblNewLabel_3);
                		
        JLabel lblNewLabel_4 = new JLabel("Amount Paid (Rs) : ");
        lblNewLabel_4.setBounds(25, 261, 107, 14);
        contentPane.add(lblNewLabel_4);
                		
        JLabel lblNewLabel_5 = new JLabel("Pending Amount (Rs) : ");
        lblNewLabel_5.setBounds(25, 302, 150, 14);
        contentPane.add(lblNewLabel_5);

        txt_Name = new JTextField();
        txt_Name.setBounds(248, 171, 140, 20);
        contentPane.add(txt_Name);
        txt_Name.setColumns(10);
                		
        txt_Date = new JTextField();
        txt_Date.setBounds(248, 216, 140, 20);
        contentPane.add(txt_Date);
        txt_Date.setColumns(10);
               		
        txt_payed = new JTextField();
        txt_payed.setBounds(248, 258, 140, 20);
        contentPane.add(txt_payed);
        txt_payed.setColumns(10);
                		
        txt_Payment = new JTextField();
        txt_Payment.setBounds(248, 299, 140, 20);
        contentPane.add(txt_Payment);
        txt_Payment.setColumns(10);
        JButton btnUpdate = new JButton("Update");
        btnUpdate.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ae) { 
        	try{
        		Connection con = new MyConnection().getConnection();
        		Statement st=con.createStatement();
        		String s1 = c1.getSelectedItem();
        		String s2 = txt_Room.getText(); //room_number;    
        		String s3 = txt_Name.getText(); //name    
        		String s4 = txt_Date.getText(); //status;    
        		String s5 = txt_payed.getText(); //deposit        				
        		st.executeUpdate("update customertable set ARN = '"+s2+"', name = '"+s3+"', CheckedIn = '"+s4+"', deposit = '"+s5+"' where number = '"+s1+"'");                                
        		JOptionPane.showMessageDialog(null, "Data Updated Successfully");
                new Reception().setVisible(true);
                setVisible(false);
               }
        	catch(Exception ee){
        		System.out.println(ee);
                             }				
        	}
        });
        btnUpdate.setBounds(168, 378, 89, 23);
        btnUpdate.setBackground(Color.BLACK);
        btnUpdate.setForeground(Color.WHITE);
        contentPane.add(btnUpdate);
        
        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new Reception().setVisible(true);
        		setVisible(false);
               			}
        	});
        btnExit.setBounds(281, 378, 89, 23);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        contentPane.add(btnExit);
                               
          		getContentPane().setBackground(Color.WHITE);
          		
          		JButton btnNewButton = new JButton("Check");
          		btnNewButton.setBackground(Color.BLACK);
          		btnNewButton.setForeground(Color.WHITE);
          		btnNewButton.addActionListener(new ActionListener() {
          			public void actionPerformed(ActionEvent arg0) {
                		try {
                			String room=null;
                			String deposit=null;
                			String price=null;
                			int topay;
                			Connection con = new MyConnection().getConnection();
                			Statement st=con.createStatement();
                			String id=c1.getSelectedItem();
                			String str="select * from customertable where number = '"+id+"'";
                			ResultSet rs=st.executeQuery(str);
                			while(rs.next()){
                				txt_Room.setText(rs.getString("ARN"));
                				txt_Name.setText(rs.getString("Name"));
                				txt_Date.setText(rs.getString("CheckedIn"));
                				txt_payed.setText(rs.getString("Deposit"));
                				room=rs.getString("ARN");
                				deposit=rs.getString("Deposit");
                			}
                			ResultSet rs1=st.executeQuery("select * from roomtable where RoomNo = '"+room+"'");
                			while(rs1.next()) {
                				price=rs1.getString("Price");
                				topay=Integer.parseInt(price)-Integer.parseInt(deposit);
                				txt_Payment.setText(Integer.toString(topay));
                			}
						} 
                		catch (SQLException e) {
							e.printStackTrace();
						}
                		
          			}
          		});
          		btnNewButton.setBounds(43, 378, 89, 23);
          		contentPane.add(btnNewButton);
                	}
                }