package com.vtiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organizationpage {
	/*intialization of webelement*/
	 
public Organizationpage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
/*Declaration of Webelement*/
@FindBy(xpath="//span[@class='dvHeaderText']")
private WebElement Actualorganizationname;
public WebElement getActualorganizationname() {
	return Actualorganizationname;
}
/*business logic*/
public WebElement actualorganizationname()
{
  return Actualorganizationname;	
}
}
