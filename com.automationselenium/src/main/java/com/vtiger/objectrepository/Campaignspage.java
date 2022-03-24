package com.vtiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Campaignspage {
	/*intialization of WebElements*/
	public Campaignspage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	/*Declaration of WebElements*/
     @FindBy(xpath="//img[@title='Create Campaign...']")
     private WebElement createnewcampaignicon;
	public WebElement getCreatenewcampaignicon() {
		return createnewcampaignicon;
	}
     
     /*business logic*/
     public void clickoncreatenewcampaignicon()
     {
    	 createnewcampaignicon.click();
     }
     
}
