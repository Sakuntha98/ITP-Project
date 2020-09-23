package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.util.DbConnect;
import java.sql.SQLException;
import com.model.Bill;
import javax.swing.JOptionPane;


public class BillServices {
	
	private static Connection connection ;
	private PreparedStatement preStatement ;
	
	public static void removeBill(String BId) {
		try {
			
			connection = DbConnect.getDBConnection();
			
			String removeQuery = "DELETE FROM bills2 WHERE Bill_ID = '"+BId+"'";
			PreparedStatement ps = connection.prepareStatement(removeQuery);
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Order remove successfully!");
			ps.close();
						
		}
		
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}



	public void addBill(Bill bill) {
		try {
			connection = DbConnect.getDBConnection();
			
			String addBillQuery = "INSERT INTO Bill_main(BId,bill,acc,amount,Bank,date) VALUES (?,?,?,?,?)";
			
			PreparedStatement pst = connection.prepareStatement(addBillQuery);
			
			pst.setString(1, bill.getBillId());
			pst.setString(2, bill.getAcc()); 
			pst.setString(3, bill.getAmount());
			pst.setString(4, bill.getBank());
			pst.setString(4, bill.getDate());
					
			pst.executeUpdate();  		//execute query 
			
			JOptionPane.showMessageDialog(null, "Payment Sucessfully!");
			
			
		}catch(SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			
			JOptionPane.showMessageDialog(null, e.getMessage());
			
		}finally {
			try {
				if (preStatement != null) {
					preStatement.close();
				}
				if(connection != null) {
					connection.close();
				}
			}catch(SQLException e) {
				
			}
			
		}
	
	}
}



