package com.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.genericLib.WebDriverCommonLibraries;

public class CreateNewProductPage extends WebDriverCommonLibraries {

	@FindBy(name = "productname")private WebElement productNameTextTb;
	
	@FindBy(name="productcategory")private WebElement productCatDropDown;
	
	@FindBy(name="manufacturer")private WebElement manufuDropDown;
	
	@FindBy(xpath = "//input[@value='T']") private WebElement userRadioBtn;
	
	@FindBy(xpath = "//input[@value='T']")private WebElement handlerDropDown;
	
	@FindBy(id="my_file_element")private WebElement uploadBtn;
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[2]")private WebElement saveBtn;
	
	
	public CreateNewProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	public WebElement getProductNameTextTb() {
		return productNameTextTb;
	}


	public WebElement getProductCatDropDown() {
		return productCatDropDown;
	}


	public WebElement getManufuDropDown() {
		return manufuDropDown;
	}


	public WebElement getHandlerDropDown() {
		return handlerDropDown;
	}


	public WebElement getUploadBtn() {
		return uploadBtn;
	}


	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	
	public void enterProductInfo(String productname,WebDriver driver)
	{
		productNameTextTb.sendKeys(productname);
		selectDropDownOption("AltvetPet Inc.", manufuDropDown);
		selectDropDownOption("Software", productCatDropDown);
		scrollBarAction(driver);
		userRadioBtn.click();
		scrollBarAction(driver);
		saveBtn.click();
	}
	
	
	
	
	
	
	
	
	
	
	
}
