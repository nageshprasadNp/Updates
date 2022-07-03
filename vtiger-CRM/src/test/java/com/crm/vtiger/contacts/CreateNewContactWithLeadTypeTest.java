package com.crm.vtiger.contacts;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

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

public class CreateNewContactWithLeadTypeTest extends BaseClass{
	
	//@Test
	@Test(groups = "regressionTest")
	public void createNewContactwithLeadTypTest() throws Throwable
	{
		
		int randNum;
		String LoginTitle=flib.getPropertyKeyValue("LoginTitle");
						
		//fetching from excel sheet using generic utilities
			
		randNum=jlib.getrandomNumber();
		String first_name = elib.readExcelData("sheet1", 7, 2);
		String last_name=elib.readExcelData("sheet1", 7, 3)+randNum;
		String mobile=elib.readExcelData("sheet1",7, 4);
		String dept_name=elib.readExcelData("sheet1", 7, 5)+randNum;
		String email=elib.readExcelData("sheet1", 7, 6);
		String leadType=elib.readExcelData("contacts", 3, 3);
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
		cnewConPage.enterContactInfoWithLeadType(first_name, last_name, mobile, dept_name, email,leadType);
		
		
		//cnewConPage.clickOnsaveBtn();

		ContactInformationPage cinfopage=new ContactInformationPage(driver);
		String actualResult=cinfopage.getContactHeaderText().getText();
		
		String expectedResult=last_name;
		
		wlib.verify(actualResult, expectedResult);
		
			
	}

}
