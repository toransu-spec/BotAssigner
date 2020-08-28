package com.test.ticketpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static com.test.DriverFactory.getChromeDriver;
import static com.test.utils.TestUtils.explicitWait;
public class TicketViewActController {
	
	private WebDriver driver = getChromeDriver();
	
	//Acciones
	public TicketViewActController selectAssignupdate() {
		driver.findElement(assignUpdateElement())
				.click();
		explicitWait();
		return this;
	}
	
	//Elements
	public static By assignUpdateElement() {
		return By.xpath("//*[@id=\"aspnetForm\"]/div[3]/div[1]/a[text()='Assign / Update']");
	}
}
