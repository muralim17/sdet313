package com.crm.autodesk.genericutility;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;


/**
 * 
 * @author MURALI M
 *
 */

public class WebDriverutility {
	/**
	 * it is the wait which waits until element to be get loaded in webpage
	 * @param driver
	 */
	public void waitforpagetobeload(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
	}
	/**
	 * it is the wait which waits until javascript to be executed
	 * @param driver
	 */
	public void waitforpagetobeloadforjseElementT(WebDriver driver) {
		driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
		
	}
	/**
	 * to maximize the window
	 * @param driver
	 */
	public void windowmaximize(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * here polling time is fixed
	 * it is the wait which checks whether element is active or not and it holds the execution until the given condition is satisfied
	 * @param driver
	 * @param element
	 */
	public void waitforuntilelementtobeclickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * it waits until the given condition will satisfy or not
	 * @param driver
	 * @param element
	 */
	public void waitforuntilelementtobeinvisibilityof(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	/**
	 * here polling time is customizable
	 * it is the wait which waits until the given condition is satisfied
	 * @param driver
	 * @param element
	 * @param pollingtime
	 * @throws InterruptedException
	 */
	public void waitforelementwithcustomtimeout(WebDriver driver,WebElement element,int pollingtime) throws InterruptedException
	{
		FluentWait wait=new FluentWait(driver);
		wait.pollingEvery(pollingtime,TimeUnit.SECONDS);
		wait.wait(20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
		
	}
	/**
	 * used to switch any window based on window title
	 * @param driver
	 * @param partialwindowtitle
	 */
	public void switchtowindow(WebDriver driver, String partialwindowtitle)
	{
		Set<String> set=driver.getWindowHandles();
		Iterator<String> it=set.iterator();
		while(it.hasNext())
		{
			String wid = it.next();
			driver.switchTo().window(wid);
			String currentwindowtitle = driver.getTitle();
			if(currentwindowtitle.contains(partialwindowtitle))
			{
				break;
			}
		}
		
	}
	/**
	 * used to switch to alert window and to click on ok button
	 * @param driver
	 */
	public void switchtoalertwindowandaccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * 
	 * used to switch to alert window and to click on cancel button
	 */
	public void switchToalertwindowandcancel(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * used to switch from current frame to another frame based on index
	 * @param driver
	 * @param index
	 */
	public void switchtoFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * used to switch to frame based on id or name attribute
	 * @param driver
	 * @param id_name_attribute
	 */
	public void switchtoframe(WebDriver driver,String id_name_attribute)
	{
		driver.switchTo().frame(id_name_attribute);
	}
	/**
	 * used to select value from dropdown base on index
	 * @param element
	 * @param index
	 */
	public void select(WebElement element,int index)
	{
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	
	/**
	 * used to select value from dropdown based on value or option available in GUI
	 * @param element
	 * @param visibletext
	 */
	public void select(WebElement element,String visibletext)
	{
		Select s=new Select(element);
		s.selectByVisibleText(visibletext);
	}
	/**
	 * it is used to place mouse cursor on specific element
	 * @param driver
	 * @param element
	 */
	public void mouseoveronElement(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 * used to right click on specied element
	 * @param driver
	 * @param element
	 */
	public void rightclickonElement(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	/**
	 * used to scroll down in webpage
	 * @param driver
	 * @param javascript
	 */
	public void executejavascript(WebDriver driver,String javascript)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeAsyncScript(javascript,null);
	}
	/**
	 * 
	 * @param element
	 * @throws InterruptedException
	 */
	
	public void waitandclick(WebElement element) throws InterruptedException
	{
		int count=0;
		while(count<20)
			try {
				element.click();
				break;
			}catch(Throwable e)
		{
				Thread.sleep(1000);
				count++;
		}
	}

	/**
	 * it is used to take the screenshot of particular webelement
	 * @param driver
	 * @param screenshotname
	 * @throws IOException 
	 */
	public String takescreenshot(WebDriver driver,String screenshotname) throws IOException
	{
	TakesScreenshot ts=(TakesScreenshot)driver;
	File source=ts.getScreenshotAs(OutputType.FILE);
	Javautility ju=new Javautility();
	String stamp=ju.getSystemDateandTime().replace(":", "-");
    File destination=new File("./screenshot/"+stamp+screenshotname+".PNG");
    FileUtils.copyFile(source, destination);
    return destination.getAbsolutePath();
	}
	/**
	 * pass enterkey to perform keyboard action
	 * @param driver
	 */
	public void passEnterKey(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
		
	}
	
	
	
	
}


















