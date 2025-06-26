package ninzaCRM.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ninzaCRM.GenericUtilities.SeleniumUtility;

/**
 * This class consists of methods related to web element of Create Product Page
 * 
 * @author Admin
 */

public class CreateProductPage extends SeleniumUtility{
	
	@FindBy(name = "productName")
	private WebElement productNameTxt;
	
	@FindBy(name = "productCategory")
	private WebElement selCategoryDropDown;
	
	@FindBy(name = "quantity")
	private WebElement quantityTxt;
	
	@FindBy(name = "price")
	private WebElement priceTxt;
	
	@FindBy(name = "vendorId")
	private WebElement selVendorDropDown;
	
	@FindBy(xpath = "//button[.='Add']")
	private WebElement addBtn;
	
	public CreateProductPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getProductNameTxt() {
		return productNameTxt;
	}

	public WebElement getSelCategoryDropDown() {
		return selCategoryDropDown;
	}

	public WebElement getQuantityTxt() {
		return quantityTxt;
	}

	public WebElement getPriceTxt() {
		return priceTxt;
	}

	public WebElement getSelVendorDropDown() {
		return selVendorDropDown;
	}

	public WebElement getAddBtn() {
		return addBtn;
	}
	/**
	 * This method will create product with mandatory fields
	 * @param driver
	 * @param productNAME
	 * @param quantity
	 * @param price
	 */
     public void createProduct(WebDriver driver, String productNAME, String quantity, String price) {
    	 productNameTxt.sendKeys(productNAME);
    	 handleDropdown("Electronics", selCategoryDropDown);
    	 quantityTxt.clear();
    	 quantityTxt.sendKeys(quantity);
    	 priceTxt.clear();
    	 priceTxt.sendKeys(price);
    	 handleDropdown("VID_001", selVendorDropDown);
    	 addBtn.click();
     }
}
