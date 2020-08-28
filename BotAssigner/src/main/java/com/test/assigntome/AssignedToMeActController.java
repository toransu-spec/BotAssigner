package com.test.assigntome;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static com.test.DriverFactory.getChromeDriver;
import static com.test.utils.TestUtils.explicitWait;
public class AssignedToMeActController {
	
	private WebDriver driver = getChromeDriver();
	
	//Acciones
	public void selectFirstAssignedTicket(String status) {
		
		int rowCount = driver.findElements(
						By.xpath("//*[@id=\"divResult_IncidentsAssignmentSearch\"]/div/table[2]/tbody/tr"))
						.size();
		
		for (int i = 2; i<=rowCount; i++) {
			
			String statusValue = driver.findElement(
								By.xpath("//*[@id=\"divResult_IncidentsAssignmentSearch\"]/div/table[2]/tbody/tr["+i+"]/td[7]"))
								.getText();
			
			if (statusValue.equalsIgnoreCase(status)) {
				
				driver.findElement(
								By.xpath("//*[@id=\"divResult_IncidentsAssignmentSearch\"]/div/table[2]/tbody/tr["+i+"]/td[1]/a"))
								.click();
				explicitWait();
				break;
			}
		}
	}

}
