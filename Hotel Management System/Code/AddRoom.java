import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class AddRoom extends JFrame implements ActionListener
{

    private JPanel contentPane;
    private JTextField t1,t2;
    private JComboBox comboBox, comboBox_1, comboBox_2;
    JButton b1,b2;
    Choice c1;
    private JLabel lblNewLabel;

    public static void main(String[] args) {
        new AddRoom().setVisible(true);
    }

        public AddRoom() {
        setBounds(160, 110, 1000, 450);
    	contentPane = new JPanel();
    	setContentPane(contentPane);
    	contentPane.setLayout(null);     
        
        JLabel l10 = new JLabel("Add Rooms");
        l10.setFont(new Font("Tahoma", Font.BOLD, 18));
    	l10.setBounds(194, 10, 120, 22);
    	contentPane.add(l10);
         
    	JLabel l1 = new JLabel("Room Number");
    	l1.setForeground(new Color(25, 25, 112));
    	l1.setFont(new Font("Tahoma", Font.BOLD, 14));
  	    l1.setBounds(64, 70, 102, 22);
	    contentPane.add(l1);
        
        t1 = new JTextField();
	    t1.setBounds(194, 73, 156, 20);
	    contentPane.add(t1);
        

    	JLabel l2 = new JLabel("Availability");
    	l2.setForeground(new Color(25, 25, 112));
    	l2.setFont(new Font("Tahoma", Font.BOLD, 14));
	    l2.setBounds(64, 110, 102, 22);
	    contentPane.add(l2);
        
        comboBox = new JComboBox(new String[] { "","Available", "Occupied" });
    	comboBox.setBounds(196, 113, 154, 20);
    	contentPane.add(comboBox);

	    JLabel l3 = new JLabel("Cleaning Status");
	    l3.setForeground(new Color(25, 25, 112));
	    l3.setFont(new Font("Tahoma", Font.BOLD, 14));
	    l3.setBounds(64, 150, 122, 22);
	    contentPane.add(l3);
        
        comboBox_1 = new JComboBox(new String[] {"", "Cleaned", "Dirty" });
	    comboBox_1.setBounds(196, 153, 154, 20);
	    contentPane.add(comboBox_1);
	    
	    JLabel l4 = new JLabel("Price");
	    l4.setForeground(new Color(25, 25, 112));
	    l4.setFont(new Font("Tahoma", Font.BOLD, 14));
	    l4.setBounds(64, 190, 102, 22);
	    contentPane.add(l4);
        
        t2 = new JTextField();
	    t2.setBounds(194, 193, 156, 20);
	    contentPane.add(t2);

        JLabel l5 = new JLabel("Bed Type");
    	l5.setForeground(new Color(25, 25, 112));
    	l5.setFont(new Font("Tahoma", Font.BOLD, 14));
    	l5.setBounds(64, 230, 102, 22);
    	contentPane.add(l5);


        comboBox_2 = new JComboBox(new String[] { "","Single Bed", "Double Bed"});
	    comboBox_2.setBounds(196, 233, 154, 20);
	    contentPane.add(comboBox_2);
	    
	    b1 = new JButton("Add Room");
	    b1.setBounds(64, 321, 111, 33);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
	    contentPane.add(b1);
	    b1.addActionListener(this);

    	b2 = new JButton("Cancel");
	    b2.setBounds(198, 321, 111, 33);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
	    contentPane.add(b2);
	    b2.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e) {
				dispose();
	    }
		    });
	
	
        contentPane.setBackground(Color.WHITE);
        
        lblNewLabel = new JLabel("");
        Image img=new ImageIcon(this.getClass().getResource("/rsz_2room.jpg")).getImage();
        lblNewLabel.setIcon(new ImageIcon(img));
        lblNewLabel.setBounds(464, 58, 426, 284);
        contentPane.add(lblNewLabel);
        
        setVisible(true);
        setBounds(160, 110, 1000, 450);
        setResizable(false);
    
    }


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String rnum=t1.getText();
		String price=t2.getText();
		String availability=(String) comboBox.getSelectedItem();
		String cleanings=(String)comboBox_1.getSelectedItem();
		String bedtype=(String)comboBox_2.getSelectedItem();
		if(rnum.trim().equals("") || price.trim().equals("")|| availability.trim().equals("")|| cleanings.trim().equals("")|| bedtype.trim().equals(""))
		{
			JOptionPane.showMessageDialog(null, "Please fill all the fields");
		}
		else
		{
			try
			{
				int fixedrooms=0,numberofrooms=0;
				Connection con=new MyConnection().getConnection();
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery("select rooms from numberofrooms");
				if(rs.next())
				{
					fixedrooms=rs.getInt("rooms");					
				}
				Statement st3=con.createStatement();
				ResultSet rs3=st3.executeQuery("select count(roomno) as rooms from roomtable");
				if(rs3.next())
				{
					numberofrooms=rs3.getInt("rooms");
				}	
				if(numberofrooms>=fixedrooms)
				{
					JOptionPane.showMessageDialog(null, "All rooms are configured");
				}
				else
				{
				PreparedStatement pst=con.prepareStatement("insert into roomtable (roomno,availability,cleaningstatus,price,bedtype)values(?,?,?,?,?)");
		        pst.setString(1, rnum);
				pst.setString(2, availability);
				pst.setString(3, cleanings);
				pst.setString(4, price);
				pst.setString(5, bedtype);
				pst.executeUpdate();
				JOptionPane.showMessageDialog(null, "Data Successfully entered");
				t1.setText("");
				t2.setText("");
				comboBox.setSelectedIndex(0);
				comboBox_1.setSelectedIndex(0);
				comboBox_2.setSelectedIndex(0);
				}}
			
		    catch(Exception exp)
		    { 
		    	exp.printStackTrace();
		    } 
		}	
	} 
}
