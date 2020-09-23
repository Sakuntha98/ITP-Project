package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.model.products;
import com.util.DbConnect;

public class productService {

	
	private PreparedStatement  preparedStatement;
	private static Connection connection;

	public static void addProduct(products products) {
		
		try {
		connection = DbConnect.getDBConnection();
		
		String insertQuery = "INSERT INTO storemanagement(ProductID, ProductName, Quantity, Price, SupplierID) VALUES ('"+products.getProductID()+"','"+products.getProductName()+"','"+products.getQuantity()+"','"+products.getPrice()+"','"+products.getSupplierID()+"')";
		
		PreparedStatement ps = connection.prepareStatement(insertQuery);
		
		ps.executeUpdate();
		JOptionPane.showMessageDialog(null, "Product added successfully!");
		
		ps.close();
		}
		
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
	}
	
	public void editProduct(products products) {
		
		
		
	}
	
	
	public static void removeProduct(String productID) {
		
		
		try {
			
			connection = DbConnect.getDBConnection();
			
			String removeQuery = "DELETE FROM storemanagement WHERE ProductID = '"+productID+"'";
		
			PreparedStatement ps = connection.prepareStatement(removeQuery);
			
			ps.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Product removed successfully!");
			
			ps.close();
			
			
		}
		
		catch (Exception e) {
			
			JOptionPane.showMessageDialog(null, e);
		}
	}		

	
	public static void updateProduct(products update) {
		
		
		try {
			
			connection = DbConnect.getDBConnection();
			String updateQuery = "UPDATE storemanagement SET ProductName = '"+update.getProductName()+"' ,  Quantity = '"+update.getQuantity()+"',  Price = '"+update.getPrice()+"',  SupplierID = '"+update.getSupplierID()+"'WHERE (ProductID = '"+update.getProductID()+"')";
			
			PreparedStatement ps = connection.prepareStatement(updateQuery);
			
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Product updated successfully ! ");
			
			ps.close();
			
			
		} catch (Exception e) {
		
			JOptionPane.showMessageDialog(null, e);
			
		}
		
		
		
	}

		
	
	
	
}
