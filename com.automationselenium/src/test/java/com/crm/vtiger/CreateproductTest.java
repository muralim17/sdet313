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
import com.vtiger.objectrepository.Productinformationpage;
import com.vtiger.objectrepository.Productpage;
import com.vtiger.objectrepository.Productspage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateproductTest  extends Baseclass {
		@Test(groups="regressionTest")
		public void createproduct() throws Throwable, IOException
		{
		Excelutility eu=new Excelutility();
		
		
		
		/*read testdata*/
		
		String product=eu.getDatafromexcel("PRODUCT",1,2)+ju.getRandomNumber();
		
		/*navigate to home page*/
		HomePage hp=new HomePage(driver);
		
	     /*create new product*/
	     hp.clickonproduct();
	     
	     /*click on icon to create new product*/
	     Productspage pp=new Productspage(driver);
	     pp.clickonicon();
	     
	     /*enter the new product name*/
	     Productinformationpage pip=new Productinformationpage(driver);
	     pip.entertheproductname(product);
	     
	     /*validate whether producted is created or not*/
	     Productpage pps=new Productpage(driver);
	     wu.waitforuntilelementtobeclickable(driver, pps.actualnameofproduct());
	     String actualnameofproduct=pps.actualnameofproduct().getText();
	     if(actualnameofproduct.contains(product))
	     {
	    	 System.out.println("product is created ===pass");
	     }
	     else
	     {
	    	 System.out.println("product is not created====fail");
	     }
	     
	   
		
		
	}	

}
