package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreatecontactTest {
public static void main(String[] args) {
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
	driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("employeename");
	driver.findElement(By.xpath("//input[@name='mobile']")).sendKeys("mobilenumber");
	driver.findElement(By.xpath("//b[text()='Organization Information']/preceding::input[@title='Save [Alt+S]']")).click();
    driver.close();
}
}
