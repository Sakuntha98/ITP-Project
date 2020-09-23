package com.Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JComboBox;

import com.model.Bill;
import com.model.maintenance;
import com.service.BillServices;
import com.service.maintenanceService;
import com.toedter.calendar.JCalendar;
import com.util.DbConnect;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class BillManagement extends JFrame {

	private PreparedStatement preparedStatement;
	private static Connection connection;
	
	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtAmount;
	private JTextField txtS1;
	private JTable table_p1;
	private JTextField txtS2;
	private JTable table_p2;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BillManagement frame = new BillManagement();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	BillServices BillServices = new BillServices();
	Bill Bill = new Bill();

	public void DisplayTable1() throws  InstantiationException, IllegalAccessException, SQLException, ClassNotFoundException {
		
		connection = DbConnect.getDBConnection();
		
		String selectQuery1 = "SELECT * FROM `bills1` ORDER BY `bills1`.`Bill_ID` DESC";
		
		PreparedStatement p1 = connection.prepareStatement(selectQuery1);
		
		ResultSet rs1 = p1.executeQuery();
		
		table_p1.setModel(DbUtils.resultSetToTableModel(rs1));	
		
		p1.close();	
	}
	
	public void DisplayTable2() throws  InstantiationException, IllegalAccessException, SQLException, ClassNotFoundException {
		
		connection = DbConnect.getDBConnection();
		
		String selectQuery2 = "SELECT * FROM `bills2`";
		
		PreparedStatement p2 = connection.prepareStatement(selectQuery2);
		
		ResultSet rs2 = p2.executeQuery();
		
		table_p2.setModel(DbUtils.resultSetToTableModel(rs2));	
		
		p2.close();	
	}
	
	
	public BillManagement() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\avina\\Desktop\\IT18195644\\images\\wious.png"));
		setTitle("Bill Management System");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200, 200, 1300, 725);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_Head = new JPanel();
