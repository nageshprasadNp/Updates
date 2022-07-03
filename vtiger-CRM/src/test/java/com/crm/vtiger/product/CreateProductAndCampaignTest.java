package com.crm.vtiger.product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.objectRepository.CampaignInfoPage;
import com.objectRepository.CampaignPage;
import com.objectRepository.CreateNewCampaignPage;
import com.objectRepository.CreateNewProductPage;
import com.objectRepository.HomePage;
import com.objectRepository.LoginPage;
import com.objectRepository.ProductInfoPage;
import com.objectRepository.ProductPage;
import com.vtiger.genericLib.ExcelUtilities;
import com.vtiger.genericLib.FileUtilities;
import com.vtiger.genericLib.JavaUtility;
import com.vtiger.genericLib.WebDriverCommonLibraries;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProductAndCampaignTest extends WebDriverCommonLibraries{

	@Test
	public void createProductWithCampaignTest() throws Throwable {
		// create product and campaign
		
		//intialization of driver
		
	WebDriver driver;
		
		//fetching data from property file
			FileUtilities flib=new FileUtilities();
			ExcelUtilities elib=new ExcelUtilities();
			JavaUtility jlib=new JavaUtility();
			WebDriverCommonLibraries wlib=new WebDriverCommonLibraries();
			
		
		String url = flib.getPropertyKeyValue("url");
		String username = flib.getPropertyKeyValue("username");
		String password = flib.getPropertyKeyValue("password");
		String browser = flib.getPropertyKeyValue("browser");
		String LoginTitle=flib.getPropertyKeyValue("LoginTitle");
		
		
		//fetching product details from excel sheet
		
		String product_Name = elib.readExcelData("sheet1", 1, 2);
		
		//fetching campaign details
		
		String campaign_Name = elib.readExcelData("sheet1", 10, 2);
		System.out.println(campaign_Name);
		
		//genrate random number
		int randNum=jlib.getrandomNumber();
		
		
		
		
		//launch the browser
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		
		//enter the url and 

		driver.manage().window().maximize();
		driver.get(url);
		waitForPageGetLoad(driver);
		
		//inspecting username, password and login button in login page
		
		LoginPage loginPage=new LoginPage(driver);
		loginPage.loginToAppln(username, password);
				
	//to inspect add product button
		HomePage homePage=new HomePage(driver);
		homePage.clickOnProductLnk();
		//to inspect add product icon button
		
		ProductPage productPage=new ProductPage(driver);
		productPage.clickOnCreateProductLkpImg();
		
		//in  add new product page
		
		CreateNewProductPage cnewProPage=new CreateNewProductPage(driver);
		cnewProPage.enterProductInfo(product_Name,driver);
		
		//verifying product is created or not
		
		ProductInfoPage pinfo=new ProductInfoPage(driver);
	
		String actualResult=pinfo.getProductDeatilsHeaderText().getText();
		System.out.println(actualResult);
		
		String expectedResult=product_Name;
		
		if(actualResult.contains(expectedResult))
		{
			System.out.println("product is craeted successfully");
		}
		else
		{
			System.out.println("product is not created ");
		}
	
		//move to cursor to more and click on campaign link
		homePage.moveOnMoreLnk(driver);
		
		//inspect camapaign icon
		
		CampaignPage camPage=new CampaignPage(driver);
		camPage.clickOnCreateCampaignLkpImg();
		
		
		//enter campaign name
		CreateNewCampaignPage cnewCampaignPage=new CreateNewCampaignPage(driver);
		cnewCampaignPage.enterCampaignInfo(driver,campaign_Name);
		
		
		
	
	
	//verification
	
		CampaignInfoPage campInfoPage=new CampaignInfoPage(driver);
		
	
	String actualResult1=campInfoPage.getCampaignHeaderText().getText();
	System.out.println(actualResult1);
	
	String expectedResult2=campaign_Name;
	
	if(actualResult1.contains(expectedResult2))
	{
		System.out.println("product and campaign is craeted  successfully");
	}
	else
	{
		System.out.println("product and campaign is not created ");
	}
	
	//inspect administered icon
	homePage.signOutLnk(driver);
	String acttitle=driver.getTitle();
	if(acttitle.equals(LoginTitle))
	{
		System.out.println("successfully sign out");
	}
	else
	{
		System.out.println("not sign out");
	}
	
	
		driver.close();
	
		
	}
	
	}

		
	

