package com.crm.vtiger;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

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
import com.vtiger.objectrepository.Createneworganizationpage;
import com.vtiger.objectrepository.HomePage;
import com.vtiger.objectrepository.Loginpage;
import com.vtiger.objectrepository.Organizationinformationpage;
import com.vtiger.objectrepository.Organizationpage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationTest  extends Baseclass{
	    @Test(groups="smokeTest")
	    public void createorganization() throws Throwable
	    {
		Excelutility eu=new Excelutility();
		
		
		
		/*read testdata*/
		String orgname=eu.getDatafromexcel("organization name",1,2)+ju.getRandomNumber();
		
		/*navigate to home page*/
		HomePage hp=new HomePage(driver);
		hp.clickonorganization();
		
		/*click on createnew*/
		Createneworganizationpage cnp=new	Createneworganizationpage(driver);
		cnp.clickoncreateimage();
		
		/* create new organization */
	     Organizationinformationpage oip=new Organizationinformationpage(driver);
	     oip.neworganizationname(orgname);
	     oip.selectindustrytype("Banking");
	     oip.clickonsavebutton();
	     
	     /*validate the organizationpage*/
	     Organizationpage op=new  Organizationpage(driver);
	     wu.waitforuntilelementtobeclickable(driver, op.actualorganizationname());
	     String actualmsg = op.actualorganizationname().getText();
	     if(actualmsg.contains(orgname))
	     {
	    	 System.out.println("organization is created successfully  ===pass");
	     }
	     else
	     {
	    	 System.out.println("organization is not created ====fail");
	     }
		
	    
		
		
		
	}	
	}
