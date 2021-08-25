import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Dashboard extends JFrame implements ActionListener
{
	JMenuBar nb;
	JMenu n1,n2;
	JMenuItem i1,i2,i3,i4;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	
Dashboard()
{
	nb=new JMenuBar();
	getContentPane().add(nb);
	
	n1=new JMenu("HOTEL MANAGEMENT");
	nb.add(n1);
	
	n2=new JMenu("ADMIN");
	nb.add(n2);
	
	i1=new JMenuItem("RECEPTION");
	n1.add(i1);
	i1.addActionListener(this);
	
	i2=new JMenuItem("ADD EMPLOYEE");
	n2.add(i2);
	i2.addActionListener(new ActionListener(){  
	    public void actionPerformed(ActionEvent e){  
	          AddEmployee emp=new AddEmployee();
	          emp.setBounds(210,40,900,600);
	    }  
	    }); 
	
	i3=new JMenuItem("ADD ROOMS");
	n2.add(i3);
	i3.addActionListener(new ActionListener(){  
	    public void actionPerformed(ActionEvent e){  
	          AddRoom room=new AddRoom();
	          room.setBounds(160, 110, 1000, 450);
	    }  
	    }); 
	
	
	i4=new JMenuItem("ADD DRIVERS");
	n2.add(i4);
	i4.addActionListener(new ActionListener(){  
	    public void actionPerformed(ActionEvent e){  
	          AddDrivers driver=new AddDrivers();
	          driver.setBounds(170, 90, 1000, 500);
	    }  
	    }); 
	
	nb.setBounds(0,0,1950,30);
	
	
	
	getContentPane().setLayout(null);
	
	lblNewLabel = new JLabel("");
	Image img=new ImageIcon(this.getClass().getResource("/9-4.jpg")).getImage();
	lblNewLabel.setIcon(new ImageIcon(img));
	lblNewLabel.setBounds(0, 30, 1201, 685);
	getContentPane().add(lblNewLabel);
	
	lblNewLabel_1 = new JLabel("WELCOME");
	lblNewLabel.add(lblNewLabel_1);
	lblNewLabel_1.setFont(new Font("Gill Sans Ultra Bold", Font.BOLD, 50));
	lblNewLabel_1.setForeground(SystemColor.control);
	lblNewLabel_1.setBounds(436, 65, 334, 45);
	setBounds(40,0,1209,753);
	setVisible(true);
	setResizable(false);
	
}
public static void main(String[] args)
{
new Dashboard().setVisible(true);
}
@Override
public void actionPerformed(ActionEvent e) 
{	
	Reception rec=new Reception();
	rec.setBounds(240, 50, 850, 570);
}
}


