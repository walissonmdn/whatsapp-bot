package com.saga.main;

import com.saga.selenium.Selenium;
import com.saga.whatsapp.Whatsapp;


public class Main {

	public static void main(String[] args) {

		Selenium driver = new Selenium();
		
		Whatsapp whatsapp = new Whatsapp(driver);
		whatsapp.getPage();
		
		driver.waitForElementToAppear("div.landing-title._2K09Y");
		System.out.println("Scan the QR Code, please.");
		
		driver.waitForElementToDisappear("div.landing-title._2K09Y");
		
		driver.waitForElementToAppear("button.opCKJ._28iyj");
		System.out.println("Conversations have been loaded.");
//		Excel excelFile = new Excel("C:\\Users\\walis\\OneDrive\\Saga\\Arquivos\\GitHub\\whatsappbot\\test.xlsx");
//		excelFile.openWorkbook();
//		excelFile.getSheetAt(0);
//		excelFile.setCellValue(1, 1, "This is a test.");
//		excelFile.saveWorkbook();
//		excelFile.closeWorkbook();
//		
//		System.out.println("Done");
		

	}

}

