package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashBoardPage;
import page.LoginPage;
import util.BrowserFactory;


public class AddCustomerTest {

	WebDriver driver;
	
	String userName; 
	String password;
	String fullName;
	String companyName;
	String eMail;
	String phoneNumber;
	String address;	
	String city;
	String country;
	String state;
	String zipCode;
	
	@Test
	@Parameters({"username","password", "FullName", "CompanyName", "Email", "Phone", "Address", "City", "State", "Zip", "Country"})
	public void validUserToUseAddCustomerOnListCustomerPage(String userName, String password, String fullName, String companyName, String eMail, String phoneNumber, String address, String city, String state, String zipCode, String country) {
		
		driver = BrowserFactory.init();
		
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.enterUsername(userName);
		login.enterPassword(password);
		login.clickSignin();
		
		DashBoardPage dashboard = PageFactory.initElements(driver, DashBoardPage.class);
		dashboard.verifyDashboardPage();
		dashboard.clickCustomersButton();
		dashboard.clickListCustomersButton();
		
		AddCustomerPage customer = PageFactory.initElements(driver, AddCustomerPage.class);
		customer.clickAddCustomerOnListCustomerPage();
		customer.enterFullName(fullName);
		customer.enterCompanyName(companyName);
		customer.enterEmail(eMail);
		customer.enterPhone(phoneNumber);
		customer.enterAdress(address);
		customer.enterCity(city);
		customer.enterState(state);
		customer.enterZip(zipCode);
		customer.enterCountry(country);
		customer.clickSaveButtonOnAddContact();
		
		customer.verifySummaryPage();
		dashboard.clickListCustomersButton();
		customer.insertNameOnSearchBarOnListCustomer();
		customer.verifySearchBarAndSummaryButtonOnListCustomer();
		customer.verifySummaryPage();
		
		BrowserFactory.tearDown();
	}
	
	
	
	
	
}
