package ninzaCRM.ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This Class consists of webelements of Opportunities Page
 * @author Admin
 */
public class OpportunitiesPage {
	
	@FindBy(xpath = "//span[.='Create Opportunity']")
	private WebElement createOpportunityBtn;
	
	@FindBy(xpath = "//table[@class='table table-striped table-hover']/tbody/tr[*]/td[2]")
	private List<WebElement> oppurtunityNamesTxt;
	
	public OpportunitiesPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	public WebElement getCreateOpportunityBtn() {
		return createOpportunityBtn;
	}


	public List<WebElement> getOppurtunityNamesTxt() {
		return oppurtunityNamesTxt;
	}

	//Business Library


	/**
	 * This method will click on create Opportunity button
	 */
	public void clickOnCreateOpportunityBtn()
	{
		createOpportunityBtn.click();
	}
	
	/**
	 * This method will capture all the Opportunity names and Compare with required Opportunity Name
	 * @param RequiredOpportunityName
	 */
	public void captureOpportunityNamesAndCompare(String RequiredOppurtunityName)
	{
		for (WebElement element : oppurtunityNamesTxt) {
			 
			String OppurtunityName = element.getText();
			if(OppurtunityName.equals(RequiredOppurtunityName))
			{
				System.out.println("Oppurtunity Created");
				break;
			}
		}
	}
	

}
