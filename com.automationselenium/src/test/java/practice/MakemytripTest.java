package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakemytripTest {
	public static void main(String[] args) {
		String monthandyear="September 2022";
		String date="28";
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
		Actions act=new Actions(driver);
		act.moveByOffset(10, 10).click().perform();;
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		
		driver.findElement(By.xpath("//label[@for='departure']")).click();
		String calendarpath="//div[text()='"+monthandyear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']";
	
	for(;;)
	{
			
	try {
		driver.findElement(By.xpath(calendarpath)).click();
		
	     break;
	}catch(Exception e)
	{
		driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
	}
	}
		


}
}
