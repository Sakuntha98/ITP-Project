package com.model;

import java.awt.Toolkit;
import java.util.Calendar;

public class maintenance {
	private String txtName;
	private Toolkit txtCategory;
	private String txtQuantity;
	private String txtPrice;
	private String txtNet;
	private Toolkit txtSupEmail;
//	private Calendar date;	
	
	public String gettxtName() {
		return txtName;
	}
	public void settxtName(String TxtName) {
		txtName = TxtName;
	}
	public Toolkit gettxtCategory() {
		return txtCategory;
	}
	public void settxtCategory(Toolkit toolkitcategory) {
		txtCategory = toolkitcategory;
	}
	public String gettxtQuantity() {
		return txtQuantity;
	}
	public void settxtQuantity(String TxtQuantity) {
		txtQuantity = TxtQuantity;
	}
	public String gettxtPrice() {
		return txtPrice;
	}
	public void settxtPrice(String TxtPrice) {
		txtPrice = TxtPrice;
	}
	public String getTxtNet() {
		return txtNet;
	}
	public void setTxtNet(String TxtNet) {
		txtNet = TxtNet;
	}
	public Toolkit getTxtSupEmail() {
		return txtSupEmail;
	}
	public void setTxtSupEmail(Toolkit Toolkitemail) {
		txtSupEmail = Toolkitemail;
	}
//	public Calendar getDate() {
//		return date;
//	}
//	public void setDate(Calendar calendar) {
//		date = calendar;
//	}
	
	
}
