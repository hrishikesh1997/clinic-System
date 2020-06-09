package markshit;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.TextArea;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class feesa extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	JTextArea textArea = new JTextArea();
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					feesa frame = new feesa();
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
	public feesa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 959, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Income Details");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(276, 31, 166, 39);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Day");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(71, 137, 72, 27);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("income");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(308, 137, 86, 27);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(57, 217, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(294, 217, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Income");
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_2.addActionListener(new ActionListener() {
			private boolean n1;

			public void actionPerformed(ActionEvent e) {
				 
				Connection con=null;
				PreparedStatement pst=null;

				try
				{
					 Class.forName("com.mysql.jdbc.Driver");
					 
					
					 con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/clinik","root", "");
				
					String sql="SELECT id,fees FROM `painfo`where date='"+textField.getText()+"'";
					pst=con.prepareStatement(sql);
					ResultSet rs=pst.executeQuery();
					int sum=0;
					int count=0;
					while (rs.next())
					{
						int id1=rs.getInt(1);
					    int fees1=rs.getInt(2);
						count++;
						sum=sum+fees1;
						textArea.append("\n"+id1+"\t="+fees1);
											}
					 textField_1.setText("sum="+sum);
					 String c=Integer.toString(count);
					 textField_2.setText(c);
					 pst.close();
					 con.close();
				}catch(Exception ae)
				{
					ae.printStackTrace();
					
				}
				
				

				
				try
				{
					 Class.forName("com.mysql.jdbc.Driver");
					 
					
					 con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/clinik","root", "");
				
					String sql="SELECT id,fees FROM `painfo`where month='"+textField_3.getText()+"'";
					pst=con.prepareStatement(sql);
					ResultSet rs=pst.executeQuery();
					int sum=0;
					int count=0;
					while (rs.next())
					{
						int id1=rs.getInt(1);
					    int fees1=rs.getInt(2);
						count++;
						sum=sum+fees1;
						//textArea.append("\n"+id1+"\t="+fees1);
						
					}
					 textField_5.setText("sum="+sum);
					 String c=Integer.toString(count);
					 textField_4.setText(c);
					 pst.close();
						con.close();
				}catch(Exception ae)
				{
					ae.printStackTrace();
					
				}
				
				
			}
			
			
			
			
			
		});
		btnNewButton_2.setBounds(189, 385, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_3 = new JLabel("Total pateient");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(159, 143, 119, 14);
		contentPane.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(178, 217, 100, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("clear");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_1.setText(null);
				textField_2.setText(null);
				textArea.setText(null);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(85, 384, 89, 23);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(436, 101, 452, 354);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(textArea);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clinic c=new clinic();
				c.setVisble(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(673, 24, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_4 = new JLabel("Month");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setBounds(57, 282, 72, 14);
		contentPane.add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setBounds(57, 326, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel label = new JLabel("Total pateient");
		label.setFont(new Font("Tahoma", Font.BOLD, 15));
		label.setBounds(163, 284, 119, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("income");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_1.setBounds(308, 276, 86, 27);
		contentPane.add(label_1);
		
		textField_4 = new JTextField();
		textField_4.setBounds(178, 326, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(294, 326, 86, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
	}
}
