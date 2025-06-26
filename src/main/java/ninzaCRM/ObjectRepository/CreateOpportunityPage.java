package ninzaCRM.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ninzaCRM.GenericUtilities.SeleniumUtility;

/**
 * This Class consists of webelements of Create Opportunity Page
 * @author Admin
 */

public class CreateOpportunityPage extends SeleniumUtility{
	
	@FindBy(name = "opportunityName")
	private WebElement opportunityNameTxt;
	
	@FindBy(name = "amount")
	private WebElement amountTxt;
	
	@FindBy(name = "businessType")
	private WebElement businessTypeTxt;
	
	@FindBy(name = "nextStep")
	private WebElement nextStepTxt;
	
	@FindBy(name = "salesStage")
	private WebElement salesStageTxt;
	
	@FindBy(name = "probability")
	private WebElement probabilityTxt;
	
	@FindBy(xpath = "//*[local-name()='svg']/parent::button")
	private WebElement selectLeadBtn;
	
	@FindBy(id = "search-criteria")
	private WebElement selLeadDropDown;
	
	@FindBy(id = "search-input")
	private WebElement searchTxt;
	
	@FindBy(xpath = "//button[.='Create Opportunity']")
	private WebElement createOpportunityBtn;
	
	public CreateOpportunityPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getOpportunityNameTxt() {
		return opportunityNameTxt;
	}

	public WebElement getAmountTxt() {
		return amountTxt;
	}

	public WebElement getBusinessTypeTxt() {
		return businessTypeTxt;
	}

	public WebElement getNextStepTxt() {
		return nextStepTxt;
	}

	public WebElement getSalesStageTxt() {
		return salesStageTxt;
	}

	public WebElement getProbabilityTxt() {
		return probabilityTxt;
	}

	public WebElement getSelectLeadBtn() {
		return selectLeadBtn;
	}

	public WebElement getSelLeadDropDown() {
		return selLeadDropDown;
	}

	public WebElement getSearchTxt() {
		return searchTxt;
	}

	public WebElement getCreateOpportunityBtn() {
		return createOpportunityBtn;
	}
	
	//Bussiness Library
	/**
	 * This method will create opportunity with mandatory fields
	 * @param driver
	 * @param opportunityName
	 * @param amount
	 * @param businessType
	 * @param nextStep
	 * @param salesStage
	 * @param probability
	 * @param leadName
	 * @throws InterruptedException
	 */
	
	public void createOpportunityWithLead(WebDriver driver, String opportunityName, String amount, String businessType, String nextStep,
			String salesStage, String probability, String leadName) throws InterruptedException {
		
		opportunityNameTxt.sendKeys(opportunityName);
		amountTxt.sendKeys(amount);
		businessTypeTxt.sendKeys(businessType);
		nextStepTxt.sendKeys(nextStep);
		salesStageTxt.sendKeys(salesStage);
		probabilityTxt.clear();
		probabilityTxt.sendKeys(probability);
		
		selectLeadBtn.click();
		
		switchToWindow(driver, "Lead");
		Thread.sleep(3000);
		
		handleDropdown("Lead Name", selLeadDropDown);
		searchTxt.sendKeys(leadName);
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//td[.='"+leadName+"']/following-sibling::td/child::button")).click();
		
		Thread.sleep(2000);
		
		switchToWindow(driver, "Ninza");
		Thread.sleep(1000);
		
		createOpportunityBtn.click();

}
}

