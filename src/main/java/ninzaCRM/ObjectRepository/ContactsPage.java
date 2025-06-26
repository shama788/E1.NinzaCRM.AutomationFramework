package ninzaCRM.ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ninzaCRM.GenericUtilities.SeleniumUtility;

/**
 * This class consists of methods related to web element of Contacts Page
 * 
 * @author Admin
 */

public class ContactsPage extends SeleniumUtility{

	@FindBy(xpath = "//span[.='Create Contact']")
	private WebElement createContactBtn;
	
	@FindBy(xpath = "//table[@class='table table-striped table-hover']/tbody/tr[*]/td[2]")
	private List<WebElement> ContactNamesTxt;
	

	@FindBy(xpath = "//select[@class='form-control']")
	private WebElement selDropDown;
	
	@FindBy(xpath = "//input[@placeholder='Search by Contact Name']")
	private WebElement searchTxt;
	
	@FindBy(xpath = "//input[@value='Delete']")
	private WebElement deleteBtn;
	
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateContactBtn() {
		return createContactBtn;
	}

	public List<WebElement> getContactNamesTxt() {
		return ContactNamesTxt;
	}
	
	public WebElement getSelDropDown() {
		return selDropDown;
	}

	public WebElement getSearchTxt() {
		return searchTxt;
	}
	
	public WebElement getDeleteBtn() {
		return deleteBtn;
	}
	

	//Business Library
	
	/**
	 * This method will click on create contact button
	 */
	public void clickOnCreateContactBtn()
	{
		createContactBtn.click();
	}
	
	
	
	
	/**
	 * This method will capture all the contacts names and Compare with required Contact Name
	 * @param RequiredContactName
	 */
	public void captureContactNamesAndCompare(String RequiredContactName)
	{
		for (WebElement element : ContactNamesTxt) {
			 
			String ContactName = element.getText();
			if(ContactName.equals(RequiredContactName))
			{
				System.out.println("Contact Created");
				break;
			}
		}
	}
	
		
		/**
		 * this method will capture Contact and delete
		 * @param driver
		 * @param contactName
		 * @throws InterruptedException
		 */
		
	public void captureContactNameAndDelete(WebDriver driver, String contactName) throws InterruptedException
	{
		
		handleDropdown("Search by Contact Name", selDropDown);
		searchTxt.sendKeys(contactName);
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//td[.='"+contactName+"']/following-sibling::td[*]/child::a[2]")).click();
		
		Thread.sleep(2000);
		
		deleteBtn.click();
		
		
		
		
	}
	
	
	
}
