package test;

import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.Test;

import core.BasePage;
import pages.OfertasDoDiaPage;
import pages.PageLogin;

public class TestPage extends BasePage {
	
	PageLogin login = new PageLogin();
	OfertasDoDiaPage ofertasDoDia = new OfertasDoDiaPage();
	
	@Test
	public void test() throws MalformedURLException, IOException{
		login.login(user,password);
		ofertasDoDia.verificarLinksDosItens();
		driver.quit();
	}

}
