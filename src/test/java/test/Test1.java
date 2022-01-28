package test;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import page.ToggleAllPage;
import util.BrowserFactory;
import util.ExcelReader;

public class Test1 {

	
WebDriver driver;

ExcelReader exlRead = new ExcelReader("src\\main\\java\\data\\TestData.xlsx");

String itemname =exlRead.getCellData("LoginInfo","ItemName", 2);
		
	
	
	
	@Test
	public void validateToglleAllCheckbox() throws InterruptedException {
		
		driver = BrowserFactory.init();
		
		ToggleAllPage toggle = PageFactory.initElements(driver, ToggleAllPage .class);
		
		
		toggle.addnewItem(itemname);
		toggle.clickAddButton();
		toggle.addnewItem(itemname);
		toggle.clickAddButton();
		Thread.sleep(3000);
		toggle.clickToggleALLButtonandValidate();;
		Thread.sleep(3000);
		
		
		BrowserFactory.teardown();
		
	}
}
