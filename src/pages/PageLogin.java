package pages;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

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

	public void login(String user, String password) throws MalformedURLException, IOException{
		openInitialPage(url);
		
		List<WebElement> links = driver.findElements(By.xpath("//div[@id='navFooter']//a"));
		System.out.println(links.size());

		for (WebElement link : links) {
			String linkURL = link.getAttribute("href");
			URL url = new URL(linkURL);
			URLConnection urlConnection = url.openConnection();
			HttpsURLConnection httpURLConnection = (HttpsURLConnection) urlConnection;
			httpURLConnection.setConnectTimeout(5000);
			httpURLConnection.connect();
			int responseCode = httpURLConnection.getResponseCode();
			if (responseCode == 200) {
				System.out.println(linkURL + " - " + responseCode + " - " + httpURLConnection.getResponseMessage());
			} else {
				System.err.println(linkURL + " - "+httpURLConnection.getResponseMessage());
			}

		}
		moveToElement(loginArea);
		click(loginButton);
	}

}
