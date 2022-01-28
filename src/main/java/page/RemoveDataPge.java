package page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RemoveDataPge extends BasePage {

	
WebDriver driver;
	
	public RemoveDataPge(WebDriver driver) {
		this.driver = driver;
	}
	
	
	@FindBy(how = How.CSS,using = "input[value='Remove']") WebElement remove_button_Element;
	@FindBy(how = How.CSS,using = "input[name='data']") WebElement add_item_Element;
	@FindBy(how = How.CSS,using = "input[value='Add']") WebElement add_Button_Element;
	@FindBy(how = How.CSS,using = "li[style='font-size: 16px']") List<WebElement> all_checkbox_Element;
	@FindBy(how = How.CSS,using = "input[type='checkbox']") WebElement verify_checkbox_Element;
	@FindBy(how = How.XPATH,using = "//div[@id='todos-content']/child::*[@action='todo.php']/child::*[@style][@style]/child::*[1]/child::*[@name]") WebElement single_item_element;
   
	
	String enteredName;
	
	public String getEnteredName() {
		return enteredName;
	}
	
	public void addnewItem(String ItemName) throws InterruptedException {
		enteredName=ItemName+generateRandomNum(999);
		add_item_Element.sendKeys(enteredName);
		Thread.sleep(3000);
	}
	public void clickAddButton() {
		add_Button_Element.click();

	}
	
	public void clickSingleElementCheckbox() {
		List<WebElement> checkboxes = all_checkbox_Element;
		System.out.println("Total no of checkboxes before deleting: "+checkboxes.size());
		int checkb1=checkboxes.size();
		
		
		//select last check box
//		for(int i=checkb1-1;i<checkb1;i++) {
//			 driver.findElement(By.xpath("(//input[@type='checkbox'])[" + (i+1) + "]")).click();
//        }
		
			//select first checkbox
		for(int i=0;i<checkb1;i++)
		{
			if(i<1)
			{
				driver.findElement(By.xpath("(//input[@type='checkbox'])[" + (i+1) + "]")).click();
			}
		}
			
		
		boolean b=single_item_element.isSelected();
		System.out.println("Is checkbox is selected: "+b);
		if(b==true) {
		System.out.println("single item is selected");
		}
		if(!b) {
			System.out.println("single item is not selected");
		}
	}
	
	
	
	
	public void clickRemoveButton() {
		remove_button_Element.click();
		List<WebElement> checkboxes = all_checkbox_Element;
		System.out.println("Total no of checkboxes after deleting "+checkboxes.size());
		System.out.println("Single list item is removed");
	}
	
	
}
