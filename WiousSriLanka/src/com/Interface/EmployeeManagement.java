package com.Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.model.employee;
import com.model.maintenance;
import com.service.employeeService;
import com.service.maintenanceService;
import com.util.DbConnect;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Insets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.Toolkit;

public class EmployeeManagement extends JFrame {

	private PreparedStatement preparedStatement;
	private static Connection connection;
	
	private JPanel contentPane;
	private JTextField txt1;
	private JTextField txt2;
	private JTextField txt4;
	private JTextField txt5;
	private JTextField txt3;
	private JTextField txt6;
	private JTable table_p1;
	private JTextField txtSearch_p1;
	private JTextField US_ID;
	private JTextField US_S;
	private JTextField txtSearch_p2;
	private JTable table_p2;
	private JTextField NoticeTo;
	private JTextField Note;
	private JTextField txt7;

	employee employee = new employee();
	employeeService employeeService = new employeeService();
	private JTextField NoteNumber;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeManagement frame = new EmployeeManagement();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void DisplayTable1() throws  InstantiationException, IllegalAccessException, SQLException, ClassNotFoundException {
		
		connection = DbConnect.getDBConnection();
		
		String selectQuery2 = "SELECT * FROM employee";
		
		PreparedStatement p2 = connection.prepareStatement(selectQuery2);
		
		ResultSet rs2 = p2.executeQuery();
		
		table_p1.setModel(DbUtils.resultSetToTableModel(rs2));	
		
		p2.close();	
	}
	
	public void DisplayTable2() throws  InstantiationException, IllegalAccessException, SQLException, ClassNotFoundException {
		
		connection = DbConnect.getDBConnection();
		
		String selectQuery2 = "SELECT * FROM notice";
		
		PreparedStatement p2 = connection.prepareStatement(selectQuery2);
		
		ResultSet rs2 = p2.executeQuery();
		
		table_p2.setModel(DbUtils.resultSetToTableModel(rs2));	
		
		p2.close();	
	}
	
	public EmployeeManagement() throws InstantiationException, IllegalAccessException, SQLException, ClassNotFoundException {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\avina\\Desktop\\IT18195644\\images\\wious.png"));
		setResizable(false);
		setTitle("Employee Management System");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200, 200, 1300, 725);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_Dashboard_Large = new JPanel();
		panel_Dashboard_Large.setBackground(new Color(189, 183, 107));
		panel_Dashboard_Large.setBounds(10, 138, 244, 547);
		contentPane.add(panel_Dashboard_Large);
		panel_Dashboard_Large.setLayout(null);
		
		txt1 = new JTextField();
		txt1.setEditable(false);
		txt1.setMargin(new Insets(2, 10, 2, 10));
		txt1.setColumns(10);
		txt1.setBounds(10, 36, 224, 25);
		txt1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				boolean validate1 = txt1.getText().matches("^[WH0-9]*$");
				
