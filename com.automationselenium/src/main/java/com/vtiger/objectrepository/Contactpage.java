package com.vtiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contactpage {
	
	/*intialization*/
	public Contactpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	/*declaration*/
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement createnewcontactimage;

	public WebElement getCreatenewcontactimage() {
		return createnewcontactimage;
	}
	
	public void clickoncreatenewcontactimage()
	{
		createnewcontactimage.click();
	}
	

}
