package com.crm.vtiger;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodesk.genericutility.Baseclass;
import com.crm.autodesk.genericutility.Excelutility;
import com.crm.autodesk.genericutility.Fileutility;
import com.crm.autodesk.genericutility.Javautility;
import com.crm.autodesk.genericutility.WebDriverutility;
import com.vtiger.objectrepository.Campaigninformationpage;
import com.vtiger.objectrepository.Campaignspage;
import com.vtiger.objectrepository.Contactinformationpage;
import com.vtiger.objectrepository.Contactpage;
import com.vtiger.objectrepository.Createnewcontactpage;
import com.vtiger.objectrepository.Createneworganizationpage;
import com.vtiger.objectrepository.Creatingnewcampaignpage;
import com.vtiger.objectrepository.HomePage;
import com.vtiger.objectrepository.Loginpage;
import com.vtiger.objectrepository.Organizationinformationpage;
import com.vtiger.objectrepository.Organizationpage;
import com.vtiger.objectrepository.Productinformationpage;
import com.vtiger.objectrepository.Productpage;
import com.vtiger.objectrepository.Productspage;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(com.crm.autodesk.genericutility.ListenerImplementationClass.class)
public class CreatecampaignTest extends Baseclass {
	@Test(groups="smokeTest")
	public void createcampaign() throws EncryptedDocumentException, IOException {
	     Excelutility eu = new Excelutility();
	    HomePage hp=new HomePage(driver);
		/*read testdata*/
		
		String product=eu.getDatafromexcel("PRODUCT",1,2)+ju.getRandomNumber();
		String campaign_name=eu.getDatafromexcel("CAMPAIGN", 2, 1)+ju.getRandomNumber();
		
		   
	     /*click on campaign*/
	     hp.clickoncampaign(driver);
	     
	     /*click on create icon */
	     Campaignspage cpm=new Campaignspage(driver);
	     cpm.clickoncreatenewcampaignicon();
	     
	     /*create new campaign*/
	     Creatingnewcampaignpage ccpn=new Creatingnewcampaignpage(driver);
	     ccpn.clickandsavecampaign(campaign_name, product);
	     
	    
	     /*validate the campaignname*/
	     
	     Campaigninformationpage cf=new Campaigninformationpage(driver);
	     String actualCampaign= cf.actualcampaignname();
	     System.out.println(actualCampaign);
	     
	     
	     
	     
	
	     if(actualCampaign.contains(campaign_name))
	     {
	    	 System.out.println("campaignname is successfully created====pass");
	     }
	     else
	     {
	    	 System.out.println("campaign name is not created====fail");
	     }
	     
	    

	}


}
