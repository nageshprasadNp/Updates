package com.crm.vtiger.organization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.util.List;
import java.util.Properties;
import java.util.Random;
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

import com.objectRepository.CreateNewOrganizationPage;
import com.objectRepository.HomePage;
import com.objectRepository.LoginPage;
import com.objectRepository.OrganizationInfoPage;
import com.objectRepository.OrganizationPage;
import com.vtiger.genericLib.BaseClass;
import com.vtiger.genericLib.ExcelUtilities;
import com.vtiger.genericLib.FileUtilities;
import com.vtiger.genericLib.JavaUtility;
import com.vtiger.genericLib.WebDriverCommonLibraries;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateNewOrganizationTest extends BaseClass {

	@Test(groups = "smokeTest")
	//@Test
	public void createNewOrg() throws Throwable {
		
	
		
		// Read the data from properties file
		try
		{
	/*	FileInputStream fis=new FileInputStream("./src/test/resources/data.properties");
		Properties p=new Properties();
		p.load(fis);
		String url = p.getProperty("url");
		String username = p.getProperty("username");
		String password=p.getProperty("password");
		String browser=p.getProperty("browser");
		String LoginTitle=p.getProperty("LoginTitle");
		//Read the data from excel sheet
		FileInputStream fstream=new FileInputStream("./src/test/resources/InputData.xlsx");
		Workbook wb=WorkbookFactory.create(fstream);
		String organization_Name = wb.getSheet("sheet1").getRow(4).getCell(2).getStringCellValue();
		String website=wb.getSheet("sheet1").getRow(4).getCell(3).getStringCellValue();
		
		//create random num 
		Random randNum=new Random();
		int randNumber = randNum.nextInt(100);
		*/
		
		String LoginTitle=flib.getPropertyKeyValue("LoginTitle");
		//String browser=flib.getPropertyKeyValue("browser");
		
		//generate random number
		int randNum=jlib.getrandomNumber();
	
		//fetching organization data from excel
		String org_name=elib.readExcelData("sheet1", 4, 2)+randNum;
		String website=elib.readExcelData("sheet1", 4, 3);
		//String phone=elib.readExcelData("organisation", 1, 4);
		String industryname=elib.readExcelData("organization", 3, 3);
		String typeValue=elib.readExcelData("organization", 4, 4);
			
		
		wlib.waitForPageGetLoad(driver);

		//inspecting organization in home page
		HomePage hp=new HomePage(driver);
		hp.clickOnOrgLink();
		
		
		//inspecting new organization icon 
		OrganizationPage orgPage=new OrganizationPage(driver);
		orgPage.clickOnCreateOrgLookUp();
		
		
		//inspect organization name text box
		CreateNewOrganizationPage createNewOrgPage=new CreateNewOrganizationPage(driver);
		createNewOrgPage.enterOrgInfo(org_name, website);
		
		createNewOrgPage.selectIndustryDropDownValue(industryname);
		createNewOrgPage.selectTypeDropDownValue(typeValue);
		//to check the notify owner check box is selected or not
		createNewOrgPage.clickOnNotifyOwnerCheckBx();
		
		
		
		
		
		//inspect save button
		createNewOrgPage.clickOnSaveBTn();
		
		
		//verifying organization is added or not
		
		//WebElement text = driver.findElement(By.xpath("//td[@class='dvtCellLabel']/following-sibling::td[1]"));
		
		OrganizationInfoPage orgInfoPage=new OrganizationInfoPage(driver);
		String actualResult=orgInfoPage.getOrgInfoHeaderText().getText();
		
		
		String expectedResult=org_name;
		//wlib.verify(actualResult, expectedResult);
		if(actualResult.contains(expectedResult))
		{
			System.out.println("organization is craeted successfully");
		}
		else
		{
			System.out.println("organization is not created ");
		}
		
		

		String acttitle=driver.getTitle();
		
		if(acttitle.equals(LoginTitle))
		{
			System.out.println("successfully sign out");
		}
		else
		{
			System.out.println("not sign out");
		}
		
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	}