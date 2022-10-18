package test;

import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.Test;

import core.BasePage;
import pages.CarrinhoPage;
import pages.OfertasDoDiaPage;
import pages.PageLogin;

public class TestPage extends BasePage {
	
	PageLogin login = new PageLogin();
	OfertasDoDiaPage ofertasDoDia = new OfertasDoDiaPage();
	CarrinhoPage carrinho = new CarrinhoPage();
	
	@Test
	public void test() throws MalformedURLException, IOException, InterruptedException{
		login.login(user,password);
//		ofertasDoDia.adicionarAoCarrinho();
		carrinho.finalizarCompras();
		driver.quit();
	}

}
