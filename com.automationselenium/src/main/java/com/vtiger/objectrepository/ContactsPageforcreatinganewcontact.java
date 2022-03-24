package com.vtiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPageforcreatinganewcontact {
	/*intialization of webelement*/
public ContactsPageforcreatinganewcontact(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
/*declaration of webelement*/
@FindBy(xpath="//img[@title='Create Contact...']")
private WebElement clickonplusicon;

public WebElement getClickonplusicon() {
	return clickonplusicon;
}

/*business logic*/
public void clickoncreateimage()
{
	clickonplusicon.click();
}





}
