package com.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.genericLib.WebDriverCommonLibraries;

public class CreateNewCampaignPage extends WebDriverCommonLibraries  {

	
	@FindBy(xpath = "//input[@class='detailedViewTextBox']")private  WebElement campaNameTextTb;
	
	@FindBy(xpath = "//input[@value='T']")private WebElement assignedToRadioBtn;
	
	@FindBy(xpath = "//select[@name='assigned_group_id']")private WebElement assignedDropDown;
	
	@FindBy(xpath = "//select[@name='campaignstatus']")private WebElement campaignStatusDropdown;
	
	@FindBy(xpath = "//img[@title='Select']")private WebElement selectProductLkpImg;
	
	@FindBy(id = "search_txt")private WebElement searchTextTb;
	
	@FindBy(name = "search")private WebElement searchBtn;
	
	@FindBy(id="1")private WebElement selectProductName;
	
	@FindBy(xpath = "//select[@name='campaigntype']")private WebElement campaignTypeDropDown;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")private WebElement saveBtn;
	
	
	public CreateNewCampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	

	public WebElement getCampaNameTextTb() {
		return campaNameTextTb;
	}




	public WebElement getAssignedToRadioBtn() {
		return assignedToRadioBtn;
	}



	public WebElement getAssignedDropDown() {
		return assignedDropDown;
	}



	public WebElement getCampaignStatusDropdown() {
		return campaignStatusDropdown;
	}



	public WebElement getSelectProductLkpImg() {
		return selectProductLkpImg;
	}



	public WebElement getSearchTextTb() {
		return searchTextTb;
	}



	public WebElement getSearchBtn() {
		return searchBtn;
	}



	public WebElement getSelectProductName() {
		return selectProductName;
	}



	public WebElement getCampaignTypeDropDown() {
		return campaignTypeDropDown;
	}
	
	
	public void enterCampaignInfo(WebDriver driver,String campaignname)
	{
		System.out.println("enter the camp info ");
		campaNameTextTb.sendKeys(campaignname);
		assignedToRadioBtn.click();
		selectDropDownOption("Support Group", assignedDropDown);
		selectDropDownOption("Active", campaignStatusDropdown);
		selectProductLkpImg.click();
		switchToWindow(driver, "Products&action");
		searchTextTb.sendKeys("SamsungMobile4");
		searchBtn.click();
		selectProductName.click();
		switchToWindow(driver, "Administrator - Campaigns - vtiger CRM 5");
		selectDropDownOption("Advertisement",campaignTypeDropDown);
		saveBtn.click();
		
		
	}
	
	
	
	
	
	
}
