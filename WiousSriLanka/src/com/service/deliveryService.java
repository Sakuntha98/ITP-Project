package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import com.util.DbConnect;

public class deliveryService {
	private PreparedStatement preparedStatement;
	private static Connection connection;
	
	public static void removedelivery(String wid) {
		
		
		try {
			
			connection = DbConnect.getDBConnection();
			
			String removeQuery = "DELETE FROM delivery WHERE Delivery_ID = '"+wid+"'";
			PreparedStatement ps = connection.prepareStatement(removeQuery);
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Delivery remove successfully!");
			ps.close();
						
		}
		
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
	}	
	
	
	public static void removeCompletedelivery(String wid) {
		
		
		try {
			
			connection = DbConnect.getDBConnection();
			
			String removeQuery = "DELETE FROM deliverydone WHERE wdid = '"+wid+"'";
			PreparedStatement ps = connection.prepareStatement(removeQuery);
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Delivery remove successfully!");
			ps.close();
						
		}
		
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
	}
}
