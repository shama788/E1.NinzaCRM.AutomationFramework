package ninzaCRM.OpportunitiesTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import ninzaCRM.GenericUtilities.BaseClass;
import ninzaCRM.ObjectRepository.CampaignPage;
import ninzaCRM.ObjectRepository.CreateCampaignPage;
import ninzaCRM.ObjectRepository.CreateLeadPage;
import ninzaCRM.ObjectRepository.CreateOpportunityPage;
import ninzaCRM.ObjectRepository.LeadsPage;
import ninzaCRM.ObjectRepository.OpportunitiesPage;

public class CreateOpportunityWithLeadTest extends BaseClass{
	
	@Test
	public void tc_03_createOpportunityWithLead() throws InterruptedException, EncryptedDocumentException, IOException
	{
		//Read Test Data from excel File
				String CAMPAIGNNAME = eUtil.readDataFromExcel("Integration", 7, 2)+jUtil.getRandomNumber();
				System.out.println(CAMPAIGNNAME);
				String TARGETSIZE = eUtil.readDataFromExcel("Integration", 7, 3);
				
				String LEADNAME = eUtil.readDataFromExcel("Integration", 7, 4);
				String COMPANY = eUtil.readDataFromExcel("Integration", 7, 5);
				String LEADSOURCE = eUtil.readDataFromExcel("Integration", 7, 6);
				String INDUSTRY = eUtil.readDataFromExcel("Integration", 7, 7);
				String PHONE = eUtil.readDataFromExcel("Integration", 7, 8);
				String LEADSTATUS = eUtil.readDataFromExcel("Integration", 7, 9);
				String RATING = eUtil.readDataFromExcel("Integration", 7, 10);
				
				String OPPORTUNITYNAME = eUtil.readDataFromExcel("Integration", 7, 11);
				String AMOUNT = eUtil.readDataFromExcel("Integration", 7, 12);
				String BUSINESSTYPE = eUtil.readDataFromExcel("Integration", 7, 13);
				String NEXTSTEP = eUtil.readDataFromExcel("Integration", 7, 14);
				String SALESSTAGE = eUtil.readDataFromExcel("Integration", 7, 15);
				String PROBABILITY = eUtil.readDataFromExcel("Integration", 7, 16);
				
				
				
				//Click on create campaign
				CampaignPage cp = new CampaignPage(driver);
				cp.clickOnCreateCampaignBtn();
				
				//Create campaign with mandatory fields
				CreateCampaignPage ccp = new CreateCampaignPage(driver);
				ccp.createCampaign(CAMPAIGNNAME, TARGETSIZE);
				
				Thread.sleep(8000);
				
				//Click on leads Link
				cp.clickOnLeadsLnk(); 
				
				//click on create lead button
				LeadsPage lp = new LeadsPage(driver);
				lp.clickOnCreateLeadBtn();
				
				//Create lead with mandatory fields
				CreateLeadPage clp = new CreateLeadPage(driver);
				clp.createLeadWithCampaign(driver, LEADNAME, COMPANY, LEADSOURCE, INDUSTRY, PHONE, LEADSTATUS, RATING, CAMPAIGNNAME);
				
				Thread.sleep(8000);
				//click on oppurtunity link
				
				cp.clickOnOppotunitiesLnk();
				
				//click on create opportunity button
				
				OpportunitiesPage op = new OpportunitiesPage(driver);
				op.clickOnCreateOpportunityBtn();
				
				//create opportunity with mandatory field
				
				CreateOpportunityPage co = new CreateOpportunityPage(driver);
				co.createOpportunityWithLead(driver, OPPORTUNITYNAME, AMOUNT, BUSINESSTYPE, NEXTSTEP, SALESSTAGE, PROBABILITY, LEADNAME);
				
				Thread.sleep(8000);
				
				//Validate for the opportunity
				op.captureOpportunityNamesAndCompare(OPPORTUNITYNAME);
				System.out.println(OPPORTUNITYNAME);
				
				Thread.sleep(8000);
		
	}
	
	

}
