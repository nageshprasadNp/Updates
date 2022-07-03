package com.vtiger.genericLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;


import com.objectRepository.HomePage;
import com.objectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver sdriver;
	public WebDriver driver;
	public DataBaseUtility dlib=new DataBaseUtility();
	public ExcelUtilities elib=new ExcelUtilities();
	public FileUtilities flib=new FileUtilities();
	public JavaUtility jlib=new JavaUtility();
	public WebDriverCommonLibraries wlib=new  WebDriverCommonLibraries();
	/**
	 * 
	 */
	@BeforeTest
	public  void dbConfig()
	{
		dlib.connectToDB();
	}
	/**
	 * 
	 * @throws Throwable
	 */
	//@Parameters({"Browser"})
	@BeforeClass
	public void launchBrowser() throws Throwable
	{
		String Browser1=flib.getPropertyKeyValue("browser");
		String URL=flib.getPropertyKeyValue("url");
		
		if(Browser1.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
		}
		else
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		sdriver=driver;
	//	Reporter.log("browser is launched sucessfull",true);
		//to maximize the window
		driver.manage().window().maximize();
		//to enter the url
		sdriver.get(URL);
		
		
	}
	/**
	 * 
	 * @throws Throwable
	 */
	
	@BeforeMethod
	public void loginToAppln() throws Throwable
	{
		String USERNAME=flib.getPropertyKeyValue("username");
		String PASSWORD=flib.getPropertyKeyValue("password");
		LoginPage loginPage=new LoginPage(driver);
		loginPage.loginToAppln(USERNAME,PASSWORD);
	
		
	}
	
	/**
	 * 
	 */
	@AfterMethod
	public void logOut()
	{
		HomePage homepage=new HomePage(driver);
		homepage.signOutLnk(driver);
		
	}
	
	
	
	/**
	 * 
	 */
	@AfterClass
	public void closeTheBrowser()
	{
		driver.quit();
		
	}
	
	@AfterSuite
	 
	public void closeDbConfig()
	{
		dlib.closeDb();
	}
	

}
