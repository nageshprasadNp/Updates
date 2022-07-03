package com.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInfoPage {

	@FindBy(xpath = "//span[@class='lvtHeaderText']")private WebElement productDeatilsHeaderText;
	
	public ProductInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getProductDeatilsHeaderText() {
		return productDeatilsHeaderText;
	}
	
	
	
	
	
	
	
}
