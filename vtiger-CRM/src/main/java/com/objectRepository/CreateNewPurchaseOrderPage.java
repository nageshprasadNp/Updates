package com.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.genericLib.WebDriverCommonLibraries;

public class CreateNewPurchaseOrderPage extends WebDriverCommonLibraries{

	//declaration
	@FindBy(name="subject")private WebElement subjectTextbx;
	
	@FindBy(xpath = "//img[@title='Select']")private WebElement selectVendorLkpImg;
	
	@FindBy(id="search_txt")private WebElement searchtextTb;
	
	@FindBy(name="search_field")private WebElement searchDropDown;
	
	@FindBy(name="search")private WebElement searchBtn;
	
	@FindBy(id="1")private WebElement selectVendorName;
	
	@FindBy(name="postatus")private WebElement statusDropDown;
	
	@FindBy(xpath="//input[@value='T']")private WebElement assignedRadioBtn;
	
	@FindBy(xpath = "//textarea[@name='bill_street']")private WebElement billingTextTb;
	
	@FindBy(xpath = "(//input[@name='cpy'])[2]")private WebElement billingRadioBtn;
	
	@FindBy(id="searchIcon1")private WebElement selectProductLkpImg;
	
	@FindBy(linkText = "oppoMobile")private WebElement selectProductName;
	
	@FindBy(id="qty1")private WebElement qyt1TextTb;
	
	@FindBy(xpath = "//input[@value='Add Service']")private WebElement addServiceBtn;
	
	@FindBy(xpath = "//img[@src='themes/images/up_layout.gif']")private WebElement upwardArrowImg;
	
	@FindBy(xpath = "//img[@src='themes/images/delete.gif']")private WebElement deleteLkpImg;
	
	@FindBy(xpath = "//img[@src='themes/images/services.gif']")private WebElement selectServiceLkpImg;
	
	@FindBy(linkText = "SoftwareUpdating")private WebElement selectServiceName;
	
	@FindBy(id="qty2")private WebElement qty2TextTb;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")private WebElement saveBtn;
	
	
	
	
	
	//initialization
	public CreateNewPurchaseOrderPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	
	//generating getters
	public WebElement getSubjectTextbx() {
		return subjectTextbx;
	}
	
	

	public WebElement getSearchDropDown() {
		return searchDropDown;
	}


	public WebElement getSelectVendorLkpImg() {
		return selectVendorLkpImg;
	}

	public WebElement getSearchtextTb() {
		return searchtextTb;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getSelectVendorName() {
		return selectVendorName;
	}

	public WebElement getStatusDropDown() {
		return statusDropDown;
	}

	public WebElement getAssignedRadioBtn() {
		return assignedRadioBtn;
	}

	public WebElement getBillingTextTb() {
		return billingTextTb;
	}

	public WebElement getBillingRadioBtn() {
		return billingRadioBtn;
	}

	public WebElement getSelectProductLkpImg() {
		return selectProductLkpImg;
	}

	public WebElement getQyt1TextTb() {
		return qyt1TextTb;
	}

	public WebElement getAddServiceBtn() {
		return addServiceBtn;
	}

	public WebElement getSelectServiceLkpImg() {
		return selectServiceLkpImg;
	}

	public WebElement getQty2TextTb() {
		return qty2TextTb;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	
	
	public WebElement getUpwardArrowImg() {
		return upwardArrowImg;
	}


	//details for purchase order with add product and add service
	public void enterPurchaseOrderDetails(WebDriver driver,String subName,String vendorName,String billingValue,String product_name,String service_name)
	{
		subjectTextbx.sendKeys(subName);
		selectVendorLkpImg.click();
		switchToWindow(driver, "Vendor&action");
		searchtextTb.sendKeys(vendorName);
		searchBtn.click();
		selectVendorName.click();
		switchToWindow(driver, "Administrator - Purchase Order");
		selectDropDownOption("Delivered", statusDropDown);
		billingTextTb.sendKeys(billingValue);
		billingRadioBtn.click();
		scrollBarAction(driver);
		selectProductLkpImg.click();
		switchToWindow(driver, "Product&action");
		searchtextTb.sendKeys(product_name);
		searchBtn.click();
		selectProductName.click();
		switchToWindow(driver, "Administrator - Purchase Order");
		qyt1TextTb.sendKeys("2");
		addServiceBtn.click();
		selectServiceLkpImg.click();
		switchToWindow(driver, "Services&action");
		searchtextTb.sendKeys(service_name);
		selectDropDownOption("Service Name", searchDropDown);
		searchBtn.click();
		selectServiceName.click();
		switchToWindow(driver, "Administrator - Purchase Order");
		
		qty2TextTb.sendKeys("1");
		saveBtn.click();
		
	}
	
	//details to add only add product
	
	public void enterPurchaseOrderWithAddProductDetails(WebDriver driver,String subName,String vendorName,String billingValue,String product_name,String service_name)
	{
		subjectTextbx.sendKeys(subName);
		selectVendorLkpImg.click();
		switchToWindow(driver, "Vendor&action");
		searchtextTb.sendKeys(vendorName);
		searchBtn.click();
		selectVendorName.click();
		switchToWindow(driver, "Administrator - Purchase Order");
		selectDropDownOption("Delivered", statusDropDown);
		billingTextTb.sendKeys(billingValue);
		billingRadioBtn.click();
		scrollBarAction(driver);
		selectProductLkpImg.click();
		switchToWindow(driver, "Product&action");
		searchtextTb.sendKeys(product_name);
		searchBtn.click();
		selectProductName.click();
		switchToWindow(driver, "Administrator - Purchase Order");
		qyt1TextTb.sendKeys("2");
		saveBtn.click();
		
	}
	public void enterPurchaseOrderWithAddProductAndClickOnUpWardArrowDetails(WebDriver driver,String subName,String vendorName,String billingValue,String product_name,String service_name)
	{
		subjectTextbx.sendKeys(subName);
		selectVendorLkpImg.click();
		switchToWindow(driver, "Vendor&action");
		searchtextTb.sendKeys(vendorName);
		searchBtn.click();
		selectVendorName.click();
		switchToWindow(driver, "Administrator - Purchase Order");
		selectDropDownOption("Delivered", statusDropDown);
		billingTextTb.sendKeys(billingValue);
		billingRadioBtn.click();
		scrollBarAction(driver);
		addServiceBtn.click();
		upwardArrowImg.click();
		selectProductLkpImg.click();
		switchToWindow(driver, "Services&action");
		searchtextTb.sendKeys(service_name);
		selectDropDownOption("Service Name", searchDropDown);
		searchBtn.click();
		selectServiceName.click();
		switchToWindow(driver, "Administrator - Purchase Order");
		
		qyt1TextTb.sendKeys("1");
		deleteLkpImg.click();
		
		saveBtn.click();
		
	}
	
	
}
