package test;

import org.junit.Test;

import core.BasePage;
import pages.PageLogin;

public class TestPage extends BasePage {
	
	PageLogin login = new PageLogin();
	
	@Test
	public void test() {
		login.login(user,password);
	}

}
