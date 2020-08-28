package com.test.header;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static com.test.DriverFactory.getChromeDriver;
import static com.test.utils.TestUtils.explicitWait;
public class PageHeader {
	
	private WebDriver driver = getChromeDriver();
	
	public static PageHeader getPageHeader() {
		return new PageHeader();
	}
	
	//Acciones
	public PageHeader selectTab(HeaderTabsEnum tabName) {
		driver.findElement(headerTab(tabName)).click();
		explicitWait();
		return this;
	}
	
	public PageHeader selectTicketTab() {
		driver.findElement(ticketsToMeElement()).click();
		explicitWait();
		return this;
	}
	
	//Elements
	public static By headerTab(HeaderTabsEnum tabName) {
		return By.xpath("//a[contains(text(),'"+tabName+"')]");
	}
	
	public static By ticketsToMeElement() {
		return By.xpath("//*[id=\"ui-id-2\"]");
	}
}
