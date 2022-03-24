package com.vtiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericutility.WebDriverutility;

public class Organizationinformationpage {
	WebDriverutility wu=new WebDriverutility();
	/*intialization of webelement*/
	public Organizationinformationpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="accountname")
	private WebElement organizationname;
	
	@FindBy(css="[name='industry']")
	private WebElement industrytype;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebutton;

	public WebElement getOrganizationname() {
		return organizationname;
	}

	public WebElement getSavebutton() {
		return savebutton;
	}
	
	public WebElement getIndustrytype() {
		return industrytype;
	}
	/*business logic*/
	public void neworganizationname(String orgname)
	{
		organizationname.sendKeys(orgname);
	}
	
	public void selectindustrytype(String visibletext)
	{
		industrytype.click();
		WebElement list = industrytype;
		wu.select(list, visibletext);
	}
	
	public void clickonsavebutton()
	{
		savebutton.click();
	}

}
