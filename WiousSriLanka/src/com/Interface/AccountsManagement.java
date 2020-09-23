package com.Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import com.Interface.*;
import com.toedter.calendar.JCalendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.util.DbConnect;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class AccountsManagement extends JFrame{
	private JTable table1;
	private JTable table2;
	private JPanel contentPane;
	private JTextField txtTID;
	private JTextField txtINO;
	private JTextField txtCus;
	private JTextField txtEmail;
	private JTextField txtTP;
	private JTextField txtAmount;
	private JTextField txtSearch_p1;
	private JTextField txtSearch_p2;
	
	
	private PreparedStatement preparedStatement;
	private static Connection connection;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccountsManagement frame = new AccountsManagement();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
   
public void DisplayTable1() throws  InstantiationException, IllegalAccessException, SQLException, ClassNotFoundException {
		
		connection = DbConnect.getDBConnection();
		
		String selectQuery2 = "SELECT * FROM accounts WHERE Status = 'Paid'";
		
		PreparedStatement p2 = connection.prepareStatement(selectQuery2);
		
		ResultSet rs2 = p2.executeQuery();
		
		table1.setModel(DbUtils.resultSetToTableModel(rs2));	
		
		p2.close();	
	}

public void DisplayTable2() throws  InstantiationException, IllegalAccessException, SQLException, ClassNotFoundException {
	
	connection = DbConnect.getDBConnection();
	
	String selectQuery2 = "SELECT * FROM accounts WHERE Status = 'Pending'";
	
	PreparedStatement p2 = connection.prepareStatement(selectQuery2);
	
	ResultSet rs2 = p2.executeQuery();
	
	table2.setModel(DbUtils.resultSetToTableModel(rs2));	
	
	p2.close();	
}

public AccountsManagement() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
	setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\avina\\Desktop\\IT18195644\\images\\wious.png"));
	setTitle("Accounts Management System");
	setResizable(false);
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setBounds(200, 200, 1300, 725);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
    
	JPanel panel_Head = new JPanel();
	panel_Head.setBackground(new Color(238, 232, 170));
	panel_Head.setBounds(10, 11, 1274, 106);
	contentPane.add(panel_Head);
	panel_Head.setLayout(null);
	
	JLabel lblAccountsManagement = new JLabel("Accounts Management");
	lblAccountsManagement.setBounds(119, 11, 691, 84);
	lblAccountsManagement.setFont(new Font("Tahoma", Font.PLAIN, 40));
	panel_Head.add(lblAccountsManagement);
	
	JButton button_6 = new JButton("Notice");
	button_6.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				Notices info = new Notices();
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Notices.main(null);
		}
	});
	button_6.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\note.png"));
	button_6.setBounds(1004, 32, 125, 36);
	panel_Head.add(button_6);
	
	JButton button_7 = new JButton("Sign Out");
	button_7.setBounds(1139, 33, 125, 35);
	button_7.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Login info = new Login();
			Login.main(null);
		}
	});
	button_7.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\signout.png"));
	button_7.setToolTipText("Sign Out");
	panel_Head.add(button_7);
	
	JLabel label = new JLabel("");
	label.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\accountsLarge.png"));
	label.setBounds(20, 11, 111, 94);
	panel_Head.add(label);
	
	JPanel panel_Navigator = new JPanel();
	panel_Navigator.setBackground(new Color(189, 183, 107));
	panel_Navigator.setBounds(10, 128, 245, 557);
	contentPane.add(panel_Navigator);
	panel_Navigator.setLayout(null);
	
	JLabel lblTransId = new JLabel("Transcation ID");
	lblTransId.setBounds(10, 11, 106, 14);
	panel_Navigator.add(lblTransId);
	
	txtTID = new JTextField();
	txtTID.setMargin(new Insets(2, 10, 2, 10));
	txtTID.setEditable(false);
	txtTID.setColumns(10);
	txtTID.setBounds(10, 36, 78, 25);
	panel_Navigator.add(txtTID);
	
	JLabel lblInvoiceNo = new JLabel("Invoice No");
	lblInvoiceNo.setBounds(112, 11, 106, 14);
	panel_Navigator.add(lblInvoiceNo);
	
	txtINO = new JTextField();
	txtINO.setMargin(new Insets(2, 10, 2, 10));
	txtINO.setColumns(10);
	txtINO.addKeyListener(new KeyAdapter() {
		@Override
		public void keyReleased(KeyEvent arg0) {
			boolean validate1 = txtINO.getText().matches("^[0-9]*$");
			
			if(validate1) {
				
			}else {
				JOptionPane.showMessageDialog(null, "Can't use speacial Characters or letters. Try again!");
				txtINO.setText(null);
			}		
		}
	});
	txtINO.setBounds(98, 36, 136, 25);
	panel_Navigator.add(txtINO);

	
	JLabel lblCustomerName = new JLabel("Customer Name");
	lblCustomerName.setBounds(20, 71, 190, 14);
	panel_Navigator.add(lblCustomerName);
	

	txtCus = new JTextField();
	txtCus.setMargin(new Insets(2, 10, 2, 10));
	txtCus.addKeyListener(new KeyAdapter() {
		@Override
		public void keyReleased(KeyEvent arg0) {
			boolean validate1 = txtCus.getText().matches("^[A-Za-z ]*$");
			
			if(validate1) {
				
			}else {
				JOptionPane.showMessageDialog(null, "Can't use speacial Characters or numbers for name. Try again!");
				txtCus.setText(null);
			}		
		}
	});
	txtCus.setColumns(10);
	txtCus.setBounds(10, 96, 224, 25);
	panel_Navigator.add(txtCus);
	
	JLabel lblEmail = new JLabel("Customer Email Address");
	lblEmail.setBounds(20, 132, 190, 14);
	panel_Navigator.add(lblEmail);
    
	txtEmail = new JTextField();
	txtEmail.setMargin(new Insets(2, 10, 2, 10));
	txtEmail.addKeyListener(new KeyAdapter() {
		@Override
		public void keyReleased(KeyEvent arg0) {
           boolean validate1 = txtEmail.getText().matches("^[0-9a-z@.]*$");
			
			if(validate1) {
				
			}else {
				JOptionPane.showMessageDialog(null, "Invalid Email. Try again!");
				txtEmail.setText(null);
			}		
		}
	});
	txtEmail.setColumns(10);
	txtEmail.setBounds(10, 156, 224, 25);
	panel_Navigator.add(txtEmail);
	
	JLabel lblCustomerPhoneNumber = new JLabel("Customer Phone Number");
	lblCustomerPhoneNumber.setBounds(20, 192, 190, 14);
	panel_Navigator.add(lblCustomerPhoneNumber);
	
	txtTP = new JTextField();
	txtTP.setMargin(new Insets(2, 10, 2, 10));
	txtTP.addKeyListener(new KeyAdapter() {
		@Override
		public void keyReleased(KeyEvent arg0) {
			boolean validate1 = txtTP.getText().matches("^[0-9]*$");
			
			if(validate1) {
				
			}else {
				JOptionPane.showMessageDialog(null, "Invalid phone number. Try again!");
				txtTP.setText(null);
			}		
		}
	});
	txtTP.setColumns(10);
	txtTP.setBounds(10, 217, 224, 25);
	panel_Navigator.add(txtTP);
	
	JLabel lblAmount = new JLabel("Amount");
	lblAmount.setBounds(20, 261, 190, 14);
	panel_Navigator.add(lblAmount);
	
	txtAmount = new JTextField();
	txtAmount.setMargin(new Insets(2, 10, 2, 10));
	txtAmount.addKeyListener(new KeyAdapter() {
		@Override
		public void keyReleased(KeyEvent arg0) {
			boolean validate1 = txtAmount.getText().matches("^[0-9]*$");
			
			if(validate1) {
				
			}else {
				JOptionPane.showMessageDialog(null, "Invalid Amount. Try again!");
				txtAmount.setText(null);
			}
		}
	});
	txtAmount.setColumns(10);
	txtAmount.setBounds(10, 281, 224, 25);
	panel_Navigator.add(txtAmount);
	
	JLabel lblStatus = new JLabel("Payment Status");
	lblStatus.setBounds(20, 322, 190, 14);
	panel_Navigator.add(lblStatus);
	
	JComboBox cmb1 = new JComboBox();
		cmb1.addItem("Paid");
		cmb1.addItem("Pending");
		cmb1.setSelectedItem(null);
		cmb1.setBounds(10, 341, 224, 25);
		panel_Navigator.add(cmb1);
	
	JLabel lblDate = new JLabel("Transaction Date");
	lblDate.setBounds(20, 383, 190, 14);
	panel_Navigator.add(lblDate);
	
	
	 JCalendar TDate =  new JCalendar();
		TDate.setWeekOfYearVisible(false);
		TDate.setBounds(10, 403, 224, 100);
		panel_Navigator.add(TDate);

		
		
		//Add

		JButton btnCreateRecord = new JButton("Create Transaction");
		btnCreateRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String a1 = txtTID.getText();
				String a2 = txtINO.getText();
				String a3 = txtCus.getText();
				String a4 = txtEmail.getText();
				String a5 = txtTP.getText();
				String a6 = txtAmount.getText();
				String a7 = (String)cmb1.getSelectedItem().toString();
				java.util.Date Date = TDate.getDate();				
				String txtDate = new SimpleDateFormat("yyyy-mm-dd").format(Date);
				
							
				if(a2.isEmpty() || a3.isEmpty() ||a4.isEmpty() || a5.isEmpty() || a6.isEmpty() || a7.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please fill all the Fields!");
				}
				else {
					int selectRowp1 = table1.getSelectedRow();
													
					try {
						connection = DbConnect.getDBConnection();
									
						String insertQuery = "INSERT INTO accounts (Invoice_No, Customer_Name, Email, Phone, Amount, Status, Transaction_Date)  VALUES('"+a2+"','"+a3+"','"+a4+"','"+a5+"','"+a6+"','"+a7+"', '"+txtDate+"')";
						PreparedStatement ps = connection.prepareStatement(insertQuery);
						ps.executeUpdate();
						JOptionPane.showMessageDialog(null, "Record created successfully!");
						ps.close();
						
						
								
					}
					
					catch(Exception e) {
						JOptionPane.showMessageDialog(null, e);
					}
				
					try {
						DisplayTable1();
						DisplayTable2();
						txtTID.setText(null);
						txtINO.setText(null);
						txtCus.setText(null);
						txtEmail.setText(null);
						txtTP.setText(null);
						txtAmount.setText(null);
						cmb1.setSelectedItem(null);
					} 
					catch (Exception e) {
						e.printStackTrace();
					}		
					
				}
			}
		});
		btnCreateRecord.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\add.png"));
		btnCreateRecord.setToolTipText("Add Now");
		btnCreateRecord.setBounds(10, 505, 224, 20);
		panel_Navigator.add(btnCreateRecord);	
		
		//Update
		
		JButton btnUpdateRecord = new JButton("Update Transaction");
		btnUpdateRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String a1 = txtTID.getText();
				String a2 = txtINO.getText();
				String a3 = txtCus.getText();
				String a4 = txtEmail.getText();
				String a5 = txtTP.getText();
				String a6 = txtAmount.getText();
				String a7 = (String)cmb1.getSelectedItem().toString();
				java.util.Date Date = TDate.getDate();				
				String txtDate = new SimpleDateFormat("yyyy-mm-dd").format(Date);
				//String a8 = (String)cmb3.getSelectedItem().toString();
							
				if(a2.isEmpty() || a3.isEmpty() ||a4.isEmpty() || a5.isEmpty() || a6.isEmpty() || a7.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please fill all the Fields!");
				}
				else {
					int selectRowp1 = table1.getSelectedRow();
													
					try {
						connection = DbConnect.getDBConnection();
												
						String UpdateQuery = "UPDATE accounts SET Invoice_No = '"+a2+"', Customer_Name = '"+a3+"', Email = '"+a4+"', Phone = '"+a5+"', Amount = '"+a6+"', Status = '"+a7+"', Transaction_Date = '"+txtDate+"' WHERE (Transaction_ID = '"+a1+"')";
						PreparedStatement ps = connection.prepareStatement(UpdateQuery);
						ps.executeUpdate();
						JOptionPane.showMessageDialog(null, "Record Updated successfully!");
						ps.close();
						
					}
					
					catch(Exception e) {
						JOptionPane.showMessageDialog(null, e);
					}
				
					try {
						DisplayTable1();
						DisplayTable2();
						txtTID.setText(null);
						txtINO.setText(null);
						txtCus.setText(null);
						txtEmail.setText(null);
						txtTP.setText(null);
						txtAmount.setText(null);
						cmb1.setSelectedItem(null);
					} 
					catch (Exception e) {
						e.printStackTrace();
					}		
				}
			}
		});
		btnUpdateRecord.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\insert.png"));
		btnUpdateRecord.setToolTipText("Update Now");
		btnUpdateRecord.setBounds(10, 530, 224, 20);
		panel_Navigator.add(btnUpdateRecord);
		
		//New Panel
	 
		JPanel panel_Body_P1 = new JPanel();
		panel_Body_P1.setBackground(new Color(189, 183, 107));
		panel_Body_P1.setBounds(265, 130, 1019, 271);
		contentPane.add(panel_Body_P1);
		panel_Body_P1.setLayout(null);
		
		//Table 1 Heading 
		
		JLabel lblPaidTransactionList = new JLabel("Paid Transaction List");
		lblPaidTransactionList.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblPaidTransactionList.setBounds(10, 0, 375, 47);
		panel_Body_P1.add(lblPaidTransactionList);
		
		// Search button 01
		
		txtSearch_p1 = new JTextField();
		txtSearch_p1.setToolTipText("Search Item Name");
		txtSearch_p1.setMargin(new Insets(2, 10, 2, 10));
		txtSearch_p1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSearch_p1.setColumns(10);
		txtSearch_p1.setBounds(758, 17, 186, 30);
		panel_Body_P1.add(txtSearch_p1);
		
		JButton btnSearch_P1 = new JButton("");
		btnSearch_P1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String searchp1 = txtSearch_p1.getText();
				
				try {
					if(searchp1.isEmpty()==true) {
						DisplayTable1();
						JOptionPane.showMessageDialog(null, "Nothing Entered!");
					}
					else {						
						connection = DbConnect.getDBConnection();
						String searchQuery = "select * from accounts where Invoice_No LIKE '"+txtSearch_p1.getText()+"'";
						PreparedStatement ps = connection.prepareStatement(searchQuery);
						ResultSet rs = ps.executeQuery();
						table1.setModel(DbUtils.resultSetToTableModel(rs));	
					}	
				} 
				catch (Exception e1) {
						JOptionPane.showMessageDialog(null,e1);
				}
			}
		});
		btnSearch_P1.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\search.png"));
		btnSearch_P1.setToolTipText("Search");
		btnSearch_P1.setBounds(954, 11, 36, 36);
		panel_Body_P1.add(btnSearch_P1);
	
		//Refresh Button 01
		
		JButton button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					DisplayTable1();
					JOptionPane.showMessageDialog(null, "Refreshed!");
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		button_2.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\refresh.png"));
		button_2.setToolTipText("Refresh");
		button_2.setBounds(552, 12, 75, 35);
		panel_Body_P1.add(button_2);

	//Delete Button 01
		
		JButton btnDelete1 = new JButton("");
		btnDelete1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int selectRow = table1.getSelectedRow();
				
				String tid = (table1.getModel().getValueAt(selectRow, 0).toString());
				
				com.service.accountsService.removepaidaccounts(tid);
				
				try {
					DisplayTable1();
					txtTID.setText(null);
					txtINO.setText(null);
					txtCus.setText(null);
					txtEmail.setText(null);
					txtTP.setText(null);
					txtAmount.setText(null);
					cmb1.setSelectedItem(null);
				} 
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnDelete1.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\delete.png"));
		btnDelete1.setToolTipText("Delete Record");
		btnDelete1.setBounds(637, 12, 75, 35);
		panel_Body_P1.add(btnDelete1);
		
	//Paid Table Scroll Pane	
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(10, 58, 999, 202);
		panel_Body_P1.add(scrollPane1);
		
		// Paid Table
		table1 = new JTable();
		scrollPane1.setViewportView(table1);
		table1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int selectRow = table1.getSelectedRow();
				
				txtTID.setText(table1.getModel().getValueAt(selectRow, 0).toString());
				txtINO.setText(table1.getModel().getValueAt(selectRow, 1).toString());
				
				txtCus.setText(table1.getModel().getValueAt(selectRow, 2).toString());
				txtEmail.setText(table1.getModel().getValueAt(selectRow, 3).toString());
				txtTP.setText(table1.getModel().getValueAt(selectRow, 4).toString());
				txtAmount.setText(table1.getModel().getValueAt(selectRow, 5).toString());
				
				cmb1.setSelectedItem(table1.getModel().getValueAt(selectRow, 6).toString());
				
				TDate.setDate((Date) table1.getModel().getValueAt(selectRow, 7));	
				
			}
		});
		table1.setBackground(Color.GRAY);
		try {
			DisplayTable1();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//New Panel
		
		JPanel panel_Body_P2 = new JPanel();
		panel_Body_P2.setBackground(new Color(189, 183, 107));
		panel_Body_P2.setBounds(265, 412, 1019, 273);
		contentPane.add(panel_Body_P2);
		panel_Body_P2.setLayout(null);
		
		//Table 2 Heading
		
		JLabel lblPendingTransactionList = new JLabel("Pending Transaction List");
		lblPendingTransactionList.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblPendingTransactionList.setBounds(10, 0, 450, 47);
		panel_Body_P2.add(lblPendingTransactionList);
		
       //Search Button 02

		txtSearch_p2 = new JTextField();
		txtSearch_p2.setToolTipText("Search Iteam Name");
		txtSearch_p2.setMargin(new Insets(2, 10, 2, 10));
		txtSearch_p2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSearch_p2.setColumns(10);
		txtSearch_p2.setBounds(758, 17, 186, 30);
		panel_Body_P2.add(txtSearch_p2);
		
		JButton btnSearch_P2 = new JButton("");
		btnSearch_P2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String searchp1 = txtSearch_p2.getText();
				
				try {
					if(searchp1.isEmpty()==true) {
						DisplayTable2();
						JOptionPane.showMessageDialog(null, "Nothing Entered!");
					}
					else {						
						connection = DbConnect.getDBConnection();
						String searchQuery = "select * from accounts where Invoice_No LIKE '"+txtSearch_p2.getText()+"'";
						PreparedStatement ps = connection.prepareStatement(searchQuery);
						ResultSet rs = ps.executeQuery();
						table2.setModel(DbUtils.resultSetToTableModel(rs));	
					}	
				} 
				catch (Exception e1) {
						JOptionPane.showMessageDialog(null,e1);
				}
			}
		});
		btnSearch_P2.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\search.png"));
		btnSearch_P2.setToolTipText("Search");
		btnSearch_P2.setBounds(954, 11, 36, 36);
		panel_Body_P2.add(btnSearch_P2);
		
		//Refresh Button 2
		
		JButton button_4 = new JButton("");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					DisplayTable2();
					JOptionPane.showMessageDialog(null, "Refreshed!");
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		button_4.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\refresh.png"));
		button_4.setToolTipText("Refresh");
		button_4.setBounds(552, 12, 75, 35);
		panel_Body_P2.add(button_4);
		
		//Delete Button 2
		
		JButton btnDelete2 = new JButton("");
		btnDelete2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectRow = table2.getSelectedRow();
				
				String tid = (table2.getModel().getValueAt(selectRow, 0).toString());
				
				com.service.accountsService.removependingaccounts(tid);
				
				try {
					DisplayTable2();
					txtTID.setText(null);
					txtINO.setText(null);
					txtCus.setText(null);
					txtEmail.setText(null);
					txtTP.setText(null);
					txtAmount.setText(null);
					cmb1.setSelectedItem(null);
				} 
				catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnDelete2.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\delete.png"));
		btnDelete2.setToolTipText("Delete");
		btnDelete2.setBounds(637, 12, 75, 35);
		panel_Body_P2.add(btnDelete2);
		
		//Pending Table's Scroll pane
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(10, 58, 999, 204);
		panel_Body_P2.add(scrollPane2);
		
		//Pending Table
		
		table2 = new JTable();
		scrollPane2.setViewportView(table2);
		table2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			int selectRow = table2.getSelectedRow();
			
			txtTID.setText(table2.getModel().getValueAt(selectRow, 0).toString());
			txtINO.setText(table2.getModel().getValueAt(selectRow, 1).toString());
			
			txtCus.setText(table2.getModel().getValueAt(selectRow, 2).toString());
			txtEmail.setText(table2.getModel().getValueAt(selectRow, 3).toString());
			txtTP.setText(table2.getModel().getValueAt(selectRow, 4).toString());
			txtAmount.setText(table2.getModel().getValueAt(selectRow, 5).toString());
			
			cmb1.setSelectedItem(table2.getModel().getValueAt(selectRow, 6).toString());
			
			TDate.setDate((Date) table1.getModel().getValueAt(selectRow, 7));	
			
			}
		});
		
		table2.setBackground(Color.GRAY);
		try {
			DisplayTable2();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	/*
	JComboBox cmb1 = new JComboBox();
	cmb1.addItem("WP LD 4648");
	cmb1.addItem("WP LB 5489");
	cmb1.addItem("WP LD 3467");
	cmb1.addItem("WP LH 1003");
	cmb1.addItem("WP LH 1016");
	cmb1.setSelectedItem(null);
	cmb1.setBounds(10, 281, 224, 25);
	panel_Navigator.add(cmb1);

	*/
}
}
