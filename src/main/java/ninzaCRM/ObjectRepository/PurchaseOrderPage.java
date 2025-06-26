package ninzaCRM.ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class consist of web element of Purchase Order Page
 */

public class PurchaseOrderPage {
	
	@FindBy(xpath = "//span[.='Create Order']")
	private WebElement createOrderBtn;
	
	@FindBy(xpath = "//table[@class='table table-striped table-hover']/tbody/tr[*]/td[2]")
	private List<WebElement> subjectNamesTxt;
	
	public PurchaseOrderPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateOrderBtn() {
		return createOrderBtn;
	}

	public List<WebElement> getSubjectNamesTxt() {
		return subjectNamesTxt;
	}
	
	 //Business Library
	
		/**
		 * This method will click on order button
		 */
		public void clickOnCreateOrderBtn()
		{
			createOrderBtn.click();
		}
		
		/**
		 * This method will capture all the subject names and Compare with required subject Name
		 * @param requiredSubjectName
		 */
		public void captureSubjectNamesAndCompare(String requiredSubjectName)
		{
			for (WebElement element : subjectNamesTxt) {
				 
				String subjectName = element.getText();
				if(subjectName.equals(requiredSubjectName))
				{
					System.out.println("Opportunity Created");
					break;
				}
			}
		}
		

}
