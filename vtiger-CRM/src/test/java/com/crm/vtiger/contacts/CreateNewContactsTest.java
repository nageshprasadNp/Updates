package com.crm.vtiger.contacts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.Connection;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.objectRepository.ContactInformationPage;
import com.objectRepository.ContactsPage;
import com.objectRepository.CreateNewContactPage;
import com.objectRepository.HomePage;
import com.objectRepository.LoginPage;
import com.vtiger.genericLib.BaseClass;
import com.vtiger.genericLib.ExcelUtilities;
import com.vtiger.genericLib.FileUtilities;
import com.vtiger.genericLib.JavaUtility;
import com.vtiger.genericLib.WebDriverCommonLibraries;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateNewContactsTest extends BaseClass {

	//@Test(groups = "smokeTest")
	@Test
	public void createContactTest() throws Throwable {
		
				
				int randNum;
				String LoginTitle=flib.getPropertyKeyValue("LoginTitle");
								
				//fetching from excel sheet using generic utilities
					
				randNum=jlib.getrandomNumber();
				String first_name = elib.readExcelData("sheet1", 7, 2);
				String last_name=elib.readExcelData("sheet1", 7, 3)+randNum;
				String mobile=elib.readExcelData("sheet1",7, 4);
				String dept_name=elib.readExcelData("sheet1", 7, 5)+randNum;
				String email=elib.readExcelData("sheet1", 7, 6);
				String leadType=elib.readExcelData("organization", 3, 4);
				String salatution=elib.readExcelData("contacts", 2, 5);
				
									
			
				//define the implicit wait 
				wlib.waitForPageGetLoad(driver);
						 
				
				//inspect contact sub menu
				HomePage homePage=new HomePage(driver);
				homePage.clickOnContactLnk();
				
							
				//inspect create new contact icon
				ContactsPage contactPage=new ContactsPage(driver);
				contactPage.clickOnCreateNewContactIcon();
				
		
				//inspect drop down
				CreateNewContactPage cnewConPage=new CreateNewContactPage(driver);
				cnewConPage.selectSalatationOption(salatution);
				cnewConPage.enterContactInfo(first_name, last_name, mobile, dept_name, email);
				

				ContactInformationPage cinfopage=new ContactInformationPage(driver);
				
				String actualResult=cinfopage.getContactHeaderText().getText();
				
				String expectedResult=last_name;
				Assert.assertTrue(actualResult.contains(expectedResult));
				//wlib.verify(actualResult, expectedResult);
				System.out.println("contact is created");
//				//verify contact is created or not
//				if(actualResult.contains(expectedResult))
//				{
//					System.out.println("contact is craeted successfully");
//				}
//				else
//				{
//					System.out.println("contact is not created ");
//				}
			
			
				
			
				
	}

}
