package com.test;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverFactory {
	
	private static WebDriver driver;
	private static WebDriverWait wait;
	private static Actions action;
	
	private DriverFactory() {
		//Esconderlo para que no pueda ser instanciado
	}
	
	public static WebDriver getChromeDriver() {
		if (driver == null) {
			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.setPageLoadStrategy(PageLoadStrategy.NONE); //en una version del driver, tuve que utilizar esto para solo cargar elementos html
			driver = new ChromeDriver(options);
		}
		return driver;
	}
	
	public static Actions getAction() {
		action = new Actions(driver);
		return action;
	}
	
	public static WebDriverWait getWebDriverWait() {
		if(wait == null) 
			wait = new WebDriverWait(getChromeDriver(), 5);
		return wait;
	}

}
