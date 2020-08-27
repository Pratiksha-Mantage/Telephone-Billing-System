import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Admin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
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
	public Admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1400, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 153, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome Admin ....");
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 25));
		lblNewLabel.setBounds(35, 13, 273, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblAdminname = new JLabel("AdminName");
		lblAdminname.setFont(new Font("Calibri", Font.BOLD, 20));
		lblAdminname.setBounds(84, 105, 118, 39);
		contentPane.add(lblAdminname);
		
		textField = new JTextField();
		textField.setBounds(323, 109, 251, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblAdminaddress = new JLabel("AdminAddress");
		lblAdminaddress.setFont(new Font("Calibri", Font.BOLD, 20));
		lblAdminaddress.setBounds(84, 168, 134, 25);
		contentPane.add(lblAdminaddress);
		
		textField_1 = new JTextField();
		textField_1.setBounds(323, 169, 474, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblAdminphonenumber = new JLabel("AdminPhoneNumber");
		lblAdminphonenumber.setFont(new Font("Calibri", Font.BOLD, 20));
		lblAdminphonenumber.setBounds(84, 230, 194, 16);
		contentPane.add(lblAdminphonenumber);
		
		textField_2 = new JTextField();
		textField_2.setBounds(323, 227, 388, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminWork aw=new AdminWork();
				AdminWork.main(null);
			}
		});
		btnNext.setFont(new Font("Calibri", Font.BOLD, 20));
		btnNext.setBounds(157, 299, 121, 25);
		contentPane.add(btnNext);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Calibri", Font.BOLD, 20));
		btnCancel.setBounds(395, 299, 97, 25);
		contentPane.add(btnCancel);
		btnCancel.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
	}
}
