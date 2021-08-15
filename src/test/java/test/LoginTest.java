package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.DashBoardPage;
import page.LoginPage;
import util.BrowserFactory;

public class LoginTest {
	
	WebDriver driver;
	
	@Test
	@Parameters({"username","password"})
	public void validUserWillLogIn(String userName, String password) {
		
		driver = BrowserFactory.init();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.enterUsername(userName);
		loginPage.enterPassword(password);
		loginPage.clickSignin();
		
		DashBoardPage dashboard = PageFactory.initElements(driver, DashBoardPage.class);
		dashboard.verifyDashboardPage();
		
		//BrowserFactory.tearDown();
		
	}

}
