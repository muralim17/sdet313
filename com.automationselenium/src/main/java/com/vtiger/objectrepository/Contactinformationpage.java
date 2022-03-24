package com.vtiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contactinformationpage {
	/*initialization of webelement*/
	public Contactinformationpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	/*declaration of webelement*/
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement actualcontactname;
	public WebElement getActualcontactname() {
		return actualcontactname;
	}
	
	/*business logic*/
	public WebElement getactualmsg()
	{
		return actualcontactname;
	}

}
