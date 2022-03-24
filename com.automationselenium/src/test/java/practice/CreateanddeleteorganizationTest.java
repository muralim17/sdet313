package practice;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.autodesk.genericutility.Excelutility;
import com.crm.autodesk.genericutility.Javautility;
import com.vtiger.objectrepository.Organizationinformationpage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateanddeleteorganizationTest extends Excelutility {
public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("http://localhost:8888/");
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("root");
	driver.findElement(By.id("submitButton")).click();
	driver.findElement(By.xpath("//a[text()='Organizations']")).click();
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	Excelutility  eu=new Excelutility();
	eu.getDatafromexcel("organization name", 1, 2);
     Javautility ju=new Javautility();
   
     String organizationname="testyantra"+  ju.getRandomNumber();
     

	driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(organizationname);
	driver.findElement(By.xpath("//b[text()='Organization Information']/preceding::input[@title='Save [Alt+S]']")).click();
Thread.sleep(4000);

	WebElement click = driver.findElement(By.xpath("//td[@class='tabSelected']/a[text()='Organizations']"));
	WebDriverWait wait=new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.elementToBeClickable(click));
	click.click();
	driver.findElement(By.xpath("//a[@title='Last']/img")).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath("(//a[@title='Organizations'])[last()]")).click();
	driver.findElement(By.xpath("//input[@title='Delete [Alt+D]']")).click();
	Alert alert=driver.switchTo().alert();
	alert.accept();
	System.out.println("successfully deleted");
	driver.close();

     }


		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