				if(validate1) {
					
				}else {
					JOptionPane.showMessageDialog(null, "Invalid ID. Try again!");
					txt1.setText(null);
				}
			}
		});
		panel_Dashboard_Large.add(txt1);
		
		JLabel lblEmployeeId = new JLabel("Wious Employee ID");
		lblEmployeeId.setBounds(44, 11, 190, 14);
		panel_Dashboard_Large.add(lblEmployeeId);
		
		JLabel lblEmployeeName = new JLabel("Employee Name");
		lblEmployeeName.setBounds(39, 71, 190, 14);
		panel_Dashboard_Large.add(lblEmployeeName);
		
		txt2 = new JTextField();
		txt2.setMargin(new Insets(2, 10, 2, 10));
		txt2.setColumns(10);
		txt2.setBounds(10, 96, 224, 25);
		txt2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				boolean validate1 = txt2.getText().matches("^[A-Za-z ]*$");
				
				if(validate1) {
					
				}else {
					JOptionPane.showMessageDialog(null, "Invalid Name. Try again!");
					txt2.setText(null);
				}
			}
		});
		panel_Dashboard_Large.add(txt2);
		
		JLabel lblNicPassportId = new JLabel("NIC/ Passport ID Number");
		lblNicPassportId.setBounds(39, 132, 190, 14);
		panel_Dashboard_Large.add(lblNicPassportId);
		
		JLabel lblWiousEmail = new JLabel("Wious Email");
		lblWiousEmail.setBounds(39, 192, 95, 14);
		panel_Dashboard_Large.add(lblWiousEmail);
		
		txt4 = new JTextField();
		txt4.setMargin(new Insets(2, 10, 2, 10));
		txt4.setColumns(10);
		txt4.setBounds(10, 216, 224, 25);
		txt4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				boolean validate1 = txt4.getText().matches("^[0-9a-z@.]*$");
				
				if(validate1) {
					
				}else {
					JOptionPane.showMessageDialog(null, "Invalid Email. Try again!");
					txt4.setText(null);
				}
			}
		});
		panel_Dashboard_Large.add(txt4);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setBounds(39, 261, 190, 14);
		panel_Dashboard_Large.add(lblPhoneNumber);
		
		txt5 = new JTextField();
		txt5.setMargin(new Insets(2, 10, 2, 10));
		txt5.setColumns(10);
		txt5.setBounds(10, 286, 224, 25);
		txt5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				boolean validate1 = txt5.getText().matches("^[0-9]*$");
				
				if(validate1) {
					
				}else {
					JOptionPane.showMessageDialog(null, "Invalid phone number. Try again!");
					txt5.setText(null);
				}
			}
		});
		panel_Dashboard_Large.add(txt5);
		
		JLabel lblWiousPassword = new JLabel("Password");
		lblWiousPassword.setBounds(44, 322, 190, 14);
		panel_Dashboard_Large.add(lblWiousPassword);
		
		JButton btnInsert = new JButton("Add Now");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String a2 = txt2.getText();
				String a3 = txt3.getText();
				String a4 = txt4.getText();
				String a5 = txt5.getText();
				String a6 = txt6.getText();
				
							
				if(a2.isEmpty() || a3.isEmpty() ||a4.isEmpty() || a5.isEmpty() || a6.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please fill all the Fields!");
				}
				else {
					int selectRowp1 = table_p1.getSelectedRow();
													
					try {
						connection = DbConnect.getDBConnection();
												
						String insertQuery = "INSERT INTO employee(wname, wnic, wemail, wphone, wpassword) VALUES ('"+a2+"','"+a3+"','"+a4+"','"+a5+"','"+a6+"')";
						PreparedStatement ps = connection.prepareStatement(insertQuery);
						ps.executeUpdate();
						JOptionPane.showMessageDialog(null, "Employee added successfully!");
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
		btnInsert.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\add.png"));
		btnInsert.setToolTipText("Add Now");
		btnInsert.setBounds(10, 455, 224, 35);
		panel_Dashboard_Large.add(btnInsert);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String id = txt1.getText();
				String a1 = txt2.getText();
				String a2 = txt3.getText();
				String a3 = txt4.getText();
				String a4 = txt5.getText();
				String a5 = txt6.getText();
				
				if(a1.isEmpty()|| a2.isEmpty() || a3.isEmpty() ||a4.isEmpty() || a5.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please fill all the Fields!");
				}
				else if(id.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Cannot be Update!");
				}
				else {
					int selectRowp1 = table_p1.getSelectedRow();
													
					try {
						connection = DbConnect.getDBConnection();
						
												
						String insertQuery = "UPDATE employee SET wname = '"+a1+"', wnic = '"+a2+"', wemail = '"+a3+"', wphone = '"+a4+"', wpassword = '"+a5+"' WHERE (wid = '"+id+"')";
						PreparedStatement ps = connection.prepareStatement(insertQuery);
						ps.executeUpdate();
						JOptionPane.showMessageDialog(null, "Details Update successfully!");
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
		btnUpdate.setToolTipText("Update");
		btnUpdate.setBounds(10, 501, 224, 35);
		panel_Dashboard_Large.add(btnUpdate);
		
		txt3 = new JTextField();
		txt3.setMargin(new Insets(2, 10, 2, 10));
		txt3.setColumns(10);
		txt3.setBounds(10, 156, 224, 25);
		txt3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				boolean validate1 = txt3.getText().matches("^[0-9V]*$");
				
				if(validate1) {
					
				}else {
					JOptionPane.showMessageDialog(null, "Invalid NIC/Passport ID. Try again!");
					txt3.setText(null);
				}
			}
		});
		panel_Dashboard_Large.add(txt3);
		
		txt6 = new JTextField();
		txt6.setMargin(new Insets(2, 10, 2, 10));
		txt6.setColumns(10);
		txt6.setBounds(10, 347, 224, 25);
		panel_Dashboard_Large.add(txt6);
		
		txt7 = new JTextField();
		txt7.setEditable(false);
		txt7.setMargin(new Insets(2, 10, 2, 10));
		txt7.setColumns(10);
		txt7.setBounds(10, 408, 224, 25);
		txt7.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				boolean validate1 = txt7.getText().matches("^[0-9.]*$");
				
				if(validate1) {
					
				}else {
					JOptionPane.showMessageDialog(null, "Invalid Salary. Try again!");
					txt7.setText(null);
				}
			}
		});
		panel_Dashboard_Large.add(txt7);
		
		JLabel label_2 = new JLabel("Salary/ Bonus/ Total Points");
		label_2.setBounds(44, 383, 190, 14);
		panel_Dashboard_Large.add(label_2);
		
		JPanel panel_Head = new JPanel();
		panel_Head.setBackground(new Color(238, 232, 170));
		panel_Head.setBounds(10, 11, 1274, 116);
		contentPane.add(panel_Head);
		panel_Head.setLayout(null);
		
		JLabel lblEmployeeManagement = new JLabel("Employee Management");
		lblEmployeeManagement.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblEmployeeManagement.setBounds(119, 23, 691, 72);
		panel_Head.add(lblEmployeeManagement);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\profileHead.png"));
		label.setBounds(37, 11, 111, 94);
		panel_Head.add(label);
		
		JButton button_2 = new JButton("Sign Out");
		button_2.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\signout.png"));
		button_2.setToolTipText("Sign Out");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login info = new Login();
				Login.main(null);
			}
		});
		button_2.setBounds(1139, 40, 125, 35);
		panel_Head.add(button_2);
		
		JButton btnNotice = new JButton("Notice");
		btnNotice.setToolTipText("Notice");
		btnNotice.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\note.png"));
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
		btnNotice.setBounds(1004, 39, 125, 36);
		panel_Head.add(btnNotice);
		
		JPanel panel_Body_Large = new JPanel();
		panel_Body_Large.setBackground(new Color(189, 183, 107));
		panel_Body_Large.setBounds(264, 138, 748, 284);
		contentPane.add(panel_Body_Large);
		panel_Body_Large.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 56, 727, 217);
		panel_Body_Large.add(scrollPane);
		
		table_p1 = new JTable();
		table_p1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int selectRow = table_p1.getSelectedRow();
				txt1.setText(table_p1.getModel().getValueAt(selectRow, 0).toString());
				txt2.setText(table_p1.getModel().getValueAt(selectRow, 1).toString());
				txt3.setText(table_p1.getModel().getValueAt(selectRow, 2).toString());
				txt4.setText(table_p1.getModel().getValueAt(selectRow, 3).toString());
				txt5.setText(table_p1.getModel().getValueAt(selectRow, 4).toString());
				txt6.setText(table_p1.getModel().getValueAt(selectRow, 5).toString());
				txt7.setText(table_p1.getModel().getValueAt(selectRow, 6).toString());
				
				US_ID.setText(table_p1.getModel().getValueAt(selectRow, 0).toString());
				US_S.setText(table_p1.getModel().getValueAt(selectRow, 6).toString());
				
				NoteNumber.setText(null);
				NoticeTo.setText(null);
				Note.setText(null);
			}
		});
		scrollPane.setViewportView(table_p1);
		table_p1.setBackground(Color.GRAY);
		DisplayTable1();
		
		JLabel lblEmployeeList = new JLabel("Employee List");
		lblEmployeeList.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblEmployeeList.setBounds(10, 1, 161, 47);
		panel_Body_Large.add(lblEmployeeList);
		
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
			}
		});
		btnRefresh_p1.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\refresh.png"));
		btnRefresh_p1.setToolTipText("Refresh");
		btnRefresh_p1.setBounds(333, 11, 75, 35);
		panel_Body_Large.add(btnRefresh_p1);
		
		txtSearch_p1 = new JTextField();
		txtSearch_p1.setToolTipText("Search Iteam Name");
		txtSearch_p1.setMargin(new Insets(2, 10, 2, 10));
		txtSearch_p1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSearch_p1.setColumns(10);
		txtSearch_p1.setBounds(503, 15, 186, 30);
		panel_Body_Large.add(txtSearch_p1);
		
		JButton BtnSearch_p1 = new JButton("");
		BtnSearch_p1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String searchp1 = txtSearch_p1.getText();
				
				try {
					if(searchp1.isEmpty()==true) {
						DisplayTable1();
						JOptionPane.showMessageDialog(null, "Entered is empty!");
					}
					else {						
						connection = DbConnect.getDBConnection();
						String searchQuery = "select * from employee where wid LIKE '"+txtSearch_p1.getText()+"'";
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
		BtnSearch_p1.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\search.png"));
		BtnSearch_p1.setToolTipText("Search");
		BtnSearch_p1.setBounds(699, 9, 36, 36);
		panel_Body_Large.add(BtnSearch_p1);
		
		JButton btnDelete_p1 = new JButton("");
		btnDelete_p1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int selectRow = table_p1.getSelectedRow();
				
				String wid = (table_p1.getModel().getValueAt(selectRow, 0).toString());
				
				com.service.employeeService.removemember(wid);
				
				try {
					DisplayTable1();
				} 
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnDelete_p1.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\delete.png"));
		btnDelete_p1.setToolTipText("Delete");
		btnDelete_p1.setBounds(418, 11, 75, 35);
		panel_Body_Large.add(btnDelete_p1);
		
		JPanel panel_Body_Small = new JPanel();
		panel_Body_Small.setBackground(new Color(189, 183, 107));
		panel_Body_Small.setBounds(264, 433, 748, 252);
		contentPane.add(panel_Body_Small);
		panel_Body_Small.setLayout(null);
		
		JLabel lblNoteNow = new JLabel("Note Now");
		lblNoteNow.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNoteNow.setBounds(10, 0, 161, 47);
		panel_Body_Small.add(lblNoteNow);
		
		JButton BtnClearAll = new JButton("");
		BtnClearAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Delete ALL details
			}
		});
		BtnClearAll.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\clear.png"));
		BtnClearAll.setToolTipText("Data Clear. Can not be undo");
		BtnClearAll.setBounds(181, 10, 75, 35);
		panel_Body_Small.add(BtnClearAll);
		
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
			}
		});
		btnRefresh_p2.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\refresh.png"));
		btnRefresh_p2.setToolTipText("Refresh");
		btnRefresh_p2.setBounds(333, 10, 75, 35);
		panel_Body_Small.add(btnRefresh_p2);
		
		JButton btnDelete_p2 = new JButton("");
		btnDelete_p2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					int selectRow = table_p2.getSelectedRow();
					
					String nid = (table_p2.getModel().getValueAt(selectRow, 0).toString());
					
					com.service.employeeService.removenote(nid);
					
					try {
						DisplayTable2();
					} 
					catch (Exception e) {
						e.printStackTrace();
					}
				
			}
		});
		btnDelete_p2.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\delete.png"));
		btnDelete_p2.setToolTipText("Refresh");
		btnDelete_p2.setBounds(418, 10, 75, 35);
		panel_Body_Small.add(btnDelete_p2);
		
		txtSearch_p2 = new JTextField();
		txtSearch_p2.setToolTipText("Search Iteam Name");
		txtSearch_p2.setMargin(new Insets(2, 10, 2, 10));
		txtSearch_p2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSearch_p2.setColumns(10);
		txtSearch_p2.setBounds(503, 14, 186, 30);
		panel_Body_Small.add(txtSearch_p2);
		
		JButton BtnSearch_p2 = new JButton("");
		BtnSearch_p2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String searchp2 = txtSearch_p2.getText();
				
				try {
					if(searchp2.isEmpty()) {
						DisplayTable2();
						JOptionPane.showMessageDialog(null, "Entered is empty!");
					}
					else {						
						connection = DbConnect.getDBConnection();
						String searchQuery = "select * from notice where NoticeID LIKE '"+searchp2+"'";
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
		BtnSearch_p2.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\search.png"));
		BtnSearch_p2.setToolTipText("Search");
		BtnSearch_p2.setBounds(699, 8, 36, 36);
		panel_Body_Small.add(BtnSearch_p2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 53, 725, 188);
		panel_Body_Small.add(scrollPane_1);
		
		table_p2 = new JTable();
		scrollPane_1.setViewportView(table_p2);
		table_p2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int selectRow = table_p2.getSelectedRow();
				txt1.setText(null);
				txt2.setText(null);
				txt3.setText(null);
				txt4.setText(null);
				txt5.setText(null);
				txt6.setText(null);
				txt7.setText(null);
				US_ID.setText(null);
				US_S.setText(null);
				
				NoteNumber.setText(table_p2.getModel().getValueAt(selectRow, 0).toString());
				NoticeTo.setText(table_p2.getModel().getValueAt(selectRow, 1).toString());
				Note.setText(table_p2.getModel().getValueAt(selectRow, 2).toString());
			}
		});
		table_p2.setBackground(Color.GRAY);
		DisplayTable2();
		
		JPanel panel_Body_End = new JPanel();
		panel_Body_End.setBackground(new Color(189, 183, 107));
		panel_Body_End.setBounds(1022, 138, 262, 284);
		contentPane.add(panel_Body_End);
		panel_Body_End.setLayout(null);
		
		JLabel label_1 = new JLabel("Wious Employee ID");
		label_1.setBounds(25, 56, 216, 14);
		panel_Body_End.add(label_1);
		
		US_ID = new JTextField();
		US_ID.setEditable(false);
		US_ID.setMargin(new Insets(2, 10, 2, 10));
		US_ID.setColumns(10);
		US_ID.setBounds(10, 81, 242, 25);
		panel_Body_End.add(US_ID);
		
		JLabel lblSalaryPoints = new JLabel("Salary Points");
		lblSalaryPoints.setBounds(20, 117, 190, 14);
		panel_Body_End.add(lblSalaryPoints);
		
		US_S = new JTextField();
		US_S.setMargin(new Insets(2, 10, 2, 10));
		US_S.setColumns(10);
		US_S.setBounds(10, 142, 242, 25);
		panel_Body_End.add(US_S);
		
		JLabel lblUpdateSalary = new JLabel("Update Salary");
		lblUpdateSalary.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblUpdateSalary.setBounds(10, 0, 242, 47);
		panel_Body_End.add(lblUpdateSalary);
		
		JButton button_5 = new JButton("Update");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String id = US_ID.getText();
				String a1 = US_S.getText();
				
				if(a1.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please fill salary details!");
				}
				else if(id.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Cannot be Update!");
				}
				else {
					int selectRowp1 = table_p1.getSelectedRow();
													
					try {
						connection = DbConnect.getDBConnection();
						
												
						String insertQuery = "UPDATE employee SET wsalary = '"+a1+"' WHERE (wid = '"+id+"')";
						PreparedStatement ps = connection.prepareStatement(insertQuery);
						ps.executeUpdate();
						JOptionPane.showMessageDialog(null, "Details Update successfully!");
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
		button_5.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\insert.png"));
		button_5.setToolTipText("Update");
		button_5.setBounds(10, 195, 242, 35);
		panel_Body_End.add(button_5);
		
		
		
		JPanel panel_Dashboard_Small = new JPanel();
		panel_Dashboard_Small.setBackground(new Color(189, 183, 107));
		panel_Dashboard_Small.setBounds(1022, 433, 262, 252);
		contentPane.add(panel_Dashboard_Small);
		panel_Dashboard_Small.setLayout(null);
		
		JLabel lblAddNoteice = new JLabel("Add Notice");
		lblAddNoteice.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblAddNoteice.setBounds(10, 0, 242, 47);
		panel_Dashboard_Small.add(lblAddNoteice);
		
		JLabel lblNoticeTo = new JLabel("Notice To");
		lblNoticeTo.setBounds(121, 45, 131, 14);
		panel_Dashboard_Small.add(lblNoticeTo);
		
		NoticeTo = new JTextField();
		NoticeTo.setMargin(new Insets(2, 10, 2, 10));
		NoticeTo.setColumns(10);
		NoticeTo.setBounds(111, 70, 141, 25);
		NoticeTo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				boolean validate1 = NoticeTo.getText().matches("^[WH0-9]*$");
				
				if(validate1) {
					
				}else {
					JOptionPane.showMessageDialog(null, "Invalid Wious ID. Try again!");
					NoticeTo.setText(null);
				}
			}
		});
		panel_Dashboard_Small.add(NoticeTo);
		
		JButton btnEnterNote = new JButton("Enter Note");
		btnEnterNote.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String a1 = NoticeTo.getText();
				String a2 = Note.getText();
											
				if(a1.isEmpty() || a2.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please fill all the Fields!");
				}
				else {
					int selectRowp1 = table_p2.getSelectedRow();
													
					try {
						connection = DbConnect.getDBConnection();
												
						String insertQuery = "INSERT INTO notice(NoticeTo, Note) VALUES ('"+a1+"','"+a2+"')";
						PreparedStatement ps = connection.prepareStatement(insertQuery);
						ps.executeUpdate();
						JOptionPane.showMessageDialog(null, "Notice added successfully!");
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
		btnEnterNote.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\add.png"));
		btnEnterNote.setToolTipText("Update");
		btnEnterNote.setBounds(99, 194, 153, 35);
		panel_Dashboard_Small.add(btnEnterNote);
		
		JLabel lblNotice = new JLabel("Notice");
		lblNotice.setBounds(20, 103, 190, 14);
		panel_Dashboard_Small.add(lblNotice);
		
		Note = new JTextField();
		Note.setMargin(new Insets(2, 10, 2, 10));
		Note.setColumns(10);
		Note.setBounds(10, 128, 242, 25);
		panel_Dashboard_Small.add(Note);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String id = NoteNumber.getText();
				String a1 = Note.getText();
				String a2 = NoticeTo.getText();
				
				if(a1.isEmpty() || a2.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please fill all the fields!");
				}
				else if(id.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Cannot be Update!");
				}
				else {
					int selectRowp1 = table_p1.getSelectedRow();
													
					try {
						connection = DbConnect.getDBConnection();
						
												
						String insertQuery = "UPDATE notice SET NoticeTo = '"+a2+"', Note = '"+a1+"' WHERE (NoticeID = '"+id+"')";
						PreparedStatement ps = connection.prepareStatement(insertQuery);
						ps.executeUpdate();
						JOptionPane.showMessageDialog(null, "Notice Update successfully!");
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
		button.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\insert.png"));
		button.setToolTipText("Update");
		button.setBounds(10, 194, 83, 35);
		panel_Dashboard_Small.add(button);
		
		JLabel lblNo = new JLabel("No");
		lblNo.setBounds(20, 45, 82, 14);
		panel_Dashboard_Small.add(lblNo);
		
		NoteNumber = new JTextField();
		NoteNumber.setEditable(false);
		NoteNumber.setMargin(new Insets(2, 10, 2, 10));
		NoteNumber.setColumns(10);
		NoteNumber.setBounds(10, 70, 92, 25);
		panel_Dashboard_Small.add(NoteNumber);
	}
}
