package com.test.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.test.DriverFactory.getChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
public class TestUtils {
	
	private static WebDriver driver = getChromeDriver();
	private static WebDriverWait wait;
	
	public static void explicitWait() {
		try {
			Thread.sleep(4000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	public static void waitSecTime(int secTime) {
		try {
			TimeUnit.SECONDS.sleep(secTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void scrollTo(By element) {
		((JavascriptExecutor) driver)
		.executeScript("arguments[0].scrollIntoView(true);"
				, driver.findElement(element));
	}
	public static String getTicketUrl() {
		return driver.getCurrentUrl();
	}
	
	public static void goToTicketUrl(String url) {
		driver.get(url);
		explicitWait();
	}
	
	public static void deleteCookes() {
		driver.manage().deleteAllCookies();
	}
	
	public static void printTime() {
		System.out.println("* System Time: " +java.time.LocalTime.now());
	}
	
	public static void waitElementNotVisible(By element) {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}
	
	public static void refreshPage() {
		driver.navigate().refresh();
		explicitWait();
	}
	
	public static void sendMail (String subject, String user) {
		try {
			Runtime.getRuntime().exec("wscript.exe " + new File("Mailbot.vbs " + subject + " " + user).getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
