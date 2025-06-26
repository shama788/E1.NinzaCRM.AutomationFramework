package ninzaCRM.ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class consists of methods related to web element of Products Page
 * 
 * @author Admin
 */

public class ProductsPage {
	@FindBy(xpath = "//span[.='Add Product']")
	private WebElement addProductBtn;
	
	@FindBy(xpath = "//table[@class='table table-striped table-hover']/tbody/tr[*]/td[2]")
	private List<WebElement> productsNamesTxt;
	
	public ProductsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getAddProductBtn() {
		return addProductBtn;
	}



	public List<WebElement> getProductsNamesTxt() {
		return productsNamesTxt;
	}

	//Business Library
	
	/**
	 * This method will click on create lead button
	 */
	public void clickOnAddProductBtn()
	{
		addProductBtn.click();
	}
	
	/**
	 * This method will capture all the lead names and Compare with required Lead Name
	 * @param RequiredLeadName
	 */
	public void captureProductNamesAndCompare(String RequiredProductName)
	{
		for (WebElement element : productsNamesTxt) {
			 
			String ProductName = element.getText();
			if(ProductName.equals(RequiredProductName))
			{
				System.out.println("product Created");
				break;
			}
		}

}
}
