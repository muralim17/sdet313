package org.crm.organization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
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
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.autodesk.genericutility.Excelutility;
import com.crm.autodesk.genericutility.Fileutility;
import com.crm.autodesk.genericutility.Javautility;
import com.crm.autodesk.genericutility.WebDriverutility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Createcontact {
	public static void main(String[] args) throws Throwable {
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
		String firstname=elib.getDatafromexcel("contactname", 2, 2)+randomnum;
		String lastname=elib.getDatafromexcel("contactname", 3, 2)+randomnum;
		System.out.println("first name is "+ firstname);
		System.out.println("last name is "+ lastname);
		/*launch the browser*/
		//Run time polymorphism
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
          wlib.waitforpagetobeload(driver);
		
		driver.manage().window().maximize();
		driver.get(url);
		wlib.waitforpagetobeload(driver);
		/*step1 login to app*/
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		/*naviagate to create contactname*/
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("firstname")).sendKeys(firstname);
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		WebElement save=driver.findElement(By.xpath("//input[@title='Save [Alt+S]']"));
		save.click();
		
		/*wait for element to get clicked*/
		wlib.waitforuntilelementtobeinvisibilityof(driver,save);
		/*signout from the app*/
		WebElement signout=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wlib.mouseoveronElement(driver, signout);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		driver.close();
	}

}
