package com.Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.util.DbConnect;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Insets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Notices extends JFrame {

	private JPanel contentPane;
	private JTable table_Note;
	private JTextField txtSearch;


	private PreparedStatement preparedStatement;
	private static Connection connection;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Notices frame = new Notices();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public void DisplayNotes() throws  InstantiationException, IllegalAccessException, SQLException, ClassNotFoundException {
		
		connection = DbConnect.getDBConnection();
		
		String selectQuery2 = "SELECT * FROM notice";
		
		PreparedStatement p2 = connection.prepareStatement(selectQuery2);
		
		ResultSet rs2 = p2.executeQuery();
		
		table_Note.setModel(DbUtils.resultSetToTableModel(rs2));	
		
		p2.close();	
	}
	
	public Notices() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\avina\\Desktop\\IT18195644\\images\\wious.png"));
		setTitle("Notices");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200, 200, 1300, 725);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_Head = new JPanel();
		panel_Head.setBackground(new Color(238, 232, 170));
		panel_Head.setBounds(10, 11, 1274, 111);
		contentPane.add(panel_Head);
		panel_Head.setLayout(null);
		
		JLabel lblNoticePlace = new JLabel("Notice Criteria");
		lblNoticePlace.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNoticePlace.setBounds(155, 19, 610, 72);
		panel_Head.add(lblNoticePlace);
		
		JPanel panel_Body = new JPanel();
		panel_Body.setBackground(new Color(189, 183, 107));
		panel_Body.setBounds(10, 133, 1274, 552);
		contentPane.add(panel_Body);
		panel_Body.setLayout(null);
		
		JLabel lblViewNotes = new JLabel("View Notes");
		lblViewNotes.setBounds(22, 11, 259, 47);
		lblViewNotes.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel_Body.add(lblViewNotes);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 82, 1204, 438);
		panel_Body.add(scrollPane);
		
		table_Note = new JTable();
		scrollPane.setViewportView(table_Note);
		table_Note.setBackground(Color.GRAY);
		
		DisplayNotes();
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int selectRow = table_Note.getSelectedRow();
				
				String nid = (table_Note.getModel().getValueAt(selectRow, 0).toString());
				
				com.service.employeeService.removenote(nid);
				
				try {
					DisplayNotes();
				} 
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnDelete.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\cancel.png"));
		btnDelete.setBounds(212, 22, 125, 36);
		panel_Body.add(btnDelete);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					DisplayNotes();
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
		btnRefresh.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\refresh.png"));
		btnRefresh.setBounds(358, 22, 125, 36);
		panel_Body.add(btnRefresh);
		
		txtSearch = new JTextField();
		txtSearch.setToolTipText("Search Iteam Name");
		txtSearch.setMargin(new Insets(2, 10, 2, 10));
		txtSearch.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSearch.setColumns(10);
		txtSearch.setBounds(958, 24, 231, 30);
		panel_Body.add(txtSearch);
		
		JButton btnSearch = new JButton("");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String searchp1 = txtSearch.getText();
				
				try {
					if(searchp1.isEmpty()==true) {
						DisplayNotes();
						JOptionPane.showMessageDialog(null, "Entered is empty!");
					}
					else {						
						connection = DbConnect.getDBConnection();
						String searchQuery = "select * from notice where NoticeID LIKE '"+txtSearch.getText()+"'";
						PreparedStatement ps = connection.prepareStatement(searchQuery);
						ResultSet rs = ps.executeQuery();
						table_Note.setModel(DbUtils.resultSetToTableModel(rs));	
					}	
				} 
				catch (Exception e1) {
						JOptionPane.showMessageDialog(null,e1);
				}
			}
		});
		btnSearch.setIcon(new ImageIcon("C:\\Users\\avina\\Desktop\\IT18195644\\images\\search.png"));
		btnSearch.setToolTipText("Search");
		btnSearch.setBounds(1199, 22, 36, 36);
		panel_Body.add(btnSearch);
	}
}
