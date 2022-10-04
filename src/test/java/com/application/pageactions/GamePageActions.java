package com.application.pageactions;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.application.pageelements.GamePageElements;
import com.framework.webdriver.WebDriverBase;

public class GamePageActions extends GamePageElements{
	
	public void verifyGamePageWelcomeLabel() {
		Assert.assertEquals(getText(helloTxt), "Hello "+MainPageActions.name);
		log("pass","Welcome Label is as Expected");
	}
	
	public void generateCookies() {
		for (int i = 0; i < 16; i++) {
			click(cookiesBtn);
			Wait(1);
		}
		Assert.assertTrue(Integer.parseInt(getText(cookiesValue)) > 0);
		log("pass", "Cokkies generated successfully");
	}
	
	public void sellAllCookies() {			
		enterInfo(sellCookiesTxtb,getText(cookiesValue));
		click(sellCookiesBtn);		
		Assert.assertTrue(Integer.parseInt(getText(cookiesValue)) == 0);
		log("pass","Cookies Successfully Soldout");
	}
	
	public void sellHalfOfTheCookies() {
		Wait(2);
		int totalCookies = Integer.parseInt(getText(cookiesValue));	
		System.out.println(totalCookies);
		enterInfo(sellCookiesTxtb,String.valueOf(totalCookies/2));
		click(sellCookiesBtn);	
		Wait(2);
		Assert.assertTrue(Integer.parseInt(getText(cookiesValue)) == (totalCookies/2));			
		log("pass","Cookies Successfully Soldout");
	}
	
	public void buyFactories() {
		
		enterInfo(factoriesToBuyTxtb,"2");
		click(buyFactoriesBtn);	
		Wait(2);
		Assert.assertTrue((Integer.parseInt(getText(factoriesValue)) == 2)) ;
		log("pass","Factories Successfully Generated");
	}
	
	public static GamePageActions getActions() {
		return PageFactory.initElements(WebDriverBase.driver, GamePageActions.class);
	}

}
