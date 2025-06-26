package ninzaCRM.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ninzaCRM.GenericUtilities.SeleniumUtility;

/**
 * This class consist of web element of create purchase order page
 * @author Admin
 */

public class CreatePurchaseOrderPage extends SeleniumUtility{
	
	@FindBy(name = "subject")
	private WebElement subjectTxt;
	
	@FindBy(name = "dueDate")
	private WebElement dueDateTxt;
	
	@FindBy(xpath = "(//*[local-name()='svg']/parent::button)[1]")
	private WebElement selectContactBtn;
	

	@FindBy(id = "search-criteria")
	private WebElement selContactNameDropDown;

	@FindBy(id = "search-input")
	private WebElement searchContactNameTxt;
	
	@FindBy(xpath = "(//textarea[@name='address'])[1]")
	private WebElement billingAddressTxtArea;
	
	@FindBy(xpath = "(//textarea[@name='address'])[2]")
	private WebElement shippingAddressTxtArea;
	
	@FindBy(xpath = "(//input[@name='poBox'])[1]")
	private WebElement billingPoBoxTxt;
	
	@FindBy(xpath = "(//input[@name='poBox'])[2]")
	private WebElement shippingPoBoxTxt;
	
	@FindBy(xpath = "(//input[@name='city'])[1]")
	private WebElement billingCityTxt;
	
	@FindBy(xpath = "(//input[@name='city'])[2]")
	private WebElement cityTxt;
	
	@FindBy(xpath = "(//input[@name='state'])[1]")
	private WebElement billingStateTxt;
	
	@FindBy(xpath = "(//input[@name='state'])[2]")
	private WebElement stateTxt;
	
	@FindBy(xpath = "(//input[@name='postalCode'])[1]")
	private WebElement billingPostalCodeTxt;
	
	@FindBy(xpath = "(//input[@name='postalCode'])[2]")
	private WebElement postalCodeTxt;
	
	@FindBy(xpath = "(//input[@name='country'])[1]")
	private WebElement billingCountryTxt;
	
	@FindBy(xpath = "(//input[@name='country'])[2]")
	private WebElement countryTxt;
	
	@FindBy(xpath = "(//*[local-name()='svg']/parent::button)[2]")
	private WebElement selectProductBtn;
	
	@FindBy(id = "search-criteria")
	private WebElement selProductNameDropDown;
	
	@FindBy(id = "search-input")
	private WebElement searchByProductNameTxt;
	

	@FindBy(xpath = "//button[.='Create Purchase Order']")
	private WebElement createPurchaseOrderBtn;

	public CreatePurchaseOrderPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getSubjectTxt() {
		return subjectTxt;
	}

	public WebElement getDueDateWidjet() {
		return dueDateTxt;
	}

	public WebElement getSelectContactBtn() {
		return selectContactBtn;
	}

	public WebElement getSelContactNameDropDown() {
		return selContactNameDropDown;
	}

	public WebElement getSearchContactNameTxt() {
		return searchContactNameTxt;
	}

	public WebElement getBillingAddressTxtArea() {
		return billingAddressTxtArea;
	}

	public WebElement getShippingAddressTxtArea() {
		return shippingAddressTxtArea;
	}

	public WebElement getBillingPoBoxTxt() {
		return billingPoBoxTxt;
	}

	public WebElement getShippingPoBoxTxt() {
		return shippingPoBoxTxt;
	}

	public WebElement getBillingCityTxt() {
		return billingCityTxt;
	}

	public WebElement getCityTxt() {
		return cityTxt;
	}

	public WebElement getBillingStateTxt() {
		return billingStateTxt;
	}

	public WebElement getStateTxt() {
		return stateTxt;
	}

	public WebElement getBillingPostalCodeTxt() {
		return billingPostalCodeTxt;
	}

	public WebElement getPostalCodeTxt() {
		return postalCodeTxt;
	}

	public WebElement getBillingCountryTxt() {
		return billingCountryTxt;
	}

	public WebElement getCountryTxt() {
		return countryTxt;
	}

	public WebElement getSelectProductBtn() {
		return selectProductBtn;
	}

	public WebElement getSelProductNameDropDown() {
		return selProductNameDropDown;
	}

	public WebElement getSearchByProductNameTxt() {
		return searchByProductNameTxt;
	}

	public WebElement getCreatePurchaseOrderBtn() {
		return createPurchaseOrderBtn;
	}
	
	//Bussiness Library
	
	public void createPurchaseOrderWithContactAndProduct(WebDriver driver, String subjectName, String dueDate, String billingAddress, String billingPoBox, String billingCity, String billingState, String billingPostalCode, String billingcountry, String shippingAddress,
			String shippingPoBox, String city, String State, String postalCode, String country, String contactName, String productName ) throws InterruptedException {
		
		subjectTxt.sendKeys(subjectName);
		dueDateTxt.sendKeys(dueDate);
		
	 selectContactBtn.click();
		
		switchToWindow(driver, "Contact");
		Thread.sleep(3000);
		
		handleDropdown("Contact Name", selContactNameDropDown);
		searchContactNameTxt.sendKeys(contactName);
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//td[.='"+contactName+"']/following-sibling::td/child::button")).click();
		
		Thread.sleep(2000);
		
		switchToWindow(driver, "Ninza");
		Thread.sleep(1000);
		
		billingAddressTxtArea.sendKeys(billingAddress);
		billingPoBoxTxt.sendKeys(billingPoBox);
		billingCityTxt.sendKeys(billingCity);
	    billingStateTxt.sendKeys(billingState);
		billingPostalCodeTxt.sendKeys(billingPostalCode);
		billingCountryTxt.sendKeys(billingcountry);
		shippingAddressTxtArea.sendKeys(shippingAddress);
		shippingPoBoxTxt.sendKeys(shippingPoBox);
		cityTxt.sendKeys(city);
		stateTxt.sendKeys(State);
		postalCodeTxt.sendKeys(postalCode);
		countryTxt.sendKeys(country);
		
		selectProductBtn.click();
		
		switchToWindow(driver, "Product");
		Thread.sleep(3000);
		
		handleDropdown("Product Name", selProductNameDropDown);
		searchByProductNameTxt.sendKeys(productName);
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//td[.='"+productName+"']/following-sibling::td/child::button")).click();
		
		Thread.sleep(2000);
		
		switchToWindow(driver, "Ninza");
		Thread.sleep(1000);
		
		createPurchaseOrderBtn.click();

	
	}		

}
