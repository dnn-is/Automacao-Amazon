package pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import core.BasePage;

public class CarrinhoPage extends BasePage {

	@FindBy(xpath = "//a[@class='nav-a nav-a-2 nav-progressive-attribute']")
	WebElement cart;

	@FindBy(xpath = "//input[@name='proceedToRetailCheckout']")
	WebElement closeOrder;

	@FindBy(xpath = "//span[@id='address-ui-widgets-countryCode']")
	WebElement countries;

	@FindBy(xpath = "//a[@data-value='BR']")
	WebElement currentCountry;

	@FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressFullName']")
	WebElement nameField;

	@FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressPhoneNumber']")
	WebElement cellField;

	@FindBy(xpath = "//input[@id='address-ui-widgets-buildingNumber']")
	WebElement houseNumberField;

	@FindBy(xpath = "//input[@id='address-ui-widgets-neighborhood']")
	WebElement neighborhoodField;

	@FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressPostalCode']")
	WebElement postalCodeField;

	@FindBy(xpath = "//input[@id='address-ui-widgets-complement']")
	WebElement complementField;

	@FindBy(xpath = "//input[@id='address-ui-widgets-streetName']")
	WebElement addressField;

	@FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressCity']")
	WebElement cityField;

	@FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressStateOrRegion']")
	WebElement stateField;
	
	@FindBy(xpath = "//span[@id='address-ui-widgets-form-submit-button']")
	WebElement useThisAddress;
	
	@FindBy(xpath ="//input[@id='taxid-field']")
	WebElement cpfField;

	public void limparCarrinho() {
		List<WebElement> clearCartItens = driver.findElements(By.xpath("//input[@value='Excluir']"));

		for (int currentDelete = clearCartItens.size(); currentDelete >= 1; currentDelete--) {

			try {
				WebElement delete = driver.findElement(By.xpath("(//input[@value='Excluir'])[" + currentDelete + "]"));
				waitToBeClickable(delete);
				click(delete);
			} catch (StaleElementReferenceException ex) {
				WebElement delete = driver.findElement(By.xpath("(//input[@value='Excluir'])[" + currentDelete + "]"));
				waitToBeClickable(delete);
				click(delete);
			}

		}

	}

	public void finalizarCompras() throws InterruptedException {
		click(cart);
		click(closeOrder);
		click(countries);
		click(currentCountry);
		
		nameField.clear();

		sendKeys(postalCodeField, postalCode);
		sendKeys(nameField, name);
		sendKeys(cellField, cellNumber);
		
		wait.until(ExpectedConditions.attributeToBeNotEmpty(addressField, "value"));
		
		sendKeys(houseNumberField, houseNumber);
		sendKeys(complementField, complement);

		Assert.assertEquals(streetName, addressField.getAttribute("value"));
		Assert.assertEquals(houseNumber, houseNumberField.getAttribute("value"));
		Assert.assertEquals(neighborhood, neighborhoodField.getAttribute("value"));
		Assert.assertEquals(city, cityField.getAttribute("value"));
		Assert.assertEquals(state, stateField.getAttribute("value"));
		click(useThisAddress);
		
		
		

	}

}