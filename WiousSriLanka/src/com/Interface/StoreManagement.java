package com.Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.model.products;
import com.service.productService;
import com.util.DbConnect;

import net.proteanit.sql.DbUtils;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class StoreManagement extends JFrame {

	private JPanel contentPane;
	private JTable table_1;
	productService productService = new productService();
	products products = new products();
	private PreparedStatement preparedStatement;
	private static Connection connection;
	private JTextField txt_search;
	private JTextField txt_ProductID;
	private JTextField txt_ProductName;
	private JTextField txt_Quantity;
	private JTextField txt_Price;
	private JTextField txt_supplierID;
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StoreManagement frame = new StoreManagement();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	public void DisplayTable()throws  InstantiationException, IllegalAccessException, SQLException, ClassNotFoundException {
		
		connection = DbConnect.getDBConnection();
		
		String selectQuery = "SELECT * FROM storemanagement";
		//System.out.println(selectQuery);
		
		PreparedStatement ps = connection.prepareStatement(selectQuery);
		
		ResultSet rs = ps.executeQuery();
		
		//while(rs.next()) {
		table_1.setModel(DbUtils.resultSetToTableModel(rs));
			
		//}
		
		ps.close();
		
		
	}
	
	public StoreManagement() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\avina\\Desktop\\IT18195644\\images\\wious.png"));
		
		products products = new products();
		productService productService = new productService();
		
		setResizable(false);
		setTitle("Store Management System");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200, 200, 1300, 725);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBackground(new Color(0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_Navigator = new JPanel();
		panel_Navigator.setBackground(new Color(189, 183, 107));
		panel_Navigator.setBounds(10, 128, 276, 557);
		contentPane.add(panel_Navigator);
		panel_Navigator.setLayout(null);
		

		JLabel lbl_Notify = new JLabel("");
		lbl_Notify.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lbl_Notify.setForeground(new Color(178, 34, 34));
		lbl_Notify.setBounds(186, 91, 116, 14);
		panel_Navigator.add(lbl_Notify);
		

		JLabel lbl_Notify2 = new JLabel("");
		lbl_Notify2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lbl_Notify2.setForeground(new Color(178, 34, 34));
		lbl_Notify2.setBounds(160, 152, 116, 14);
		panel_Navigator.add(lbl_Notify2);

		JLabel lbl_Notify3 = new JLabel("");
		lbl_Notify3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lbl_Notify3.setForeground(new Color(178, 34, 34));
		lbl_Notify3.setBounds(186, 214, 116, 14);
		panel_Navigator.add(lbl_Notify3);

		JLabel lbl_Notify4 = new JLabel("");
		lbl_Notify4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lbl_Notify4.setForeground(new Color(178, 34, 34));
		lbl_Notify4.setBounds(186, 273, 132, 14);
		panel_Navigator.add(lbl_Notify4);
		
		JLabel lbl_Notify5 = new JLabel("");
		lbl_Notify5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lbl_Notify5.setForeground(new Color(178, 34, 34));
		lbl_Notify5.setBounds(186, 335, 132, 14);
		panel_Navigator.add(lbl_Notify5);
		
		
		txt_ProductID = new JTextField();
		txt_ProductID.setBackground(new Color(238, 232, 170));
		txt_ProductID.setMargin(new Insets(2, 10, 2, 10));
		txt_ProductID.setColumns(10);
		txt_ProductID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				String productID = txt_ProductID.getText();
				if(!productID.matches("[a-zA-Z0-9,]+")) {
					txt_ProductID.setText(null);
					lbl_Notify.setText("Invalid ID ! ");
				}
				else {
					lbl_Notify.setText(null);
				}
				
			}
		});
		txt_ProductID.setBounds(10, 106, 256, 25);
		panel_Navigator.add(txt_ProductID);
		
		JLabel lblProductId = new JLabel("Product ID");
		lblProductId.setBounds(20, 81, 190, 14);
		panel_Navigator.add(lblProductId);
		
		JLabel lblProductName = new JLabel("Product Name");
		lblProductName.setBounds(20, 142, 190, 14);
		panel_Navigator.add(lblProductName);
		
		txt_ProductName = new JTextField();
		txt_ProductName.setBackground(new Color(238, 232, 170));
		txt_ProductName.setMargin(new Insets(2, 10, 2, 10));
		txt_ProductName.setColumns(10);
		txt_ProductName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				String  ProductName  =  txt_ProductName.getText();
				if(!ProductName.matches("[a-zA-Z ]+")) {
					txt_ProductName.setText(null);
					lbl_Notify2.setText("Invalid ProductName ! ");
					
				}
				else {
					
					lbl_Notify2.setText(null);
				}
				
				
			}
		});
		txt_ProductName.setBounds(10, 166, 256, 25);
		panel_Navigator.add(txt_ProductName);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(20, 202, 190, 14);
		panel_Navigator.add(lblQuantity);
		
		txt_Quantity = new JTextField();
		txt_Quantity.setBackground(new Color(238, 232, 170));
		txt_Quantity.setMargin(new Insets(2, 10, 2, 10));
		txt_Quantity.setColumns(10);
		txt_Quantity.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
			String Quantity = txt_Quantity.getText();
			if(!Quantity.matches("[0-9]+")){
				txt_Quantity.setText(null);
				lbl_Notify3.setText("Invalid Quantity ! ");
				
			}
			else {
				
				lbl_Notify3.setText(null);
			}
				
			}
		});
		txt_Quantity.setBounds(10, 227, 256, 25);
		panel_Navigator.add(txt_Quantity);
		
		txt_Price = new JTextField();
		txt_Price.setBackground(new Color(238, 232, 170));
		txt_Price.setMargin(new Insets(2, 10, 2, 10));
		txt_Price.setColumns(10);
		txt_Price.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				String Price = txt_Price.getText();
				
				if(!Price.matches("[0-9.]+")) {
					txt_Price.setText(null);
					lbl_Notify4.setText("Invalid Price ! ");
				}
				else {
					lbl_Notify4.setText(null);
				}
				
			}
		});
		txt_Price.setBounds(10, 288, 256, 25);
		panel_Navigator.add(txt_Price);
		
		JLabel lblPriceForItem = new JLabel("Price For Item");
		lblPriceForItem.setBounds(20, 263, 190, 14);
		panel_Navigator.add(lblPriceForItem);
		
		JLabel lblSupplierIdNumber = new JLabel("Supplier ID Number");
		lblSupplierIdNumber.setBounds(20, 324, 190, 14);
		panel_Navigator.add(lblSupplierIdNumber);
		
		txt_supplierID = new JTextField();
		txt_supplierID.setBackground(new Color(238, 232, 170));
		txt_supplierID.setMargin(new Insets(2, 10, 2, 10));
		txt_supplierID.setColumns(10);
		txt_supplierID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				String supplierID = txt_supplierID.getText();
				
				if(!supplierID.matches("[a-zA-Z0-9]+")) {
					txt_supplierID.setText(null);
					lbl_Notify5.setText("Invalid ID !");
				}
				else {
					lbl_Notify5.setText(null);
				}
				
			}
		});
		txt_supplierID.setBounds(10, 348, 256, 25);
		panel_Navigator.add(txt_supplierID);
		
		JLabel lblIntroduceItem = new JLabel("Introduce Item");
		lblIntroduceItem.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblIntroduceItem.setBounds(10, 11, 198, 47);
		panel_Navigator.add(lblIntroduceItem);
		
		JButton btn_add = new JButton("Create Item");
		btn_add.setForeground(new Color(255, 255, 255));
		btn_add.setBackground(new Color(205, 133, 63));
		btn_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a1 = txt_ProductID.getText();
				String a2 = txt_ProductName.getText();
				String a3 = txt_Quantity.getText();
				String a4 = txt_Price.getText();
				String a5 = txt_supplierID.getText();
				
				if(a1.isEmpty() || a2.isEmpty() || a3.isEmpty() || a4.isEmpty() || a5.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please fill all !");
				}
				else {
				
			
						products.setProductID(txt_ProductID.getText());
						products.setProductName(txt_ProductName.getText());
						products.setQuantity(txt_Quantity.getText());	
						products.setPrice(txt_Price.getText());
						products.setSupplierID(txt_supplierID.getText());
					
					
					productService.addProduct(products);
					
					try {
						DisplayTable();
					} catch (Exception e1) {
						
						e1.printStackTrace();
					}
				}
			}
		});
		btn_add.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\add.png"));
		btn_add.setToolTipText("Add Now");
		btn_add.setBounds(10, 452, 256, 35);
		panel_Navigator.add(btn_add);
		JButton btn_Edit = new JButton("Update");
		btn_Edit.setForeground(new Color(255, 255, 255));
		btn_Edit.setBackground(new Color(205, 133, 63));
		btn_Edit.setBounds(71, 329, 111, 32);
		panel_Navigator.add(btn_Edit);
		btn_Edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				products.setProductID(txt_ProductID.getText());
				products.setProductName(txt_ProductName.getText());
				products.setQuantity(txt_Quantity.getText());
				products.setPrice(txt_Price.getText());
				products.setSupplierID(txt_supplierID.getText());
				
				
				
				
				productService.updateProduct(products);
				
				try {
					DisplayTable();
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
					
					e.printStackTrace();
				}
				
				
				
				
			}
		});
		btn_Edit.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\insert.png"));
		btn_Edit.setToolTipText("Update");
		btn_Edit.setBounds(10, 498, 256, 35);
		panel_Navigator.add(btn_Edit);
		
		JButton btnDemo = new JButton("DEMO");
		btnDemo.setForeground(new Color(255, 255, 255));
		btnDemo.setBackground(new Color(205, 133, 63));
		btnDemo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				txt_ProductID.setText("P1000000");
				txt_ProductName.setText("Bricks");
				txt_Price.setText("50.00");
				txt_Quantity.setText("100");
				txt_supplierID.setText("S1000000");
				
			}
		});
		btnDemo.setFont(new Font("Calibri Light", Font.BOLD, 15));
		btnDemo.setBounds(92, 384, 89, 23);
		panel_Navigator.add(btnDemo);
		
		
		JPanel panel_Head = new JPanel();
		panel_Head.setBackground(new Color(238, 232, 170));
		panel_Head.setBounds(10, 11, 1274, 109);
		contentPane.add(panel_Head);
		panel_Head.setLayout(null);
		
		JLabel lblInventoryManagement = new JLabel("Inventory Management");
		lblInventoryManagement.setBackground(new Color(238, 232, 170));
		lblInventoryManagement.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblInventoryManagement.setBounds(110, 14, 691, 84);
		panel_Head.add(lblInventoryManagement);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\store.png"));
		label.setBounds(34, 11, 85, 87);
		panel_Head.add(label);
		
		JButton button = new JButton("Sign Out");
		button.setBackground(new Color(85, 107, 47));
		button.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\signout.png"));
		button.setToolTipText("Sign Out");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login info = new Login();
				Login.main(null);
			}
		});
		button.setBounds(1139, 37, 125, 35);
		panel_Head.add(button);
		
		JButton button_1 = new JButton("Notice");
		button_1.setBackground(new Color(85, 107, 47));
		button_1.addActionListener(new ActionListener() {
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
		button_1.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\note.png"));
		button_1.setBounds(1004, 36, 125, 36);
		panel_Head.add(button_1);
		
		JPanel panel_Body = new JPanel();
		panel_Body.setBackground(new Color(189, 183, 107));
		panel_Body.setBounds(296, 128, 988, 557);
		contentPane.add(panel_Body);
		panel_Body.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 65, 968, 481);
		panel_Body.add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int selectRow = table_1.getSelectedRow();
				txt_ProductID.setText(table_1.getModel().getValueAt(selectRow, 0).toString());
				txt_ProductName.setText(table_1.getModel().getValueAt(selectRow, 1).toString());
				txt_Quantity.setText(table_1.getModel().getValueAt(selectRow, 2).toString());
				txt_Price.setText(table_1.getModel().getValueAt(selectRow, 3).toString());
				txt_supplierID.setText(table_1.getModel().getValueAt(selectRow, 4).toString());
			
			}
		});
		table_1.setBackground(new Color(255, 255, 255));
		
		DisplayTable();
		
		JLabel lblWiousStore = new JLabel("Wious Store");
		lblWiousStore.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblWiousStore.setBounds(36, 11, 290, 47);
		panel_Body.add(lblWiousStore);
		
		JButton btn_refresh = new JButton("");
		btn_refresh.setBackground(new Color(240, 230, 140));
		btn_refresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DisplayTable();
					JOptionPane.showMessageDialog(null, "Refreshed ! ");
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
			}
		});
		btn_refresh.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\refresh.png"));
		btn_refresh.setToolTipText("Refresh");
		btn_refresh.setBounds(365, 19, 120, 35);
		panel_Body.add(btn_refresh);
		
		JButton button_3 = new JButton("");
		button_3.setBackground(new Color(240, 230, 140));
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectRow = table_1.getSelectedRow();
				
				
				String productID = (table_1.getModel().getValueAt(selectRow, 0).toString());
				
				com.service.productService.removeProduct(productID);
				
				try {
					DisplayTable();
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
			}
		});
		button_3.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\cancel.png"));
		button_3.setToolTipText("Delete");
		button_3.setBounds(495, 19, 120, 35);
		panel_Body.add(button_3);
		
		txt_search = new JTextField();
		txt_search.setBackground(new Color(238, 232, 170));
		txt_search.setToolTipText("Search Iteam Name");
		txt_search.setMargin(new Insets(2, 10, 2, 10));
		txt_search.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_search.setColumns(10);
		txt_search.setBounds(682, 24, 213, 30);
		panel_Body.add(txt_search);
		
		JButton btn_search = new JButton("");
		btn_search.setBackground(new Color(240, 230, 140));
		btn_search.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\search.png"));
		btn_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String search1 = txt_search.getText();
				
				try {
				if(search1.isEmpty()==true) {
					
						DisplayTable();
					
				}
				else {
				
				
				
					
					connection = DbConnect.getDBConnection();
					
					
					String searchQuery = "select * from storemanagement where ProductID  LIKE '"+search1+"'";
					
					PreparedStatement ps = connection.prepareStatement(searchQuery);
					
					
					ResultSet rs = ps.executeQuery();
					
					
					table_1.setModel(DbUtils.resultSetToTableModel(rs));
					
				}
					
					
					
					
				} catch (Exception e1) {
					
					JOptionPane.showMessageDialog(null,e1);
					
				}
			}
		});
		btn_search.setToolTipText("Search");
		btn_search.setBounds(905, 24, 56, 30);
		panel_Body.add(btn_search);
	}
}
