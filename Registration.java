import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.sql.*;
import java.awt.Font;
import java.awt.Color;
public class Registration extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField pwdPratiksha;
	private JLabel lblPassword;
	private JButton btnLogin;
	private JButton btnReset;
	private JButton btnCancel;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration frame = new Registration();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Registration() 
{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,1400, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(175, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setFont(new Font("Calibri", Font.BOLD, 20));
		lblUsername.setBounds(106, 66, 124, 16);
		contentPane.add(lblUsername);
		
		textField = new JTextField();
		textField.setBounds(290, 63, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPhonenumber = new JLabel("PHONENUMBER");
		lblPhonenumber.setFont(new Font("Calibri", Font.BOLD, 20));
		lblPhonenumber.setBounds(106, 95, 144, 22);
		contentPane.add(lblPhonenumber);
		
		textField_1 = new JTextField();
		//textField_1.setText();
		textField_1.setBounds(290, 98, 116, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		pwdPratiksha = new JPasswordField();
		//pwdPratiksha.setText("Pratiksha");
		pwdPratiksha.setBounds(290, 165, 116, 22);
		contentPane.add(pwdPratiksha);
		
		lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Calibri", Font.BOLD, 20));
		lblPassword.setBounds(106, 165, 124, 22);
		contentPane.add(lblPassword);
		
		btnLogin = new JButton("SUBMIT");
		btnLogin.setFont(new Font("Calibri", Font.BOLD, 20));
		btnLogin.setBounds(106, 220, 97, 25);
		contentPane.add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				try {
				String user=textField.getText();
				String psd=pwdPratiksha.getText();
				String adr=textField_2.getText();
				String phno=textField_1.getText();
				
				/*if(user.equals("Pratiksha")&&psd.equals("Pratiksha")&&phno.equals("7057733854")) {
					textField.setText("null");
					pwdPratiksha.setText("null");
					textField_1.setText("null");*/
			//	create table users(u_id number(2),u_name varchar(10),u_mobileno varchar(10),u_addr varchar(20),
					//	u_pass varchar(15));
				 String sql="insert into users(u_name,u_mobileno,u_addr,u_pass) values ('"+ user +  "','"  + phno +"','"+adr+"','"+psd+"')";

					System.out.println(sql);
                     Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
					Statement stmt=con.createStatement();
					stmt.executeUpdate(sql); 
					System.out.println("values Inserted Successfully");
					stmt.close();
					con.close();
				    UserInfo u=	new UserInfo();
					UserInfo.main(null);
				}
					catch(Exception e) {
						System.out.println(e);
					}
			}
		});
		
		
		btnReset = new JButton("RESET");
		btnReset.setFont(new Font("Calibri", Font.BOLD, 20));
		btnReset.setBounds(236, 220, 97, 25);
		contentPane.add(btnReset);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pwdPratiksha.setText("");
				textField_1.setText("");
				textField.setText("");
				
				
				
			}
		});
		btnCancel = new JButton("CANCEL");
		btnCancel.setFont(new Font("Calibri", Font.BOLD, 20));
		btnCancel.setBounds(380, 220, 97, 25);
		contentPane.add(btnCancel);
		
		JLabel lblAddress = new JLabel("ADDRESS");
		lblAddress.setFont(new Font("Calibri", Font.BOLD, 22));
		lblAddress.setBounds(106, 130, 97, 22);
		contentPane.add(lblAddress);
		
		textField_2 = new JTextField();
		textField_2.setBounds(290, 133, 255, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		btnCancel.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				
				
				System.exit(0);
			
		}
	});
}
}
