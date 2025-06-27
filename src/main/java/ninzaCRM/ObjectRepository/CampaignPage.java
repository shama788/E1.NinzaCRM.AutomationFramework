package ninzaCRM.ObjectRepository;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ninzaCRM.GenericUtilities.SeleniumUtility;

/**
 * This class consists of methods related to web element of Campaign Page
 * 
 * @author Admin
 */

public class CampaignPage extends SeleniumUtility{
	
	@FindBy(xpath = "//span[.='Create Campaign']")
	private WebElement createCampaignBtn;
	
	@FindBy(linkText = "Campaigns")
	private WebElement campaignsLnk;

	@FindBy(linkText = "Leads")
	private WebElement leadsLnk;

	@FindBy(linkText = "Contacts")
	private WebElement contactsLnk; 

	@FindBy(linkText = "Opportunities")
	private WebElement oppotunitiesLnk;
	
	@FindBy(linkText = "Products")
	private WebElement productsLnk;
	
	@FindBy(linkText = "Quotes")
	private WebElement quotesLnk;
	
	@FindBy(linkText = "Purchase Order")
	private WebElement purchaseOrderLnk;
	
	@FindBy(linkText = "Sales Order")
	private WebElement salesOrderLnk;
	
	@FindBy(xpath = "//select[@class='form-control']")
	private WebElement selDropDown;
	
	@FindBy(xpath = "//input[@placeholder='Search by Campaign Name']")
	private WebElement searchTxt;
	
	@FindBy(xpath = "//input[@value='Delete']")
	private WebElement deleteBtn;
	
	@FindBy(xpath = "//table[@class='table table-striped table-hover']/tbody/tr[*]/td[2]")
	private List<WebElement> CampaignNamesTxt;

	@FindBy(xpath = "//div[@class='user-icon']")
	private WebElement userIcon;

	@FindBy(xpath = "//div[@class='dropdown-item logout']")
	private WebElement logoutLnk;

	public CampaignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateCampaignBtn() {
		return createCampaignBtn;
	}
	
	public WebElement getCampaignLnk() {
		return campaignsLnk;
	}

	public WebElement getLeadsLnk() {
		return leadsLnk;
	}

	public WebElement getContactsLnk() {
		return contactsLnk;
	}

	public WebElement getOppotunitiesLnk() {
		return oppotunitiesLnk;
	}

	public WebElement getProductsLnk() {
		return productsLnk;
	}
	
	public WebElement getQuotesLnk() {
		return quotesLnk;
	}
	
	public WebElement getPurchaseOrderLnk() {
		return purchaseOrderLnk;
	}
	
	public WebElement getSelDropDown() {
		return selDropDown;
	}
	
	public WebElement getDeleteBtn() {
		return deleteBtn;
	}
	
	public WebElement getSearchTxt() {
		return searchTxt;
	}
	
	public List<WebElement> getCampaignNamesTxt() {
		return CampaignNamesTxt;
	}
	
	public WebElement getuserIcon() {
		return userIcon;
	}

	public WebElement getlogoutLnk() {
		return logoutLnk;
	}

	// Business Library

	/**
	 * This method will click on create campaign button
	 * 
	 */

	public void clickOnCreateCampaignBtn(WebDriver driver) {
		addExplicitWait(driver, createCampaignBtn);
		createCampaignBtn.click();
		addExplicitWait(driver, createCampaignBtn);

	}
	
	

	/**
	 * This method will click on campaign link
	 * 
	 */
	public void clickOnCampaignsLnk() {
		campaignsLnk.click();
	}

	/**
	 * This method will click on leads link
	 * 
	 */
	public void clickOnLeadsLnk() {
		leadsLnk.click();
	}

	/**
	 * This method will click on contacts link
	 * 
	 */
	public void clickOnContactsLnk() {
		contactsLnk.click();

	}

	/**
	 * This method will click on opportunities link
	 * 
	 */
	public void clickOnOppotunitiesLnk() {
		oppotunitiesLnk.click();
	}

	/**
	 * This method will click on products link
	 * 
	 */
	public void clickOnProductsLnk() {
		productsLnk.click();
	}
	
	/**
	 * This method will click on quotes link
	 * 
	 */
	public void clickOnQuotesLnk() {
		quotesLnk.click();
	}
	
	/**
	 * This method will click on purchase order link
	 * 
	 */
	public void clickOnPurchaseOrderLnk() {
		purchaseOrderLnk.click();
	}
	
	/**
	 * This method will click on Sales order link
	 * 
	 */
	public void clickOnSalesOrderLnk() {
		salesOrderLnk.click();
	}
	
	/**
	 * this method will capture Campaign and delete
	 * @param driver
	 * @param campaignName
	 * @throws InterruptedException
	 */
	
	public void captureCampaignNameAndDelete(WebDriver driver, String campaignName) throws InterruptedException
	{
		
		handleDropdown("Search by Campaign Name", selDropDown);
		searchTxt.sendKeys(campaignName);
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//td[.='"+campaignName+"']/following-sibling::td[*]/child::a[2]")).click();
		
		Thread.sleep(2000);
		
		deleteBtn.click();
		
		
		
		
	}
	
	
	/**
	 * this method will check campaign name sucessfully deleted
	 * @param RequiredCampaignName
	 */
	public void captureCampaignNamesAndCompare(String RequiredCampaignName)
	{
		for (WebElement element : CampaignNamesTxt) {
			 
			String CampaignName = element.getText();
			if(CampaignName.equals(RequiredCampaignName))
			{
				System.out.println("Camapign not deleted");
				break;
			}
			else
				System.out.println("Camapign Name sucessfully deleted ");
		}

	}
	
	
	/**
	 * This method will logout of Application
	 * @param driver
	 * @throws InterruptedException
	 */
	public void logoutOfApp(WebDriver driver) throws InterruptedException
	{
		mouseOverAction(driver, userIcon);
		Thread.sleep(4000);
		logoutLnk.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
