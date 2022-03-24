package com.vtiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericutility.WebDriverutility;

public class HomePageforcontact {
	/*intialization of webelement*/
public HomePageforcontact(WebDriver driver) {
	PageFactory.initElements(driver, this);
	
}


@FindBy(xpath="//a[text()='Contacts']")
private WebElement movetocontactlink;
public WebElement getMovetocontactlink() {
	return movetocontactlink;
}
WebDriverutility wu=new WebDriverutility();
public void clickoncontactlink(WebDriver driver)
{
	wu.mouseoveronElement(driver, movetocontactlink);
	movetocontactlink.click();
}
}
