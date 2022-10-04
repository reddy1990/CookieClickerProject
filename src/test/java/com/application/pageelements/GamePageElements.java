package com.application.pageelements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.framework.commons.WebCommons;

public class GamePageElements extends WebCommons {
	
	@FindBy(xpath = "//a[contains(text(),'Cookie Clicker!')]")
	public WebElement cookieClickerLink;

	@FindBy(xpath = "//p[contains(text(),'Hello')]")
	public WebElement helloTxt;

	@FindBy(xpath = "//b[contains(text(),'Cookies:')]")
	public WebElement cookiesLabel;

	@FindBy(xpath = "//span[@id='cookies']")
	public WebElement cookiesValue;

	@FindBy(xpath = "//b[contains(text(),'Factories:')]")
	public WebElement factoriesLabel;

	@FindBy(xpath = "//span[@id='factories']")
	public WebElement factoriesValue;

	@FindBy(xpath = "//b[contains(text(),'Money')]")
	public WebElement moneyLabel;

	@FindBy(xpath = "//span[@id='money']")
	public WebElement moneyValue;
	
	@FindBy(xpath = "//button[@id='click']")
	public WebElement cookiesBtn;
	
	@FindBy(xpath = "//input[@id='cookies-to-sell']")
	public WebElement sellCookiesTxtb;

	@FindBy(xpath = "//button[@id='sell-cookies']")
	public WebElement sellCookiesBtn;

	@FindBy(xpath = "//input[@id='factories-to-buy']")
	public WebElement factoriesToBuyTxtb;

	@FindBy(xpath = "//button[@id='buy-factories']")
	public WebElement buyFactoriesBtn;

}
