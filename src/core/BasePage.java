package core;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import javax.net.ssl.HttpsURLConnection;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class BasePage extends DriverFactory implements Atributes {

	public static WebDriver driver = inicializaDriverFactory();
	WebDriverWait wait = new WebDriverWait(driver, 5);
	Actions action = new Actions(driver);

	public BasePage() {

		PageFactory.initElements(driver, this);
	}

	public void click(WebElement element) {

		try {
			wait.until(ExpectedConditions.elementToBeClickable(element)).click();
		} catch (Exception e) {
			wait.until(ExpectedConditions.visibilityOf(element)).click();
		}
	}

	public void openInitialPage(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	public boolean isElementVisible(WebElement element) {
		try {
			
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public void sendKeys(WebElement element, String text) {

		try {
			wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(text);
		} catch (Exception e) {
			wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
		}
	}

	public String getText(WebElement element) {

		wait.until(ExpectedConditions.visibilityOf(element)).getText();
		return element.getText();
	}

	public void waitToBeClickable(WebElement element) {

		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitToBeVisible(WebElement element) {

		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void alternarAbas(int index) {

		List<String> abas = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(abas.get(index));
	}

	public void moveToElement(WebElement element) {
		waitToBeVisible(element);
		action.moveToElement(element).build().perform();
	}

	public void testBrokenLink(WebElement link) throws MalformedURLException, IOException {
//		SoftAssert softAssert = new SoftAssert();
		String linkURL = link.getAttribute("href");
		URL url = new URL(linkURL);
		URLConnection urlConnection = url.openConnection();
		HttpsURLConnection httpURLConnection = (HttpsURLConnection) urlConnection;
		httpURLConnection.setConnectTimeout(10000);
		httpURLConnection.connect();
		int responseCode = httpURLConnection.getResponseCode();
		if (responseCode == 200) {
			System.out.println(linkURL + " - " + responseCode + " - " + httpURLConnection.getResponseMessage());
		} else {
			System.err.println(linkURL + " - " + responseCode + " - " + httpURLConnection.getResponseMessage());
		}
//		softAssert.assertTrue(responseCode<400, "Text with the broken link is: " + link.getText() + " | Response code: " + responseCode);

	}

}
