package com.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.genericLib.WebDriverCommonLibraries;

public class HomePage extends WebDriverCommonLibraries{

	@FindBy(linkText = "Contacts")
	private WebElement contactslnk;
	
	@FindBy(linkText = "Organizations")
	private WebElement orgLnk;
	
	@FindBy(linkText = "More")private WebElement moreLnk;
	
	@FindBy(linkText = "Purchase Order") private WebElement purchaseOrderLnk;
	
	
	@FindBy(xpath = "//a[.='Products']")private WebElement productLnk;
	
	@FindBy(linkText = "Campaigns")private WebElement campaignLnk;
	
	
	@FindBy(xpath ="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminIcon;
	
	
	
	@FindBy(linkText = "Sign Out")
	private WebElement signoutLnk;
	
	
	
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getProductLnk()
	{
		return productLnk;
	}

	public WebElement getOrgLnk() {
		return orgLnk;
	}



	public WebElement getCampaignLnk() {
		return campaignLnk;
	}

	public WebElement getMoreLnk() {
		return moreLnk;
	}


	public WebElement getPurchaseOrderLnk() {
		return purchaseOrderLnk;
	}


	public WebElement getContactslnk() {
		return contactslnk;
	}
	
	
	public void clickOnContactLnk()
	{
		contactslnk.click();
		
	}
	
	public void clickOnOrgLink()
	{
		orgLnk.click();
	}
	
	public void clickOnProductLnk()
	{
		productLnk.click();
	}
	
	public void clickOnMoreLnk(WebDriver driver)
	{
		mouseOverAnElement(driver, moreLnk);
		purchaseOrderLnk.click();
	}
	
	public void moveOnMoreLnk(WebDriver driver)
	{
		mouseOverAnElement(driver, moreLnk);
		campaignLnk.click();
	}
	
	
	public void signOutLnk(WebDriver driver)
	{
		mouseOverAnElement(driver, adminIcon);
		signoutLnk.click();
	}
	
}
