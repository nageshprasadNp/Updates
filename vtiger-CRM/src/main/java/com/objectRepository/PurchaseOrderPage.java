package com.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.genericLib.WebDriverCommonLibraries;

public class PurchaseOrderPage extends WebDriverCommonLibraries{
	
	@FindBy(xpath ="//img[@title='Create Purchase Order...']")private WebElement purchaseOrderLkpImg;
	
	public PurchaseOrderPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getPurchaseOrderLkpImg() {
		return purchaseOrderLkpImg;
	}

	
	public void clickOnPurchaseOrderLkImg()
	{
		purchaseOrderLkpImg.click();
	}
	
	
	
}
