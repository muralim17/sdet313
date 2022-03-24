package com.crm.autodesk.genericutility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.vtiger.objectrepository.HomePage;
import com.vtiger.objectrepository.Loginpage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	public WebDriver driver=null;
	public Fileutility fu=new Fileutility();
	public Javautility ju=new Javautility();
	public WebDriverutility wu=new WebDriverutility();
	public static WebDriver sDriver;
@BeforeSuite(groups= {"smokeTest","regressionTest"})
public void beforesuite()
{
	System.out.println("open databaseconnection");
}

@BeforeTest(groups= {"smokeTest","regressionTest"})
public void beforetest()
{
	System.out.println("open parallel mode execution");
}
@Parameters("browsername")
@BeforeClass(groups= {"smokeTest","regressionTest"})
//String browser
public void beforeclass() throws Throwable
{
	 
	String browser = fu.getpropertykeyvalue("browser");
	String url = fu.getpropertykeyvalue("url");
	if(browser.equals("chrome"))
	{
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
    }
	else if(browser.equals("firefox"))
			{
		     WebDriverManager.chromedriver().setup();
		     driver=new FirefoxDriver();
			}
	else
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	driver.get(url);
	wu.windowmaximize(driver);
	wu.waitforpagetobeload(driver);
	sDriver=driver;
}


@BeforeMethod(groups= {"smokeTest","regressionTest"})
public void beforemethod() throws IOException
{
	String username = fu.getpropertykeyvalue("username");
	String password = fu.getpropertykeyvalue("password");
	Loginpage lp=new Loginpage(driver);
	lp.login(username, password);
}

@AfterMethod(groups= {"smokeTest","regressionTest"})
public void aftermethod()
{
	HomePage hp=new HomePage(driver);
	hp.logout(driver);
}

@AfterClass(groups= {"smokeTest","regressionTest"})
public void aferclass()
{
	driver.quit();
}

@AfterTest(groups= {"smokeTest","regressionTest"})
public void aftertest()
{
	System.out.println("close parallel mode execution");
}

@AfterSuite(groups= {"smokeTest","regressionTest"})
public void aftersuite()
{
	System.out.println("close all databaseconnection");
}















}
