package ninzaCRM.ContactsTests;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CreateContactWithCampaignTest {
	
	@Test
	public void tc_02_createContactWithCampaign() throws InterruptedException{
		//Launch the browser
				WebDriver driver=new EdgeDriver();
				 driver.manage().window().maximize(); 
				 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				 driver.get("http://49.249.28.218:8098/");
				 
				 //Login to the Application
				  driver.findElement(By.id("username")).sendKeys("rmgyantra");
			 	  driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
			 	  driver.findElement(By.xpath("//button[.='Sign In']")).click();
			 	  
			 	//Click on create Campaign
			 	 driver.findElement(By.xpath("//span[.='Create Campaign']")).click();
			 	 
			 	//Create Campaign with Madatory Field
			 	driver.findElement(By.name("campaignName")).sendKeys("AdvetisingCamp");
			 	driver.findElement(By.name("campaignStatus")).sendKeys("Accepted");
			 	driver.findElement(By.name("targetSize")).sendKeys("4");
			 	driver.findElement(By.xpath("//button[.='Create Campaign']")).click();
			 	
			 	//Navigate to contact
			 	
			 	driver.findElement(By.linkText("Contacts")).click();
			 	
			 	//Click on create contact
				Thread.sleep(8000);

			 	driver.findElement(By.xpath("//span[.='Create Contact']")).click();
			 	
			 	//Create contact with campaign
					driver.findElement(By.name("organizationName")).sendKeys("TCS");
					driver.findElement(By.name("title")).sendKeys("Shams");
					driver.findElement(By.name("contactName")).sendKeys("Sharma");
					driver.findElement(By.name("mobile")).sendKeys("9999897601");

					//navigate to campagin page
					driver.findElement(By.xpath("//*[local-name()='svg']/parent::button")).click();
					
					//Handle window popup
					String mainWindID = driver.getWindowHandle();
					System.out.println(mainWindID);
					
					Set<String> allWinIds = driver.getWindowHandles();
					for(String winID:allWinIds)
					{
						if(!winID.equals(mainWindID))
						{
							driver.switchTo().window(winID);
							System.out.println(winID);
							break;
						}
					}
					
					System.out.println("Swicth from parent to child successful");
					
					//search for campagin in child window
					WebElement selDropdown = driver.findElement(By.id("search-criteria"));
					Select s = new Select(selDropdown);
					s.selectByVisibleText("Campaign Name");
					
					driver.findElement(By.id("search-input")).sendKeys("AdvetisingCamp");
					driver.findElement(By.xpath("//td[.='AdvetisingCamp']/following-sibling::td/child::button")).click();
					
					//switch the window control to main
					driver.switchTo().window(mainWindID);
					
					//Click on create contact
					driver.findElement(By.xpath("//button[.='Create Contact']")).click();
					
					//Validation
					List<WebElement> list = driver.findElements(By.xpath("//table[@class='table table-striped table-hover']/tbody/tr[*]/td[2]"));
				    for(WebElement ele:list)
				    {
				    	String leadInfo = ele.getText();
				    	if(leadInfo.equalsIgnoreCase("Test Lead I"))
				    	{
				    		System.out.println(leadInfo);
				    		System.out.println("Contact added successfully");
				    		break;
				    	}
				    }
	}

}
