package com.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.genericLib.WebDriverCommonLibraries;

public class CreateNewContactPage extends WebDriverCommonLibraries {
	
	@FindBy(name="salutationtype")
	private WebElement salutationDropDown;
	
	@FindBy(name="firstname")
	private WebElement firatnameTb;
	
	@FindBy(name="lastname")
	private WebElement lastnameTb;
	
	@FindBy(name="mobile")
	private WebElement mobileTb;
	
	@FindBy(name="department")
	private WebElement departTb;
	
	@FindBy(id="email")
	private WebElement emailTb;
	
	@FindBy(name="imagename")
	private WebElement uploadBtn;
	
	@FindBy(name="leadsource")
	private WebElement leadDropDown;
	
	@FindBy(xpath = "//img[@title='Select']")
	private WebElement organizationLookUpImg;
	
	@FindBy(id="search_txt")
	private WebElement searchTextEdit;
	
	@FindBy(name="search")private WebElement searchBtn;
	
	@FindBy(id="2")private WebElement selectOrgName;
		
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//initialization
	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	public WebElement getSearchTextEdit() {
		return searchTextEdit;
	}





	public WebElement getSearchBtn() {
		return searchBtn;
	}





	public WebElement getSalutationDropDown() {
		return salutationDropDown;
	}





	public WebElement getFiratnameTb() {
		return firatnameTb;
	}


	public WebElement getLastnameTb() {
		return lastnameTb;
	}


	public WebElement getMobileTb() {
		return mobileTb;
	}





	public WebElement getDepartTb() {
		return departTb;
	}

	public WebElement getEmailTb() {
		return emailTb;
	}

	public WebElement getLeadDropDown() {
		return leadDropDown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	
	public void enterContactInfoWithLeadType(String firstname,String lastname,String mobile,String deprt,String email,String leadType)
	{
		firatnameTb.sendKeys(firstname);
		lastnameTb.sendKeys(lastname);
		mobileTb.sendKeys(mobile);
		departTb.sendKeys(deprt);
		emailTb.sendKeys(email);
		selectDropDownOptionLead(leadType);
		saveBtn.click();
	}
	
	public void enterContactInfo(String firstname,String lastname,String mobile,String deprt,String email)
	{
		firatnameTb.sendKeys(firstname);
		lastnameTb.sendKeys(lastname);
		mobileTb.sendKeys(mobile);
		departTb.sendKeys(deprt);
		emailTb.sendKeys(email);
		saveBtn.click();
	}

	public void enterContactInfoWithOrgName(String firstname,String lastname,String mobile,String deprt,String email,WebDriver driver, String orgname,String leadType)
	{
		
		firatnameTb.sendKeys(firstname);
		lastnameTb.sendKeys(lastname);
		mobileTb.sendKeys(mobile);
		departTb.sendKeys(deprt);
		selectDropDownOptionLead(leadType);
		emailTb.sendKeys(email);
		organizationLookUpImg.click();
		switchToWindow(driver, "Accounts&action");
		searchTextEdit.sendKeys(orgname);
		searchBtn.click();
		selectOrgName.click();
		switchToWindow(driver, "Contacts&action");
		saveBtn.click();
		
		
		
	}
	
	public void selectSalatationOption(String option)
	{
		selectDropDownOption(option, salutationDropDown);
	}
	
	public void clickOnOrgLookUp()
	{
		organizationLookUpImg.click();
	}
	
	public void selectDropDownOptionLead(String value)
	
	{
		selectDropDownOption(value, leadDropDown);
	}
	
	public void clickOnsaveBtn()
	{
		saveBtn.click();
	}
	
	

}
