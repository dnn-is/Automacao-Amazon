package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import core.BasePage;

public class PageLogin extends BasePage {
	
	@FindBy (xpath = "//div[@id='nav-tools']//a[@id='nav-link-accountList']")
	WebElement loginArea;
	
	public void login(String user, String password) {
		openInitialPage(url);
		moveToElement(loginArea);
		
	}

}
