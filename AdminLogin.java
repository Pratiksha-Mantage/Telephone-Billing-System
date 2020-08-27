import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;

public class AdminLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField AdminPwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin frame = new AdminLogin();
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
	public AdminLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1400, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterName = new JLabel("Enter Name");
		lblEnterName.setFont(new Font("Calibri", Font.BOLD, 25));
		lblEnterName.setBounds(129, 188, 141, 37);
		contentPane.add(lblEnterName);
		
		JLabel lblEnterPassword = new JLabel("Enter Password");
		lblEnterPassword.setFont(new Font("Calibri", Font.BOLD, 25));
		lblEnterPassword.setBounds(121, 255, 161, 37);
		contentPane.add(lblEnterPassword);
		
		textField = new JTextField();
		textField.setBounds(350, 187, 297, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		AdminPwd = new JPasswordField();
		AdminPwd.setBounds(350, 264, 192, 22);
		contentPane.add(AdminPwd);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Calibri", Font.BOLD, 20));
		btnLogin.setBounds(382, 314, 97, 25);
		contentPane.add(btnLogin);
		
		JLabel lblNewLabel = new JLabel("AdminLogin....");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 30));
		lblNewLabel.setBounds(269, 25, 223, 37);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("F:\\a123.png"));
		label.setBounds(-12, -37, 1400, 700);
		contentPane.add(label);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			/*	String user=textField.getText();
				String psd=AdminPwd.getText();
				if(user.equals("Pratiksha")&&psd.equals("Pratiksha")) {
					textField.setText("null");
					AdminPwd.setText("null");
					Admin a=new Admin();
					//AdminWork AdminWork = new AdminWork();
					//AdminWork.main(null);
					
				}
					
						else {
							JOptionPane.showMessageDialog(null,"Invalid Login Details");
							textField.setText("null");
							AdminPwd.setText("null");
					     	}*/
					
				try {
				 	String user=textField.getText();
					char[]  psd=AdminPwd.getPassword();
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
					
					String sql="select * from users";
					//where u_name='"+user+"and u_pass="+psd+"'";
					Statement  st =con.createStatement();
					ResultSet rs=st.executeQuery(sql);
					while(rs.next())
								{  if(user.equals(rs.getString(2))) {
						
						JOptionPane.showMessageDialog(null,"Login successful");
						//UserInfo u=	new UserInfo();
						//u.SetUser(user,psd2);
					    //UserInfo.main(null);
						AdminWork aw=new AdminWork();
						AdminWork.main(null);
					    
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

					
							
						
						
					
		
	}
}
