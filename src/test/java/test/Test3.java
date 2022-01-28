package test;

import org.junit.Test;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


import page.RemoveDataPge;
import page.RemoveDataUsingToggleAllPge;
import util.BrowserFactory;
import util.ExcelReader;

public class Test3 {

	
WebDriver driver;

ExcelReader exlRead = new ExcelReader("src\\main\\java\\data\\TestData.xlsx");

String itemname =exlRead.getCellData("LoginInfo","ItemName", 2);
	
	
	
	@Test

	public void removeAllCheckbox() throws InterruptedException {
		
		driver = BrowserFactory.init();
		
		RemoveDataUsingToggleAllPge RDTPage = PageFactory.initElements(driver, RemoveDataUsingToggleAllPge.class);
		
		RDTPage.addnewItem(itemname);
		RDTPage.clickAddButton();
		RDTPage.addnewItem(itemname);
		RDTPage.clickAddButton();
		Thread.sleep(3000);
		RDTPage.clickToggleALLButtonandValidate();;
		Thread.sleep(3000);
		RDTPage.clickRemoveButton();
		
		
		BrowserFactory.teardown();
	}
}
