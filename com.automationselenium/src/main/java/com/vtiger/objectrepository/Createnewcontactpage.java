package com.vtiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Createnewcontactpage {
	/*Initialisation of webelement*/
	public Createnewcontactpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	/*declaration of webelement*/
		@FindBy(xpath="//input[@name='firstname']")
	private WebElement firstname;
	
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement lastname;
	
	@FindBy(xpath="//input[@id='mobile']")
	private WebElement mobileno;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebutton;

	public WebElement getSavebutton() {
		return savebutton;
	}

	public WebElement getFirstname() {
		return firstname;
	}

	public WebElement getMobileno() {
		return mobileno;
	}

	public WebElement getLastname() {
		return lastname;
	}
     
	
	/*business logic*/
	public void enterthefirstname_lastnameandmobilenumber(String fname,String lname,String mobilenum)
	{
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		mobileno.sendKeys(mobilenum);
		savebutton.click();
	}
	

}
