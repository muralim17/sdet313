package com.vtiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Creatingnewcampaignpage {
	/*intialization of webelement*/
public Creatingnewcampaignpage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
/*declaration of webelement*/
@FindBy(xpath="//input[@name='campaignname']")
private WebElement campaignname;

@FindBy(xpath="//img[@alt='Select']")
private WebElement productimage;

@FindBy(xpath="//input[@name='product_name']")
private WebElement productbar;


public WebElement getProductbar() {
	return productbar;
}
@FindBy(xpath="//b[text()='Campaign Information']/preceding::input[@title='Save [Alt+S]']")
private WebElement save_button;



public WebElement getProductimage() {
	return productimage;
}

public WebElement getCampaign_name() {
	return campaignname;
}

public WebElement getSave_button() {
	return save_button;
}
/*business logic*/
public void clickandsavecampaign(String campaign_name,String productname)
{
	campaignname.sendKeys(campaign_name);
	productbar.sendKeys(productname);
	save_button.click();
}
}
