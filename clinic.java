package markshit;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class clinic {

	private JFrame frame;
	JTextField textField;
	 JTextField textField_1;
	 JTextField textField_2;
	 JTextField fees;
	 JLabel datec;
	 JTextField agec;
	 JTextField mob;
	JLabel time = new JLabel("");
	JComboBox comboBox = new JComboBox();
	private JTable table;
	int month=0;
	 int year=0;
	public void refresh()
	{
		 Connection con=null;
		  PreparedStatement pst=null;

		try
		{
			 Class.forName("com.mysql.jdbc.Driver");
			 
			
			 con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/clinik","root", "");
			 //String sql="SELECT `id`, `Fname`, `Lname` FROM `painfo` `";
			String sql="SELECT `id`, `Fname`, `Lname`, `Gender`, `age`, `mnumber`, `fees`, `date` ,time,descri FROM `painfo` `";
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
					clinic window = new clinic();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public clinic() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1151, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Clinik System");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(327, 28, 160, 41);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Paitent id");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(65, 127, 118, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField.setEditable(false);
		textField.setToolTipText("No nedd of enter pid it is Automatically created");
		textField.setBounds(229, 131, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("First name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(382, 127, 86, 25);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField_1.setBounds(483, 131, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblLastName = new JLabel("last name");
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLastName.setBounds(617, 127, 118, 25);
		frame.getContentPane().add(lblLastName);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField_2.setBounds(741, 131, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblFees = new JLabel("Fees");
		lblFees.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFees.setBounds(65, 246, 118, 25);
		frame.getContentPane().add(lblFees);
		
		fees = new JTextField();
		fees.setFont(new Font("Tahoma", Font.BOLD, 11));
		fees.setBounds(229, 250, 86, 20);
		frame.getContentPane().add(fees);
		fees.setColumns(10);
		
		JButton btnNewButton = new JButton("date");
		btnNewButton.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				Calendar cl=new GregorianCalendar();
				   int day= cl.get(Calendar.DAY_OF_MONTH);
				   int month1=cl.get(Calendar.MONTH);
				   year=cl.get(Calendar.YEAR);
				   //int month=0;
				   month=month1+1;
				   int hour=cl.get(Calendar.HOUR);
				   int mini=cl.get(Calendar.MINUTE);
				   int secon=cl.get(Calendar.SECOND);
				   int A=cl.get(Calendar.AM_PM);
				   String A1=null;
				   if (A==1)
				   {
					   A1="PM";
					   
				   }else
				   {
					   A1="AM";
				   }
				   datec.setText(""+day+":"+month+":"+year);
				   time.setText(""+hour+":"+mini+":"+secon+":"+A1+"");
				   
				
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
			   Calendar cl=new GregorianCalendar();
			   int day= cl.get(Calendar.DAY_OF_MONTH);
			   int month1=cl.get(Calendar.MONTH);
			   year=cl.get(Calendar.YEAR);
			   month=0;
			   month=month1+1;
			   int hour=cl.get(Calendar.HOUR);
			   int mini=cl.get(Calendar.MINUTE);
			   int secon=cl.get(Calendar.SECOND);
			   int A=cl.get(Calendar.AM_PM);
			   String A1=null;
			   if (A==1)
			   {
				   A1="PM";
				   
			   }else
			   {
				   A1="AM";
			   }
			   datec.setText(""+day+":"+month+":"+year);
			   time.setText(""+hour+":"+mini+":"+secon+":"+A1+"");
			   
			  
				
			
				
			};
			   
					   
			
			    
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(398, 247, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		datec = new JLabel("date");
		datec.setBounds(792, 251, 75, 20);
		frame.getContentPane().add(datec);
		
		JLabel lblNewLabel_4 = new JLabel("age");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_4.setBounds(382, 196, 52, 25);
		frame.getContentPane().add(lblNewLabel_4);
		
		agec = new JTextField();
		agec.setFont(new Font("Tahoma", Font.BOLD, 11));
		agec.setBounds(483, 193, 86, 20);
		frame.getContentPane().add(agec);
		agec.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Mobile number");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_5.setBounds(617, 196, 107, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		mob = new JTextField();
		mob.setFont(new Font("Tahoma", Font.BOLD, 11));
		mob.setBounds(741, 193, 86, 20);
		frame.getContentPane().add(mob);
		mob.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Gender");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_6.setBounds(65, 194, 85, 14);
		frame.getContentPane().add(lblNewLabel_6);
		comboBox.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				comboBox.getSelectedItem();
			}
		});
		
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select", "Male", "FeMale"}));
		comboBox.setBounds(229, 199, 85, 20);
		frame.getContentPane().add(comboBox);
		
		JButton btnNewButton_1 = new JButton("ADD");
		btnNewButton_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				 String m=Integer.toString(month);
				 String y=Integer.toString(year);
				 String my=""+m+":"+y;
						 
				Connection con=null;
				PreparedStatement pst=null;
				 try
				 {
					 Class.forName("com.mysql.jdbc.Driver");
					 con=DriverManager.getConnection("jdbc:mysql://127.0.01:3306/clinik","root", "");
					 String sql="INSERT INTO `painfo`(`Fname`, `Lname`, `Gender`, `age`, `mnumber`, `fees`, `date`,time,month) VALUES (?,?,?,?,?,?,?,?,?)";
					 pst=con.prepareStatement(sql);
				   //  pst.setString(1, textField.getText());
					 pst.setString(1, textField_1.getText());
					 pst.setString(2, textField_2.getText());
					 pst.setString(3, (String) comboBox.getSelectedItem());
					 pst.setString(4, agec.getText());
					 pst.setString(5, mob.getText());
					 pst.setString(6, fees.getText());
					 pst.setString(7, datec.getText());
					 pst.setString(8, time.getText());
					 pst.setString(9, my);
					 pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "insert succesfully");
						pst.close();
						con.close();
					
				 }catch(Exception ae)
				 {
					 JOptionPane.showMessageDialog(null, ae);
				 }
				 refresh();
				 
				description dsc=new description();
				 dsc.setVisible(true);
			
				 
				 }
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String m=Integer.toString(month);
				 String y=Integer.toString(year);
				 String my=""+m+":"+y;
				
				Connection con=null;
				PreparedStatement pst=null;
				 try
				 {
					 Class.forName("com.mysql.jdbc.Driver");
					 con=DriverManager.getConnection("jdbc:mysql://127.0.01:3306/clinik","root", "");
					 String sql="INSERT INTO `painfo`(`Fname`, `Lname`, `Gender`, `age`, `mnumber`, `fees`, `date`,time,month) VALUES (?,?,?,?,?,?,?,?,?)";
					 pst=con.prepareStatement(sql);
				   //  pst.setString(1, textField.getText());
					 pst.setString(1, textField_1.getText());
					 pst.setString(2, textField_2.getText());
					 pst.setString(3, (String) comboBox.getSelectedItem());
					 pst.setString(4, agec.getText());
					 pst.setString(5, mob.getText());
					 pst.setString(6, fees.getText());
					 pst.setString(7, datec.getText());
					 pst.setString(8, time.getText());
					 pst.setString(9, my);
					 pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "insert succesfully");
						pst.close();
						con.close();
					
				 }catch(Exception ae)
				 {
					 JOptionPane.showMessageDialog(null, ae);
				 }
				 refresh();
				 
				description dsc=new description();
				 dsc.setVisible(true);
			
			}
			});
		btnNewButton_1.setBounds(549, 248, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("clear");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				textField_1.setText(null);
				agec.setText(null);
				datec.setText(null);
				fees.setText(null);
				mob.setText(null);
				textField_2.setText(null);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_2.setBounds(210, 378, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Delete");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con=null;
				PreparedStatement pst=null;
				 try
				 {
					 Class.forName("com.mysql.jdbc.Driver");
					 con=DriverManager.getConnection("jdbc:mysql://127.0.01:3306/clinik","root", "");
					 String sql="DELETE FROM `painfo` WHERE id=?";
					 pst=con.prepareStatement(sql);
				     pst.setString(1, textField.getText());
				     //pst.executeUpdate();
				   //  JOptionPane.showMessageDialog(null, "deleted succesfully" );
				    if( JOptionPane.showConfirmDialog(btnNewButton_3, "confiram if u want to delete","clinic",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION)
				    {
				    	pst.executeUpdate();
				    }
				     con.close();
				     pst.close();
				
			}catch(Exception ae)
				 {
				   JOptionPane.showMessageDialog(null, ae );
				 }
				 refresh();
			}
		});
		btnNewButton_3.setBounds(61, 378, 89, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		
		time.setBounds(975, 257, 83, 14);
		frame.getContentPane().add(time);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(414, 304, 674, 206);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD, 11));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				   Connection con=null;
				   PreparedStatement pst=null;
				
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
							String age=rs.getString(5);
							String mobc=rs.getString(6);
							String fee=rs.getString(7);
							
							
							//String desc=rs.getString(10);
							
							textField.setText(pid);
							textField_1.setText(name);
							textField_2.setText(lname);
							agec.setText(age);
							mob.setText(mobc);
							fees.setText(fee);
							
							
							
							
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
		
		JButton btnNewButton_4 = new JButton("load");
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  Connection con=null;
				  PreparedStatement pst=null;

				try
				{
					 Class.forName("com.mysql.jdbc.Driver");
					 
					
					 con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/clinik","root", "");
					 //String sql="SELECT `id`, `Fname`, `Lname` FROM `painfo` `";
					String sql="SELECT `id`, `Fname`, `Lname`, `Gender`, `age`, `mnumber`, `fees`, `date` ,time,descri FROM `painfo` `";
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
		btnNewButton_4.setBounds(210, 436, 89, 23);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Update");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con=null;
				PreparedStatement pst=null;
				try
				{
				   Class.forName("com.mysql.jdbc.Driver");
				   con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/clinik","root", "");
					String sql="UPDATE `painfo` SET `Fname`=?,`Lname`=?,`Gender`=?,`age`=?,`mnumber`=?,`fees`=? WHERE id=?";
					
							
                    pst=con.prepareStatement(sql);
                    pst.setString(1, textField_1.getText());
                    pst.setString(2, textField_2.getText());
                    pst.setString(3, (String) comboBox.getSelectedItem());
                    pst.setString(4, agec.getText());
                    pst.setString(5, mob.getText());
                    pst.setString(6, fees.getText());
                    pst.setString(7, textField.getText());
                  //  pst.setString(7, datec.getText());
                   // pst.setString(8, time.getText());
                   
                   // pst.execute();
                    //JOptionPane.showMessageDialog(null, "updated succesfully" );
                   if( JOptionPane.showConfirmDialog(btnNewButton_5, "Do  u want to update ","clinic",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION)
				    {
                    	 pst.execute();
				    }
                    
                    con.close();
                    pst.close();
				   
				}catch(Exception ae)
				{
					ae.printStackTrace();
				}
			}
		});
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_5.setBounds(65, 436, 89, 23);
		frame.getContentPane().add(btnNewButton_5);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("details");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				detailst d=new detailst();
				d.setVisible(true);
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		 
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("fees");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				feesa f=new feesa();
				f.setVisible(true);
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Description");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				description d=new description();
				d.setVisible(true);
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
	}

	
	   void setVisble(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
