package com.vtiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contactinformationvalidationpage {
	/*intialization of webelement*/
public Contactinformationvalidationpage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

/*declaration of webelement*/
@FindBy(xpath="//span[@class='dvHeaderText']")
private WebElement headermessage;

@FindBy(xpath="//span[@class='dvHeaderText']")
private WebElement headermessage2;


public WebElement getGetheadermessage2() {
	return headermessage2;
}

public WebElement getHeadermessage() {
	return headermessage;
}

/*business logic*/
public WebElement validateheadermessage()
{
	
	return headermessage;
}
public WebElement validateheadermessage2()
{
	
	return headermessage2;
}


}
