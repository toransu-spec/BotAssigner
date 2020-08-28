package com.test.conditions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import static com.test.utils.ExcelDataProvider.testData;
import static com.test.DriverFactory.getChromeDriver;
import static com.test.DriverFactory.getWebDriverWait;
import static com.test.utils.TestUtils.explicitWait;

import java.util.concurrent.TimeUnit;

public class Conditions {
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	
	//los datos que recoge el data provider simulan usuarios. ningun usuario es real.
	@DataProvider(name = "controlTest")
	public Object[][] getData(){
		String excelPath = "excel/data.xlsx";
		Object data[][] = testData(excelPath, "sheet1");
		return data;
	}
	
	@BeforeSuite
	public void startUpBrowser() {
		driver = getChromeDriver();
		driver.manage().timeouts()	.implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		wait = getWebDriverWait();
	}
	
	@BeforeMethod
	public void goToHome() {
		driver.manage().deleteAllCookies();
		driver.get("http://ticketsurlhere.com/"); //el nombre de la pagina que testeaba fue borrado para subir el codigo
		explicitWait();
	}
	
	@AfterSuite(alwaysRun = true)
	public void close() {
		driver.quit();
	}

}
