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
		
		driver.waitForElementToDissapear("div.landing-title._2K09Y");
		
		driver.waitForElementToAppear("button.opCKJ._28iyj");
		System.out.println("Conversations have been loaded.");
	

	}

}

