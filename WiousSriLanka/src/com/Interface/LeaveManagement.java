package com.Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JComboBox;
import com.toedter.calendar.JCalendar;
import com.util.DbConnect;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class LeaveManagement extends JFrame {

	private PreparedStatement preparedStatement;
	private static Connection connection;
	
	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtEMPID;
	private JTextField txtEMPNAME;
	private JTextField txtREASON;
	private JTextField txtSearch1;
	private JTable table_P1;
	private JTextField txtSearch2;
	private JTable table_P2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LeaveManagement frame = new LeaveManagement();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void Display01() throws  InstantiationException, IllegalAccessException, SQLException, ClassNotFoundException {
		
		connection = DbConnect.getDBConnection();
		
		String selectQuery1 = "SELECT * FROM LeaveNUSRY";
		
		PreparedStatement p1 = connection.prepareStatement(selectQuery1);
		
		ResultSet rs1 = p1.executeQuery();
		
		table_P1.setModel(DbUtils.resultSetToTableModel(rs1));	
		
		p1.close();	
	}
	
	public void Display02() throws  InstantiationException, IllegalAccessException, SQLException, ClassNotFoundException {
		
		connection = DbConnect.getDBConnection();
		
		String selectQuery2 = "SELECT * FROM leave_request";
		
		PreparedStatement p2 = connection.prepareStatement(selectQuery2);
		
		ResultSet rs2 = p2.executeQuery();
		
		table_P2.setModel(DbUtils.resultSetToTableModel(rs2));	
		
		p2.close();	
	}
	
	@SuppressWarnings("deprecation")
	public LeaveManagement() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\avina\\Desktop\\New folder (2)\\IT18195644\\images\\wious.png"));
		setTitle("Leave Management System");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200, 200, 1300, 725);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_Head = new JPanel();
		panel_Head.setBackground(new Color(238, 232, 170));
		panel_Head.setBounds(10, 11, 1274, 114);
		contentPane.add(panel_Head);
		panel_Head.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\New folder (2)\\IT18195644\\images\\LeaveLarge.png"));
		label.setBounds(21, 11, 111, 94);
		panel_Head.add(label);
		
		JLabel lblLeaveManagement = new JLabel("Leave Management");
		lblLeaveManagement.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblLeaveManagement.setBounds(120, 21, 610, 72);
		panel_Head.add(lblLeaveManagement);
		
		JButton button = new JButton("Notices");
		button.addActionListener(new ActionListener() {
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
		button.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\New folder (2)\\IT18195644\\images\\note.png"));
		button.setBounds(1004, 35, 125, 36);
		panel_Head.add(button);
		
		JButton button_1 = new JButton("Sign Out");
		button_1.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\New folder (2)\\IT18195644\\images\\signout.png"));
		button_1.setToolTipText("Sign Out");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login info = new Login();
				Login.main(null);
			}
		});
		button_1.setBounds(1139, 36, 125, 35);
		panel_Head.add(button_1);
		
		JPanel panel_Navigator = new JPanel();
		panel_Navigator.setBackground(new Color(189, 183, 107));
		panel_Navigator.setBounds(10, 136, 446, 549);
		contentPane.add(panel_Navigator);
		panel_Navigator.setLayout(null);
		
		JLabel lblLeaveIdNumber = new JLabel("Leave ID Number");
		lblLeaveIdNumber.setBounds(20, 11, 190, 14);
		panel_Navigator.add(lblLeaveIdNumber);
		
		txtID = new JTextField();
		txtID.setEnabled(false);
		txtID.setMargin(new Insets(2, 10, 2, 10));
		txtID.setColumns(10);
		txtID.setBounds(10, 36, 200, 25);
		panel_Navigator.add(txtID);
		
		JLabel lblEmployeeName = new JLabel("Employee ID Number");
		lblEmployeeName.setBounds(20, 133, 190, 14);
		panel_Navigator.add(lblEmployeeName);
		
		txtEMPID = new JTextField();
		txtEMPID.setMargin(new Insets(2, 10, 2, 10));
		txtEMPID.setColumns(10);
		txtEMPID.setBounds(10, 158, 200, 25);
		panel_Navigator.add(txtEMPID);
		
		JLabel lblEmployeeName_1 = new JLabel("Employee Name");
		lblEmployeeName_1.setBounds(20, 72, 190, 14);
		panel_Navigator.add(lblEmployeeName_1);
		
		txtEMPNAME = new JTextField();
		txtEMPNAME.setMargin(new Insets(2, 10, 2, 10));
		txtEMPNAME.setColumns(10);
		txtEMPNAME.setBounds(10, 97, 200, 25);
		panel_Navigator.add(txtEMPNAME);
		
		JLabel lblReason = new JLabel("Reason ");
		lblReason.setBounds(244, 11, 190, 14);
		panel_Navigator.add(lblReason);
		
		txtREASON = new JTextField();
		txtREASON.setMargin(new Insets(2, 10, 2, 10));
		txtREASON.setColumns(10);
		txtREASON.setBounds(234, 36, 200, 25);
		panel_Navigator.add(txtREASON);
		
		JLabel lblLeaveType = new JLabel("Leave Type");
		lblLeaveType.setBounds(244, 73, 190, 14);
		panel_Navigator.add(lblLeaveType);
		
		JComboBox cmbTYPE = new JComboBox();
		cmbTYPE.addItem("Annual");
		cmbTYPE.addItem("Casual");
		cmbTYPE.setSelectedItem(null);
		cmbTYPE.setBounds(234, 97, 200, 25);
		panel_Navigator.add(cmbTYPE);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(244, 136, 190, 14);
		panel_Navigator.add(lblStatus);
		
		JComboBox cmbSTATUS = new JComboBox();
		cmbSTATUS.addItem("Accepted");
		cmbSTATUS.addItem("Rejected");
		cmbSTATUS.setSelectedItem(null);
		cmbSTATUS.setBounds(234, 160, 200, 25);
		panel_Navigator.add(cmbSTATUS);
		
		JCalendar FromDate = new JCalendar();
		FromDate.setBounds(10, 230, 198, 153);
		panel_Navigator.add(FromDate);
		
		JCalendar ToDate = new JCalendar();
		ToDate.setBounds(236, 230, 198, 153);
		panel_Navigator.add(ToDate);
		
		JLabel lblFrom = new JLabel("From");
		lblFrom.setBounds(18, 209, 190, 14);
		panel_Navigator.add(lblFrom);
		
		JLabel lblTo = new JLabel("To");
		lblTo.setBounds(244, 209, 190, 14);
		panel_Navigator.add(lblTo);
		
		JButton Insert = new JButton("Create Leave Report");
		Insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String a1 = txtEMPNAME.getText();
				String a2 = txtEMPID.getText().toString();
				String a3 = txtREASON.getText();
				
				String a5 = (String) cmbSTATUS.getSelectedItem().toString();
				String a6 = (String) cmbTYPE.getSelectedItem().toString();
				java.util.Date Date1 = FromDate.getDate();				
				String FD = new SimpleDateFormat("yyyy-mm-dd").format(Date1);
				java.util.Date Date2 = ToDate.getDate();				
				String TD = new SimpleDateFormat("yyyy-mm-dd").format(Date2);
				
							
				if(a1.isEmpty()|| a2.isEmpty() || a3.isEmpty() || a5.isEmpty() || a6.isEmpty() || FD.isEmpty() || TD.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please fill all the Fields!");
				}
				else {
					int selectRowp1 = table_P2.getSelectedRow();
													
					try {
						connection = DbConnect.getDBConnection();
						
												
						String insertQuery = "INSERT INTO leave_request(Employee_ID, Employee_Name, Leave_type, From_Leave, To_Leave, Reason, Status) VALUES('"+a2+"','"+a1+"','"+a6+"','"+FD+"','"+TD+"','"+a3+"','"+a5+"')";
						PreparedStatement ps = connection.prepareStatement(insertQuery);
						ps.executeUpdate();
						JOptionPane.showMessageDialog(null, "Leave report add successfully!");
						ps.close();
						
						String id = txtID.getText();
						
						if(!id.isEmpty()) {
							try {
								connection = DbConnect.getDBConnection();
																
								String deleteRequest = "DELETE FROM LeaveNUSRY WHERE (Leave_ID = '"+id+"')";
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
						Display01();
						Display02();
					} 
					catch (Exception e) {
						e.printStackTrace();
					}		
				}
			}
		});
		Insert.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\New folder (2)\\IT18195644\\images\\add.png"));
		Insert.setBounds(10, 422, 424, 48);
		panel_Navigator.add(Insert);
		
		JButton Update = new JButton("Update Leave Report");
		Update.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\New folder (2)\\IT18195644\\images\\insert.png"));
		Update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String id = txtID.getText();
				
				String a1 = txtEMPNAME.getText();
				String a2 = txtEMPID.getText().toString();
				String a3 = txtREASON.getText();
				
				java.util.Date Date1 = FromDate.getDate();				
				String FD = new SimpleDateFormat("yyyy-mm-dd").format(Date1);
				java.util.Date Date2 = ToDate.getDate();				
				String TD = new SimpleDateFormat("yyyy-mm-dd").format(Date2);
				
							
				if(a1.isEmpty()|| a2.isEmpty() || a3.isEmpty() || FD.isEmpty() || TD.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please fill all the Fields!");
				}
				else {
					int selectRowp1 = table_P1.getSelectedRow();
													
					try {
						connection = DbConnect.getDBConnection();
						
												
						String insertQuery = "UPDATE leavenusry SET Name = '"+a1+"', Employee_ID = '"+a2+"', Reason = '"+a3+"', FromDate = '"+FD+"', ToDate = '"+TD+"' WHERE (Leave_ID = '"+id+"')";
						PreparedStatement ps = connection.prepareStatement(insertQuery);
						ps.executeUpdate();
						JOptionPane.showMessageDialog(null, "Leave form update successfully!");
						ps.close();
						
					}
					
					catch(Exception e) {
						JOptionPane.showMessageDialog(null, e);
					}
				
					try {
						Display01();
						Display02();
					} 
					catch (Exception e) {
						e.printStackTrace();
					}		
				}
			}
		});
		Update.setBounds(10, 481, 424, 48);
		panel_Navigator.add(Update);
		
		JPanel panel_Body_P1 = new JPanel();
		panel_Body_P1.setBackground(new Color(189, 183, 107));
		panel_Body_P1.setBounds(466, 136, 818, 263);
		contentPane.add(panel_Body_P1);
		panel_Body_P1.setLayout(null);
		
		JLabel lblLeaveRequestList = new JLabel("Leave Request List");
		lblLeaveRequestList.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblLeaveRequestList.setBounds(10, 0, 326, 47);
		panel_Body_P1.add(lblLeaveRequestList);
		
		JButton Refresh1 = new JButton("");
		Refresh1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Display01();
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
		Refresh1.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\New folder (2)\\IT18195644\\images\\refresh.png"));
		Refresh1.setToolTipText("Refresh");
		Refresh1.setBounds(277, 12, 110, 35);
		panel_Body_P1.add(Refresh1);
		
		txtSearch1 = new JTextField();
		txtSearch1.setToolTipText("Search Iteam Name");
		txtSearch1.setMargin(new Insets(2, 10, 2, 10));
		txtSearch1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSearch1.setColumns(10);
		txtSearch1.setBounds(517, 13, 231, 30);
		panel_Body_P1.add(txtSearch1);
		
		JButton BtnSearch1 = new JButton("");
		BtnSearch1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String searchp1 = txtSearch1.getText();
				
				try {
					if(searchp1.isEmpty()) {
						Display01();
						JOptionPane.showMessageDialog(null, "Entered is empty!");
					}
					else {						
						connection = DbConnect.getDBConnection();
						String searchQuery = "select * from leavenusry where Name LIKE '"+searchp1+"'";
						PreparedStatement ps = connection.prepareStatement(searchQuery);
						ResultSet rs = ps.executeQuery();
						table_P1.setModel(DbUtils.resultSetToTableModel(rs));	
					}	
				} 
				catch (Exception e1) {
						JOptionPane.showMessageDialog(null,e1);
				}
			}
		});
		BtnSearch1.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\New folder (2)\\IT18195644\\images\\search.png"));
		BtnSearch1.setToolTipText("Search");
		BtnSearch1.setBounds(758, 11, 36, 36);
		panel_Body_P1.add(BtnSearch1);
		
		JButton Delete1 = new JButton("");
		Delete1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int selectRow = table_P1.getSelectedRow();
				
				String wid = (table_P1.getModel().getValueAt(selectRow, 0).toString());
				
				com.service.LeaveService.removeleaveRequest(wid);
				
				try {
					Display01();
				} 
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		Delete1.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\New folder (2)\\IT18195644\\images\\delete.png"));
		Delete1.setToolTipText("Refresh");
		Delete1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int selectRow = table_P1.getSelectedRow();
				
				String wid = (table_P1.getModel().getValueAt(selectRow, 0).toString());
				
				com.service.LeaveService.removeleave(wid) ;
				
				try {
					Display01();
				} 
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		Delete1.setBounds(397, 12, 110, 35);
		panel_Body_P1.add(Delete1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 53, 798, 199);
		panel_Body_P1.add(scrollPane);
		
		table_P1 = new JTable();
		scrollPane.setViewportView(table_P1);
		table_P1.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int selectRow = table_P1.getSelectedRow();
				
				txtID.setText(table_P1.getModel().getValueAt(selectRow, 0).toString());
				txtEMPNAME.setText(table_P1.getModel().getValueAt(selectRow, 1).toString());
				txtEMPID.setText(table_P1.getModel().getValueAt(selectRow, 2).toString());
				txtREASON.setText(table_P1.getModel().getValueAt(selectRow, 3).toString());
				
				FromDate.setDate((Date) table_P1.getModel().getValueAt(selectRow, 4));
				ToDate.setDate((Date) table_P1.getModel().getValueAt(selectRow, 5));
			
			}
		});
		table_P1.setBackground(Color.GRAY);
		Display01();
		
		JPanel panel_Body_P2 = new JPanel();
		panel_Body_P2.setBackground(new Color(189, 183, 107));
		panel_Body_P2.setBounds(466, 410, 818, 275);
		contentPane.add(panel_Body_P2);
		panel_Body_P2.setLayout(null);
		
		JLabel lblLeaves = new JLabel("Leaves");
		lblLeaves.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblLeaves.setBounds(10, 0, 326, 47);
		panel_Body_P2.add(lblLeaves);
		
		JButton Refresh2 = new JButton("");
		Refresh2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Display02();
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
		Refresh2.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\New folder (2)\\IT18195644\\images\\refresh.png"));
		Refresh2.setToolTipText("Refresh");
		Refresh2.setBounds(277, 12, 110, 35);
		panel_Body_P2.add(Refresh2);
		
		JButton Delete2 = new JButton("");
		Delete2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int selectRow = table_P2.getSelectedRow();
				
				String wid = (table_P2.getModel().getValueAt(selectRow, 0).toString());
				
				com.service.LeaveService.removeleaveRequest(wid);
				
				try {
					Display02();
				} 
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		Delete2.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\New folder (2)\\IT18195644\\images\\delete.png"));
		Delete2.setBounds(397, 12, 110, 35);
		panel_Body_P2.add(Delete2);
		
		txtSearch2 = new JTextField();
		txtSearch2.setToolTipText("Search Iteam Name");
		txtSearch2.setMargin(new Insets(2, 10, 2, 10));
		txtSearch2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSearch2.setColumns(10);
		txtSearch2.setBounds(517, 13, 231, 30);
		panel_Body_P2.add(txtSearch2);
		
		JButton BtnSearch2 = new JButton("");
		BtnSearch2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String searchp1 = txtSearch2.getText();
				
				try {
					if(searchp1.isEmpty()) {
						Display02();
						JOptionPane.showMessageDialog(null, "Entered is empty!");
					}
					else {						
						connection = DbConnect.getDBConnection();
						String searchQuery = "select * from leave_request where Employee_Name LIKE '"+searchp1+"'";
						PreparedStatement ps = connection.prepareStatement(searchQuery);
						ResultSet rs = ps.executeQuery();
						table_P2.setModel(DbUtils.resultSetToTableModel(rs));	
					}	
				} 
				catch (Exception e1) {
						JOptionPane.showMessageDialog(null,e1);
				}
			}
		});
		BtnSearch2.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\New folder (2)\\IT18195644\\images\\search.png"));
		BtnSearch2.setToolTipText("Search");
		BtnSearch2.setBounds(758, 11, 36, 36);
		panel_Body_P2.add(BtnSearch2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 58, 798, 206);
		panel_Body_P2.add(scrollPane_1);
		
		table_P2 = new JTable();
		scrollPane_1.setViewportView(table_P2);
		table_P2.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int selectRow = table_P2.getSelectedRow();
				
				txtID.setText(null);
				txtEMPNAME.setText(null);
				txtEMPID.setText(null);
				txtREASON.setText(null);
				
				cmbSTATUS.setSelectedItem(null);
				cmbTYPE.setSelectedItem(null);
				
				FromDate.setDate(null);
				ToDate.setDate(null);
				
			}
		});
		table_P2.setBackground(Color.GRAY);
		Display02();
	}
}
