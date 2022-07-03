package com.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.genericLib.WebDriverCommonLibraries;

public class CreateNewOrganizationPage extends WebDriverCommonLibraries {
	
	
	@FindBy(name="accountname")
	private WebElement orgName;
	
	@FindBy(xpath = "//input[@class='detailedViewTextBox' and @name='website']")
	private WebElement website;
	
	@FindBy(name="industry")
	private WebElement industryDroDown;
	
	@FindBy(name="accounttype")
	private WebElement typedropDown;
	
	@FindBy(name="notify_owner")
	private WebElement notifyOwnercheckBx;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	
	//initialization
	
	public CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	public WebElement getOrgName() {
		return orgName;
	}


	public WebElement getWebsite() {
		return website;
	}


	public WebElement getIndustryDroDown() {
		return industryDroDown;
	}


	public WebElement getTypedropDown() {
		return typedropDown;
	}


	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	
	
	
	public WebElement getNotifyOwnercheckBx() {
		return notifyOwnercheckBx;
	}


	public void enterOrgInfo(String Orgname,String web_site)
	{
		orgName.sendKeys(Orgname);
		website.sendKeys(web_site);
		
	}
	
	public void selectIndustryDropDownValue(String opt)
	{
		selectDropDownOption(opt, industryDroDown);
	}
	
	public void selectTypeDropDownValue(String opt1)
	{
		selectDropDownOption(opt1, typedropDown);
	}
	
	public void clickOnNotifyOwnerCheckBx()
	{
		notifyOwnercheckBx.click();
		boolean res = notifyOwnercheckBx.isSelected();
		if(res==true)
		{
			System.out.println("already checked");
		}
		else
		{
			notifyOwnercheckBx.click();
			System.out.println("now the Notify owner check box is selecting  ");
		}
	}
	
	public void clickOnSaveBTn()
	{
		saveBtn.click();
	}
	
}
