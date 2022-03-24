package org.crm.organization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.autodesk.genericutility.Excelutility;
import com.crm.autodesk.genericutility.Fileutility;
import com.crm.autodesk.genericutility.Javautility;
import com.crm.autodesk.genericutility.WebDriverutility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProductTest {
	public static void main(String[] args) throws Throwable, IOException {
		/* create object of all generic classes*/
		Excelutility elib=new Excelutility();
		Fileutility flib=new Fileutility();
		Javautility jlib=new Javautility();
		WebDriverutility wlib=new WebDriverutility();
		/*get randomdata*/
		int randomnum = jlib.getRandomNumber();
		/*get propertydata*/
		String browser = flib.getpropertykeyvalue("browser");
		String url = flib.getpropertykeyvalue("url");
		String username = flib.getpropertykeyvalue("username");
		String password = flib.getpropertykeyvalue("password");
		/*getexceldata*/
	       String organizationname=elib.getDatafromexcel("organization name",2,2)+randomnum;
	       String firstname=elib.getDatafromexcel("contactname",2,2)+randomnum;
	       String lastname=elib.getDatafromexcel("contactname",3,2)+randomnum;
	       String mobilenum=elib.getDatafromexcel("contactname",4,2)+randomnum;
	    /*launch the browser*/
        WebDriver driver=null;
		
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			System.out.println("launched browser is : "+ browser);
			
		} else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			System.out.println("launched browser is : "+ browser);

		}
		else {
			System.out.println("specify a valid browser");
			
		}
		
		driver.get(url);
		wlib.windowmaximize(driver);
		wlib.waitforpagetobeload(driver);
		/*navigate to login*/
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		/*pass the organization name*/
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(organizationname);
		/*select the industry type*/
		driver.findElement(By.cssSelector("[name='industry']")).click();
		WebElement list=driver.findElement(By.cssSelector("[name='industry']"));
		wlib.select(list, "Manufacturing");
		WebElement save=driver.findElement(By.xpath("//input[@title='Save [Alt+S]']"));
		save.click();
		wlib.waitforuntilelementtobeinvisibilityof(driver, save);
	    WebElement click=driver.findElement(By.xpath("//a[text()='Contacts']"));
	    click.click();
	   wlib.waitforuntilelementtobeinvisibilityof(driver, click);
	   /*create contactname by providing firstname and lastname*/
	    driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		
		driver.findElement(By.name("firstname")).sendKeys(firstname);
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		
		
		driver.findElement(By.xpath("//img[@title='Select']")).click();
		wlib.switchtowindow(driver, "Accounts");
		/* pass the organization name and search*/
		driver.findElement(By.id("search_txt")).sendKeys(organizationname);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+organizationname+"']")).click();
		wlib.switchtowindow(driver, "Contacts");
		
		
		WebElement save2=driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]"));
		save2.click();
		wlib.waitforuntilelementtobeinvisibilityof(driver, save2);
		String actheadermsg1=driver.findElement(By.className("dvHeaderText")).getText();
		if(actheadermsg1.contains(lastname))
		{
			System.out.println( lastname + "pass");
		}
		else
		{
			System.out.println(lastname+"fail");
		}
			/*create the product name*/
		String productname=elib.getDatafromexcel("PRODUCT",1,2)+randomnum;
		driver.findElement(By.xpath("//a[text()='Products']")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		driver.findElement(By.name("productname")).sendKeys(productname);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String actheadermsg2=driver.findElement(By.className("lvtHeaderText")).getText();
		/*validate whether productname is created or not*/
		if(actheadermsg2.contains(productname))
		{
			System.out.println( productname + "pass");
		}
		else
		{
			System.out.println( productname + "fail");
		}
		WebElement signout=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wlib.mouseoveronElement(driver, signout);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		driver.close();
		
	}

}
