package com.Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.model.Supplier;
import com.model.maintenance;
import com.service.SupplierService;
import com.service.maintenanceService;
import com.util.DbConnect;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class SupplierManagement extends JFrame {

	private JPanel contentPane;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SupplierManagement frame = new SupplierManagement();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	SupplierService SupplierService = new SupplierService();
	Supplier Supplier = new Supplier();
	
	private PreparedStatement preparedStatement;
	private static Connection connection;
	private JTextField txtSearch;
	private JTable table;
	private JTextField ID;
	private JTextField txtSID;
	private JTextField txtName;
	private JTextField txtNIC;
	private JTextField txtEmail;
	private JTextField txtPhone;
	
	public void DisplayTable1() throws  InstantiationException, IllegalAccessException, SQLException, ClassNotFoundException {
		
		connection = DbConnect.getDBConnection();
		
		String selectQuery2 = "SELECT * FROM suppliermanagement";
		
		PreparedStatement p2 = connection.prepareStatement(selectQuery2);
		
		ResultSet rs2 = p2.executeQuery();
		
		table.setModel(DbUtils.resultSetToTableModel(rs2));	
		
		p2.close();	
	}
	
	
	public SupplierManagement() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\avina\\Desktop\\IT18195644\\images\\wious.png"));
		
		SupplierService SupplierService = new SupplierService();
		Supplier Supplier = new Supplier();
		
		setTitle("Supplier Management");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200, 200, 1300, 725);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_Head = new JPanel();
		panel_Head.setBounds(10, 11, 1274, 109);
		panel_Head.setBackground(new Color(238, 232, 170));
		contentPane.add(panel_Head);
		panel_Head.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\supplierLarge.png"));
		label.setBounds(23, 11, 117, 84);
		panel_Head.add(label);
		
		JLabel lblSupplierManagement = new JLabel("Supplier Management");
		lblSupplierManagement.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblSupplierManagement.setBounds(112, 11, 691, 84);
		panel_Head.add(lblSupplierManagement);
		
		JButton button = new JButton("Notice");
		button.addActionListener(new ActionListener() {
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
		button.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\note.png"));
		button.setBounds(1004, 31, 125, 36);
		panel_Head.add(button);
		
		JButton button_1 = new JButton("Sign Out");
		button_1.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\signout.png"));
		button_1.setToolTipText("Sign Out");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login info = new Login();
				Login.main(null);
			}
		});
		button_1.setBounds(1139, 32, 125, 35);
		panel_Head.add(button_1);
		
		JPanel panel_Navigator = new JPanel();
		panel_Navigator.setBackground(new Color(189, 183, 107));
		panel_Navigator.setBounds(10, 131, 271, 554);
		contentPane.add(panel_Navigator);
		panel_Navigator.setLayout(null);
		
		JLabel lableid = new JLabel("ID");
		lableid.setBounds(25, 67, 106, 14);
		panel_Navigator.add(lableid);
		
		ID = new JTextField();
		ID.setEditable(false);
		ID.setMargin(new Insets(2, 10, 2, 10));
		ID.setColumns(10);
		ID.setBounds(10, 92, 251, 25);
		panel_Navigator.add(ID);
		
		JLabel lblSupplierIdNumber = new JLabel("Supplier ID Number");
		lblSupplierIdNumber.setBounds(20, 127, 190, 14);
		panel_Navigator.add(lblSupplierIdNumber);
		
		txtSID = new JTextField();
		txtSID.setMargin(new Insets(2, 10, 2, 10));
		txtSID.setColumns(10);
		txtSID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				boolean validate1 = txtSID.getText().matches("^[0-9SID]*$");
				
				if(validate1) {
					
				}else {
					JOptionPane.showMessageDialog(null, "Invalid supplier ID. Try again!");
					txtSID.setText(null);
				}		
			}
		});
		txtSID.setBounds(10, 152, 251, 25);
		panel_Navigator.add(txtSID);
		
		JLabel lblSupplierName = new JLabel("Supplier Name");
		lblSupplierName.setBounds(20, 188, 190, 14);
		panel_Navigator.add(lblSupplierName);
		
		txtName = new JTextField();
		txtName.setMargin(new Insets(2, 10, 2, 10));
		txtName.setColumns(10);
		txtName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				boolean validate1 = txtName.getText().matches("^[A-Za-z ]*$");
				
				if(validate1) {
					
				}else {
					JOptionPane.showMessageDialog(null, "Invalid supplier name. Try again!");
					txtName.setText(null);
				}		
			}
		});
		txtName.setBounds(10, 212, 251, 25);
		panel_Navigator.add(txtName);
		
		JLabel lblSupplierNic = new JLabel("Supplier NIC");
		lblSupplierNic.setBounds(20, 248, 190, 14);
		panel_Navigator.add(lblSupplierNic);
		
		txtNIC = new JTextField();
		txtNIC.setMargin(new Insets(2, 10, 2, 10));
		txtNIC.setColumns(10);
		txtNIC.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				boolean validate1 = txtNIC.getText().matches("^[0-9V]*$");
				
				if(validate1) {
					
				}else {
					JOptionPane.showMessageDialog(null, "Invalid supplier NIC. Try again!");
					txtNIC.setText(null);
				}		
			}
		});
		txtNIC.setBounds(10, 273, 251, 25);
		panel_Navigator.add(txtNIC);
		
		JLabel lblCreateNewSupplier = new JLabel("Create New Supplier");
		lblCreateNewSupplier.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblCreateNewSupplier.setBounds(10, 11, 375, 47);
		panel_Navigator.add(lblCreateNewSupplier);
		
		JLabel lblEmail = new JLabel("Email ");
		lblEmail.setBounds(20, 309, 190, 14);
		panel_Navigator.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setMargin(new Insets(2, 10, 2, 10));
		txtEmail.setColumns(10);
		txtEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				boolean validate1 = txtEmail.getText().matches("^[0-9a-z@.]*$");
				
				if(validate1) {
					
				}else {
					JOptionPane.showMessageDialog(null, "Invalid supplier Email. Try again!");
					txtEmail.setText(null);
				}		
			}
		});
		txtEmail.setBounds(10, 334, 251, 25);
		panel_Navigator.add(txtEmail);
		
		txtPhone = new JTextField();
		txtPhone.setMargin(new Insets(2, 10, 2, 10));
		txtPhone.setColumns(10);
		txtPhone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				boolean validate1 = txtPhone.getText().matches("^[0-9]*$");
				
				if(validate1) {
					
				}else {
					JOptionPane.showMessageDialog(null, "Invalid supplier Phone. Try again!");
					txtPhone.setText(null);
				}		
			}
		});
		txtPhone.setBounds(10, 396, 251, 25);
		panel_Navigator.add(txtPhone);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setBounds(20, 371, 190, 14);
		panel_Navigator.add(lblPhoneNumber);
		
		JButton btnCreateSupplier = new JButton("Create Supplier");
		btnCreateSupplier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Supplier.setID(ID.getText());
				Supplier.setSID(txtSID.getText());
				Supplier.setNAME(txtName.getText());
				Supplier.setNIC(txtNIC.getText());
				Supplier.setEMAIL(txtEmail.getText());
				Supplier.setPHONE(txtPhone.getText());
				
				String a1 = ID.getText();
				String a2 = txtSID.getText();
				String a3 = txtName.getText();
				String a4 = txtNIC.getText();
				String a5 = txtEmail.getText();
				String a6 = txtPhone.getText();
				
				
				if(a1.isEmpty() || a2.isEmpty() || a3.isEmpty() || a4.isEmpty() || a5.isEmpty() || a6.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please fill all the fields!");
				}
				else {
					SupplierService.addSuppliers(Supplier);
					try {
						DisplayTable1();
					} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnCreateSupplier.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\add.png"));
		btnCreateSupplier.setToolTipText("Add Now");
		btnCreateSupplier.setBounds(10, 462, 251, 35);
		panel_Navigator.add(btnCreateSupplier);
		
		JButton btnUpdateDetails = new JButton("Update Details");
		btnUpdateDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Supplier.setID(ID.getText());
				Supplier.setSID(txtSID.getText());
				Supplier.setNAME(txtName.getText());
				Supplier.setNIC(txtNIC.getText());
				Supplier.setEMAIL(txtEmail.getText());
				Supplier.setPHONE(txtPhone.getText());
				
				String a1 = ID.getText();
				String a2 = txtSID.getText();
				String a3 = txtName.getText();
				String a4 = txtNIC.getText();
				String a5 = txtEmail.getText();
				String a6 = txtPhone.getText();
				
				
				if(a1.isEmpty() || a2.isEmpty() || a3.isEmpty() || a4.isEmpty() || a5.isEmpty() || a6.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please fill all the fields!");
				}
				else {
					SupplierService.updateSuppliers(Supplier);
					try {
						DisplayTable1();
					} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
								
			}
		});
		btnUpdateDetails.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\insert.png"));
		btnUpdateDetails.setToolTipText("Update");
		btnUpdateDetails.setBounds(10, 508, 251, 35);
		panel_Navigator.add(btnUpdateDetails);
		
		JPanel panel_Body = new JPanel();
		panel_Body.setBackground(new Color(189, 183, 107));
		panel_Body.setBounds(291, 131, 993, 554);
		contentPane.add(panel_Body);
		panel_Body.setLayout(null);
		
		JLabel lblSupplierDetails = new JLabel("Supplier Details");
		lblSupplierDetails.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblSupplierDetails.setBounds(22, 11, 375, 47);
		panel_Body.add(lblSupplierDetails);
		
		JButton btnRefresh = new JButton("");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DisplayTable1();
				} catch (InstantiationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Refreshed!");
			}
		});
		btnRefresh.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\refresh.png"));
		btnRefresh.setToolTipText("Refresh");
		btnRefresh.setBounds(494, 16, 75, 35);
		panel_Body.add(btnRefresh);
		
		JButton btnDelete = new JButton("");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectRow = table.getSelectedRow();
				
				String id = (table.getModel().getValueAt(selectRow, 0).toString());
				
				com.service.SupplierService.removeSuppliers(id);
				
				try {
					DisplayTable1();
				} 
				catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnDelete.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\delete.png"));
		btnDelete.setToolTipText("Refresh");
		btnDelete.setBounds(579, 16, 75, 35);
		panel_Body.add(btnDelete);
		
		txtSearch = new JTextField();
		txtSearch.setToolTipText("Search Iteam Name");
		txtSearch.setMargin(new Insets(2, 10, 2, 10));
		txtSearch.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSearch.setColumns(10);
		txtSearch.setBounds(722, 17, 186, 30);
		panel_Body.add(txtSearch);
		
		JButton BtnSearch = new JButton("");
		BtnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String search1 = txtSearch.getText();
				
				try {
					if(search1.isEmpty()==true) {
						DisplayTable1();
					}
					else {
						
						connection = DbConnect.getDBConnection();
						
						String searchQuery = "SELECT * FROM suppliermanagement WHERE  Supplier_ID LIKE '"+search1+"'";
						
						PreparedStatement ps = connection.prepareStatement(searchQuery);
						
						ResultSet rs = ps.executeQuery();
						
						table.setModel(DbUtils.resultSetToTableModel(rs));
					}
				}catch(Exception e1) {
					
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		BtnSearch.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\search.png"));
		BtnSearch.setToolTipText("Search");
		BtnSearch.setBounds(918, 11, 36, 36);
		panel_Body.add(BtnSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 63, 948, 465);
		panel_Body.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
								
				int selectedRow = table.getSelectedRow();
				
				ID.setText(table.getModel().getValueAt(selectedRow, 0).toString());
				txtSID.setText(table.getModel().getValueAt(selectedRow, 1).toString());
				txtName.setText(table.getModel().getValueAt(selectedRow, 2).toString());
				txtNIC.setText(table.getModel().getValueAt(selectedRow, 3).toString());
				txtEmail.setText(table.getModel().getValueAt(selectedRow, 4).toString());
				txtPhone.setText(table.getModel().getValueAt(selectedRow, 5).toString());
			}
			
		});
		table.setBackground(Color.GRAY);
		
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

}
