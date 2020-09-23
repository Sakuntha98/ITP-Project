package com.Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import com.Interface.*;
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

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class DeliveryManagement extends JFrame {

	private JPanel contentPane;
	private JTextField txtSearch_p1;
	private JTextField txtSearch_p2;
	private JTable table_p1;
	private JTable table_p2;
	private JTextField txtDID;
	private JTextField txt1;
	private JTextField txt2;
	private JTextField txt3;
	private JTextField txtBID;


	private PreparedStatement preparedStatement;
	private static Connection connection;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeliveryManagement frame = new DeliveryManagement();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public void DisplayTable1() throws  InstantiationException, IllegalAccessException, SQLException, ClassNotFoundException {
		
		connection = DbConnect.getDBConnection();
		
		String selectQuery2 = "SELECT * FROM delivery";
		
		PreparedStatement p2 = connection.prepareStatement(selectQuery2);
		
		ResultSet rs2 = p2.executeQuery();
		
		table_p1.setModel(DbUtils.resultSetToTableModel(rs2));	
		
		p2.close();	
	}
	
	public void DisplayTable2() throws  InstantiationException, IllegalAccessException, SQLException, ClassNotFoundException {
		
		connection = DbConnect.getDBConnection();
		
		String selectQuery2 = "SELECT * FROM deliverydone";
		
		PreparedStatement p2 = connection.prepareStatement(selectQuery2);
		
		ResultSet rs2 = p2.executeQuery();
		
		table_p2.setModel(DbUtils.resultSetToTableModel(rs2));	
		
		p2.close();	
	}
	
	
	public DeliveryManagement() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\avina\\Desktop\\IT18195644\\images\\wious.png"));
		setTitle("Delivery Management");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200, 200, 1300, 725);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_Head = new JPanel();
		panel_Head.setBackground(new Color(238, 232, 170));
		panel_Head.setBounds(10, 11, 1274, 106);
		contentPane.add(panel_Head);
		panel_Head.setLayout(null);
		
		JLabel lblDeliveryManagement = new JLabel("Delivery Management");
		lblDeliveryManagement.setBounds(119, 11, 691, 84);
		lblDeliveryManagement.setFont(new Font("Tahoma", Font.PLAIN, 40));
		panel_Head.add(lblDeliveryManagement);
		
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
		button_7.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\signout.png"));
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login info = new Login();
				Login.main(null);
			}
		});
		button_7.setToolTipText("Sign Out");
		panel_Head.add(button_7);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\delivery.png"));
		label.setBounds(30, 11, 117, 84);
		panel_Head.add(label);
		
		JPanel panel_Navigator = new JPanel();
		panel_Navigator.setBackground(new Color(189, 183, 107));
		panel_Navigator.setBounds(10, 128, 245, 557);
		contentPane.add(panel_Navigator);
		panel_Navigator.setLayout(null);
		
		JLabel lblDeliveryId = new JLabel("Delivery ID");
		lblDeliveryId.setBounds(25, 11, 106, 14);
		panel_Navigator.add(lblDeliveryId);
		
		txtDID = new JTextField();
		txtDID.setMargin(new Insets(2, 10, 2, 10));
		txtDID.setEditable(false);
		txtDID.setColumns(10);
		txtDID.setBounds(10, 36, 78, 25);
		panel_Navigator.add(txtDID);
		
		JLabel lblCustomerName = new JLabel("Customer Name");
		lblCustomerName.setBounds(20, 71, 190, 14);
		panel_Navigator.add(lblCustomerName);
		
		txt1 = new JTextField();
		txt1.setMargin(new Insets(2, 10, 2, 10));
		txt1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				boolean validate1 = txt1.getText().matches("^[A-Za-z ]*$");
				
				if(validate1) {
					
				}else {
					JOptionPane.showMessageDialog(null, "Can't use speacial Characters or numbers for name. Try again!");
					txt1.setText(null);
				}		
			}
		});
		txt1.setColumns(10);
		txt1.setBounds(10, 96, 224, 25);
		panel_Navigator.add(txt1);
		
		JLabel lblDeliveryAddress = new JLabel("Delivery Address");
		lblDeliveryAddress.setBounds(20, 132, 190, 14);
		panel_Navigator.add(lblDeliveryAddress);
		
		txt2 = new JTextField();
		txt2.setMargin(new Insets(2, 10, 2, 10));
		txt2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				boolean validate1 = txt2.getText().matches("^[A-Za-z0-9./' ]*$");
				
				if(validate1) {
					
				}else {
					JOptionPane.showMessageDialog(null, "Invalid Address. Try again!");
					txt2.setText(null);
				}		
			}
		});
		txt2.setColumns(10);
		txt2.setBounds(10, 156, 224, 25);
		panel_Navigator.add(txt2);
		
		JLabel lblCustomerPhoneNumber = new JLabel("Customer Phone Number");
		lblCustomerPhoneNumber.setBounds(20, 192, 190, 14);
		panel_Navigator.add(lblCustomerPhoneNumber);
		
		JLabel lblVehicleNumber = new JLabel("Vehicle Number");
		lblVehicleNumber.setBounds(20, 261, 190, 14);
		panel_Navigator.add(lblVehicleNumber);
		
		JLabel lblAssignDriver = new JLabel("Assign Driver");
		lblAssignDriver.setBounds(25, 322, 190, 14);
		panel_Navigator.add(lblAssignDriver);
		
		JLabel lblPaymentType = new JLabel("Payment Type");
		lblPaymentType.setBounds(25, 383, 190, 14);
		panel_Navigator.add(lblPaymentType);
		
		txt3 = new JTextField();
		txt3.setMargin(new Insets(2, 10, 2, 10));
		txt3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				boolean validate1 = txt3.getText().matches("^[0-9]*$");
				
				if(validate1) {
					
				}else {
					JOptionPane.showMessageDialog(null, "Invalid phone number. Try again!");
					txt3.setText(null);
				}		
			}
		});
		txt3.setColumns(10);
		txt3.setBounds(10, 217, 224, 25);
		panel_Navigator.add(txt3);
		
		JComboBox cmb1 = new JComboBox();
		cmb1.addItem("WP LD 4648");
		cmb1.addItem("WP LB 5489");
		cmb1.addItem("WP LD 3467");
		cmb1.addItem("WP LH 1003");
		cmb1.addItem("WP LH 1016");
		cmb1.setSelectedItem(null);
		cmb1.setBounds(10, 281, 224, 25);
		panel_Navigator.add(cmb1);
		
		JComboBox cmb2 = new JComboBox();
		cmb2.addItem("Mr. Kumara - D1");
		cmb2.addItem("Mr. Lalith - D2");
		cmb2.addItem("Mr. Dushan - D3");
		cmb2.addItem("Mr. Amila - D4");
		cmb2.addItem("Mr. Nirmal - D5");
		cmb2.setSelectedItem(null);
		cmb2.setBounds(10, 341, 224, 25);
		panel_Navigator.add(cmb2);
		
		JComboBox cmb3 = new JComboBox();
		cmb3.addItem("Cash");
		cmb3.addItem("Cheque");
		cmb3.setSelectedItem(null);
		cmb3.setBounds(10, 403, 224, 25);
		panel_Navigator.add(cmb3);
		
		JButton btnCreateDelivery = new JButton("Create Delivery");
		btnCreateDelivery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String a1 = txtDID.getText();
				String a2 = txtBID.getText();
				String a3 = txt1.getText();
				String a4 = txt2.getText();
				String a5 = txt3.getText();
				String a6 = (String)cmb1.getSelectedItem().toString();
				String a7 = (String)cmb2.getSelectedItem().toString();
				String a8 = (String)cmb3.getSelectedItem().toString();
							
				if(a2.isEmpty() || a3.isEmpty() ||a4.isEmpty() || a5.isEmpty() || a6.isEmpty() || a7.isEmpty() || a8.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please fill all the Fields!");
				}
				else {
					int selectRowp1 = table_p1.getSelectedRow();
													
					try {
						connection = DbConnect.getDBConnection();
									
						String insertQuery = "INSERT INTO delivery (Bill_ID, Customer_Name, Customer_Address, Phone, Vehicle_No, Driver_Name, Payment)  VALUES('"+a2+"','"+a3+"','"+a4+"','"+a5+"','"+a6+"','"+a7+"','"+a8+"')";
						PreparedStatement ps = connection.prepareStatement(insertQuery);
						ps.executeUpdate();
						JOptionPane.showMessageDialog(null, "Delivery create successfully!");
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
		btnCreateDelivery.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\add.png"));
		btnCreateDelivery.setToolTipText("Add Now");
		btnCreateDelivery.setBounds(10, 465, 224, 35);
		panel_Navigator.add(btnCreateDelivery);
		
		JButton btnUpdateDelivery = new JButton("Update Delivery");
		btnUpdateDelivery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String a1 = txtDID.getText();
				String a2 = txtBID.getText();
				String a3 = txt1.getText();
				String a4 = txt2.getText();
				String a5 = txt3.getText();
				String a6 = (String)cmb1.getSelectedItem().toString();
				String a7 = (String)cmb2.getSelectedItem().toString();
				String a8 = (String)cmb3.getSelectedItem().toString();
							
				if(a2.isEmpty() || a3.isEmpty() ||a4.isEmpty() || a5.isEmpty() || a6.isEmpty() || a7.isEmpty() || a8.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please fill all the Fields!");
				}
				else {
					int selectRowp1 = table_p1.getSelectedRow();
													
					try {
						connection = DbConnect.getDBConnection();
												
						String UpdateQuery = "UPDATE delivery SET Bill_ID = '"+a2+"', Customer_Name = '"+a3+"', Customer_Address = '"+a4+"', Phone = '"+a5+"', Vehicle_No = '"+a6+"', Driver_Name = '"+a7+"', Payment = '"+a8+"' WHERE (Delivery_ID = '"+a1+"')";
						PreparedStatement ps = connection.prepareStatement(UpdateQuery);
						ps.executeUpdate();
						JOptionPane.showMessageDialog(null, "Delivery Update successfully!");
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
		btnUpdateDelivery.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\insert.png"));
		btnUpdateDelivery.setToolTipText("Update");
		btnUpdateDelivery.setBounds(10, 511, 224, 35);
		panel_Navigator.add(btnUpdateDelivery);
				
		JLabel lblBillId = new JLabel("Bill ID");
		lblBillId.setBounds(112, 11, 106, 14);
		panel_Navigator.add(lblBillId);
		
		txtBID = new JTextField();
		txtBID.setMargin(new Insets(2, 10, 2, 10));
		txtBID.setColumns(10);
		txtBID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				boolean validate1 = txtBID.getText().matches("^[0-9]*$");
				
				if(validate1) {
					
				}else {
					JOptionPane.showMessageDialog(null, "Can't use speacial Characters or letters. Try again!");
					txtBID.setText(null);
				}		
			}
		});
		txtBID.setBounds(98, 36, 136, 25);
		panel_Navigator.add(txtBID);
		
		JPanel panel_Body_P1 = new JPanel();
		panel_Body_P1.setBackground(new Color(189, 183, 107));
		panel_Body_P1.setBounds(265, 130, 1019, 271);
		contentPane.add(panel_Body_P1);
		panel_Body_P1.setLayout(null);
		
		JLabel lblUncompletedDeliveryList = new JLabel("Uncompleted Delivery List");
		lblUncompletedDeliveryList.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblUncompletedDeliveryList.setBounds(10, 0, 375, 47);
		panel_Body_P1.add(lblUncompletedDeliveryList);
		
		txtSearch_p1 = new JTextField();
		txtSearch_p1.setToolTipText("Search Iteam Name");
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
						JOptionPane.showMessageDialog(null, "Entered is empty!");
					}
					else {						
						connection = DbConnect.getDBConnection();
						String searchQuery = "select * from delivery where Bill_ID LIKE '"+txtSearch_p1.getText()+"'";
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
		btnSearch_P1.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\search.png"));
		btnSearch_P1.setToolTipText("Search");
		btnSearch_P1.setBounds(954, 11, 36, 36);
		panel_Body_P1.add(btnSearch_P1);
		
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
		
		JButton btnDelete_p1 = new JButton("");
		btnDelete_p1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int selectRow = table_p1.getSelectedRow();
				
				String wid = (table_p1.getModel().getValueAt(selectRow, 0).toString());
				
				com.service.deliveryService.removedelivery(wid);
				
				try {
					DisplayTable1();
				} 
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnDelete_p1.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\delete.png"));
		btnDelete_p1.setToolTipText("Refresh");
		btnDelete_p1.setBounds(637, 12, 75, 35);
		panel_Body_P1.add(btnDelete_p1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 58, 999, 202);
		panel_Body_P1.add(scrollPane);
		
		table_p1 = new JTable();
		scrollPane.setViewportView(table_p1);
		table_p1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int selectRow = table_p1.getSelectedRow();
				
				txtDID.setText(table_p1.getModel().getValueAt(selectRow, 0).toString());
				txtBID.setText(table_p1.getModel().getValueAt(selectRow, 1).toString());
				
				txt1.setText(table_p1.getModel().getValueAt(selectRow, 2).toString());
				txt2.setText(table_p1.getModel().getValueAt(selectRow, 3).toString());
				txt3.setText(table_p1.getModel().getValueAt(selectRow, 4).toString());
				
				cmb1.setSelectedItem(table_p1.getModel().getValueAt(selectRow, 5).toString());
				cmb2.setSelectedItem(table_p1.getModel().getValueAt(selectRow, 6).toString());
				cmb3.setSelectedItem(table_p1.getModel().getValueAt(selectRow, 7).toString());
			}
		});
		table_p1.setBackground(Color.GRAY);
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
		
		JButton btnExportCompleted = new JButton("Export as Completed");
		btnExportCompleted.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int selectRowp1 = table_p1.getSelectedRow();
				
				
				String a2 = txtBID.getText();
				String a3 = txt1.getText();
				String a4 = txt2.getText();
				String a5 = txt3.getText();
				String a6 = (String)cmb1.getSelectedItem().toString();
				String a7 = (String)cmb2.getSelectedItem().toString();
				String a8 = (String)cmb3.getSelectedItem().toString();
				
				try {
					connection = DbConnect.getDBConnection();
					
					
					String insertQuery = "INSERT INTO deliverydone (wdbillid, wdcusname, wdcusaddress, wdcusphone, wdvehicleid, wddriverid, wdpaymenttype)  VALUES('"+a2+"','"+a3+"','"+a4+"','"+a5+"','"+a6+"','"+a7+"','"+a8+"')";
					PreparedStatement ps = connection.prepareStatement(insertQuery);
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "Delivery export successfully!");
					ps.close();
											
					
					
					String did = txtDID.getText();
					
					if(!did.isEmpty()) {
						try {
							connection = DbConnect.getDBConnection();
															
							String deleteRequest = "DELETE FROM delivery WHERE (Delivery_ID = '"+did+"')";
							PreparedStatement pst = connection.prepareStatement(deleteRequest);
							pst.executeUpdate();
							pst.close();
						}
						
						catch(Exception e1) {
							JOptionPane.showMessageDialog(null, e1);
						}
					}
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
				
				try {
					DisplayTable1();
					DisplayTable2();
				} 
				catch (Exception e1) {
					e1.printStackTrace();
				}		
			}

		});
		btnExportCompleted.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\exportas.png"));
		btnExportCompleted.setToolTipText("Refresh");
		btnExportCompleted.setBounds(331, 12, 211, 35);
		panel_Body_P1.add(btnExportCompleted);
		
		JPanel panel_Body_P2 = new JPanel();
		panel_Body_P2.setBackground(new Color(189, 183, 107));
		panel_Body_P2.setBounds(265, 412, 1019, 273);
		contentPane.add(panel_Body_P2);
		panel_Body_P2.setLayout(null);
		
		JLabel lblCompletedDeliveryList = new JLabel("Completed Delivery List");
		lblCompletedDeliveryList.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblCompletedDeliveryList.setBounds(10, 0, 450, 47);
		panel_Body_P2.add(lblCompletedDeliveryList);
		
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
						JOptionPane.showMessageDialog(null, "Entered is empty!");
					}
					else {						
						connection = DbConnect.getDBConnection();
						String searchQuery = "select * from deliverydone where wdbillid LIKE '"+txtSearch_p2.getText()+"'";
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
		btnSearch_P2.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\search.png"));
		btnSearch_P2.setToolTipText("Search");
		btnSearch_P2.setBounds(954, 11, 36, 36);
		panel_Body_P2.add(btnSearch_P2);
		
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
		
		JButton btnDelete_p2 = new JButton("");
		btnDelete_p2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectRow = table_p2.getSelectedRow();
				
				String wid = (table_p2.getModel().getValueAt(selectRow, 0).toString());
				
				com.service.deliveryService.removeCompletedelivery(wid);
				
				try {
					DisplayTable2();
				} 
				catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnDelete_p2.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\delete.png"));
		btnDelete_p2.setToolTipText("Refresh");
		btnDelete_p2.setBounds(637, 12, 75, 35);
		panel_Body_P2.add(btnDelete_p2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 58, 999, 204);
		panel_Body_P2.add(scrollPane_1);
		
		table_p2 = new JTable();
		scrollPane_1.setViewportView(table_p2);
		table_p2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int selectRow = table_p2.getSelectedRow();
				
				txtDID.setText(null);
				txtBID.setText(null);
				
				txt1.setText(null);
				txt2.setText(null);
				txt3.setText(null);
				
				cmb1.setSelectedItem(null);
				cmb2.setSelectedItem(null);
				cmb3.setSelectedItem(null);
			}
		});
		table_p2.setBackground(Color.GRAY);
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
	}
}
