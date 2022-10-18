package pages;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import core.BasePage;

public class PageLogin extends BasePage {

	@FindBy(xpath = "//div[@id='nav-tools']//span[@id='nav-link-accountList-nav-line-1']")
	WebElement loginArea;

	@FindBy(xpath = "//div[@id='nav-flyout-ya-signin']//span[@class='nav-action-inner']")
	WebElement loginButton;

	@FindBy(xpath = "//div[@id='navFooter']")
	WebElement footerArea;

	@FindBy(xpath = "//input[@type='email']")
	WebElement emailArea;

	@FindBy(xpath = "//input[@id='continue']")
	WebElement continueButton;

	@FindBy(xpath = "//input[@type='password']")
	WebElement passwordArea;

	@FindBy(xpath = "//input[@id='signInSubmit']")
	WebElement enter;

	@FindBy(xpath = "//div[@class='nav-line-1-container']//span[@id='nav-link-accountList-nav-line-1']")
	WebElement presentationArea;

	@FindBy(xpath = "//span[@id='nav-cart-count']")
	WebElement cartQuantity;

	@FindBy(xpath = "//a[@class='nav-a nav-a-2 nav-progressive-attribute']")
	WebElement cart;

	CarrinhoPage carrinho = new CarrinhoPage();

	public void login(String user, String password) throws MalformedURLException, IOException {
		openInitialPage(url);

//		List<WebElement> links = footerArea.findElements(By.xpath("//div[@id='navFooter']//a"));
//		System.out.println(links.size());
//
//		for (WebElement link : links) {
//			testBrokenLink(link);
//		}

		moveToElement(loginArea);
		click(loginButton);
		sendKeys(emailArea, user);
		click(continueButton);
		sendKeys(passwordArea, password);
		click(enter);
		Assert.assertEquals("Olá, Dennis", presentationArea.getText());
		int cartNumber = Integer.parseInt(cartQuantity.getText());

//		if (cartNumber > 0) {
//			click(cart);
//			carrinho.limparCarrinho();
//		}

	}

}
