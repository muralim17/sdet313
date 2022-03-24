package com.vtiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Newwindowofcontactpage {
	/*intialization of webelement*/
public Newwindowofcontactpage(WebDriver driver) 
{
	PageFactory.initElements(driver, this);
}
/*Declaration of Webelement*/
@FindBy(xpath="//table[@class='small']/tbody/tr/td/div/table/tbody/tr[2]/td/a")
private WebElement nametoselect;

public WebElement getNametoselect() {
	return nametoselect;
}
/*business logic*/
public void selectnametoclick()
{
	nametoselect.click();
}
}
