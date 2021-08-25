import javax.swing.*;

import java.sql.*;	
import java.awt.event.*;
import java.awt.*;

public class Reception extends JFrame implements ActionListener 
{

	private JPanel contentPane;

	public static void main(String[] args) {
		new Reception();
	}
	
	public Reception()
	{	
        setBounds(240, 50, 850, 570);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setVisible(true);
		
		JButton btnNewCustomerForm = new JButton("New Customer Form");
		btnNewCustomerForm.setBounds(10, 65, 200, 30);
        btnNewCustomerForm.setBackground(Color.BLACK);
        btnNewCustomerForm.setForeground(Color.WHITE);
		contentPane.add(btnNewCustomerForm);
		btnNewCustomerForm.addActionListener(this);
		
		
		JButton btnNewButton = new JButton("Room");
		btnNewButton.setBounds(10, 106, 200, 30);
        btnNewButton.setBackground(Color.BLACK);
        btnNewButton.setForeground(Color.WHITE);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		          try 
		          {
					Room room=new Room();
					room.setBounds(80, 40, 1125, 600);
					dispose();
			      } 
		          catch (SQLException e1) 
		          {
					e1.printStackTrace();
				  }
		    }  
		    });
		
		JButton btnNewButton_1 = new JButton("Department");
		btnNewButton_1.setBounds(10, 147, 200, 30);
        btnNewButton_1.setBackground(Color.BLACK);
        btnNewButton_1.setForeground(Color.WHITE);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		          try 
		          {
					Department dept=new Department();
					dept.setBounds(290, 80, 700, 500);
					dispose();
			      } 
		          catch (SQLException e1) 
		          {
					e1.printStackTrace();
				  }
		    }  
		    });
		
		JButton btnNewButton_2 = new JButton("All Employee Info");
		btnNewButton_2.setBounds(10, 188, 200, 30);                
        btnNewButton_2.setBackground(Color.BLACK);
        btnNewButton_2.setForeground(Color.WHITE);
		contentPane.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		          try 
		          {
					EmployeeInfo einfo=new EmployeeInfo();
					einfo.setBounds(160, 40, 1000, 600);
					dispose();
			      } 
		          catch (SQLException e1) 
		          {
					e1.printStackTrace();
				  }
		    }  
		    });
		
		JButton btnNewButton_3 = new JButton("Customer Info");
		btnNewButton_3.setBounds(10, 229, 200, 30);
        btnNewButton_3.setBackground(Color.BLACK);
        btnNewButton_3.setForeground(Color.WHITE);
		contentPane.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		          try 
		          {
					CustomerInfo cinfo=new CustomerInfo();
					cinfo.setBounds(220, 40, 900, 600);
					dispose();
			      } 
		          catch (SQLException e1) 
		          {
					e1.printStackTrace();
				  }
		    }  
		    });
		
		JButton btnNewButton_4 = new JButton("Check Out");
		btnNewButton_4.setBounds(10, 270, 200, 30);
        btnNewButton_4.setBackground(Color.BLACK);
        btnNewButton_4.setForeground(Color.WHITE);
		contentPane.add(btnNewButton_4);
		btnNewButton_4.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		          try 
		          {
					CheckOut cout= new CheckOut();
					cout.setBounds(240, 150, 800, 360);
					dispose();
			      } 
		          catch (SQLException e1) 
		          {
					e1.printStackTrace();
				  }
		    }  
		    });
		
		JButton btnNewButton_5 = new JButton("Update Check Status");
		btnNewButton_5.setBounds(10, 310, 200, 30);
        btnNewButton_5.setBackground(Color.BLACK);
        btnNewButton_5.setForeground(Color.WHITE);
		contentPane.add(btnNewButton_5);
		btnNewButton_5.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		          try 
		          {
					UpdateCheck ucheck=new UpdateCheck();
					ucheck.setBounds(160, 100, 945, 450);
					dispose();
			      } 
		          catch (SQLException e1) 
		          {
					e1.printStackTrace();
				  }
		    }  
		    });
		
		JButton btnNewButton_6 = new JButton("Update Room Status");
		btnNewButton_6.setBounds(10, 350, 200, 30);
        btnNewButton_6.setBackground(Color.BLACK);
        btnNewButton_6.setForeground(Color.WHITE);
		contentPane.add(btnNewButton_6);
		btnNewButton_6.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		          try 
		          {
					UpdateRoom uroom=new UpdateRoom();
					uroom.setBounds(150, 110, 945, 450);
					dispose();
			      } 
		          catch (SQLException e1) 
		          {
					e1.printStackTrace();
				  }
		    }  
		    });
		
		JButton btnPickUpSerice = new JButton("Pick up Service");
		btnPickUpSerice.setBounds(10, 390, 200, 30);
        btnPickUpSerice.setBackground(Color.BLACK);
        btnPickUpSerice.setForeground(Color.WHITE);
		contentPane.add(btnPickUpSerice);
		btnPickUpSerice.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		          try 
		          {
					PickUp pickup=new PickUp();
					pickup.setBounds(250, 40, 800, 600);
					dispose();
			      } 
		          catch (SQLException e1) 
		          {
					e1.printStackTrace();
				  }
		    }  
		    });
		
		JButton btnSearchRoom = new JButton("Search Room");
		btnSearchRoom.setBounds(10, 430, 200, 30);
        btnSearchRoom.setBackground(Color.BLACK);
        btnSearchRoom.setForeground(Color.WHITE);
		contentPane.add(btnSearchRoom);
		btnSearchRoom.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		          try 
		          {
					SearchRoom sroom=new SearchRoom();
					sroom.setBounds(285, 100, 700, 500);;
					dispose();
			      } 
		          catch (SQLException e1) 
		          {
					e1.printStackTrace();
				  }
		    }  
		    });

		JButton btnNewButton_7 = new JButton("Log Out");
		btnNewButton_7.setBounds(10, 470, 200, 30);
        btnNewButton_7.setBackground(Color.BLACK);            
        btnNewButton_7.setForeground(Color.WHITE);
        contentPane.add(btnNewButton_7);
        btnNewButton_7.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
					dispose();
					}  
		    });

        getContentPane().setBackground(Color.WHITE);
            
        JLabel lblNewLabel = new JLabel("");
        Image img=new ImageIcon(this.getClass().getResource("/rsz_1rsz_reception.jpg")).getImage();
        lblNewLabel.setIcon(new ImageIcon(img));
        lblNewLabel.setBounds(251, 65, 573, 435);
        contentPane.add(lblNewLabel);
               
        JLabel lblNewLabel_1 = new JLabel("RECEPTION");
        lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 38));
        lblNewLabel_1.setBounds(295, 0, 246, 60);
        contentPane.add(lblNewLabel_1);
 
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		 try 
		 {
			 new AddCustomer();
			dispose();
		 } 
		 catch (SQLException e1) 
		 {
			e1.printStackTrace();
		 }
	    
	}
}