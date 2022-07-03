package com.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	
	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement createNewContactLookUpImg;
	
	
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	public WebElement getCreateNewContactLookUpImg() {
		return createNewContactLookUpImg;
	}
	
	
	public void clickOnCreateNewContactIcon()
	{
		createNewContactLookUpImg.click();
	}

}
