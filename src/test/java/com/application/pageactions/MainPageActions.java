package com.application.pageactions;

import org.openqa.selenium.support.PageFactory;

import com.application.pageelements.MainPageElements;
import com.framework.webdriver.WebDriverBase;

public class MainPageActions extends MainPageElements{
	
	static String name = null;
	
	public void startTheGame() {
		WaitForElement(bycookieClicker);
		name = "lakkyreddy"+uniqueId();
		enterInfo(yourNameTxtb, name);
		click(startBtn);
		WaitForElement(bycookieClickerLink);
		click(cookieClickerLink);
		log("pass","game started successfully");
	}
	
	public void verifyNewUserDetailsInApplication() {
		WaitForElement(byuserLink(name));
		log("pass","user successfully created");
	}
	
	public void navigateToUserGamePage() {
		click(userLink(name));
		WaitForElement(bycookieClickerLink);
		log("pass","game page successfully Launched");
	}
	
	public static MainPageActions getActions() {
		return PageFactory.initElements(WebDriverBase.driver, MainPageActions.class);
	}
}
