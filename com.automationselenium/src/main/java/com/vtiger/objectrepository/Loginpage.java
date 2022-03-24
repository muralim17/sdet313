package com.vtiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	/*intialization of webelement*/
	public Loginpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	/*Declaration of Webelement*/
	@FindBy(name="user_name")
	private WebElement usernametextfield;
	@FindBy(name="user_password")
	private WebElement usernamepassword;
	@FindBy(id="submitButton")
	private WebElement loginbutton;
	public WebElement getUsernametextfield() {
		return usernametextfield;
	}
	public WebElement getUsernamepassword() {
		return usernamepassword;
	}
	public WebElement getSubmitbutton() {
		return loginbutton;
	}
	
	/*business logic*/
	public void login(String username,String password)
	{
		usernametextfield.sendKeys(username);
		usernamepassword.sendKeys(password);
		loginbutton.click();
	}
	
	

}
