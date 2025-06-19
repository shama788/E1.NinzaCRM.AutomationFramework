package ninzaCRM.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ninzaCRM.GenericUtilities.SeleniumUtility;

/**
 * This class consists of methods related to web element of Create Contacts Page
 * 
 * @author Admin
 */

public class CreateContactPage extends SeleniumUtility{
	
	@FindBy(name = "organizationName")
	private WebElement organizationNameTxt;

	@FindBy(name = "title")
	private WebElement titleTxt;

	@FindBy(name = "contactName")
	private WebElement contactNameTxt;

	@FindBy(name = "mobile")
	private WebElement mobileTxt;


	@FindBy(xpath = "//*[local-name()='svg']/parent::button")
	private WebElement selectCampaignBtn;

	@FindBy(id = "search-criteria")
	private WebElement selDropDown;

	@FindBy(id = "search-input")
	private WebElement searchTxt;

	@FindBy(xpath = "//button[.='Create Contact']")
	private WebElement createContactBtn;

	public CreateContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrganizationNameTxt() {
		return organizationNameTxt;
	}

	public WebElement getTitleTxt() {
		return titleTxt;
	}

	public WebElement getContactNameTxt() {
		return contactNameTxt;
	}

	public WebElement getMobileTxt() {
		return mobileTxt;
	}

	public WebElement getSelectCampaignBtn() {
		return selectCampaignBtn;
	}

	public WebElement getSelDropDown() {
		return selDropDown;
	}

	public WebElement getSearchTxt() {
		return searchTxt;
	}

	public WebElement getCreateContactBtn() {
		return createContactBtn;
	}

	// Business library
		/**
		 * This method will create contact with mandatory fields
		 * @param driver
		 * @param organizationName
		 * @param title
		 * @param contactName
		 * @param mobile
		 * @param campaignname
		 * @throws InterruptedException
		 */
		public void createContactWithCampaign(WebDriver driver, String organizationName, String title , String contactName, String mobile,
				String campaignname) throws InterruptedException {
			
			organizationNameTxt.sendKeys(organizationName);
			titleTxt.sendKeys(title);
			contactNameTxt.sendKeys(contactName);
			mobileTxt.sendKeys(mobile);
			selectCampaignBtn.click();
			
			switchToWindow(driver, "Campaign");
			Thread.sleep(3000);
			
			handleDropdown("Campaign Name", selDropDown);
			searchTxt.sendKeys(campaignname);
			
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//td[.='"+campaignname+"']/following-sibling::td/child::button")).click();
			
			Thread.sleep(2000);
			
			switchToWindow(driver, "Ninza");
			Thread.sleep(1000);
			
			createContactBtn.click();
			
		
		
		}

	

}
