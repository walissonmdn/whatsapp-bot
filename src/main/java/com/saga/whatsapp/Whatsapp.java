package com.saga.whatsapp;

import java.util.List;
import org.openqa.selenium.WebElement;
import com.saga.selenium.Selenium;

public class Whatsapp {
	private Selenium driver;
	
	public Whatsapp(Selenium driver) {
		this.driver = driver;
	}
	
	public void getPage() {
		driver.getPage("https://web.whatsapp.com/");
	}
	
	public void contact(String number, String message) {
		driver.scriptJavascript("window.open('https://web.whatsapp.com/send/?phone=" + number + "&" + "text="+ message + "');");
		driver.closeCurrentWindow();
		driver.switchToWindow(0);
	}
	
	public void sendMessage() {
		WebElement button = driver.findElement("button.tvf2evcx.oq44ahr5.lb5m6g5c.svlsagor.p2rjqpw5.epia9gcq");
		driver.click(button);
	}
	
	public String getLastMessage() {
		List<WebElement> messageElements = driver.findElements("div._3B19s > div > div._5kRIK > div.n5hs2j7m.oq31bsqd.gx1rr48f.qh5tioqs > div > div > div > div > div > div > div > div > div > span._11JPr.selectable-text.copyable-text > span");
		WebElement lastMessageElement = messageElements.get(messageElements.size() - 1);
		String lastMessage = driver.getText(lastMessageElement);
		return lastMessage;
	}
	
	public String getLastMessageStatus() {
		List<WebElement> messageStatusElements = driver.findElements("div._3B19s > div > div._5kRIK > div.n5hs2j7m.oq31bsqd.gx1rr48f.qh5tioqs > div > div > div > div > div > div:nth-child(2) > div > div > div > div.do8e0lj9.l7jjieqr.k6y3xtnu > span");
		WebElement lastMessageStatusElement = messageStatusElements.get(messageStatusElements.size() - 1);
		String lastMessageStatus = driver.getText(lastMessageStatusElement);
		return lastMessageStatus;
	}
	
}
