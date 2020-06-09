package markshit;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
public class detailst extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnNewButton;
	Connection con=null;
	PreparedStatement pst=null;
	JTextArea textArea = new JTextArea();
	private JButton btnNewButton_2;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					detailst frame = new detailst();
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
	public detailst() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1078, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 86, 669, 365);
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
				
					String id1=(table.getModel().getValueAt(row,0 ).toString());
					String sql="SELECT `id`, `Fname`, `Lname`, `Gender`, `age`, `mnumber`, `fees`, `date`, `time`,descri FROM `painfo` WHERE   id='"+id1+"'";
					 pst=con.prepareStatement(sql);
					ResultSet rs=pst.executeQuery();
					
					while(rs.next())
					{
						
						int id=rs.getInt(1);
						String name=rs.getString(2);
						String Laname=rs.getString(3);
						String date=rs.getString(8);
						String des=rs.getString(10);
						//des.new Font("Monotype Corsiva", Font.BOLD, 15);
						
						textArea.append("paitent id="+id+"\t name="+name+"\t Lname="+Laname+
								        "\ndate="+date+
								                       "\n\n\t Description"       );
					
						
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
		
		btnNewButton = new JButton("load");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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
		btnNewButton.setBounds(963, 11, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Welcome to clinik System");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 21));
		lblNewLabel.setBounds(310, 17, 252, 39);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				clinic c=new clinic();
				c.setVisble(true);
				dispose();
				
			}
		});
		btnNewButton_1.setBounds(620, 13, 89, 23);
		contentPane.add(btnNewButton_1);
		textArea.setFont(new Font("Monotype Corsiva", Font.BOLD, 15));
		
		
		textArea.setBounds(724, 149, 299, 267);
		contentPane.add(textArea);
		
		btnNewButton_2 = new JButton("Print");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		         try
		         {
		        	 textArea.print();
		         }catch(Exception ae)
		         {
		        	 JOptionPane.showMessageDialog(null, ae);
		         }
			}
		});
		btnNewButton_2.setBounds(909, 83, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Clear");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_3.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				textArea.setText(null);;			}
		});
		btnNewButton_3.setBounds(736, 83, 89, 23);
		contentPane.add(btnNewButton_3);
	}
}
