import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class AddEmployee extends JFrame implements ActionListener
{     
	    JTextField textField,textField_1,textField_2,textField_3,textField_4;
        JComboBox c1;
        JRadioButton r1,r2;
        JButton save,b2;
        ButtonGroup btgrp=null;

        public AddEmployee()
        {
            getContentPane().setForeground(Color.BLUE);
            getContentPane().setBackground(Color.WHITE);
            setTitle("ADD EMPLOYEE DETAILS");
		 
            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            setSize(900,500);
            getContentPane().setLayout(null);
            setVisible(true);
			
            btgrp=new ButtonGroup();
            JLabel name = new JLabel("NAME");
            name.setFont(new Font("Tahoma", Font.PLAIN, 17));
            name.setBounds(60, 30, 150, 27);
            getContentPane().add(name);
            
            textField = new JTextField();
            textField.setBounds(200, 30, 150, 27);
            getContentPane().add(textField);
			
            JLabel Age = new JLabel("AGE");
            Age.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Age.setBounds(60, 80, 150, 27);
            getContentPane().add(Age);
			
            textField_1 = new JTextField();
            textField_1.setBounds(200, 80, 150, 27);
            getContentPane().add(textField_1);
            
            JLabel Gender = new JLabel("GENDER");
            Gender.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Gender.setBounds(60, 118, 130, 45);
            getContentPane().add(Gender);
		
            r1 = new JRadioButton("MALE");
            r1.setBackground(Color.WHITE);
            r1.setBounds(200, 126, 58, 27);
            r1.setActionCommand("MALE");
            btgrp.add(r1);
            getContentPane().add(r1);
           
	
            r2 = new JRadioButton("FEMALE");
            r2.setBackground(Color.WHITE);
            r2.setBounds(280, 126, 70, 27);
            r2.setActionCommand("FEMALE");
            btgrp.add(r2);
            getContentPane().add(r2);
            		
            JLabel Salary = new JLabel("SALARY");
            Salary.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Salary.setBounds(60, 174, 119, 27);
            getContentPane().add(Salary);
			
            textField_2 = new JTextField();
            textField_2.setBounds(200,175,150,30);
            getContentPane().add(textField_2);
	
            JLabel phone = new JLabel("PHONE");
            phone.setFont(new Font("Tahoma", Font.PLAIN, 17));
            phone.setBounds(60, 229, 105, 27);
            getContentPane().add(phone);
	
            textField_3 = new JTextField();
            textField_3.setBounds(200, 232, 150, 27);
            getContentPane().add(textField_3);
            
            JLabel email = new JLabel("EMAIL");
            email.setFont(new Font("Tahoma", Font.PLAIN, 17));
            email.setBounds(60, 282, 105, 27);
            getContentPane().add(email);
			
            textField_4 = new JTextField();
            textField_4.setBounds(200, 285, 150, 27);
            getContentPane().add(textField_4);
	
            JLabel job = new JLabel("JOB");
            job.setFont(new Font("Tahoma", Font.PLAIN, 17));
            job.setBounds(60, 330, 105, 27);
            getContentPane().add(job);
			
            String course[] = {"","Front Desk Clerks","Porters","Housekeeping","Kitchen Staff","Room Service","Waiter/Waitress","Manager","Accountant","Chef"};
            c1 = new JComboBox(course);
            c1.setBackground(Color.WHITE);
            c1.setBounds(200, 333, 150, 27);
            getContentPane().add(c1);
	
            JLabel AddEmployee = new JLabel("ADD EMPLOYEE DETAILS");
            AddEmployee.setForeground(Color.BLUE);
            AddEmployee.setFont(new Font("Tahoma", Font.PLAIN, 31));
            AddEmployee.setBounds(450, 24, 442, 35);
            getContentPane().add(AddEmployee);
            
            JLabel lblNewLabel = new JLabel("");
            Image img=new ImageIcon(this.getClass().getResource("/employee.jpg")).getImage();
            lblNewLabel.setIcon(new ImageIcon(img));
            lblNewLabel.setBounds(503, 120, 274, 277);
            getContentPane().add(lblNewLabel);
            
            save = new JButton("SAVE");
            save.setBounds(99, 399, 111, 32);
            save.setBackground(Color.BLACK);
            save.setForeground(Color.WHITE);
            getContentPane().add(save);
            save.addActionListener(this);
            
            b2 = new JButton("Back");
            b2.setBounds(240, 399, 111, 32);
            b2.setBackground(Color.BLACK);
            b2.setForeground(Color.WHITE);
            getContentPane().add(b2);
            b2.addActionListener(new ActionListener(){  
    		    public void actionPerformed(ActionEvent e){  
  		 		dispose();
  		    }  
  		    });
            
            setBounds(210,40,900,600);
            setVisible(true);
            setResizable(false);
			
	}
        
    public static void main(String[] args)
    {
        new AddEmployee();
    }

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String name= textField.getText();
		String age= textField_1.getText();
		String salary= textField_2.getText();
		String phone= textField_3.getText();
		String email= textField_4.getText();
		String job=(String)c1.getSelectedItem();
		String gender="";
		
    	if(name.trim().equals("") || age.trim().equals("") || salary.trim().equals("") || phone.trim().equals("") || email.trim().equals("") || job.trim().equals(""))
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
		else
		{
			try
			{
				gender=btgrp.getSelection().getActionCommand();
				Connection con=new MyConnection().getConnection();
				PreparedStatement pst=con.prepareStatement("insert into employee (name,age,gender,job,salary,phone,email)values(?,?,?,?,?,?,?)");
				pst.setString(1, name);
				pst.setString(2, age);
				pst.setString(3, gender);
				pst.setString(4, job);
				pst.setString(5, salary);
				pst.setString(6, phone);
				pst.setString(7, email);
				int i=pst.executeUpdate();
				JOptionPane.showMessageDialog(null, "Data Successfully entered");
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				c1.setSelectedIndex(0);
			}
		    catch(Exception exp)
		    { 
		    	exp.printStackTrace();
		    } 
		}
	}   
}
