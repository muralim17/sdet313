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
import com.vtiger.objectrepository.Contactinformationpage;
import com.vtiger.objectrepository.Contactpage;
import com.vtiger.objectrepository.Createnewcontactpage;
import com.vtiger.objectrepository.Createneworganizationpage;
import com.vtiger.objectrepository.HomePage;
import com.vtiger.objectrepository.Loginpage;
import com.vtiger.objectrepository.Organizationinformationpage;
import com.vtiger.objectrepository.Organizationpage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreatecontactTest extends Baseclass {
	    @Test(groups="regressionTest")
	    public void createcontact() throws Throwable, IOException
	    {
	    	
		Excelutility eu=new Excelutility();
		
		
		/*read testdata*/
		String fname=eu.getDatafromexcel("contactname",2, 2)+ju.getRandomNumber();
		String lname=eu.getDatafromexcel("contactname",3, 2)+ju.getRandomNumber();
		String mobilenum=eu.getDatafromexcel("contactname",4, 2);
		
				
		/*navigate to home page*/
		HomePage hp=new HomePage(driver);
		
	     /*create new contact*/
	     hp.clickoncontact();
	     
	     /*create new contact*/
	     Contactpage cp=new Contactpage(driver);
	     cp.clickoncreatenewcontactimage();
	     
	     /*Enter the required fields*/
	     Createnewcontactpage cncp=new Createnewcontactpage(driver);
	     cncp.enterthefirstname_lastnameandmobilenumber(fname,lname,mobilenum);
	     
	     /*validate whether contact page is created or not*/
	     Contactinformationpage cip=new Contactinformationpage(driver);
	     wu.waitforuntilelementtobeclickable(driver, cip.getActualcontactname());
	     String actualmsg2=cip.getActualcontactname().getText();
	     if(actualmsg2.contains(lname))
	     {
	    	 System.out.println("new contact is created===pass");
	     }
	     else
	     {
	    	 System.out.println("new contact is not creates===fail");
	     }
	     
	     
		
	   
		
		
	}	

}
