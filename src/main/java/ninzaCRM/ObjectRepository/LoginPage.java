package ninzaCRM.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class consists of methods related to web element login
 * @author Admin
 */

public class LoginPage {
	
	@FindBy(id = "username")
	private WebElement usernameText;
	
	@FindBy(id = "inputPassword")
	private WebElement passwordText;
	
	@FindBy(xpath = "//button[.='Sign In']")
	private WebElement loginBtn;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getUsernameText()
	{
		return usernameText;
	}

	public WebElement getPasswordText()
	{
		return passwordText;
	}

	public WebElement getLoginBtn()
	{
		return loginBtn;
	}
	
	//Business Library - Optimizing - Generic methods
	
	/**
	 * This method will perform Login Operation
	 * @param un
	 * @param psw
	 */
	
	public void loginToApp(String USERNAME, String PASSWORD)
	{
		usernameText.sendKeys(USERNAME);
		passwordText.sendKeys(PASSWORD);
		loginBtn.click();
	}
		
	
	

	
	

}
