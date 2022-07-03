package com.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignInfoPage {
	
	
	@FindBy(xpath = "//span[@class='dvHeaderText']") private WebElement campaignHeaderText;
	
	public CampaignInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCampaignHeaderText() {
		return campaignHeaderText;
	}
	
	
	

}
