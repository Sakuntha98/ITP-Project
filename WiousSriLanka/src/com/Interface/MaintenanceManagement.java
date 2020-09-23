package com.Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import com.Interface.*;
import com.model.*;
import com.service.*;
import com.util.DbConnect;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Font;
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
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Window;

import com.toedter.calendar.JCalendar;


import net.proteanit.sql.DbUtils;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;


public class MaintenanceManagement extends JFrame {


	private PreparedStatement preparedStatement;
	private static Connection connection;
	
	private JPanel contentPane;
	private JTextField txtSearch_p1;
	private JTextField txt1;
	private JTextField txt2;
	private JTextField txt4;
	private JTextField txt5;
	private JTextField txtSearch_p2;
	private JTable table_p1;
	private JTable table_p2;
	private JTextField txtRID;
	private JTextField txtQTY;
	private JTextField txt6;
	private JTextField txtbill;
	private JTextField txtPrice;
	
	maintenanceService maintenanceService = new maintenanceService();
	maintenance maintenance = new maintenance();
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MaintenanceManagement frame = new MaintenanceManagement();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public void DisplayTable1() throws  InstantiationException, IllegalAccessException, SQLException, ClassNotFoundException {
		
		connection = DbConnect.getDBConnection();
		
		String selectQuery2 = "SELECT * FROM request";
		
		PreparedStatement p2 = connection.prepareStatement(selectQuery2);
		
		ResultSet rs2 = p2.executeQuery();
		
		table_p1.setModel(DbUtils.resultSetToTableModel(rs2));	
		
		p2.close();	
	}
	
	public void DisplayTable2() throws  InstantiationException, IllegalAccessException, SQLException, ClassNotFoundException {
		
		connection = DbConnect.getDBConnection();
		
		String selectQuery2 = "SELECT * FROM bills1";
		
		PreparedStatement p2 = connection.prepareStatement(selectQuery2);
		
		ResultSet rs2 = p2.executeQuery();
		
		table_p2.setModel(DbUtils.resultSetToTableModel(rs2));	
		
		p2.close();	
	}
	
	
	public MaintenanceManagement() throws InstantiationException, IllegalAccessException, SQLException, ClassNotFoundException {
		setResizable(false);
		
		maintenanceService maintenanceService = new maintenanceService();
		maintenance maintenance = new maintenance();
		
		
		setTitle("Maintenance Management System");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\avina\\Desktop\\IT18195644\\images\\wious.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200, 200, 1300, 725);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_Head = new JPanel();
		panel_Head.setBackground(new Color(238, 232, 170));
		panel_Head.setBounds(241, 11, 1043, 116);
		contentPane.add(panel_Head);
		panel_Head.setLayout(null);
		
