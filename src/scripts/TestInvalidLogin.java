package scripts;

import org.testng.annotations.Test;

import generics.BaseTest;
import generics.Lib;
import pompages.LoginPage;
public class TestInvalidLogin extends BaseTest{
	@Test
	public void testLoginInvalid(){
		LoginPage lp = new LoginPage(driver);
		int rowcount = Lib.getRowCount("InvalidLogin");
		for (int i = 1; i < rowcount; i++) {			
		String username = Lib.getCellValue("InvalidLogin", i, 0);
		lp.setUsername(username);
		String password = Lib.getCellValue("InvalidLogin", i, 1);
		lp.setPassword(password);
		lp.clickLogin();
		}
		
	}
}
