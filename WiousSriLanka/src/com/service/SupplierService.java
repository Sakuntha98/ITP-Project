package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import com.model.Supplier;
import com.util.DbConnect;

public class SupplierService {
	
	private PreparedStatement preparedStatement;
	private static Connection connection;
	
	
	
	

	public void addSuppliers(Supplier supplier) {
		
		try {
			
			connection = DbConnect.getDBConnection();
			
			String insertQuery = "INSERT INTO suppliermanagement(Supplier_ID, Name, NIC_Number, Email, Phone) VALUES('"+supplier.getSID()+"','"+supplier.getNAME()+"','"+supplier.getNIC()+"','"+supplier.getEMAIL()+"','"+supplier.getPHONE()+"')";
			
			PreparedStatement ps = connection.prepareStatement(insertQuery);
			
			ps.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Supplier added Successfully");
			
			ps.close();
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
		
	}
	
	public void updateSuppliers(Supplier update) { 
		
		try {
			
			connection = DbConnect.getDBConnection();
			
			String updateQuery = "Update suppliermanagement SET Supplier_ID='"+update.getSID()+"',Name='"+update.getNAME()+"',NIC_Number='"+update.getNIC()+"',Email='"+update.getEMAIL()+"',Phone='"+update.getPHONE()+"' WHERE ID = '"+update.getID()+"'"; 
			
			PreparedStatement pst = connection.prepareStatement(updateQuery);
			
			pst.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Supplier details update successfully");
			
			pst.close();	
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	public static void removeSuppliers(String id) {
		
		try {
			
			connection = DbConnect.getDBConnection();
			
			String removeQuery = "DELETE FROM suppliermanagement WHERE ID = '"+id+"'";
			
			PreparedStatement pst = connection.prepareStatement(removeQuery);
			
			pst.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Supplier Remove Successfuly");
			
			pst.close();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
	}		
	}