//		panel_Head.setBackground(Color.WHITE);
		panel_Head.setBackground(new Color(238, 232, 170));
		panel_Head.setBounds(292, 11, 992, 106);
		contentPane.add(panel_Head);
		panel_Head.setLayout(null);
		
		JLabel lblBillManagement = new JLabel("Bill Management");
		lblBillManagement.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblBillManagement.setBounds(99, 11, 691, 84);
		panel_Head.add(lblBillManagement);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\billLarge.png"));
		label_1.setBounds(21, 11, 117, 84);
		panel_Head.add(label_1);
		
		JButton button = new JButton("Sign Out");
		button.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\signout.png"));
		button.setToolTipText("Sign Out");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login info = new Login();
				Login.main(null);
			}
		});
		button.setBounds(857, 35, 125, 35);
		panel_Head.add(button);
		
		JButton btnNotice = new JButton("Notice");
		btnNotice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Notices info = new Notices();
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Notices.main(null);
			}
		});
		btnNotice.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\note.png"));
		btnNotice.setBounds(722, 34, 125, 36);
		panel_Head.add(btnNotice);
		
		JPanel panel_Navigator = new JPanel();
		panel_Navigator.setBackground(new Color(189, 183, 107));
		panel_Navigator.setBounds(10, 11, 272, 674);
		contentPane.add(panel_Navigator);
		panel_Navigator.setLayout(null);
		
		JLabel lblBillId = new JLabel("Bill ID");
		lblBillId.setBounds(20, 11, 242, 14);
		panel_Navigator.add(lblBillId);
		
		txtID = new JTextField();
		txtID.setEnabled(false);
		txtID.setMargin(new Insets(2, 10, 2, 10));
		txtID.setColumns(10);
		txtID.setBounds(10, 36, 252, 25);
		panel_Navigator.add(txtID);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setBounds(20, 132, 242, 14);
		panel_Navigator.add(lblAmount);
		
		txtAmount = new JTextField();
		txtAmount.setMargin(new Insets(2, 10, 2, 10));
		txtAmount.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				boolean validate1 = txtAmount.getText().matches("^[0-9]*$");
				
				if(validate1) {
					
				}else {
					JOptionPane.showMessageDialog(null, "Can't use speacial Characters or letters for ammount. Try again!");
					txtAmount.setText(null);
				}
			}
		});
		txtAmount.setColumns(10);
		txtAmount.setBounds(10, 157, 252, 25);
		panel_Navigator.add(txtAmount);
		
		JLabel lblBank = new JLabel("Supplier Email");
		lblBank.setBounds(20, 201, 242, 14);
		panel_Navigator.add(lblBank);
		
		JComboBox cmb2 = new JComboBox();
		cmb2.addItem("sid1001@wious.lk");
		cmb2.addItem("sid1002@wious.lk");
		cmb2.addItem("sid1003@wious.lk");
		cmb2.addItem("sid1004@wious.lk");
		cmb2.addItem("sid1005@wious.lk");
		cmb2.setSelectedItem(null);
		cmb2.setBounds(10, 221, 252, 25);
		panel_Navigator.add(cmb2);
		
		JLabel label = new JLabel("Bank Name");
		label.setBounds(20, 262, 242, 14);
		panel_Navigator.add(label);
		
		JComboBox cmb3 = new JComboBox();
		cmb3.addItem("BOC");
		cmb3.addItem("Sampath Bank");
		cmb3.addItem("Commercial Bank");
		cmb3.addItem("Peoples Bank");
		cmb3.setSelectedItem(null);
		cmb3.setBounds(10, 282, 252, 25);
		panel_Navigator.add(cmb3);
		
		JLabel label_2 = new JLabel("Account Number");
		label_2.setBounds(20, 325, 242, 14);
		panel_Navigator.add(label_2);
		
		JComboBox cmb4 = new JComboBox();
		cmb4.addItem("18195644 - BOC");
		cmb4.addItem("18195330 - Sampath Bank");
		cmb4.addItem("18169454 - Commercial Bank");
		cmb4.addItem("18081244 - Peoples Bank");
		cmb4.setSelectedItem(null);
		cmb4.setBounds(10, 350, 252, 25);
		panel_Navigator.add(cmb4);
		
		JComboBox cmb1 = new JComboBox();
		cmb1.addItem("Machine");
		cmb1.addItem("Vehicle");
		cmb1.addItem("Other Items");
		cmb1.setSelectedItem(null);
		cmb1.setBounds(10, 96, 252, 25);
		panel_Navigator.add(cmb1);
		
		JLabel lblType = new JLabel("Category");
		lblType.setBounds(20, 76, 242, 14);
		panel_Navigator.add(lblType);
		
		JCalendar OrderDate = new JCalendar();
		OrderDate.setBounds(10, 393, 252, 153);
		panel_Navigator.add(OrderDate);
		
		JButton btnInsert = new JButton("Add Now");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String a1 = (String) cmb1.getSelectedItem().toString();
				String a2 = txtAmount.getText().toString();
				String a3 = (String) cmb2.getSelectedItem().toString();
				String a4 = (String) cmb3.getSelectedItem().toString();
				String a5 = (String) cmb4.getSelectedItem().toString();
				java.util.Date Date = OrderDate.getDate();				
				String txtDate = new SimpleDateFormat("yyyy-mm-dd").format(Date);
				
							
				if(a1.isEmpty() || a2.isEmpty() || a3.isEmpty() ||a4.isEmpty() || a5.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please fill all the Fields!");
				}
				else {
					int selectRowp1 = table_p1.getSelectedRow();
													
					try {
						connection = DbConnect.getDBConnection();
					
												
						String insertQuery = "INSERT INTO bills2(Category, Amount, Supplier_ID, Bank, Account_ID,OrderDate) VALUES('"+a1+"','"+a2+"','"+a3+"','"+a4+"','"+a5+"','"+txtDate+"')";
						PreparedStatement ps = connection.prepareStatement(insertQuery);
						ps.executeUpdate();
						JOptionPane.showMessageDialog(null, "Bill created successfully!");
						ps.close();
						
						String rid = txtID.getText().toString();
						
						if(!rid.isEmpty()) {
							try {
								connection = DbConnect.getDBConnection();
																
								String deleteRequest = "DELETE FROM bills1 WHERE (Bill_ID = '"+rid+"')";
								PreparedStatement pst = connection.prepareStatement(deleteRequest);
								pst.executeUpdate();
								pst.close();
							}
							
							catch(Exception e) {
								JOptionPane.showMessageDialog(null, e);
							}
						}
						
					}
					
					catch(Exception e) {
						JOptionPane.showMessageDialog(null, e);
					}
				
					try {
						DisplayTable1();
						DisplayTable2();
					} 
					catch (Exception e) {
						e.printStackTrace();
					}		
				}
			}
		});
		btnInsert.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\add.png"));
		btnInsert.setToolTipText("Add Now");
		btnInsert.setBounds(10, 582, 252, 35);
		panel_Navigator.add(btnInsert);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\insert.png"));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String id = txtID.getText().toString();
				String a1 = (String) cmb1.getSelectedItem().toString();
				String a2 = txtAmount.getText().toString();
				String a3 = (String) cmb2.getSelectedItem().toString();
				String a4 = (String) cmb3.getSelectedItem().toString();
				String a5 = (String) cmb4.getSelectedItem().toString();
				java.util.Date Date = OrderDate.getDate();				
				String txtDate = new SimpleDateFormat("yyyy-mm-dd").format(Date);
				
							
				if(a1.isEmpty()|| a2.isEmpty() || a3.isEmpty() ||a4.isEmpty() || a5.isEmpty() || txtDate.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please fill all the Fields!");
				}
				else {
					int selectRowp1 = table_p2.getSelectedRow();
													
					try {
						connection = DbConnect.getDBConnection();
						
						String insertQuery = "UPDATE bills2 SET Category = '"+a1+"', Amount = '"+a2+"', Supplier_ID = '"+a3+"', Bank = '"+a4+"', Account_ID = '"+a5+"', OrderDate = '"+txtDate+"' WHERE (Bill_ID = '"+id+"')";
						PreparedStatement ps = connection.prepareStatement(insertQuery);
						ps.executeUpdate();
						JOptionPane.showMessageDialog(null, "Bill Update successfully!");
						ps.close();
						
					}
					
					catch(Exception e) {
						JOptionPane.showMessageDialog(null, e);
					}
				
					try {
						DisplayTable1();
						DisplayTable2();
					} 
					catch (Exception e) {
						e.printStackTrace();
					}		
				}
			}
		});
		btnUpdate.setToolTipText("Update");
		btnUpdate.setBounds(10, 628, 252, 35);
		panel_Navigator.add(btnUpdate);
		
		JPanel panel_Body_P2 = new JPanel();
		panel_Body_P2.setBackground(new Color(189, 183, 107));
		panel_Body_P2.setBounds(292, 413, 992, 272);
		contentPane.add(panel_Body_P2);
		panel_Body_P2.setLayout(null);
		
		JLabel lblBillManagement_1 = new JLabel("Bill Management");
		lblBillManagement_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblBillManagement_1.setBounds(10, 0, 375, 47);
		panel_Body_P2.add(lblBillManagement_1);
		
		JButton BtnRefreshP2 = new JButton("");
		BtnRefreshP2.addActionListener(new ActionListener() {
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
		BtnRefreshP2.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\refresh.png"));
		BtnRefreshP2.setToolTipText("Data Clear. Can not be undo");
		BtnRefreshP2.setBounds(435, 12, 100, 35);
		panel_Body_P2.add(BtnRefreshP2);
		
		JButton BtnDeleteP2 = new JButton("");
		BtnDeleteP2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int selectRow = table_p2.getSelectedRow();
				
				String BId = (table_p2.getModel().getValueAt(selectRow, 0).toString());
				
				com.service.BillServices.removeBill(BId);
				
				try {
					DisplayTable2();
				} 
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		BtnDeleteP2.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\delete.png"));
		BtnDeleteP2.setToolTipText("Refresh");
		BtnDeleteP2.setBounds(545, 12, 110, 35);
		panel_Body_P2.add(BtnDeleteP2);
		
		txtS2 = new JTextField();
		txtS2.setToolTipText("Search Iteam Name");
		txtS2.setMargin(new Insets(2, 10, 2, 10));
		txtS2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtS2.setColumns(10);
		txtS2.setBounds(688, 12, 231, 30);
		panel_Body_P2.add(txtS2);
		
		JButton BtnSearch_P2 = new JButton("");
		BtnSearch_P2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String searchp1 = txtS2.getText();
				
				try {
					if(searchp1.isEmpty()) {
						DisplayTable1();
						JOptionPane.showMessageDialog(null, "Entered is empty!");
					}
					else {						
						connection = DbConnect.getDBConnection();
						String searchQuery = "select * from bills2 where Bill_ID LIKE '"+searchp1+"'";
						PreparedStatement ps = connection.prepareStatement(searchQuery);
						ResultSet rs = ps.executeQuery();
						table_p2.setModel(DbUtils.resultSetToTableModel(rs));	
					}	
				} 
				catch (Exception e1) {
						JOptionPane.showMessageDialog(null,e1);
				}
			}
		});
		BtnSearch_P2.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\search.png"));
		BtnSearch_P2.setToolTipText("Search");
		BtnSearch_P2.setBounds(929, 10, 36, 36);
		panel_Body_P2.add(BtnSearch_P2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 58, 972, 203);
		panel_Body_P2.add(scrollPane_1);
		
		table_p2 = new JTable();
		scrollPane_1.setViewportView(table_p2);
		table_p2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int selectRow = table_p2.getSelectedRow();
	
				txtID.setText(table_p2.getModel().getValueAt(selectRow, 0).toString());
				cmb1.setSelectedItem(table_p2.getModel().getValueAt(selectRow, 1).toString());
				txtAmount.setText(table_p2.getModel().getValueAt(selectRow, 2).toString());
				cmb2.setSelectedItem(table_p2.getModel().getValueAt(selectRow, 3).toString());
				cmb3.setSelectedItem(table_p2.getModel().getValueAt(selectRow, 4).toString());
				cmb4.setSelectedItem(table_p2.getModel().getValueAt(selectRow, 5).toString());
				OrderDate.setDate((Date) table_p2.getModel().getValueAt(selectRow, 6));
				
			}
		});
		table_p2.setBackground(Color.GRAY);
		DisplayTable2();
		
		JPanel panel_Body_P1 = new JPanel();
		panel_Body_P1.setBackground(new Color(189, 183, 107));
		panel_Body_P1.setBounds(292, 130, 992, 272);
		contentPane.add(panel_Body_P1);
		panel_Body_P1.setLayout(null);
		
		JLabel label_5 = new JLabel("Ordered List");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label_5.setBounds(10, 0, 196, 47);
		panel_Body_P1.add(label_5);
		
		JButton BtnRefreshP1 = new JButton("");
		BtnRefreshP1.addActionListener(new ActionListener() {
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
		BtnRefreshP1.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\refresh.png"));
		BtnRefreshP1.setToolTipText("Data Clear. Can not be undo");
		BtnRefreshP1.setBounds(554, 13, 100, 35);
		panel_Body_P1.add(BtnRefreshP1);
		
		txtS1 = new JTextField();
		txtS1.setToolTipText("Search Iteam Name");
		txtS1.setMargin(new Insets(2, 10, 2, 10));
		txtS1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtS1.setColumns(10);
		txtS1.setBounds(693, 13, 231, 30);
		panel_Body_P1.add(txtS1);
		
		JButton BtnSearch_P1 = new JButton("");
		BtnSearch_P1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String searchp1 = txtS1.getText();
				
				try {
					if(searchp1.isEmpty()) {
						DisplayTable1();
						JOptionPane.showMessageDialog(null, "Entered is empty!");
					}
					else {						
						connection = DbConnect.getDBConnection();
						String searchQuery = "select * from bills1 where Bill_ID LIKE '"+searchp1+"'";
						PreparedStatement ps = connection.prepareStatement(searchQuery);
						ResultSet rs = ps.executeQuery();
						table_p1.setModel(DbUtils.resultSetToTableModel(rs));	
					}	
				} 
				catch (Exception e1) {
						JOptionPane.showMessageDialog(null,e1);
				}
			}
		});
		BtnSearch_P1.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\search.png"));
		BtnSearch_P1.setToolTipText("Search");
		BtnSearch_P1.setBounds(934, 11, 36, 36);
		panel_Body_P1.add(BtnSearch_P1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 54, 972, 207);
		panel_Body_P1.add(scrollPane);
		
		table_p1 = new JTable();
		scrollPane.setViewportView(table_p1);
		table_p1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int selectRow = table_p1.getSelectedRow();
	
				txtID.setText(table_p1.getModel().getValueAt(selectRow, 0).toString());
				cmb1.setSelectedItem(table_p1.getModel().getValueAt(selectRow, 2).toString());
				txtAmount.setText(table_p1.getModel().getValueAt(selectRow, 5).toString());
				cmb2.setSelectedItem(table_p1.getModel().getValueAt(selectRow, 6).toString());
				cmb3.setSelectedItem(null);
				cmb4.setSelectedItem(null);
				OrderDate.setDate((Date) table_p1.getModel().getValueAt(selectRow, 7));
				
			}
		});
		table_p1.setBackground(Color.GRAY);
		DisplayTable1();
		
	}
}
