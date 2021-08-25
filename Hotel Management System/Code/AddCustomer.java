import java.awt.BorderLayout;
import java.awt.*;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.Image;
import java.sql.*;	
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class AddCustomer extends JFrame implements ActionListener 
{
	private JPanel contentPane;
	private JTextField t1,t2,t3,t4,t5;
	JComboBox comboBox;
    JRadioButton r1,r2;
    Choice c1;
    ButtonGroup btgrp=null;
    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCustomer frame = new AddCustomer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AddCustomer() throws SQLException 
	{
		setBounds(240, 60, 850, 550);
   		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
        setResizable(false);
        btgrp=new ButtonGroup();
		
		JLabel lblName = new JLabel("NEW CUSTOMER FORM");
		lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
		lblName.setBounds(118, 11, 260, 53);
		contentPane.add(lblName);
                
		JLabel lblId = new JLabel("ID :");
		lblId.setBounds(35, 76, 200, 14);
		contentPane.add(lblId);
                
		comboBox = new JComboBox(new String[] {" ","Passport", "Aadhar Card", "Voter Id", "Driving license"});
		comboBox.setBounds(271, 73, 150, 20);
		contentPane.add(comboBox);
                
		JLabel l2 = new JLabel("Number :");
		l2.setBounds(35, 111, 200, 14);
		contentPane.add(l2);
                
		t1 = new JTextField();
		t1.setBounds(271, 111, 150, 20);
		contentPane.add(t1);
		t1.setColumns(10);
		
		JLabel lblName_1 = new JLabel("Name :");
		lblName_1.setBounds(35, 151, 200, 14);
		contentPane.add(lblName_1);
		
		t2 = new JTextField();
		t2.setBounds(271, 151, 150, 20);
		contentPane.add(t2);
		t2.setColumns(10);

                
		JLabel lblGender = new JLabel("Gender :");
		lblGender.setBounds(35, 191, 200, 14);
		contentPane.add(lblGender);
                
        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        r1.setBackground(Color.WHITE);
        r1.setBounds(271, 191, 80, 12);
        r1.setActionCommand("MALE");
        btgrp.add(r1);
        getContentPane().add(r1);
                
        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350, 191, 100, 12);
        r2.setActionCommand("FEMALE");
        btgrp.add(r2);
		getContentPane().add(r2);
                
		JLabel lblCountry = new JLabel("Country :");
		lblCountry.setBounds(35, 231, 200, 14);
		contentPane.add(lblCountry);
		
		JLabel lblReserveRoomNumber = new JLabel("Allocated Room Number :");
		lblReserveRoomNumber.setBounds(35, 274, 200, 14);
		contentPane.add(lblReserveRoomNumber);
		c1 = new Choice();
        try
        {
        	String a="Available";
        	String b="Cleaned";
            Connection con = new MyConnection().getConnection();
            Statement st=con.createStatement();
            ResultSet rs = st.executeQuery("select roomno from roomtable where availability='"+a+"' and CleaningStatus='"+b+"'");
            while(rs.next())
            {
                c1.add(rs.getString("roomno"));    
            }
        }
        catch(Exception e)    
        { 
        	e.printStackTrace();
        }
        c1.setBounds(271, 274, 150, 20);
        contentPane.add(c1);
                		
		JLabel lblCheckInStatus = new JLabel("Checked-In :");
		lblCheckInStatus.setBounds(35, 316, 200, 14);
		contentPane.add(lblCheckInStatus);
		
		JLabel lblDeposite = new JLabel("Deposit :");
		lblDeposite.setBounds(35, 359, 200, 14);
		contentPane.add(lblDeposite);
		
		t3 = new JTextField();
		t3.setBounds(271, 231, 150, 20);
		contentPane.add(t3);
		t3.setColumns(10);
		
		
		t4 = new JTextField();
		t4.setBounds(271, 316, 150, 20);
		contentPane.add(t4);
		t4.setColumns(10);
		
		t5 = new JTextField();
		t5.setBounds(271, 359, 150, 20);
		contentPane.add(t5);
		t5.setColumns(10);

		JButton btnNewButton = new JButton("Add");
		btnNewButton.setBounds(100, 430, 120, 30);
        btnNewButton.setBackground(Color.BLACK);
        btnNewButton.setForeground(Color.WHITE);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(this);
		
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            new Reception().setVisible(true);
                            setVisible(false);
			}
		}); 
		btnExit.setBounds(260, 430, 120, 30);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);
                
        getContentPane().setBackground(Color.WHITE);
               
        JLabel lblNewLabel = new JLabel("");
        Image img=new ImageIcon(this.getClass().getResource("/LogBook_1.png")).getImage();
        lblNewLabel.setIcon(new ImageIcon(img));
        lblNewLabel.setBounds(569, 76, 100, 165);
        contentPane.add(lblNewLabel);
                
        JLabel lblNewLabel_1 = new JLabel("");
        Image img1=new ImageIcon(this.getClass().getResource("/BookingDiary.png")).getImage();
        lblNewLabel_1.setIcon(new ImageIcon(img1));
        lblNewLabel_1.setBounds(569, 252, 100, 157);
        contentPane.add(lblNewLabel_1);
                
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String id=(String) comboBox.getSelectedItem();
		String number=t1.getText();
		String name=t2.getText();
		String country=t3.getText();
	    String checkin=t4.getText();
	    String deposite=t5.getText();
	    String arn=c1.getSelectedItem();
	    String gender="";
	    if(id.trim().equals("") || number.trim().equals("")|| name.trim().equals("")|| country.trim().equals("")|| checkin.trim().equals("") || deposite.trim().equals(""))
		{
			JOptionPane.showMessageDialog(null, "Please fill all the fields");
			try
			{
				gender=btgrp.getSelection().getActionCommand();
			}
			catch(Exception e1)
			{
				JOptionPane.showMessageDialog(null, "Please choose the gender fields");
			}
		}
	    else {
			try
			{
				gender=btgrp.getSelection().getActionCommand();
				Connection con=new MyConnection().getConnection();
				PreparedStatement pst=con.prepareStatement("insert into customertable (id,number,name,gender,country,ARN,checkedin,deposit)values(?,?,?,?,?,?,?,?)");
				pst.setString(1, id);
				pst.setString(2, number);
				pst.setString(3, name);
				pst.setString(4, gender);
				pst.setString(5, country);
				pst.setString(6, arn);
				pst.setString(7, checkin);
				pst.setString(8, deposite);
				pst.executeUpdate();
				JOptionPane.showMessageDialog(null, "Data Successfully entered");
				PreparedStatement pst1=con.prepareStatement("update roomtable set availability = 'Occupied' where roomno= "+arn);
				pst1.executeUpdate();
				new Reception().setVisible(true);
                setVisible(false);
			}
		    catch(Exception exp)
		    { 
		    	exp.printStackTrace();
		    } 
	    }
	}
}