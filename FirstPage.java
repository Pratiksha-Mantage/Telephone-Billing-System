import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javafx.scene.image.Image;

import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Color;

public class FirstPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstPage frame = new FirstPage();
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
	public FirstPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//Image i=new Image("C:\\java programs\\workspace\\Telephone Billing System\\src");
	
		
		
		JLabel lblWelcomeToTelephone = new JLabel("Welcome To Telephone Billing System");
		lblWelcomeToTelephone.setFont(new Font("Calibri", Font.BOLD, 20));
		lblWelcomeToTelephone.setBounds(60, 24, 338, 16);
		contentPane.add(lblWelcomeToTelephone);
		
		
		JButton btnAdmin = new JButton("Admin");
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminLogin a=new AdminLogin();
				AdminLogin.main(null);
			}
		});
		btnAdmin.setFont(new Font("Calibri", Font.BOLD, 20));
		btnAdmin.setBounds(184, 83, 97, 25);
		contentPane.add(btnAdmin);
		
		JButton btnUser = new JButton("User");
		btnUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginPage l=new LoginPage();
				 LoginPage.main(null);
					
			}
		});
		btnUser.setFont(new Font("Calibri", Font.BOLD, 20));
		btnUser.setBounds(184, 147, 97, 25);
		contentPane.add(btnUser);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("F:\\tele.png"));
		lblNewLabel.setBounds(49, 45, 398, 194);
		contentPane.add(lblNewLabel);
	/*	JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("F:\\a123.png"));
		label.setBounds(-12, -37, 1453, 700);
		contentPane.add(label);*/
		
	/*	JLabel lblNewLabel = new JLabel("new LABEL	");
		lblNewLabel.setIcon(new ImageIcon("F:\\telephone.png"));
		lblNewLabel.setBounds(0, 0, 1400, 700);
        contentPane.add(lblNewLabel);*/
	}
}
