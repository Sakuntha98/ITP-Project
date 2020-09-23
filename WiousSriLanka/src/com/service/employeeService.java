package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.model.employee;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import com.util.DbConnect;

public class employeeService {
	private PreparedStatement preparedStatement;
	private static Connection connection;
	
	public static void removemember(String wid) {
		
		
		try {
			
			connection = DbConnect.getDBConnection();
			
			String removeQuery = "DELETE FROM employee WHERE wid = '"+wid+"'";
			PreparedStatement ps = connection.prepareStatement(removeQuery);
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Employee remove successfully!");
			ps.close();
						
		}
		
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
	}		
	
	public static void removenote(String nid) {
		
		
		try {
			
			connection = DbConnect.getDBConnection();
			
			String removeQuery = "DELETE FROM notice WHERE NoticeID = '"+nid+"'";
			PreparedStatement ps = connection.prepareStatement(removeQuery);
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Notice remove successfully!");
			ps.close();
						
		}
		
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
	}		
}
