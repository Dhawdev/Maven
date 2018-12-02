package generics;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hpsf.Date;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
public class Lib implements IAutoConstant{
	public static Workbook wb;	
	
	public static String getCellValue(String SheetName, int RowNum, int ColNum){
		String cellValue="";
		try {
			wb = WorkbookFactory.create(new FileInputStream(EXCEL_PATH));
			cellValue  = wb.getSheet(SheetName).getRow(RowNum).getCell(ColNum).toString();
		} catch (Exception e) {
		}		
		return cellValue;
	}
	public static String getPropertyValue(String prop){
		String propertyValue="";
		Properties p = new Properties();
		try {
			p.load(new FileInputStream(CONFIG_PATH));
			propertyValue = p.getProperty(prop);		
		} catch (Exception e) {			
	}
		return propertyValue;
	}
	public static void captureScreenshots(WebDriver driver, String testMethodName){
		try {
			Date d = new Date();
			String d1 = d.toString();
			String currentDateAndTime = d1.replaceAll(":", "_");
	TakesScreenshot ts = (TakesScreenshot)driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	File dest = new File(SCREENSHOT_PATH+testMethodName+currentDateAndTime+".png");
	FileUtils.copyFile(src, dest);
	} catch (Exception e) {
	}	
	}
	public static int getRowCount(String sheet){
		int rowCount=0;
		try {
			wb = WorkbookFactory.create(new FileInputStream(EXCEL_PATH));
			rowCount = wb.getSheet(sheet).getLastRowNum();
		} catch (Exception e) {
		}
		
		return rowCount;
	}
}