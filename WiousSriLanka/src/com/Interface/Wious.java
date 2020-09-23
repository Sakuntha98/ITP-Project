package com.Interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Toolkit;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import com.Interface.*;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;
import java.awt.Color;

public class Wious {

	private JFrame frmWiousHoldings;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Wious window = new Wious();
					window.frmWiousHoldings.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Wious() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmWiousHoldings = new JFrame();
		frmWiousHoldings.getContentPane().setBackground(Color.WHITE);
		frmWiousHoldings.setType(Type.POPUP);
		frmWiousHoldings.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		frmWiousHoldings.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\avina\\Desktop\\IT18195644\\images\\wious.png"));
		frmWiousHoldings.setResizable(false);
		frmWiousHoldings.setTitle("Wious Holdings");
		frmWiousHoldings.setBounds(200, 200, 1300, 725);
		frmWiousHoldings.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmWiousHoldings.getContentPane().setLayout(null);
		
		JPanel panel_Body = new JPanel();
		panel_Body.setBackground(Color.WHITE);
		panel_Body.setBounds(10, 11, 1274, 674);
		frmWiousHoldings.getContentPane().add(panel_Body);
		panel_Body.setLayout(null);
		
		JButton btnLogin = new JButton("Employee Management");
		btnLogin.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\Wious\\employeeManagement.png"));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Login info = new Login();
				Login.main(null);
			}
		});
		btnLogin.setBounds(10, 11, 275, 133);
		panel_Body.add(btnLogin);
		
		JButton btnMaintanceManagement = new JButton("Maintance Management");
		btnMaintanceManagement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login info = new Login();
				Login.main(null);
			}
		});
		btnMaintanceManagement.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\Wious\\maintenanceManagement.png"));
		btnMaintanceManagement.setBounds(10, 155, 275, 133);
		panel_Body.add(btnMaintanceManagement);
		
		JButton btnStoreManagement = new JButton("Store Management");
		btnStoreManagement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login info = new Login();
				Login.main(null);
			}
		});
		btnStoreManagement.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\Wious\\storeManagement.png"));
		btnStoreManagement.setBounds(10, 299, 275, 133);
		panel_Body.add(btnStoreManagement);
		
		JButton btnDeliveryManagement = new JButton("Delivery Management");
		btnDeliveryManagement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login info = new Login();
				Login.main(null);
			}
		});
		btnDeliveryManagement.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\Wious\\deliveryManagement.png"));
		btnDeliveryManagement.setBounds(10, 443, 275, 133);
		panel_Body.add(btnDeliveryManagement);
		
		JButton btnBillAnalyzing = new JButton("Bill Analyzing");
		btnBillAnalyzing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login info = new Login();
				Login.main(null);
			}
		});
		btnBillAnalyzing.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\Wious\\billManagement.png"));
		btnBillAnalyzing.setBounds(989, 11, 275, 133);
		panel_Body.add(btnBillAnalyzing);
		
		JButton btnLeavesManagement = new JButton("Leaves Management");
		btnLeavesManagement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login info = new Login();
				Login.main(null);
			}
		});
		btnLeavesManagement.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\Wious\\leaveManagement.png"));
		btnLeavesManagement.setBounds(989, 155, 275, 133);
		panel_Body.add(btnLeavesManagement);
		
		JButton btnAccount = new JButton("Accounts Management");
		btnAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login info = new Login();
				Login.main(null);
			}
		});
		btnAccount.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\Wious\\accountManagement.png"));
		btnAccount.setBounds(989, 299, 275, 133);
		panel_Body.add(btnAccount);
		
		JButton btnSupplierManagement = new JButton("Supplier Management");
		btnSupplierManagement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login info = new Login();
				Login.main(null);
			}
		});
		btnSupplierManagement.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\Wious\\supplierManagement.png"));
		btnSupplierManagement.setBounds(989, 443, 275, 133);
		panel_Body.add(btnSupplierManagement);
		
		JPanel panel_Footer = new JPanel();
		panel_Footer.setBackground(Color.WHITE);
		panel_Footer.setBounds(10, 582, 1254, 81);
		panel_Body.add(panel_Footer);
		panel_Footer.setLayout(null);
		
		JLabel lblWiousHoldingspvt = new JLabel("Wious Holdings (PVT) Ltd.");
		lblWiousHoldingspvt.setBounds(574, 11, 361, 14);
		panel_Footer.add(lblWiousHoldingspvt);
		
		JLabel lblTp = new JLabel("TP: 0112 122 122");
		lblTp.setBounds(590, 36, 223, 14);
		panel_Footer.add(lblTp);
		
		JPanel panel_Body_Center = new JPanel();
		panel_Body_Center.setBackground(Color.WHITE);
		panel_Body_Center.setBounds(251, 0, 772, 663);
		panel_Body.add(panel_Body_Center);
		panel_Body_Center.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\wious.png"));
		label.setBounds(104, 0, 693, 565);
		panel_Body_Center.add(label);
	}
}
