package ninzaCRM.ContactsTests;


import org.testng.AssertJUnit;
import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ninzaCRM.GenericUtilities.BaseClass;
import ninzaCRM.ObjectRepository.CampaignPage;
import ninzaCRM.ObjectRepository.ContactsPage;
import ninzaCRM.ObjectRepository.CreateCampaignPage;
import ninzaCRM.ObjectRepository.CreateContactPage;

@Listeners(ninzaCRM.GenericUtilities.ListenersImplementation.class)

public class CreateContactTest extends BaseClass{
	
	@Test
	public void createContact() throws EncryptedDocumentException, IOException, InterruptedException
	{
		//Read Test Data from excel File
				String CAMPAIGNNAME = eUtil.readDataFromExcel("Integration", 4, 2)+jUtil.getRandomNumber();
				System.out.println(CAMPAIGNNAME);
				String TARGETSIZE = eUtil.readDataFromExcel("Integration", 4, 3);
				
				String ORGANIZATION = eUtil.readDataFromExcel("Integration", 4, 4);
				String TITLE = eUtil.readDataFromExcel("Integration", 4, 5);
				String CONTACTNAME = eUtil.readDataFromExcel("Integration", 4, 6);
				String MOBILE = eUtil.readDataFromExcel("Integration", 4, 7);
				
				
				
				
				//Click on create campaign
				CampaignPage cp = new CampaignPage(driver);
				cp.clickOnCreateCampaignBtn();
				
				
				//Create campaign with mandatory fields
				CreateCampaignPage ccp = new CreateCampaignPage(driver);
				ccp.createCampaign(CAMPAIGNNAME, TARGETSIZE);
				
				Thread.sleep(8000);
				
				//Click on contacts Link
				cp.clickOnContactsLnk();
				
				//click on create contacts button
				ContactsPage cpp = new ContactsPage(driver);
				cpp.clickOnCreateContactBtn();
				
				//AssertJUnit.fail();
				
				//Create contact with mandatory fields
				CreateContactPage cconp = new CreateContactPage(driver);
				cconp.createContactWithCampaign(driver, ORGANIZATION, TITLE, CONTACTNAME, MOBILE, CAMPAIGNNAME);
				
				//Validate for the contact
				cpp.captureContactNamesAndCompare(CONTACTNAME);
				System.out.println(CONTACTNAME);
				
				Thread.sleep(8000);

	}

}
