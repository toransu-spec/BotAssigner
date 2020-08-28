package com.test.infoupdate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static com.test.DriverFactory.getChromeDriver;
import static com.test.utils.TestUtils.scrollTo;
import static com.test.utils.TestUtils.explicitWait;
public class TicketUpdateActController {
	
	private WebDriver driver = getChromeDriver();
	
	//Acciones
	public TicketUpdateActController clickCraDropDown() {
		driver.findElement(craDropDownElement())
				.click();
		return this;
	}
	
	public TicketUpdateActController selectCRA(String name) {
		scrollTo(craNameElement(name));
		driver.findElement(craNameElement(name))
				.click();
		return this;
	}
	
	public TicketUpdateActController clickActionDropDown() {
		driver.findElement(actionDropDownElement())
				.click();
		return this;
	}
	
	public TicketUpdateActController selectAction(int num) {
		scrollTo(actionListElement(num));
		driver.findElement(actionListElement(num))
				.click();
		return this;
	}
	
	public TicketUpdateActController inputTextBoxAssigned() {
		driver.findElement(textBoxElement())
				.sendKeys("Assigned.");
		return this;
	}
	
	public TicketUpdateActController inputTextBoxWIP() {
		driver.findElement(textBoxElement())
				.sendKeys("Work in progress.");
		return this;
	}
	
	public void cancelUpdate() {
		scrollTo(actionsLabel());
		driver.findElement(cancelElement())
				.click();
		explicitWait();
	}
	
	public void submitUpdate() {
		scrollTo(submitElement());
		driver.findElement(submitElement())
				.click();
		explicitWait();
	}
	
	//Elements
	public static By craDropDownElement() {
		return By.xpath("//*[@id=\"ddlOper_Assignee\"]");
	}
	
	public static By craListElement(int num) {
		return By.xpath("//*[@id=\"ddlOper_Assignee\"]/option["+num+"]");
	}
	
	public static By craNameElement(String name) {
		return By.xpath("//*[@id=\"ddlOper_Assignee\"]/option[@value='"+name+"']");
	}
	
	public static By actionDropDownElement() {
		return By.xpath("//*[@id=\"ct100_mainContent_ddlOper_actionCode\"]");
	}
	
	public static By actionListElement(int num) {
		return By.xpath("//*[@id=\"ct100_mainContent_ddlOper_actionCode\"]/option["+num+"]");
	}
	
	public static By textBoxElement() {
		return By.xpath("//*[@id=\"ct100_mainContent_ddlOper_txbOper_CorrectiveActions\"]");
	}
	
	public static By cancelElement() {
		return By.xpath("//*[@id=\"tab-1\"]/ul//a[text()='Cancel']");
	}
	
	public static By submitElement() {
		return By.id("ct100_mainContent_btnOper_UpdateActions");
	}
	
	public static By actionsLabel() {
		return By.xpath("//*[@id=\"aspnetForm\"]/div[3]/h3");
	}
}
