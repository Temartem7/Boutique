package com.dataprovider;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.utility.ExcelLibrary;

public class Data_Providers {

	ExcelLibrary obj = new ExcelLibrary();
	//======================================================================	
	@DataProvider(name = "Credentials")
	public Object[][] getCredentials() {
		// Totals rows count
		int rows = obj.getRowCount("LoginCredentials_Info");
		// Total Columns
		int column = obj.getColumnCount("LoginCredentials_Info");
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj.getCellData("LoginCredentials_Info", j, i + 2);
			}
		}
		return data;
	}	
	//======================================================================
	@DataProvider(name = "Email")
	public Object[][] verify_Email() {
		// Totals rows count
		int rows = obj.getRowCount("Email_Info");
		// Total Columns
		int column = obj.getColumnCount("Email_Info");
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj.getCellData("Email_Info", j, i + 2);
			}
		}
		return data;
	}
	//======================================================================
	@DataProvider(name = "Product")
	public Object[][] verify_Product() {
			// Totals rows count
			int rows = obj.getRowCount("Product_Info");
			// Total Columns
			int column = obj.getColumnCount("Product_Info");
			int actRows = rows - 1;

			Object[][] data = new Object[actRows][column];

			for (int i = 0; i < actRows; i++) {
				for (int j = 0; j < column; j++) {
					data[i][j] = obj.getCellData("Product_Info", j, i + 2);
				}
			}
			return data;
		}
	//======================================================================
	@DataProvider(name = "NewAccount")
	public Object[][] new_NewAccount() {
		// Totals rows count
		int rows = obj.getRowCount("NewAccount_Info");
		// Total Columns
		int column = obj.getColumnCount("NewAccount_Info");
		int actRows = rows - 1;
		//Created an object of array to store data
		Object[][] data = new Object[actRows][1];
		
		for (int i = 0; i < actRows; i++) {
			Map<String, String> hashMap = new HashMap<String, String>();
			for (int j = 0; j < column; j++) {
				hashMap.put(obj.getCellData("NewAccount_Info", j, 1),
						obj.getCellData("NewAccount_Info", j, i + 2));
			}
			data[i][0]=hashMap;
		}
		return data;
	}
	//======================================================================
	@DataProvider(name = "SearchProduct")
	public Object[][] verify_ProductPrice() {
		// Totals rows count
		int rows = obj.getRowCount("SearchProduct_Info");
		// Total Columns
		int column = obj.getColumnCount("SearchProduct_Info");
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj.getCellData("SearchProduct_Info", j, i + 2);
			}
		}
		return data;
	}
	//======================================================================
}
