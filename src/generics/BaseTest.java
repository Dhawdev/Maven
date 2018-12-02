package generics;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
public class BaseTest implements IAutoConstant {
	
	public WebDriver driver;
	
	static {
		//System.setProperty("webdriver.gecko.driver","./drivers/geckodriver.exe");
		System.setProperty(GECKO_KEY, GECKO_PATH);
		System.setProperty(CHROME_KEY, CHROME_PATH);
	}
	
	@BeforeMethod
	public void openApp() {
		driver = new FirefoxDriver();
		driver.get(Lib.getPropertyValue("URL"));
		String imp = Lib.getPropertyValue("ImplicitTimeout");
		driver.manage().timeouts().implicitlyWait(Long.parseLong(imp), TimeUnit.SECONDS);
	}
	@AfterMethod
	public void closeApp(ITestResult res) {
		if(ITestResult.FAILURE==res.getStatus()){
			Lib.captureScreenshots(driver, res.getName());
		}
		driver.close();
	}
}
