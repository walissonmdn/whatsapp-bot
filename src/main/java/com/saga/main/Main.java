package com.saga.main;

import com.saga.excel.Excel;
import com.saga.selenium.Selenium;
import com.saga.whatsapp.Whatsapp;


public class Main {

	public static void main(String[] args) {

		Selenium driver = new Selenium();
		Whatsapp whatsapp = new Whatsapp(driver);
		whatsapp.getPage();
		
		driver.wait("div.landing-title._2K09Y");
		System.out.println("Scan the QR Code, please.");
		while (true) {
			try {
				driver.findElement("div.landing-title._2K09Y");
			} catch(Exception e) {
				break;
			}
		}
		driver.wait("button.opCKJ._28iyj");
		System.out.println("Conversations have been loaded.");
	
	}

}

