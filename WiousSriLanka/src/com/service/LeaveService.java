package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import com.util.DbConnect;

public class LeaveService {
	
	private PreparedStatement preparedStatement;
	private static Connection connection;
	
	public static void removeleaveRequest(String wid) {
		
	
		
		try {
			
			connection = DbConnect.getDBConnection();
			
			String removeQuery = "DELETE FROM leave_request WHERE Leave_ID = '"+wid+"'";
			PreparedStatement ps = connection.prepareStatement(removeQuery);
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Employee remove successfully!");
			ps.close();
						
		}
		
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
	}
	
	public static void removeleave(String wid) {
		
	
		
		try {
			
			connection = DbConnect.getDBConnection();
			
			String removeQuery = "DELETE FROM LeaveNUSRY WHERE Leave_ID = '"+wid+"'";
			PreparedStatement ps = connection.prepareStatement(removeQuery);
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Leave form delete successfully!");
			ps.close();
						
		}
		
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
	}
}

	
