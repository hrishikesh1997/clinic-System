package markshit;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class description extends JFrame {

	 private JPanel contentPane;
	 JTextField dpid;
	 JTextField dpnm;
	 JTextField dplnm;
	 private JTable table;
	 Connection con=null;
	 PreparedStatement pst=null;
	 public void refresh()
	 {
		 try
			{
				 Class.forName("com.mysql.jdbc.Driver");
				 
				
				 con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/clinik","root", "");
			
				String sql="SELECT `id`, `Fname`, `Lname`,descri FROM `painfo` ";
				pst=con.prepareStatement(sql);
				ResultSet rs=pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
			  
				
				
				
				pst.close();
				con.close();
			}catch(Exception ae)
			{
				ae.printStackTrace();
				//JOptionPane.showConfirmDialog(null, ae);
			}
	 }

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					description frame = new description();
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
	public description() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 935, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Paitent id");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(66, 46, 101, 24);
		contentPane.add(lblNewLabel);
		
		dpid = new JTextField();
		dpid.setBounds(192, 48, 86, 20);
		contentPane.add(dpid);
		dpid.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("First name\r\n");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(310, 46, 117, 24);
		contentPane.add(lblNewLabel_1);
		
		dpnm = new JTextField();
		dpnm.setBounds(437, 43, 86, 20);
		contentPane.add(dpnm);
		dpnm.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("last name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(571, 51, 97, 14);
		contentPane.add(lblNewLabel_2);
		
		dplnm = new JTextField();
		dplnm.setBounds(725, 48, 86, 20);
		contentPane.add(dplnm);
		dplnm.setColumns(10);
		
		JTextArea txtrDescription = new JTextArea();
		txtrDescription.setForeground(Color.BLACK);
		txtrDescription.setBackground(Color.WHITE);
		txtrDescription.setFont(new Font("Times New Roman", Font.BOLD, 15));
		txtrDescription.setBounds(10, 154, 446, 180);
		contentPane.add(txtrDescription);
		
		JLabel lblNewLabel_3 = new JLabel("Description");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_3.setBounds(134, 102, 188, 34);
		contentPane.add(lblNewLabel_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(511, 115, 398, 277);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					 con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/clinik","root", "");
					 int row=table.getSelectedRow();
				
					String id=(table.getModel().getValueAt(row,0 ).toString());
					String sql="SELECT `id`, `Fname`, `Lname`, `Gender`, `age`, `mnumber`, `fees`, `date`, `time`,descri FROM `painfo` WHERE   id='"+id+"'";
					 pst=con.prepareStatement(sql);
					ResultSet rs=pst.executeQuery();
					
					if(rs.next())
					{
						String pid=rs.getString(1);
						String name=rs.getString(2);
						String lname=rs.getString(3);
						String desc=rs.getString(10);
						
						
						
						dpid.setText(pid);
						dpnm.setText(name);
						dplnm.setText(lname);
						txtrDescription.setText(desc);
						
						
						
					}
					
					pst.close();
					con.close();
				
					
				}catch(Exception ae)
				{
					JOptionPane.showMessageDialog(null, ae);
				}
				
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				clinic c=new clinic();
				c.setVisble(true);
				dispose();
				
				
				
			
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(247, 357, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("load data");
		btnNewButton_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				try
				{
					 Class.forName("com.mysql.jdbc.Driver");
					 
					
					 con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/clinik","root", "");
				
					String sql="SELECT `id`, `Fname`, `Lname`,descri FROM `painfo` ";
					pst=con.prepareStatement(sql);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				  
					
					
					
					pst.close();
					con.close();
				}catch(Exception ae)
				{
					ae.printStackTrace();
					//JOptionPane.showConfirmD
				}	
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					 Class.forName("com.mysql.jdbc.Driver");
					 
					
					 con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/clinik","root", "");
				
					String sql="SELECT `id`, `Fname`, `Lname`,descri FROM `painfo` ";
					pst=con.prepareStatement(sql);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				  
					
					
					
					pst.close();
					con.close();
				}catch(Exception ae)
				{
					ae.printStackTrace();
					//JOptionPane.showConfirmDialog(null, ae);
				}
			}
		});
		btnNewButton_1.setBounds(735, 81, 145, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
				  Class.forName("com.mysql.jdbc.Driver");
				 
					
				 con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/clinik","root", "");
				 
				     String sql="DELETE FROM `painfo` WHERE id=?";
					pst=con.prepareStatement(sql);
					pst.setString(1, dpid.getText());
					//pst.executeUpdate();
					//JOptionPane.showMessageDialog(null,"deleted succesfully");
					if(JOptionPane.showConfirmDialog(btnNewButton_2, "Do you want to delete","",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION)
					{
						pst.executeUpdate();
					}
					
							
			    }catch(Exception ae)
				{
				  JOptionPane.showMessageDialog(null, ae);
				}
				refresh();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2.setBounds(78, 359, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Add/Description");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try
				{
					  Class.forName("com.mysql.jdbc.Driver");
					  con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/clinik", "root", "");
					
					
					    String sql1="UPDATE `painfo` SET `descri`=? WHERE id=?";
					    pst=con.prepareStatement(sql1);
					   
					  //  pst.setString(1,dpnm.getText());
					    //pst.setString(2,dplnm.getText());
					    pst.setString(1,txtrDescription.getText());
					    pst.setString(2,dpid.getText().toString());
						pst.executeUpdate();
						JOptionPane.showMessageDialog(null, "update succesfully");
						
						
						
				}catch(Exception ae)
				{
					JOptionPane.showMessageDialog(null, ae);
				}
				refresh();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(247, 357, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_11 = new JButton("New button");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					 Class.forName("com.mysql.jdbc.Driver");
					 
					
					 con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/clinik","root", "");
				
					String sql="SELECT `id`, `Fname`, `Lname`FROM `painfo` ";
					pst=con.prepareStatement(sql);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				  
					
					
					
					pst.close();
					con.close();
				}catch(Exception ae)
				{
					ae.printStackTrace();
					//JOptionPane.showConfirmDialog(null, ae);
				}
				
			}
		});
		btnNewButton_3.setBounds(366, 359, 135, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Find id");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					 con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/clinik","root", "");
					
				
					
					String sql="SELECT  `Fname`, `Lname`, descri FROM `painfo` WHERE   id='"+dpid.getText()+"'";
					 pst=con.prepareStatement(sql);
					ResultSet rs=pst.executeQuery();
					
					if(rs.next())
					{
					//	String pid=rs.getString(1);
						String name=rs.getString(1);
						String lname=rs.getString(2);
						String desc=rs.getString(3);
						
						
						
						
						dpnm.setText(name);
						dplnm.setText(lname);
						txtrDescription.setText(desc);
						
						
						
					}
					
					pst.close();
					con.close();
				
					
				}catch(Exception ae)
				{
					JOptionPane.showMessageDialog(null, ae);
				}
				
				
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_4.setBounds(57, 11, 89, 23);
		contentPane.add(btnNewButton_4);
	}
}
