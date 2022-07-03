package com.crm.vtiger.contacts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.objectRepository.ContactInformationPage;
import com.objectRepository.ContactsPage;
import com.objectRepository.CreateNewContactPage;
import com.objectRepository.HomePage;
import com.objectRepository.LoginPage;
import com.vtiger.genericLib.BaseClass;
import com.vtiger.genericLib.WebDriverCommonLibraries;

import io.github.bonigarcia.wdm.WebDriverManager;



public class CreateNewContactWithOrganizationNameTest extends BaseClass {

	@Test
	//@Test(groups = "regressionTest")
	public void createContactwithOrg() throws Throwable  {
		
			// Read the data from properties file
		try
		{
		
			String LoginTitle=flib.getPropertyKeyValue("LoginTitle");
			
			//fetching data from excel sheet
			String first_name=elib.readExcelData("sheet1", 7, 2);
			String last_name=elib.readExcelData("sheet1", 7, 3);
			String mobileNUm = elib.readExcelData("sheet1", 7, 4);
			String mobileno=mobileNUm.toString();
			String depart =elib.readExcelData("sheet1", 7, 5);
			String email=elib.readExcelData("sheet1", 7, 6);
			
			//get random number
			int randNum = jlib.getrandomNumber();
	
	
		//fetching organization name
		String organization_Name = elib.readExcelData("sheet1", 4, 3)+randNum;
		String leadType=elib.readExcelData("contacts", 5, 3);
		String salatution=elib.readExcelData("contacts", 2, 5);
		
				
		//inspect contact sub menu
		HomePage hp=new HomePage(driver);
		hp.clickOnContactLnk();
		
		//inspect create new contact icon
		ContactsPage cp=new ContactsPage(driver);
		cp.clickOnCreateNewContactIcon();
		
		
		//inspect drop down
		CreateNewContactPage cnp=new CreateNewContactPage(driver);
		cnp.selectSalatationOption(salatution);
		cnp.enterContactInfoWithOrgName(first_name,last_name, mobileno, depart, email,driver,organization_Name,leadType);
		
		//verifying contact is created or not
		
		ContactInformationPage cinfopage=new ContactInformationPage(driver);
		
		String actualResult=cinfopage.getContactHeaderText().getText();
		
		System.out.println(actualResult);
		
		String expectedResult=last_name;
		wlib.verify(actualResult, expectedResult);
//		if(actualResult.contains(expectedResult))
//		{
//			System.out.println("contact is craeted with organization successfully");
//		}
//		else
//		{
//			System.out.println("contact is not created ");
//		}
//		
//		
		
		
	}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

}
