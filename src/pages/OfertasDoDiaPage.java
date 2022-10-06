package pages;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import core.BasePage;

public class OfertasDoDiaPage extends BasePage {

	@FindBy(xpath = "//a[@data-csa-c-content-id='nav_cs_gb']")
	WebElement ofertasDoDia;

	@FindBy(xpath = "//li[@class='a-last']")
	WebElement visibleElement;

	@FindBy(xpath = "//a[@data-id='4FCC8AEA6088473DD6F80CEC0182BD9E']")
	WebElement alimentosEBebidas;

	@FindBy(xpath = "(//div[@class='DealContent-module__truncate_sWbxETx42ZPStTc9jwySW'])[1]")
	WebElement primeiroItem;

	@FindBy(xpath = "//select[@id='quantity']")
	WebElement dropdownQuantidade;

	@FindBy(xpath = "//input[@id='add-to-cart-button']")
	WebElement adicionarAoCarrinho;

	public void verificarLinksDosItens() throws MalformedURLException, IOException {
		click(ofertasDoDia);
//		List<WebElement> linksOfertasDoDia = driver.findElements(By.xpath(
//				"//div[@data-testid='grid-deals-container']//div[@class='DealGridItem-module__dealItemDisplayGrid_e7RQVFWSOrwXBX4i24Tqg DealGridItem-module__withBorders_2jNNLI6U1oDls7Ten3Dttl DealGridItem-module__withoutActionButton_2OI8DAanWNRCagYDL2iIqN']//a"));
//		System.out.println(linksOfertasDoDia.size());
//		for (WebElement link : linksOfertasDoDia) {
//			testBrokenLink(link);
//		}
		click(alimentosEBebidas);
		waitToBeVisible(primeiroItem);
		List<WebElement> produtosDoDia = driver.findElements(By.xpath(
				"//div[@class='Grid-module__gridDisplayGrid_2X7cDTY7pjoTwwvSRQbt9Y']//div[@class='a-image-container a-dynamic-image-container aok-align-center-horizontally DealImage-module__image_1aM-S1pMSsajamWgCRXa6y DealImage-module__imageAspectRatioFix_DJdrM5BSpMhSiPB6czCA4']"));

		int intervalo = produtosDoDia.size();

		int produtoAtual = 1;
		while (produtoAtual <= intervalo) {
			WebElement produto = driver.findElement(By.xpath(
					"(//div[@class='Grid-module__gridDisplayGrid_2X7cDTY7pjoTwwvSRQbt9Y']//div[@class='a-image-container a-dynamic-image-container aok-align-center-horizontally DealImage-module__image_1aM-S1pMSsajamWgCRXa6y DealImage-module__imageAspectRatioFix_DJdrM5BSpMhSiPB6czCA4'])["
							+ produtoAtual + "]"));
			waitToBeClickable(produto);
			click(produto);
			Select dropdown = new Select(dropdownQuantidade);
			dropdown.selectByValue(quantity);
			click(adicionarAoCarrinho);
			click(ofertasDoDia);
			click(alimentosEBebidas);
			produtoAtual++;
		}

	}

}