		JButton btnSignOut = new JButton("Sign Out");
		btnSignOut.setToolTipText("Sign Out");
		btnSignOut.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\signout.png"));
		btnSignOut.setBounds(898, 38, 125, 35);
		btnSignOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login info = new Login();
				Login.main(null);
			}
		});
		panel_Head.add(btnSignOut);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\maintenance.png"));
		label_1.setBounds(64, 11, 111, 94);
		panel_Head.add(label_1);
		
		JLabel lblMain = new JLabel("Maintenance Management");
		lblMain.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblMain.setBounds(185, 21, 610, 72);
		panel_Head.add(lblMain);
		
		JButton btnNotices = new JButton("Notices");
		btnNotices.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\note.png"));
		btnNotices.addActionListener(new ActionListener() {
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
		btnNotices.setBounds(763, 37, 125, 36);
		panel_Head.add(btnNotices);
		
		JPanel panel_Sub_Menu = new JPanel();
		panel_Sub_Menu.setBackground(new Color(189, 183, 107));
		panel_Sub_Menu.setBounds(10, 11, 221, 674);
		contentPane.add(panel_Sub_Menu);
		panel_Sub_Menu.setLayout(null);
		
		txt1 = new JTextField();
		txt1.setEditable(false);
		txt1.setMargin(new Insets(2, 10, 2, 10));
		txt1.setBounds(10, 36, 95, 25);
		panel_Sub_Menu.add(txt1);
		txt1.setColumns(10);
		
		txt2 = new JTextField();
		txt2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				boolean validate1 = txt2.getText().matches("^[A-Za-z ]*$");
				
				if(validate1) {
					
				}else {
					JOptionPane.showMessageDialog(null, "Can't use speacial Characters or numbers for name. Try again!");
					txt2.setText(null);
				}
			}
		});
		txt2.setMargin(new Insets(2, 10, 2, 10));
		txt2.setColumns(10);
		txt2.setBounds(10, 96, 200, 25);
		panel_Sub_Menu.add(txt2);
		
		txt4 = new JTextField();
		txt4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				boolean validate1 = txt4.getText().matches("^[0-9]*$");
				
				if(validate1) {
					
				}else {
					JOptionPane.showMessageDialog(null, "Can't use speacial Characters or letters. Try again!");
					txt4.setText(null);
				}		
			}
		});
		txt4.setMargin(new Insets(2, 10, 2, 10));
		txt4.setColumns(10);
		txt4.setBounds(10, 216, 95, 25);
		panel_Sub_Menu.add(txt4);
		
		txt5 = new JTextField();
		txt5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				boolean validate1 = txt5.getText().matches("^[0-9.]*$");
				
				if(validate1) {
					
				}else {
					JOptionPane.showMessageDialog(null, "Can't use speacial Characters or letters. Try again!");
					txt5.setText(null);
				}		
			}
		});
		txt5.setMargin(new Insets(2, 10, 2, 10));
		txt5.setColumns(10);
		txt5.setBounds(115, 216, 95, 25);
		panel_Sub_Menu.add(txt5);
		
		JComboBox cmb3 = new JComboBox();
		cmb3.addItem("Machine");
		cmb3.addItem("Vehicle");
		cmb3.addItem("Other Items");
		cmb3.setSelectedItem(null);
		cmb3.setBounds(10, 156, 200, 25); 
		panel_Sub_Menu.add(cmb3);
		
		JComboBox Combo7 = new JComboBox();
		Combo7.addItem("sid1001@wious.lk");
		Combo7.addItem("sid1002@wious.lk");
		Combo7.addItem("sid1003@wious.lk");
		Combo7.addItem("sid1004@wious.lk");
		Combo7.addItem("sid1005@wious.lk");
		Combo7.setSelectedItem(null);
		Combo7.setBounds(10, 347, 200, 25);
		panel_Sub_Menu.add(Combo7);
		
		JCalendar OrderDate =  new JCalendar();
		OrderDate.setWeekOfYearVisible(false);
		OrderDate.setBounds(10, 408, 198, 153);
		panel_Sub_Menu.add(OrderDate);
		
		JButton btnAddNow = new JButton("Add Now");
		btnAddNow.setToolTipText("Add Now");
		btnAddNow.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent arg0) {
				
				String a1 = txt2.getText();
				String a2 = (String) cmb3.getSelectedItem().toString();
				String a3 = txt4.getText();
				String a4 = txt5.getText();
				String a5 = txt6.getText();
				String a6 =  (String) Combo7.getSelectedItem().toString();
				java.util.Date Date = OrderDate.getDate();				
				String txtDate = new SimpleDateFormat("yyyy-mm-dd").format(Date);
				
							
				if(a1.isEmpty()|| a2.isEmpty() || a3.isEmpty() ||a4.isEmpty() || a5.isEmpty() || a6.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please fill all the Fields!");
				}
				else {
					int selectRowp1 = table_p1.getSelectedRow();
													
					try {
						connection = DbConnect.getDBConnection();
						
												
						String insertQuery = "INSERT INTO bills1(ItemName, Category, Quantity, Price, NetPayment, SupplierEmail, OrderDate) VALUES('"+a1+"','"+a2+"','"+a3+"','"+a4+"','"+a5+"','"+a6+"','"+txtDate+"')";
						PreparedStatement ps = connection.prepareStatement(insertQuery);
						ps.executeUpdate();
						JOptionPane.showMessageDialog(null, "Item Order successfully!");
						ps.close();
						
						String rid = txt1.getText();
						
						if(!rid.isEmpty()) {
							try {
								connection = DbConnect.getDBConnection();
																
								String deleteRequest = "DELETE FROM request WHERE (Request_ID = '"+rid+"')";
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
		btnAddNow.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\add.png"));
		btnAddNow.setBounds(10, 582, 200, 35);
		panel_Sub_Menu.add(btnAddNow);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setToolTipText("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String id = txtbill.getText();
				String a1 = txt2.getText();
				String a2 = (String) cmb3.getSelectedItem().toString();
				String a3 = txt4.getText();
				String a4 = txt5.getText();
				String a5 = txt6.getText();
				String a6 =  (String) Combo7.getSelectedItem().toString();
				java.util.Date Date = OrderDate.getDate();				
				String txtDate = new SimpleDateFormat("yyyy-mm-dd").format(Date);
				
							
				if(a1.isEmpty()|| a2.isEmpty() || a3.isEmpty() ||a4.isEmpty() || a5.isEmpty() || a6.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please fill all the Fields!");
				}
				else {
					int selectRowp1 = table_p1.getSelectedRow();
													
					try {
						connection = DbConnect.getDBConnection();
						
												
						String insertQuery = "UPDATE bills1 SET ItemName = '"+a1+"', Category = '"+a2+"', Quantity = '"+a3+"', Price = '"+a4+"', NetPayment = '"+a5+"', SupplierEmail = '"+a6+"', OrderDate = '"+txtDate+"' WHERE (Bill_ID = '"+id+"')";
						PreparedStatement ps = connection.prepareStatement(insertQuery);
						ps.executeUpdate();
						JOptionPane.showMessageDialog(null, "Order Update successfully!");
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
		btnUpdate.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\insert.png"));
		btnUpdate.setBounds(10, 628, 200, 35);
		panel_Sub_Menu.add(btnUpdate);
		
		JLabel lblA = new JLabel("Request ID");
		lblA.setBounds(25, 11, 100, 14);
		panel_Sub_Menu.add(lblA);
		
		JLabel lblIteamName = new JLabel("Iteam Name");
		lblIteamName.setBounds(20, 71, 190, 14);
		panel_Sub_Menu.add(lblIteamName);
		
		JLabel lblItemCategory = new JLabel("Item Category");
		lblItemCategory.setBounds(20, 132, 190, 14);
		panel_Sub_Menu.add(lblItemCategory);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(20, 192, 95, 14);
		panel_Sub_Menu.add(lblQuantity);
		
		JLabel lblPriceForItem = new JLabel("Price for Item");
		lblPriceForItem.setBounds(125, 192, 96, 14);
		panel_Sub_Menu.add(lblPriceForItem);
		
		JLabel lblTotalPayment = new JLabel("Total Payment");
		lblTotalPayment.setBounds(20, 261, 190, 14);
		panel_Sub_Menu.add(lblTotalPayment);
		
		txt6 = new JTextField();
		txt6.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				boolean validate1 = txt6.getText().matches("^[0-9.]*$");
				
				if(validate1) {
					
				}else {
					JOptionPane.showMessageDialog(null, "Can't use speacial Characters or letters. Try again!");
					txt6.setText(null);
				}		
			}
		});
		txt6.setMargin(new Insets(2, 10, 2, 10));
		txt6.setColumns(10);
		txt6.setBounds(10, 286, 200, 25);
		panel_Sub_Menu.add(txt6);
		
		JLabel lblSupplierEmail = new JLabel("Supplier Email");
		lblSupplierEmail.setBounds(25, 322, 190, 14);
		panel_Sub_Menu.add(lblSupplierEmail);
		
		JLabel lblOrderDate = new JLabel("Order Date");
		lblOrderDate.setBounds(25, 383, 190, 14);
		panel_Sub_Menu.add(lblOrderDate);
		
		JLabel lblBillId = new JLabel("Bill ID");
		lblBillId.setBounds(145, 11, 76, 14);
		panel_Sub_Menu.add(lblBillId);
		
		txtbill = new JTextField();
		txtbill.setEditable(false);
		txtbill.setMargin(new Insets(2, 10, 2, 10));
		txtbill.setColumns(10);
		txtbill.setBounds(115, 36, 95, 25);
		panel_Sub_Menu.add(txtbill);
			
		JPanel panel_Body_top = new JPanel();
		panel_Body_top.setBackground(new Color(189, 183, 107));
		panel_Body_top.setBounds(241, 138, 1043, 263);
		contentPane.add(panel_Body_top);
		panel_Body_top.setLayout(null);
		
		txtSearch_p1 = new JTextField();
		txtSearch_p1.setToolTipText("Search Iteam Name");
		txtSearch_p1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSearch_p1.setBounds(747, 13, 231, 30);
		panel_Body_top.add(txtSearch_p1);
		txtSearch_p1.setMargin(new Insets(2, 10, 2, 10));
		txtSearch_p1.setColumns(10);
		
		JButton btnSearch_p1 = new JButton("");
		btnSearch_p1.setToolTipText("Search");
		btnSearch_p1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String searchp1 = txtSearch_p1.getText();
				
				try {
					if(searchp1.isEmpty()==true) {
						DisplayTable1();
						JOptionPane.showMessageDialog(null, "Entered is empty!");
					}
					else {						
						connection = DbConnect.getDBConnection();
						String searchQuery = "select * from request where ItemName LIKE '"+txtSearch_p1.getText()+"'";
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
		btnSearch_p1.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\search.png"));
		btnSearch_p1.setBounds(987, 12, 36, 36);
		panel_Body_top.add(btnSearch_p1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 56, 803, 195);
		panel_Body_top.add(scrollPane_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_2.setViewportView(scrollPane_1);
		
		table_p1 = new JTable();
		table_p1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int selectRow = table_p1.getSelectedRow();
				txt1.setEditable(false);
				txtbill.setEditable(false);
				
				txt6.setText(null);
				txtbill.setText(null);
				Combo7.setSelectedItem(null);		
				txt1.setText(table_p1.getModel().getValueAt(selectRow, 0).toString());
				txt2.setText(table_p1.getModel().getValueAt(selectRow, 1).toString());
				cmb3.setSelectedItem(table_p1.getModel().getValueAt(selectRow, 2).toString());
				txt4.setText(table_p1.getModel().getValueAt(selectRow, 3).toString());
				txt5.setText(table_p1.getModel().getValueAt(selectRow, 4).toString());
				
				txtRID.setEditable(false);
				txtRID.setText(table_p1.getModel().getValueAt(selectRow, 0).toString());
				txtQTY.setText(table_p1.getModel().getValueAt(selectRow, 3).toString());
				txtPrice.setText(table_p1.getModel().getValueAt(selectRow, 4).toString());
			}
		});
		scrollPane_1.setViewportView(table_p1);
		table_p1.setBackground(Color.GRAY);
				
		DisplayTable1();
		
		JLabel lblRequestList = new JLabel("Request List");
		lblRequestList.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblRequestList.setBounds(25, 0, 161, 47);
		panel_Body_top.add(lblRequestList);
		
		JLabel label = new JLabel("Request ID Number");
		label.setBounds(833, 57, 190, 14);
		panel_Body_top.add(label);
		
		txtRID = new JTextField();
		txtRID.setEditable(false);
		txtRID.setMargin(new Insets(2, 10, 2, 10));
		txtRID.setColumns(10);
		txtRID.setBounds(823, 82, 210, 25);
		panel_Body_top.add(txtRID);
		
		JLabel Quantity = new JLabel("Quantity");
		Quantity.setBounds(833, 127, 89, 14);
		panel_Body_top.add(Quantity);
		
		txtQTY = new JTextField();
		txtQTY.setMargin(new Insets(2, 10, 2, 10));
		txtQTY.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				boolean validate1 = txtQTY.getText().matches("^[0-9]*$");
				
				if(validate1) {
					
				}else {
					JOptionPane.showMessageDialog(null, "Invalid quantity. Try again!");
					txtQTY.setText(null);
				}
			}
		});
		txtQTY.setColumns(10);
		txtQTY.setBounds(823, 152, 99, 25);
		panel_Body_top.add(txtQTY);
		
		JButton btnUpdateQty = new JButton("Update");
		btnUpdateQty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String Rid = txtRID.getText().toString();
				String a1 = txtQTY.getText().toString();
				String a2 = txtPrice.getText().toString();
				
				if(a1.isEmpty() || a2.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please fill all the Fields!");
				}
				else {
					
					try {
						connection = DbConnect.getDBConnection();
												
						String UpdateQuery = "UPDATE request SET Quantity = '"+a1+"', ItemPrize = '"+a2+"' WHERE (Request_ID = '"+Rid+"')";
						PreparedStatement ps = connection.prepareStatement(UpdateQuery);
						ps.executeUpdate();
						JOptionPane.showMessageDialog(null, "Request update successfully!");
						ps.close();
						
					}
					
					catch(Exception e) {
						JOptionPane.showMessageDialog(null, e);
					}
				
					try {
						DisplayTable1();
					} 
					catch (Exception e) {
						e.printStackTrace();
					}		
				}
			}
		});
		btnUpdateQty.setToolTipText("Update Quantity");
		btnUpdateQty.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\insert.png"));
		btnUpdateQty.setBounds(878, 201, 110, 35);
		panel_Body_top.add(btnUpdateQty);
		
		JButton btnDataClear_p1 = new JButton("");
		btnDataClear_p1.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\clear.png"));
		btnDataClear_p1.setToolTipText("Data Clear. Can not be undo");
		btnDataClear_p1.setBounds(185, 12, 100, 35);
		panel_Body_top.add(btnDataClear_p1);
		
		JButton btnRefresh_p1 = new JButton("");
		btnRefresh_p1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
				JOptionPane.showMessageDialog(null, "Refreshed!");
			}
		});
		btnRefresh_p1.setToolTipText("Refresh");
		btnRefresh_p1.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\refresh.png"));
		btnRefresh_p1.setBounds(295, 12, 110, 35);
		panel_Body_top.add(btnRefresh_p1);
		
		txtPrice = new JTextField();
		txtPrice.setMargin(new Insets(2, 10, 2, 10));
		txtPrice.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				boolean validate1 = txtPrice.getText().matches("^[0-9.]*$");
				
				if(validate1) {
					
				}else {
					JOptionPane.showMessageDialog(null, "Invalid price. Try again!");
					txtPrice.setText(null);
				}
			}
		});
		txtPrice.setColumns(10);
		txtPrice.setBounds(934, 152, 99, 25);
		panel_Body_top.add(txtPrice);
		
		JLabel lblItemPrice = new JLabel("Item Price");
		lblItemPrice.setBounds(944, 127, 89, 14);
		panel_Body_top.add(lblItemPrice);
		
		JPanel panel_body_bottom = new JPanel();
		panel_body_bottom.setBackground(new Color(189, 183, 107));
		panel_body_bottom.setBounds(241, 412, 1043, 273);
		contentPane.add(panel_body_bottom);
		panel_body_bottom.setLayout(null);
		
		JButton btnSearch_p2 = new JButton("");
		btnSearch_p2.setToolTipText("Search");
		btnSearch_p2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String searchp2 = txtSearch_p2.getText();
				
				try {
					if(searchp2.isEmpty()==true) {
							DisplayTable2();	
							JOptionPane.showMessageDialog(null, "Entered is empty!");
					}
					else {						
						connection = DbConnect.getDBConnection();
						String searchQuery = "select * from bills1 where ItemName LIKE '"+txtSearch_p2.getText()+"'";
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
		btnSearch_p2.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\search.png"));
		btnSearch_p2.setBounds(988, 11, 35, 35);
		panel_body_bottom.add(btnSearch_p2);
		
		txtSearch_p2 = new JTextField();
		txtSearch_p2.setToolTipText("Search ItemName");
		txtSearch_p2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSearch_p2.setBounds(748, 12, 231, 30);
		txtSearch_p2.setMargin(new Insets(2, 10, 2, 10));
		txtSearch_p2.setColumns(10);
		panel_body_bottom.add(txtSearch_p2);
		
		JButton btnDelete_p2 = new JButton("");
		btnDelete_p2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int selectRow = table_p2.getSelectedRow();
			
				String billid = (table_p2.getModel().getValueAt(selectRow, 0).toString());
				
				com.service.maintenanceService.removeOrder(billid);
				
				try {
					DisplayTable2();
				} 
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnDelete_p2.setToolTipText("Delete Selected Row");
		btnDelete_p2.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\delete.png"));
		btnDelete_p2.setBounds(584, 11, 100, 35);
		panel_body_bottom.add(btnDelete_p2);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 57, 1023, 205);
		panel_body_bottom.add(scrollPane_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane_3.setViewportView(scrollPane);
		scrollPane.setForeground(Color.BLACK);
		
		table_p2 = new JTable();
		table_p2.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int selectRow = table_p2.getSelectedRow();
				txt1.setEditable(false);
				txtbill.setEditable(false);
				txt1.setText(null);
				txtbill.setText(table_p2.getModel().getValueAt(selectRow, 0).toString());
				txt2.setText(table_p2.getModel().getValueAt(selectRow, 1).toString());
				cmb3.setSelectedItem(table_p2.getModel().getValueAt(selectRow, 2).toString());
				txt4.setText(table_p2.getModel().getValueAt(selectRow, 3).toString());
				txt5.setText(table_p2.getModel().getValueAt(selectRow, 4).toString());
				txt6.setText(table_p2.getModel().getValueAt(selectRow, 5).toString());
				Combo7.setSelectedItem(table_p2.getModel().getValueAt(selectRow, 6).toString());
				OrderDate.setDate((Date) table_p2.getModel().getValueAt(selectRow, 7));
				
				txtRID.setText(null);
				txtQTY.setText(null);
				txtPrice.setText(null);
			}
		});
		scrollPane.setViewportView(table_p2);
		table_p2.setBackground(Color.GRAY);
		
		DisplayTable2();
		
		JLabel lblOrderList = new JLabel("Ordered List");
		lblOrderList.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblOrderList.setBounds(25, 0, 156, 47);
		panel_body_bottom.add(lblOrderList);
		
		JButton btnDataClear_p2 = new JButton("");
		btnDataClear_p2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Delete All the data in table
				
			}
		});
		btnDataClear_p2.setToolTipText("Data Clear. Can not be undo");
		btnDataClear_p2.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\clear.png"));
		btnDataClear_p2.setBounds(185, 12, 100, 35);
		panel_body_bottom.add(btnDataClear_p2);
		
		JButton btnRefresh_p2 = new JButton("");
		btnRefresh_p2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
				JOptionPane.showMessageDialog(null, "Refreshed!");
			}
		});
		btnRefresh_p2.setToolTipText("Refresh");
		btnRefresh_p2.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\refresh.png"));
		btnRefresh_p2.setBounds(295, 11, 110, 35);
		panel_body_bottom.add(btnRefresh_p2);
	}
}
