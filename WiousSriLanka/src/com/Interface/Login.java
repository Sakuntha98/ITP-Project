package com.Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.util.DbConnect;
import com.Interface.*;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JTextField txtPassword;

	private PreparedStatement preparedStatement;
	private static Connection connection;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\avina\\Desktop\\IT18195644\\images\\wious.png"));
		setResizable(false);
		setTitle("Login Now!");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200, 200, 1300, 725);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(387, 137, 500, 500);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblLogin = new JLabel("SignIn Now!");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblLogin.setBounds(123, 8, 410, 67);
		panel.add(lblLogin);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 86, 480, 403);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblUserId = new JLabel("User ID");
		lblUserId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUserId.setBounds(218, 133, 198, 14);
		panel_1.add(lblUserId);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(218, 230, 198, 14);
		panel_1.add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtUsername.setMargin(new Insets(2, 10, 2, 10));
		txtUsername.setBounds(67, 154, 360, 44);
		panel_1.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPassword.setMargin(new Insets(2, 10, 2, 10));
		txtPassword.setColumns(10);
		txtPassword.setBounds(67, 255, 360, 44);
		panel_1.add(txtPassword);
		
		JButton SignIn = new JButton("Sign In");
		SignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					connection = DbConnect.getDBConnection();
					Statement stmt = connection.createStatement();
					String sql = "select * from employee where wid = '"+txtUsername.getText()+"' AND wpassword='"+txtPassword.getText().toString()+"'";
					
					ResultSet rs = stmt.executeQuery(sql);
					if(rs.next()) {
						String Susername = txtUsername.getText();
						
						//Employee management connected
						if(Susername.contains("4")) {
							txtPassword.setText(null);
							txtUsername.setText(null);
							EmployeeManagement info = new EmployeeManagement();
							EmployeeManagement.main(null);
						}
						
						//Maintains management connected
						if(Susername.contains("2")) {
							txtPassword.setText(null);
							txtUsername.setText(null);
							MaintenanceManagement info = new MaintenanceManagement();
							MaintenanceManagement.main(null);
						}
						
						//Bill management connected
						if(Susername.contains("3")) {
							txtPassword.setText(null);
							txtUsername.setText(null);
							BillManagement info = new BillManagement();
							BillManagement.main(null);
						}
						
						//Inventory management
						if(Susername.contains("4")) {
							txtPassword.setText(null);
							txtUsername.setText(null);
							StoreManagement info = new StoreManagement();
							StoreManagement.main(null);
						}
						
						//Delivery management connected
						if(Susername.contains("5")) {
							txtPassword.setText(null);
							txtUsername.setText(null);
							DeliveryManagement info = new DeliveryManagement();
							DeliveryManagement.main(null);
						}
						
						//Accounts management connected
						if(Susername.contains("8")) {
							txtPassword.setText(null);
							txtUsername.setText(null);
							AccountsManagement info = new AccountsManagement();
							AccountsManagement.main(null);
						}
						
						//Suppliers management connected
						if(Susername.contains("7")) {
							txtPassword.setText(null);
							txtUsername.setText(null);
							SupplierManagement info = new SupplierManagement();
							SupplierManagement.main(null);
						}
						
						//Leaves management
						if(Susername.contains("1")) {
							txtPassword.setText(null);
							txtUsername.setText(null);
							LeaveManagement info = new LeaveManagement();
							LeaveManagement.main(null);
						}
						
					}
					else {
						JOptionPane.showMessageDialog(null, "Invalid Username or Password.", "Login Error", JOptionPane.ERROR_MESSAGE);
						txtPassword.setText(null);
						txtUsername.setText(null);
					}
				}
				catch(Exception e1) {
					System.out.println(e1);
				}
			}
		});
		SignIn.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\signin.png"));
		SignIn.setBounds(67, 334, 360, 44);
		panel_1.add(SignIn);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\signLarge.png"));
		label.setBounds(209, 11, 82, 85);
		panel_1.add(label);
	}

}
