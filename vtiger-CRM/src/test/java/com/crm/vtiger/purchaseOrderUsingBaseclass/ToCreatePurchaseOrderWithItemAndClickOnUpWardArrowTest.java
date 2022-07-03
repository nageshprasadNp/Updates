package com.crm.vtiger.purchaseOrderUsingBaseclass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.objectRepository.CreateNewPurchaseOrderPage;
import com.objectRepository.HomePage;
import com.objectRepository.LoginPage;
import com.objectRepository.PurchaseOrderPage;
import com.vtiger.genericLib.BaseClass;
import com.vtiger.genericLib.ExcelUtilities;
import com.vtiger.genericLib.FileUtilities;
import com.vtiger.genericLib.JavaUtility;
import com.vtiger.genericLib.WebDriverCommonLibraries;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ToCreatePurchaseOrderWithItemAndClickOnUpWardArrowTest extends BaseClass {

	@Test(enabled = true)
	public void cratePurchaseOrderTest() throws Throwable {
	
		
		String LoginTitle=flib.getPropertyKeyValue("LoginTitle");
		
	
		
		FileInputStream fstream=new FileInputStream("./src/test/resources/InputData.xlsx");
		Workbook wb=WorkbookFactory.create(fstream);
	 	String subject= wb.getSheet("sheet1").getRow(16).getCell(2).getStringCellValue();
		String billing_address=wb.getSheet("sheet1").getRow(16).getCell(3).getStringCellValue();
		String qty=String.valueOf((int)wb.getSheet("sheet1").getRow(16).getCell(4).getNumericCellValue());
		String service_name=wb.getSheet("sheet1").getRow(19).getCell(2).getStringCellValue();
		String product_name="oppoMobile";
		
		String vendor_name=wb.getSheet("sheet1").getRow(22).getCell(2).getStringCellValue();
		System.out.println(vendor_name);
		
		
		Random random=new Random();
		int randnum = random.nextInt(100);
		
		//derive the implicicty wait
		wlib.waitForPageGetLoad(driver);
				
		
		//to inspect more
		HomePage homePage=new HomePage(driver);
		homePage.clickOnMoreLnk(driver);
			
		
		PurchaseOrderPage porderPage=new PurchaseOrderPage(driver);
		porderPage.clickOnPurchaseOrderLkImg();
		
		//to add purchase order
		CreateNewPurchaseOrderPage cPurchaseOrderPage=new CreateNewPurchaseOrderPage(driver);
		cPurchaseOrderPage.enterPurchaseOrderWithAddProductAndClickOnUpWardArrowDetails(driver,subject,vendor_name, billing_address, product_name, service_name);
		
	
				//verification
				String signUpPage = driver.getTitle();
				wlib.verify(signUpPage, LoginTitle);
//				if(signUpPage.equals(LoginTitle))
//				{
//					System.out.println("signed out successfully and Sign up page is displayed");
//				}
//				else
//				{
//					System.out.println(" not signed out");
//				}

	}

}
