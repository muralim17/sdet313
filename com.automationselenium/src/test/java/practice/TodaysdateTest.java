package practice;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TodaysdateTest {
public static void main(String[] args) throws InterruptedException {
	LocalDateTime dateandtime = LocalDateTime.now().plusDays(3);
	int date = dateandtime.getDayOfMonth();
	System.out.println(date);
	System.out.println(dateandtime);
	 String month = dateandtime.getMonth().toString();
	int year = dateandtime.getYear();
	String actualmonth = month.substring(0, 1)+month.substring(1).toLowerCase();
	String monthandyear = actualmonth+" "+year;
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://www.makemytrip.com");
	Actions act=new Actions(driver);
	act.moveByOffset(10,0).click().perform();
	driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
	
	driver.findElement(By.xpath("//label[@for='fromCity']")).click();
	driver.findElement(By.xpath("//span[text()='From']")).click();
	WebElement from = driver.findElement(By.xpath("//div[@class='hsw_autocomplePopup autoSuggestPlugin ']/descendant::input"));
	from.sendKeys("Mumbai");
	WebDriverWait wait=new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.elementToBeClickable(from));
	from.sendKeys(Keys.ARROW_DOWN);
	from.sendKeys(Keys.ENTER);
	driver.findElement(By.xpath("//div[@class='fsw_inputBox searchToCity inactiveWidget ']")).click();
	WebElement sendbar = driver.findElement(By.xpath("//label[@for='toCity']"));
	sendbar.sendKeys("Bengaluru");
	WebDriverWait wait1=new WebDriverWait(driver,20);
	wait1.until(ExpectedConditions.elementToBeClickable(sendbar));
	sendbar.sendKeys(Keys.ARROW_DOWN);
	sendbar.sendKeys(Keys.ENTER);
			
	driver.findElement(By.xpath("//label[@for='departure']")).click();
	String calendar="//div[text()='"+monthandyear+"']/ancestor::div[@role='grid']/descendant::p[text()='"+date+"']";
	driver.findElement(By.xpath(calendar)).click();
	driver.findElement(By.xpath("//a[@class='primaryBtn font24 latoBold widgetSearchBtn ']")).click();
	 List<WebElement> airlines = driver.findElements(By.xpath("//span[@class='boldFont blackText airlineName']"));
	 for(int i=0;i<airlines.size();i++)
	 {
		String name = airlines.get(i).getText();
		System.out.println(name);
		System.out.println("availabale airlines for a "+ date+ "is"+name);
	 }
      
}
}
