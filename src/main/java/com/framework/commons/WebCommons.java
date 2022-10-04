package com.framework.commons;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.framework.reports.ReportsClass;
import com.framework.utils.Constants;
import com.framework.webdriver.WebDriverBase;

public class WebCommons {
	
	//This class will have all the common methods related to UI automation
	
	public WebDriver driver = WebDriverBase.driver;
	
	public void scrollToElement(WebElement element) {
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView()",element);
	}
	
	public void click(WebElement element) {
		scrollToElement(element);
		element.click();
	}
	
	public void jsClick(WebElement element) {
		scrollToElement(element);
		((JavascriptExecutor)driver).executeScript("arguments[0].click()",element);
	}
	
	public void enterInfo(WebElement element, String value) {
		scrollToElement(element);
		element.clear();
		element.sendKeys(value);
	}
	
	public void selectCheckbox(WebElement element) {
		scrollToElement(element);
		if(!element.isSelected())
			element.click();
	}
	
	public void selectOption(WebElement element, String option , String By) {
		scrollToElement(element);
		Select s = new Select(element);
		if (By.equalsIgnoreCase("Index")) {
			s.selectByIndex(Integer.parseInt(option));
		}else if (By.equalsIgnoreCase("Value")) {
			s.selectByValue(option);
		}else if (By.equalsIgnoreCase("VisibleText")) {
			s.selectByVisibleText(option);
		}
	}
	
	
	public void Wait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.WAIT_TIME));
	}
	
	public void WaitForElement(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.WAIT_TIME));
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(locator, 0));
	}
	
	public String takeScreenshotOfPage(String name) throws IOException {
		String path = System.getProperty("user.dir")+"\\Screenshots\\"+name+".png";		
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File(path));
		return path;
	}
	
	public String takeScreenshotOfElement(String name, WebElement element) throws IOException {
		String path = System.getProperty("user.dir")+"\\Screenshots\\"+name+".png";		
		File file = element.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File(path));
		return path;
	}
	
	public String uniqueId() {
		return new SimpleDateFormat("ddMMyyyyhhmmss").format(Calendar.getInstance().getTime());
	}
	
	public void log(String status, String message) {
		ExtentTest logger = ReportsClass.logger;
		
		if (status.equalsIgnoreCase("pass")) {
			logger.pass(message);
		}else if (status.equalsIgnoreCase("fail")) {
			logger.fail(message);
		}else if (status.equalsIgnoreCase("info")) {
			logger.info(message);
		}
	}
	
	public void Wait(int seconds){
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getText(WebElement element) {
		return element.getText();
	}

}
