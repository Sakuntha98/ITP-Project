package com.model;

import java.awt.Toolkit;
import java.util.Calendar;

public class accounts {
	
	private int Transacation_ID;
	private int Invoice_No;
	private String Customer_Name;
	private String Email;
	private String Phone;
	private int Amount;
	private String Status;
	private String Transaction_Date;  
	
	
	public int getTransacation_ID() {
		return Transacation_ID;
	}
	public void setTransacation_ID(int transacation_ID) {
		Transacation_ID = transacation_ID;
	}
	public int getInvoice_No() {
		return Invoice_No;
	}
	public void setInvoice_No(int invoice_No) {
		Invoice_No = invoice_No;
	}
	public String getCustomer_Name() {
		return Customer_Name;
	}
	public void setCustomer_Name(String customer_Name) {
		Customer_Name = customer_Name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public int getAmount() {
		return Amount;
	}
	public void setAmount(int amount) {
		Amount = amount;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getTransaction_Date() {
		return Transaction_Date;
	}
	public void setTransaction_Date(String transaction_Date) {
		Transaction_Date = transaction_Date;
	}
	



	

}
