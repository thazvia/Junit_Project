package test;


import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import page.RemoveDataPge;
import page.RemoveDataUsingToggleAllPge;
import page.ToggleAllPage;
import util.BrowserFactory;
import util.ExcelReader;

public class All_Tests {

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
