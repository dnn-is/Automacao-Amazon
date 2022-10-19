package pages;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.junit.Assert;
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

	@FindBy(xpath = "//label[.='Alimentos e Bebidas']//input")
	WebElement foodAndBeverages;

	@FindBy(xpath = "//label[.='Bebidas Alcoólicas']//input")
	WebElement alcoholicBeverages;

	@FindBy(xpath = "//div[@class='a-accordion-row-a11y']")
	WebElement specialCondition;

	@FindBy(xpath = "//i[@class='a-icon a-accordion-radio a-icon-radio-inactive']")
	WebElement specialOffer;

	@FindBy(xpath = "//div[@id='promotionTitle']")
	WebElement promotionTitle;

	@FindBy(xpath = "//img[@src='https://images-na.ssl-images-amazon.com/images/G/32/error/pt_BR/title._TTD_.png']")
	WebElement invalidPage;

	@FindBy(xpath = "//img[@id='b']")
	WebElement home;

	public void adicionarAoCarrinho() throws MalformedURLException, IOException, InterruptedException {
		click(ofertasDoDia);
//		List<WebElement> linksOfertasDoDia = driver.findElements(By.xpath(
//				"//div[@data-testid='grid-deals-container']//div[@class='DealGridItem-module__dealItemDisplayGrid_e7RQVFWSOrwXBX4i24Tqg DealGridItem-module__withBorders_2jNNLI6U1oDls7Ten3Dttl DealGridItem-module__withoutActionButton_2OI8DAanWNRCagYDL2iIqN']//a"));
//		System.out.println(linksOfertasDoDia.size());
//		for (WebElement link : linksOfertasDoDia) {
//			testBrokenLink(link);
//		}
		click(alimentosEBebidas);
		waitToBeVisible(primeiroItem);
		Assert.assertTrue(foodAndBeverages.isSelected());
		Assert.assertTrue(alcoholicBeverages.isSelected());

		List<WebElement> descontosDoDia = driver
				.findElements(By.xpath("//div[@class='DealContent-module__truncate_sWbxETx42ZPStTc9jwySW']"));

		for (int produtoAtual = 1; produtoAtual <= descontosDoDia.size(); produtoAtual++) {
			Thread.sleep(1500);
			WebElement produto = driver.findElement(By.xpath(
					"(//div[@class='DealContent-module__truncate_sWbxETx42ZPStTc9jwySW'])[" + produtoAtual + "]"));
			click(produto);
			

			if (isElementVisible(specialCondition)) {
				if (!isElementVisible(adicionarAoCarrinho)) {
					click(ofertasDoDia);
					click(alimentosEBebidas);
					continue;
				}
				click(specialOffer);
				if (isElementVisible(dropdownQuantidade)) {
					Select dropdown = new Select(dropdownQuantidade);
					dropdown.selectByValue(quantity);
				}
				click(adicionarAoCarrinho);
				click(ofertasDoDia);
				click(alimentosEBebidas);
			} else if (isElementVisible(promotionTitle)) {
				click(ofertasDoDia);
				click(alimentosEBebidas);
			} else if (isElementVisible(invalidPage)) {
				click(home);
				click(ofertasDoDia);
				click(alimentosEBebidas);
				continue;

			} else {
				if (!isElementVisible(adicionarAoCarrinho)) {
					click(ofertasDoDia);
					click(alimentosEBebidas);
					continue;

				}
				if (isElementVisible(dropdownQuantidade)) {
					Select dropdown = new Select(dropdownQuantidade);
					dropdown.selectByValue(quantity);
				}
				click(adicionarAoCarrinho);
				click(ofertasDoDia);
				click(alimentosEBebidas);
			}

		}

	}
}
