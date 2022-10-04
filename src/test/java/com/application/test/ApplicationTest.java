package com.application.test;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.application.pageactions.GamePageActions;
import com.application.pageactions.MainPageActions;
import com.framework.utils.ReadExcel;
import com.framework.webdriver.WebDriverBase;

public class ApplicationTest extends WebDriverBase {
	
	MainPageActions mainpage ;
	GamePageActions gamepage ;
	
	@Test(priority=1)
	public void startTheGame(){
		mainpage = MainPageActions.getActions();
		mainpage.startTheGame();
	}
	
	@Test(priority=2)
	public void verifyNewUser(){
		mainpage = MainPageActions.getActions();
		mainpage.verifyNewUserDetailsInApplication();
	}
	
	@Test(priority=3)
	public void generateCookies(){
		mainpage = MainPageActions.getActions();
		gamepage = GamePageActions.getActions();
		mainpage.navigateToUserGamePage();
		gamepage.generateCookies();
	}
	
	@Test(priority=4)
	public void sellAllCookies(){
		mainpage = MainPageActions.getActions();
		gamepage = GamePageActions.getActions();
		mainpage.navigateToUserGamePage();
		gamepage.sellAllCookies();
	}
	
	@Test(priority=5)
	public void sellHalfOfTheCookies(){
		mainpage = MainPageActions.getActions();
		gamepage = GamePageActions.getActions();
		mainpage.navigateToUserGamePage();
		gamepage.sellHalfOfTheCookies();
	}
	
	@Test(priority=6)
	public void buyFactories(){
		mainpage = MainPageActions.getActions();
		gamepage = GamePageActions.getActions();		
		mainpage.navigateToUserGamePage();		
		gamepage.buyFactories();
	}

}
