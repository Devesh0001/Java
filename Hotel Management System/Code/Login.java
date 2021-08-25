import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Statement;
import java.awt.*;
public class Login extends JFrame implements ActionListener
{
	private JPanel contentPane;
	private JTextField textField_1;
	private JPasswordField passwordField;
	JButton btnNewButton_1 = new JButton("Cancel");
	JButton btnNewButton = new JButton("Sign In");
	
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					Login frame = new Login();
					frame.setVisible(true);
				}
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(420, 180, 450, 300);
		contentPane = new JPanel(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.desktop);
		panel.setForeground(new Color(25, 25, 112));
		panel.setBounds(0, 0, 444, 272);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setBounds(129, 87, 105, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		
		btnNewButton.setBounds(25, 206, 78, 23);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(this);
		
		btnNewButton_1.setBounds(145, 206, 89, 23);
		panel.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
	          dispose();  
	    }  
	    }); 
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setForeground(SystemColor.controlHighlight);
		lblNewLabel.setBackground(SystemColor.controlHighlight);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 28));
		lblNewLabel.setBounds(72, 11, 111, 42);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setForeground(SystemColor.controlHighlight);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1.setBounds(26, 88, 111, 17);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setForeground(SystemColor.controlHighlight);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2.setBounds(26, 127, 111, 17);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		Image img=new ImageIcon(this.getClass().getResource("/CustomerInfo.png")).getImage();
		lblNewLabel_3.setIcon(new ImageIcon(img));
		lblNewLabel_3.setBounds(288, 74, 99, 80);
		panel.add(lblNewLabel_3);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(129, 126, 105, 20);
		panel.add(passwordField);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Show Password");
		chckbxNewCheckBox.setFont(new Font("Arial", Font.PLAIN, 11));
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(chckbxNewCheckBox.isSelected())
			{
				passwordField.setEchoChar((char)0);
			}
			else
			{
				passwordField.setEchoChar('*');
			}
			}
			
		});
		chckbxNewCheckBox.setForeground(SystemColor.controlHighlight);
		chckbxNewCheckBox.setBackground(Color.BLACK);
		chckbxNewCheckBox.setBounds(6, 162, 131, 20);
		panel.add(chckbxNewCheckBox);
		contentPane.setLayout(null);
}

	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		String username=textField_1.getText();
		String password=passwordField.getText();
		if(username.trim().equals("") && password.trim().equals(""))
		{
			JOptionPane.showMessageDialog(this, "Please fill all the fields");
		}
		else
		{
			try
			{
				Connection con=new MyConnection().getConnection();
				Statement st=con.createStatement();
			    ResultSet rs=st.executeQuery("select username from datatable where username='"+username+"' and password='"+password+"'");
			     if(rs.next())
			     {
				  new Dashboard();
				  dispose(); 
		         }
			     else
			     {
				  JOptionPane.showMessageDialog(this, "Wrong details please enter again");
		         }
				}
			    catch(Exception exp)
			    { 
				 exp.printStackTrace();
			    } 
		}
	}
}






