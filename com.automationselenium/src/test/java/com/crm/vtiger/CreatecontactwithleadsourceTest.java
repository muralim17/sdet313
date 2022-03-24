package com.crm.vtiger;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
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

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreatecontactwithleadsourceTest   extends Baseclass {
     @Test(groups="smokeTest")
     public void createcontactwithleadsource() throws Throwable, IOException
     {
	
	Excelutility eu=new Excelutility();
	
	
	
	/*read exceldata*/
	String contact_name=eu.getDatafromexcel("contactname", 6, 2)+ju.getRandomNumber();
	
	
	
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
	
	/*select the lead source*/
	creatingnewcontactpage.selectleadsource();
	creatingnewcontactpage.clickonsavebutton2();
	
	/*validation of contactpage*/
	Contactinformationvalidationpage Contactinformationvalidationpage=new Contactinformationvalidationpage(driver);
	String actualname = Contactinformationvalidationpage.validateheadermessage2().getText();
	if(actualname.contains(contact_name))
	{
		System.out.println("contact name is successfully created::::::validationpass");
	}
	else
	{
		System.out.println("contact name is not created::::::validationfail");
	}
	

	
	
	
	
	
	
	
	
	
}
}
