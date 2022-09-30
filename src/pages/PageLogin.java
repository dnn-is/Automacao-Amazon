package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import core.BasePage;

public class PageLogin extends BasePage {
	
	@FindBy (xpath = "//div[@id='nav-tools']//span[@id='nav-link-accountList-nav-line-1']")
	WebElement loginArea;
	
	@FindBy (xpath = "//div[@id='nav-flyout-ya-signin']//span[@class='nav-action-inner']")
	WebElement loginButton;
	
	public void login(String user, String password) {
		openInitialPage(url);
		moveToElement(loginArea);
		click(loginButton);	
	}

}
