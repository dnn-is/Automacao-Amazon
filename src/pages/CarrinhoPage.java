package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core.BasePage;

public class CarrinhoPage extends BasePage {

	public void limparCarrinho() {
		List<WebElement> clearCartItens = driver.findElements(By.xpath("//input[@value='Excluir']"));
		
		
		for (int currentDelete = clearCartItens.size(); currentDelete >= 1; currentDelete--) {
			
			
			try {
				WebElement delete = driver.findElement(By.xpath("(//input[@value='Excluir'])["+currentDelete+"]"));
				waitToBeClickable(delete);
				click(delete);
			}
			catch(org.openqa.selenium.StaleElementReferenceException ex)
			{
				WebElement delete = driver.findElement(By.xpath("(//input[@value='Excluir'])["+currentDelete+"]"));
				waitToBeClickable(delete);
				click(delete);
			}
			
			
		}

	}

}
