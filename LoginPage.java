import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class LoginPage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField pwdPratiksha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
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
	public LoginPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1400, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setFont(new Font("Calibri", Font.BOLD, 20));
		lblUsername.setBounds(81, 92, 106, 16);
		contentPane.add(lblUsername);
		
		textField = new JTextField();
		textField.setBounds(213, 89, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(113, 181, -37, 22);
		contentPane.add(passwordField);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Calibri", Font.BOLD, 20));
		lblPassword.setBounds(81, 143, 106, 16);
		contentPane.add(lblPassword);
		
		final JPasswordField pwd = new JPasswordField();
		//pwd.setText("");
		pwd.setBounds(213, 140, 134, 22);
		contentPane.add(pwd);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setBackground(new Color(255, 0, 0));
		btnLogin.setFont(new Font("Calibri", Font.BOLD, 20));
		btnLogin.setBounds(195, 181, 97, 25);
		contentPane.add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
private String psd2;

public void actionPerformed(ActionEvent arg0) {
	

		try {
	 	String user=textField.getText();
			char[]  psd=pwd.getPassword();
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
			
			String sql="select * from users";
			//where u_name='"+user+"and u_pass="+psd+"'";
			Statement  st =con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next())
						{  if(user.equals(rs.getString(2))) {
				
				JOptionPane.showMessageDialog(null,"Login successful");
				UserInfo u=	new UserInfo();
				//u.SetUser(user,psd2);
			    UserInfo.main(null);
			    
			}//end if
			}
				
				
			/*(else {
			JOptionPane.showMessageDialog(null,"Invalid Login Details");
			textField.setText("");
			pwd.setText("");
	     	}*/
				
			con.close();
	
				
			
		}
		catch(Exception e) {System.out.println(e);}
		
	
		
			
}
		
				
			}
			
		);
		
		JButton btnRegister = new JButton("REGISTER");
		btnRegister.setFont(new Font("Calibri", Font.BOLD, 20));
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				Registration r=new Registration();
			 Registration.main(null);
				
			}
		});
		btnRegister.setBounds(390, 57, 120, 25);
		contentPane.add(btnRegister);
		
		JLabel lblNewUserRegister = new JLabel("NEW USER REGISTER");
		lblNewUserRegister.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewUserRegister.setBounds(351, 28, 180, 16);
		contentPane.add(lblNewUserRegister);
		
		JButton btnReset = new JButton("RESET");
		btnReset.setBackground(new Color(255, 0, 0));
		btnReset.setFont(new Font("Calibri", Font.BOLD, 20));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				pwdPratiksha.setText(" ");
				textField.setText(" ");
				}
				catch(Exception e) {}
				
				
				
			}
		});
		btnReset.setBounds(304, 181, 97, 25);
		contentPane.add(btnReset);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.setBackground(new Color(255, 0, 0));
		btnCancel.setFont(new Font("Calibri", Font.BOLD, 20));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
								
				System.exit(0);
				
				
			}
		});
		btnCancel.setBounds(413, 178, 97, 25);
		contentPane.add(btnCancel);
	}
}
