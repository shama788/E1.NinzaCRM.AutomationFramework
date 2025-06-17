package ninzaCRM.ObjectRepository;

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

	@FindBy(linkText = "Leads")
	private WebElement leadsLnk;

	@FindBy(linkText = "Contacts")
	private WebElement contactsLnk;

	@FindBy(linkText = "Opportunities")
	private WebElement oppotunitiesLnk;

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

	public WebElement getLeadsLnk() {
		return leadsLnk;
	}

	public WebElement getContactsLnk() {
		return contactsLnk;
	}

	public WebElement getOppotunitiesLnk() {
		return oppotunitiesLnk;
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

	public void clickOnCreateCampaignBtn() {
		createCampaignBtn.click();

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
