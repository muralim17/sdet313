package com.vtiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericutility.WebDriverutility;

public class HomePage extends WebDriverutility {
	/*intialization of webelement*/
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	/*Declaration of WebElement*/
	@FindBy(linkText="Organizations")
	private WebElement organizationlink;
	
	@FindBy(linkText="Leads")
	private WebElement leadslink;
	
	@FindBy(linkText="Contacts")
	private WebElement contacslink;
	
	@FindBy(linkText="Products")
	private WebElement productslink;
	
	@FindBy(xpath="//a[@id='more' and @name='Campaigns']")
	private WebElement campaigns;
	
	
	
	public WebElement getCampaigns() {
		return campaigns;
	}
	@FindBy(xpath="//td[@class='tabUnSelected']/a[text()='More']")
	private WebElement more;
	
	public WebElement getMouseoveron() {
		
		return more;
	}

	public WebElement getProductslink() {
		return productslink;
	}
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement signouticonimage;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signouticonlink;
/* getters*/
	public WebElement getOrganizationlink() {
		return organizationlink;
	}

	public WebElement getLeadslink() {
		return leadslink;
	}

	public WebElement getContacslink() {
		return contacslink;
	}

	public WebElement getSignouticonimage() {
		return signouticonimage;
	}

	public WebElement getSignouticonlink() {
		return signouticonlink;
	}
	
public void setCampaigns(WebElement campaigns) {
		this.campaigns = campaigns;
	}

	/*business logic*/
	public void clickonorganization()
	{
		organizationlink.click();	
	}
	public void clickoncontact()
	{
		contacslink.click();
	}
	public void clickonproduct()
	{
		productslink.click();
	}
	WebDriverutility wu=new WebDriverutility();
	public void clickoncampaign(WebDriver driver)
	{
		WebElement moreon = more;
		wu.mouseoveronElement(driver, more);
		campaigns.click();
	}
	
	public void logout(WebDriver driver)
	{
		wu.mouseoveronElement(driver, signouticonimage);
		signouticonlink.click();
		
	}
	
	
	
}
