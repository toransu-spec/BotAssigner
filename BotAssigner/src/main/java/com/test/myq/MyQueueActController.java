package com.test.myq;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static com.test.DriverFactory.getChromeDriver;
import static com.test.utils.TestUtils.explicitWait;
import static com.test.utils.TestUtils.waitElementNotVisible;
public class MyQueueActController {
	
	public WebDriver driver = getChromeDriver();
	
	//Acciones
	public MyQueueActController showUnassignedOnly() {
		if (!driver.findElement(showUnassignedElement()).isSelected())
			driver.findElement(showUnassignedElement())
				.click();
		explicitWait();
		return this;
	}
	
	public MyQueueActController selectQueueDropDown() {
		if (driver.findElement(loadingBoxElement()).isDisplayed())
			waitElementNotVisible(loadingBoxElement());
		driver.findElement(queueDropDownElement())
				.click();
		explicitWait();
		return this;
	}
	
	public MyQueueActController selectYourQueue(String queue) {
		waitElementNotVisible(loadingBoxElement());
		driver.findElement(selectQueueElement(queue))
				.click();
		return this;
	}
	
	public MyQueueActController selectUnassignedTicket() {
		waitElementNotVisible(loadingBoxElement());
		driver.findElements(By.xpath("//*[@id=\"divResult_IncidentQueueSearch\"]/div/table[2]/tbody/tr[2]/td[1]/a")).get(0)
				.click();
		explicitWait();
		return this;
	}
	
	//funcion de prueba. verifica si la queu que intenta seleccionar esta en la lista
	public boolean queueIsNotVisible(String queue) {
		return driver.findElements(selectQueueElement(queue)).isEmpty();
	}
	
	//funcion que devuelve el numero de ticket
	public void printTicketNumber() {
		System.out.println("* Ticket #: "+driver.findElement(ticketNumber()).getText());
	}
	
	//Elements
	public static By queueDropDownElement() {
		return By.id("selIncidentAssignmentGroup");
	}
	
	public static By selectQueueElement(String queue) {
		return By.xpath("//*[@id=\"selIncidentAssignmentGroup\"]/option[@value='"+queue+"']");
	}
	
	public static By showUnassignedElement() {
		return By.id("chkbxIncQueue_UnassignedOnly");
	}
	
	public static By loadingBoxElement() {
		return By.id("divSearchmessage_incidentQueueSearch");
	}
	
	public static By ticketNumber() {
		return By.xpath("//*[@id=\"aspnetForm\"]/div[3]/h1/strong");
	}
	
	public boolean queueDropDownVisible() {
		return driver.findElements(queueDropDownElement()).isEmpty();
	}
	
	public String stringTicketNumber() {
		return driver.findElement(ticketNumber()).getText();
	}
}
