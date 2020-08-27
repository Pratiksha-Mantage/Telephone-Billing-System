import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class AdminWork extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminWork frame = new AdminWork();
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
	public AdminWork() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1400, 700);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
			
		});
		btnNewButton.setFont(new Font("Calibri", Font.BOLD, 20));
		btnNewButton.setBounds(57, 78, 97, 25);
		contentPane.add(btnNewButton);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnDelete.setFont(new Font("Calibri", Font.BOLD, 20));
		btnDelete.setBounds(199, 78, 97, 25);
		contentPane.add(btnDelete);
		
		JLabel lblAdminWork = new JLabel("Admin Work");
		lblAdminWork.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblAdminWork.setBounds(117, 13, 299, 36);
		contentPane.add(lblAdminWork);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 134, 692, 344);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Times New Roman", Font.BOLD, 15));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id", "name", "Phone Number", "Address", "Password", "Date", "Duration", "Total Amount"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("Show all");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
try {
					
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
					String query="select *  from users ";
	
					PreparedStatement pst=con.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					// ((JTable) table.getColumn(1)).getColumn(2)).getColumn(3);
					
					//add(table);
					}
				catch(Exception e) {
					System.out.println(e);
				}
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1.setBounds(334, 78, 121, 25);
		contentPane.add(btnNewButton_1);
		
		JButton Cancel = new JButton("Cancel");
		Cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		Cancel.setFont(new Font("Calibri", Font.BOLD, 20));
		Cancel.setBounds(499, 78, 97, 25);
		contentPane.add(Cancel);
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{btnNewButton, btnDelete}));
		
		
		
		
		//String str[]= {"Select","Search","Delete","UpdateInfo"};
		//comboBox.addItem("Select");
		
	}
}
