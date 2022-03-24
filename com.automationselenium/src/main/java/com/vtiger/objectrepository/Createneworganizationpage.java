package com.vtiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Createneworganizationpage {
	/*intialization of Webelement*/
	public Createneworganizationpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	/*declaration of webelement*/
@FindBy(xpath="//img[@title='Create Organization...']")
private WebElement createneworganizationimage;

/*getters*/
public WebElement getCreateneworganizationimage() {
	return createneworganizationimage;
}

/*business logic*/
public void clickoncreateimage()
{
	createneworganizationimage.click();
}

	
}

