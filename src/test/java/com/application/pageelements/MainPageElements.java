package com.application.pageelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.framework.commons.WebCommons;

public class MainPageElements extends WebCommons{

	@FindBy(xpath = "//h1[contains(text(),'Cookie Clicker')]")
	public WebElement cookieClicker;
	public By bycookieClicker = By.xpath("//h1[contains(text(),'Cookie Clicker')]");

	@FindBy(xpath = "//h2[contains(text(),'New Game')]")
	public WebElement newGame;

	@FindBy(xpath = "//label[contains(text(),'Your name:')]")
	public WebElement yourNameLabel;

	@FindBy(xpath = "//input[@name='name']")
	public WebElement yourNameTxtb;

	@FindBy(xpath = "//button[contains(text(),'Start')]")
	public WebElement startBtn;
	
	@FindBy(xpath = "//a[contains(text(),'Cookie Clicker')]")
	public WebElement cookieClickerLink;
	
	public By bycookieClickerLink = By.xpath("//a[contains(text(),'Cookie Clicker')]");

	@FindBy(xpath = "//h2[contains(text(),'High Scores')]")
	public WebElement highScores;

	@FindBy(xpath = "//th[contains(text(),'Player')]")
	public WebElement player;

	@FindBy(xpath = "//th[contains(text(),'Score')]")
	public WebElement score;

	public By byuserLink(String username) {
		return By.xpath("//a[text()='"+username+"']");
	}
	
	@FindBy(xpath = "//label[contains(text(),'Your name:')]")
	public WebElement yourNameLabel2;
	
	public WebElement userLink(String username) {
		return driver.findElement(By.xpath("//a[text()='"+username+"']"));
	}

}
