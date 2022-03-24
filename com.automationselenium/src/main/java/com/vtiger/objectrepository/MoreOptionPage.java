package com.vtiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MoreOptionPage {
	/*intialization of webelement*/
	public MoreOptionPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	/*Declaration of Webelement*/
	@FindBy(linkText="Campaigns")
    private WebElement campaignLinkText;

	public WebElement getCampaignLinkText() {
		return campaignLinkText;
	}
	/*business logic*/
	public void campaign() {
		campaignLinkText.click();
	}
}
