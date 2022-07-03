package com.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.genericLib.WebDriverCommonLibraries;

public class OrganizationInfoPage extends WebDriverCommonLibraries{
	
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement orgInfoHeaderText;
	
	@FindBy(xpath ="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminIcon;
	
	
	
	@FindBy(linkText = "Sign Out")
	private WebElement signoutLnk;
	
	
	public OrganizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	public WebElement getOrgInfoHeaderText() {
		return orgInfoHeaderText;
	}
	
	
	public void signOutLnk(WebDriver driver)
	{
		mouseOverAnElement(driver, adminIcon);
		signoutLnk.click();
	}
	

}
