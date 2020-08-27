

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class UserInfo extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JButton btnPaybill;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInfo frame = new UserInfo();
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
	public UserInfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 773, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblEnterName = new JLabel("Enter Name");
		lblEnterName.setBounds(29, 17, 97, 16);
		contentPane.add(lblEnterName);
		textField = new JTextField();
		textField.setBounds(184, 14, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(90, 56, 547, 349);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"name", "Phone Number", "Duration", "total amount", "Paid Date"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(139);
		table.getColumnModel().getColumn(3).setPreferredWidth(103);
		table.getColumnModel().getColumn(4).setPreferredWidth(86);
		scrollPane.setViewportView(table);
		
		JButton btnShow = new JButton("Show");
		btnShow.setBounds(417, 13, 97, 25);
		contentPane.add(btnShow);
		
		
		
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
try {
					
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
					String query="select * from users where u_name LIKE '"+textField.getText()+"'";
					//System.out.println()
			
	
					PreparedStatement pst=con.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					//while(rs.next()) {
					//if(textField.getText().equals(rs.getString(2)))
					table.setModel(DbUtils.resultSetToTableModel(rs));
					// ((JTable) table.getColumn(1)).getColumn(2)).getColumn(3);
					
					//add(table);
					}
//}
				catch(Exception e) {
					System.out.println(e);
				}
			}

			
		});
		btnPaybill = new JButton("Paybill");
		btnPaybill.setBounds(302, 423, 97, 25);
		contentPane.add(btnPaybill);
		btnPaybill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				//BillPage bp= new BillPage();
				//BillPage.main(null);
				
			}
		});
		
	}
}
