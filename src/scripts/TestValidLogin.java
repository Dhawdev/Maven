package scripts;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import generics.BaseTest;
import generics.Lib;
import pompages.LoginPage;

public class TestValidLogin extends BaseTest{
	@Test
	public void testValidLogin(){
	LoginPage lp = new LoginPage(driver);
	String username = Lib.getCellValue("ValidLogin",1,0);
	lp.setUsername(username);
	
	String password = Lib.getCellValue("ValidLogin",1,1);
	lp.setPassword(password);
	lp.clickLogin();
	
	WebDriverWait wait = new WebDriverWait(driver, 12);
	wait.until(ExpectedConditions.titleIs("actiTIME - Login"));
	String actual_title = driver.getTitle();
	Assert.assertEquals(actual_title, "actiTIME - Login");
	
	
	
	
	
	}
	
}
