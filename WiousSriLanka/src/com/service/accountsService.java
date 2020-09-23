package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import com.util.DbConnect;

public class accountsService {

	private PreparedStatement preparedStatement;
	private static Connection connection;
	
	public static void removepaidaccounts(String tid) {
		
		
		try {
			
			connection = DbConnect.getDBConnection();
			
			String removeQuery = "DELETE FROM accounts WHERE Transaction_ID = '"+tid+"'";
			PreparedStatement ps = connection.prepareStatement(removeQuery);
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Record remove successfully!");
			ps.close();
						
		}
		
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
	}	
	
	
	public static void removependingaccounts(String tid) {
		
		
		try {
			
			connection = DbConnect.getDBConnection();
			
			String removeQuery = "DELETE FROM accounts WHERE Transaction_ID = '"+tid+"'";
			PreparedStatement ps = connection.prepareStatement(removeQuery);
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Record removed successfully!");
			ps.close();
						
		}
		
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
	}
}
