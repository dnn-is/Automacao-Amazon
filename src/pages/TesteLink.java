package pages;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core.BasePage;

public class TesteLink extends BasePage {

	@Test
	public void test() throws InterruptedException, IOException {
		openInitialPage("https://www.hyrtutorials.com/");
		List<WebElement> links = driver.findElements(By.tagName("a"));
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

	}
}
