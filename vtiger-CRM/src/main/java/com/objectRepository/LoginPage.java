package com.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	
	@FindBy(name="user_name")
	private WebElement usernameTb;
	
	@FindBy(name="user_password")
	private WebElement passwordTb;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getUsernameTb() {
		return usernameTb;
	}

	public WebElement getPasswordTb() {
		return passwordTb;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	
	public void loginToAppln(String username,String password)
	{
		usernameTb.sendKeys(username);
		passwordTb.sendKeys(password);
		loginBtn.click();
	}
	
	

}
