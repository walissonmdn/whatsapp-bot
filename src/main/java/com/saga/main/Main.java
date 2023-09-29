package com.saga.main;

import com.saga.excel.Excel;
import com.saga.selenium.Selenium;
import com.saga.whatsapp.Whatsapp;


public class Main {

	public static void main(String[] args) {

		// Parameters
		String excelFilePath = "C:\\Users\\walis\\OneDrive\\Saga\\Arquivos\\GitHub\\whatsappbot\\src\\main\\resources\\data.xlsx"; 
		int numberOfRowsInWorksheet = 3;
		//
	
		
		// Initialize Whatsapp.
		Selenium driver = new Selenium();
		
		Whatsapp whatsapp = new Whatsapp(driver);
		whatsapp.getPage();
		
		driver.waitForElementToAppear("div.landing-title._2K09Y");
		System.out.println("Scan the QR Code, please.");
		
		driver.waitForElementToDisappear("div.landing-title._2K09Y");
		
		driver.waitForElementToAppear("button.opCKJ._28iyj");
		System.out.println("Conversations have been loaded.");
		
		
		// Contact people according to the worksheet.
		Excel excelFile = new Excel(excelFilePath);
		for (int i = 1; i <= numberOfRowsInWorksheet; i++) {
			excelFile.openWorkbook();
			excelFile.getSheetAt(0);
			
			// Code will be implemented.
			
			excelFile.saveWorkbook();
			excelFile.closeWorkbook();			
		}
		
		System.out.println("Done.");

	}

}

