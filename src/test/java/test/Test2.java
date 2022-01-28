package test;

import org.junit.Test;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


import page.RemoveDataPge;
import util.BrowserFactory;
import util.ExcelReader;

public class Test2 {

	
WebDriver driver;

ExcelReader exlRead = new ExcelReader("src\\main\\java\\data\\TestData.xlsx");

String itemname =exlRead.getCellData("LoginInfo","ItemName", 2);
	
	
	
	@Test

	public void removeSingleCheckbox() throws InterruptedException {
		
		driver = BrowserFactory.init();
		
		RemoveDataPge RDPage = PageFactory.initElements(driver, RemoveDataPge .class);
		
		RDPage.addnewItem(itemname);
		RDPage.clickAddButton();
		RDPage.addnewItem(itemname);
		RDPage.clickAddButton();
		RDPage.clickSingleElementCheckbox();
		Thread.sleep(3000);
		RDPage.clickRemoveButton();
		
		BrowserFactory.teardown();
	}
}
