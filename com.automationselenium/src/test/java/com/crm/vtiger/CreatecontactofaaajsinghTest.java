package com.crm.vtiger;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.autodesk.genericutility.Baseclass;
import com.crm.autodesk.genericutility.Excelutility;
import com.crm.autodesk.genericutility.Fileutility;
import com.crm.autodesk.genericutility.Javautility;
import com.crm.autodesk.genericutility.WebDriverutility;
import com.vtiger.objectrepository.Contactinformationvalidationpage;
import com.vtiger.objectrepository.ContactsPageforcreatinganewcontact;
import com.vtiger.objectrepository.Creatingnewcontactpage;
import com.vtiger.objectrepository.HomePage;
import com.vtiger.objectrepository.HomePageforcontact;
import com.vtiger.objectrepository.Loginpage;
import com.vtiger.objectrepository.Newwindowofcontactpage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreatecontactofaaajsinghTest extends Baseclass {
	    @Test(groups="regressionTest")
	    public void createcontactofaaasingh() throws Throwable, IOException
	    {
		
		Excelutility eu=new Excelutility();
		
		/*read exceldata*/
		String contact_name=eu.getDatafromexcel("contactname", 5, 2)+ju.getRandomNumber();
		
		
		
		/*click on contact*/
		HomePageforcontact homepageforcontact=new HomePageforcontact(driver);
		homepageforcontact.clickoncontactlink(driver);
		
		/*click on + image*/
		ContactsPageforcreatinganewcontact contactsPageforcreatinganewcontact=new ContactsPageforcreatinganewcontact(driver);
		contactsPageforcreatinganewcontact.clickoncreateimage();
		
		/*enter the mandatory fields*/
		Creatingnewcontactpage creatingnewcontactpage=new Creatingnewcontactpage(driver);
		creatingnewcontactpage.enterthecontactname(contact_name);
		creatingnewcontactpage.selectradiobutton();
		creatingnewcontactpage.clickonreporttoimage();
		
		wu.switchtowindow(driver, "action");
		Newwindowofcontactpage Newwindowofcontactpage=new Newwindowofcontactpage(driver);
		Newwindowofcontactpage.selectnametoclick();
		wu.switchtowindow(driver, "Contacts");
		creatingnewcontactpage.clickonerase();
		creatingnewcontactpage.clickonsavebutton();
		
		/*validate the createdmessage*/
		Contactinformationvalidationpage Contactinformationvalidationpage=new Contactinformationvalidationpage(driver);
		String actualcreatedcontactname = Contactinformationvalidationpage.getHeadermessage().getText();
		if(actualcreatedcontactname.contains(contact_name))
				{
			      System.out.println("contact name is created sucessfully ::::::validation pass");
				}
		else
		{
			System.out.println("contact name is not created sucessfully::::validation fail");
		}
		
		
		
	}

}
