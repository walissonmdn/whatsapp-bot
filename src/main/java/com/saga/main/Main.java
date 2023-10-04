package com.saga.main;

import com.saga.excel.Excel;
import com.saga.selenium.Selenium;
import com.saga.whatsapp.Whatsapp;
import java.lang.Thread;
import java.time.Duration;

public class Main {

	public static void main(String[] args) {
		// Parameters
		String excelFilePath = "C:\\Users\\walis\\OneDrive\\Saga\\Arquivos\\GitHub\\whatsappbot\\src\\main\\resources\\data.xlsx"; 
		int numberOfRowsInWorksheet = 2;
		int initialRow = 1;
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
		String lastMessage;
		String lastMessageStatus;
		Excel excelFile = new Excel(excelFilePath);
		for (int row = initialRow; row <= numberOfRowsInWorksheet; row++) {
			excelFile.openWorkbook();
			excelFile.getSheetAt(0);
			
			String phoneNumber = excelFile.getCellValue(row, 0);
			String name = excelFile.getCellValue(row, 1);
			String message = "Hi, " + name + ". This is an automatic message.";
			
			whatsapp.contact("+" + phoneNumber, message);
			System.out.println("Navigating to the conversation.");
			
			while(true) {
				lastMessage = whatsapp.getLastMessage();
				System.out.println(lastMessage);
				lastMessageStatus = whatsapp.getLastMessageStatus();
				System.out.println(lastMessageStatus);
				if(lastMessageStatus.toLowerCase().contains("pending") == true) {
					try {
						Thread.sleep(Duration.ofMillis(500));
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if(lastMessageStatus.toLowerCase().contains("sent") == true || lastMessageStatus.toLowerCase().contains("read")) {
					excelFile.setCellValue(row, 2, "Message sent.");
					break;
				}
			}
			excelFile.saveWorkbook();
			excelFile.closeWorkbook();			
		}
		
		System.out.println("Done.");
	}

}

