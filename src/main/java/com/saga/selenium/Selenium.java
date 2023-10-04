package com.saga.selenium;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Selenium {
	private WebDriver driver;
	
	public Selenium() {
		driver = new EdgeDriver();
	}
	
	public void clear(WebElement element) {
		element.clear();
	}
	
	public void click(WebElement element) {
		element.click();
	}
	
	public void clickLoop(WebElement element) {
		while(true) {
			try {
				element.click();
				break;
			} catch(Exception e) {
				// Repeat the code until it's possible to click on the element.
			}
		}
	}	
	
	public void closeCurrentWindow() {
		driver.close();
	}
	
	public WebElement findElement(String cssSelector) {
		return driver.findElement(By.cssSelector(cssSelector));
	}
	
	public WebElement findElementLoop(String cssSelector) {
		WebElement element;
		while(true) {
			try {
				element = driver.findElement(By.cssSelector(cssSelector));
				break;
			} catch(Exception e) {
				// Repeat the code until element is found.
			}
		}
		return element;
	}	
	
	public List<WebElement> findElements(String cssSelector) {
		return driver.findElements(By.cssSelector(cssSelector));
	}
	
	public List<WebElement> findElementsLoop(String cssSelector) {
		List<WebElement> elements;
		while(true) {
			try {
				elements = driver.findElements(By.cssSelector(cssSelector));
				break;
			} catch(Exception e) {
				// Repeat the code until elements are found.
			}
		}
		return elements;
	}	
	
	public String getAttribute(WebElement element, String attribute) {
		return element.getAttribute(attribute);
	}
	
	public void getPage(String url) {
		driver.get(url);
	}
	
	public String getText(WebElement element) {
		String text;
		while(true) {
			try {
				text = element.getText();
				break;
			} catch (Exception e) {
				//
			}
				
		}
		
		return text;
	}
	
	public void refreshPage() {
		driver.navigate().refresh();
	}
	
	public void scriptJavascript(String code) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript(code);
	}
	
	public void sendKeys(WebElement element, String text) {
		element.sendKeys(text);
	}
	
	public void switchToWindow(int windowIndex) {
		ArrayList<String> windows = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(windows.get(windowIndex));

	}

	public void waitForElementToAppear(String cssSelector) {
		while (true) {
			try {
				findElement(cssSelector);
				break;
			} catch (Exception e) {
			// Element not found, so the loop will run again until element is found.
			}
		}
	}
	
	public void waitForElementToDisappear(String cssSelector) {
		while(true) {
			try {
				driver.findElement(By.cssSelector(cssSelector));
			} catch(Exception e) {
				break;
			}	
		}
		
	}
}
