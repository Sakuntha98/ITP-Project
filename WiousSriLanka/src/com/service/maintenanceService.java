package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import com.model.maintenance;
import com.util.DbConnect;

public class maintenanceService {
	private PreparedStatement preparedStatement;
	private static Connection connection;
	
	public static void addOrderdelete(String requestid) {
		
		
		try {
			
			connection = DbConnect.getDBConnection();
			
			String removeQuery = "DELETE FROM request WHERE Request_ID = '"+requestid+"'";
			PreparedStatement ps = connection.prepareStatement(removeQuery);
			ps.executeUpdate();
			ps.close();
					
		}
		
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
	}	
	
	public static void removeOrder(String billid) {
		
		
		try {
			
			connection = DbConnect.getDBConnection();
			
			String removeQuery = "DELETE FROM bills1 WHERE Bill_ID = '"+billid+"'";
			PreparedStatement ps = connection.prepareStatement(removeQuery);
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Order remove successfully!");
			ps.close();
						
		}
		
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
	}		

}
