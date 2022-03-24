package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.autodesk.genericutility.Javautility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreatecontactTestngTest {
	
	@Test(dataProvider="getdata" )
	public void multipledata(String employeename,String mobilenumber)
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("root");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(employeename);
		driver.findElement(By.xpath("//input[@name='mobile']")).sendKeys(mobilenumber);
		driver.findElement(By.xpath("//b[text()='Contact Information']/preceding::input[@title='Save [Alt+S]']")).click();
        driver.close();
	}
	Javautility ju=new Javautility();
	
	@DataProvider(parallel=true)
	public Object[][] getdata()
	{
		Object[][] data = new Object[5][2];
		data[0][0]="muralim"+ju.getRandomNumber();
		data[0][1]="8197733540"+ju.getRandomNumber();
		
		data[1][0]="rohithh"+ju.getRandomNumber();
		data[1][1]="9874563211"+ju.getRandomNumber();
		
		data[2][0]="klrahulh"+ju.getRandomNumber();
		data[2][1]="987451235"+ju.getRandomNumber();
		
		data[3][0]="sureshraina+"+ju.getRandomNumber();
		data[3][1]="5478963211"+ju.getRandomNumber();
		
		data[4][0]="hardikpandya"+ju.getRandomNumber();
		data[4][1]="8745632111"+ju.getRandomNumber();
		 
		
		return data;
	}

}
