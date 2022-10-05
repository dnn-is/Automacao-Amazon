package pages;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import core.BasePage;

public class OfertasDoDiaPage extends BasePage {

	@FindBy(xpath = "//a[@data-csa-c-content-id='nav_cs_gb']")
	WebElement ofertasDoDia;
	
	@FindBy(xpath = "//li[@class='a-last']")
	WebElement visibleElement;

	public void verificarLinksDosItens() throws MalformedURLException, IOException {
		click(ofertasDoDia);
		waitToBeVisible(visibleElement);
		List<WebElement> linksOfertasDoDia = driver.findElements(By.xpath(
				"//div[@data-testid='grid-deals-container']//div[@class='DealGridItem-module__dealItemDisplayGrid_e7RQVFWSOrwXBX4i24Tqg DealGridItem-module__withBorders_2jNNLI6U1oDls7Ten3Dttl DealGridItem-module__withoutActionButton_2OI8DAanWNRCagYDL2iIqN']//a"));
		System.out.println(linksOfertasDoDia.size());
		for (WebElement link : linksOfertasDoDia) {
			testBrokenLink(link);
		}
	}

}
