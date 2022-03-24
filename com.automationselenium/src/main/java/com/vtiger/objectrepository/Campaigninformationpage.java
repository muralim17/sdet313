package com.vtiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * 
 * @author LOVERBOY
 *
 */

public class Campaigninformationpage {
	/*intialization of WebElements*/
	/**
	 * it is used to create a object of pom class
	 * @param driver
	 */
public Campaigninformationpage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

/*Declaration of WebElements*/
@FindBy(css="span.dvHeaderText")
private WebElement validationofcampaignname;
public WebElement getValidationofcampaignname() {
	return validationofcampaignname;
}

/*business logic*/
public String actualcampaignname()
{
	return validationofcampaignname.getText();
}
}
