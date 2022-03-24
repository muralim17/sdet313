package org.crm.organization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
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

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateorgTest {
public static void main(String[] args) throws Throwable, IOException {
	FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\testdata\\organization - Copy.xlsx ");
	Workbook book=WorkbookFactory.create(fis);
	Sheet sh=book.getSheet("sheet3");
	int lastrownum = sh.getLastRowNum();
	int lastcell = sh.getRow(0).getLastCellNum();
	System.out.println("total number of rows "+lastrownum);
	System.out.println("total number of columns"+lastcell);
	for(int i=0;i<=lastrownum;i++)
	{
		for(int j=0;j<lastcell;j++)
		{
			Row row=sh.getRow(i);
			Cell cell=row.getCell(j);
			String data=cell.getStringCellValue();
			System.out.print(data + "  ");
			
		}
		System.out.println();
	}
	System.out.println("============================================================");
	String orgname=sh.getRow(1).getCell(1).getStringCellValue();
	System.out.println("organization name is "+ orgname);
	FileInputStream fil=new FileInputStream("./src/main/resources/commondata/data.Properties");
	Properties pobj = new Properties();
	pobj.load(fil);
	String browser=pobj.getProperty("browser");
	String url=pobj.getProperty("url");
	String username=pobj.getProperty("username");
	String password=pobj.getProperty("password");
	System.out.println(browser);
	System.out.println(url);
	System.out.println(username);
	System.out.println(password);
	
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
	driver.manage().window().maximize();
	driver.get(url);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.name("user_name")).sendKeys(username);
	driver.findElement(By.name("user_password")).sendKeys(password);
	driver.findElement(By.id("submitButton")).click();
	driver.findElement(By.xpath("//td[@class='tabUnSelected']//a[text()='Organizations']")).click();
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	Random r=new Random();
	int randomnum = r.nextInt(1000);
	orgname=orgname+randomnum;
	driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgname);
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	driver.close();
	
	
	
}


}

