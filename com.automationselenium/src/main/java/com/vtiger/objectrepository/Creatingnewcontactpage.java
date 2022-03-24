package com.vtiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericutility.WebDriverutility;

public class Creatingnewcontactpage  extends WebDriverutility {
	/*intialization  of webelement     */
public Creatingnewcontactpage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
/*declaration of webelement */
@FindBy(xpath="//input[@name='lastname']")
private WebElement lastname;

@FindBy(xpath="//input[@type='radio']")
private WebElement radiobutton;

@FindBy(xpath="//img[@title='Export Contacts']")
private WebElement exportimage;

@FindBy(xpath="//input[@name='contact_id']/following-sibling::img[@title='Select']")
private WebElement reportto;

@FindBy(xpath="//input[@name='contact_name']/following-sibling::input[2]")
private WebElement erase;

@FindBy(xpath="//b[text()='Contact Information']/preceding::input[@title='Save [Alt+S]']")
private WebElement savebutton;

@FindBy(xpath="//select[@name='leadsource']")
private WebElement leadsource;

@FindBy(xpath="//b[text()='Contact Information']/preceding::input[@title='Save [Alt+S]']")
private WebElement savebutton2;




public WebElement getSavebutton2() {
	return savebutton2;
}

public WebElement getLeadsource() {
	return leadsource;
}

public WebElement getSavebutton() {
	return savebutton;
}

public WebElement getErase() {
	return erase;
}

public WebElement getReportto() {
	return reportto;
}

public WebElement getExportimage() {
	return exportimage;
}

public WebElement getLastname() {
	return lastname;
}

public WebElement getRadiobutton() {
	return radiobutton;
}

/*enter the business logic*/
public void enterthecontactname(String contactname)
{
lastname.sendKeys(contactname);
}

public void selectradiobutton()
{
	radiobutton.click();
}

public void clickonExportimage()
{
	exportimage.click();
}
public void clickonreporttoimage()
{
	reportto.click();
}
public void clickonerase()
{
	erase.click();
}

public void clickonsavebutton()
{
	savebutton.click();
}
WebDriverutility wu=new WebDriverutility();

public void selectleadsource()
{
	select(leadsource, "Employee");
}
public void clickonsavebutton2()
{
	savebutton2.click();
}
}
