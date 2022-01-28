package page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ToggleAllPage extends BasePage {

	
	
WebDriver driver;
	
	public ToggleAllPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how = How.CSS,using = "input[value='on']") WebElement Toggle_All_Element;
	@FindBy(how = How.CSS,using = "input[name='data']") WebElement add_item_Element;
	@FindBy(how = How.CSS,using = "input[value='Add']") WebElement add_Button_Element;
	@FindBy(how = How.CSS,using = "li[style='font-size: 16px']") List<WebElement> all_checkbox_Element;
	@FindBy(how = How.CSS,using = "input[type='checkbox']") WebElement verify_checkbox_Element;
   
	public void clickToggleALLButtonandValidate() {
		boolean a=verify_checkbox_Element.isSelected();
		System.out.println("Is checkbox is selected: "+a);
		Toggle_All_Element.click();
		List<WebElement> checkboxes = all_checkbox_Element;
		System.out.println("Total no of checkboxes " +checkboxes.size());
   
		boolean b=verify_checkbox_Element.isSelected();
		System.out.println("Is checkbox is selected: "+b);
		if(b==true) {
		System.out.println("All check boxes for list items are  CHECKED ON");
		}
		if(!b) {
			System.out.println("All check boxes are not selected");
		}
		
		System.out.println("print all items on list");
		for(int i=0;i<checkboxes.size();i++) {
			System.out.println(checkboxes.get(i).getAttribute("text()"));
		}//check
		
	}
	
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
}
