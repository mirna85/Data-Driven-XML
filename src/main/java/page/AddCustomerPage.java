package page;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AddCustomerPage extends BasePage { //stopped at 1:27:11 

	WebDriver driver;

	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//input[@id='account']")
	WebElement FULL_NAME_FIELD;
	@FindBy(how = How.XPATH, using = "//select[@id='cid']")
	WebElement COMPANY_FIELD;
	@FindBy(how = How.XPATH, using = "//input[@id='email']")
	WebElement EMAIL_FIELD;
	@FindBy(how = How.XPATH, using = "//input[@id='phone']")
	WebElement PHONE_FIELD;
	@FindBy(how = How.XPATH, using = "//input[@id='address']")
	WebElement ADDRESS_FIELD;
	@FindBy(how = How.XPATH, using = "//input[@id='city']")
	WebElement CITY_FIELD;
	@FindBy(how = How.XPATH, using = "//input[@id='state']")
	WebElement STATE_FIELD;
	@FindBy(how = How.XPATH, using = "//input[@id='zip']")
	WebElement ZIP_FIELD;
	@FindBy(how = How.XPATH, using = "//select[@id=\"country\"]")
	WebElement COUNTRY_FIELD;
	@FindBy(how = How.XPATH, using = "//button[@class='md-btn md-btn-primary waves-effect waves-light' and @type='submit']")
	WebElement SAVE_BUTTON_ON_ADD_CONTACT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"submit\"]")
	WebElement SUMMARY_ON_SUMMARY_PAGE;
	@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div[1]/a[1]")
	WebElement ADD_CUSTOMER_ON_LIST_CUSTOMER;
	@FindBy(how = How.XPATH, using = "//*[@id=\"foo_filter\"]")
	WebElement SEARCH_BAR_ON_LIST_CUSTOMER;

	String enteredName;
	
	public void enterFullName(String fullName) {
		
		waitForElement(driver, 3, FULL_NAME_FIELD); 
		enteredName = fullName + generateNumber(999);
		FULL_NAME_FIELD.sendKeys(enteredName);
	}

	public void enterCompanyName(String company) {
		selectDropdown(COMPANY_FIELD, company);
	}

	public void enterEmail(String email) {
		EMAIL_FIELD.sendKeys(generateNumber(999) + email);
	}

	public void enterPhone(String phone) {
		PHONE_FIELD.sendKeys(generateNumber(99) + phone);
	}
	
	public void enterAdress(String address) {
		ADDRESS_FIELD.sendKeys(address);
	}
	
	public void enterCity(String city) {
		CITY_FIELD.sendKeys(city);
	}
	
	public void enterState(String state) {
		STATE_FIELD.sendKeys(state);
	}
	
	public void enterZip(String zip) {
		ZIP_FIELD.sendKeys(zip);
	}
	
	public void enterCountry(String country) {
		COUNTRY_FIELD.sendKeys(country);
	}
	
	public void clickSaveButtonOnAddContact() {
		SAVE_BUTTON_ON_ADD_CONTACT.click();
	}
	
	public void verifySummaryPage(){
		waitForElement(driver, 10, SUMMARY_ON_SUMMARY_PAGE);
		Assert.assertEquals(SUMMARY_ON_SUMMARY_PAGE.getText(), "Summary", "Wrong Page");

	}
	
	public void clickAddCustomerOnListCustomerPage() {
		ADD_CUSTOMER_ON_LIST_CUSTOMER.click();
	
	}
	
	public void insertNameOnSearchBarOnListCustomer() {
		SEARCH_BAR_ON_LIST_CUSTOMER.sendKeys(enteredName);
		
	}
	
	//tbody/tr[1]/td[3]
	//tbody/tr[2]/td[3]
	//tbody/tr[3]/td[3]
	//tbody/tr[i]/td[3]
	//tbody/tr[1]/td[3]/following-sibling::td[4]/a[2] //absolute
	//tbody/tr[i]/td[3]/following-sibling::td[4]/a[2] //relative
	
	public void verifyEnteredNameAndDelete() {
		
		String before_xpath = "//tbody/tr[";
		String after_xpath = "]/td[3]";
		
		for(int i = 1; i <=10 ; i++) {
			
		String name =	driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
//		System.out.println(name);
//		Assert.assertEquals(name, enteredName, "Entered Name Does Not Exist!");
//		break;
		
		if(name.contains(enteredName)) {
			System.out.println("Entered Name Exists");
			driver.findElement(By.xpath(before_xpath + "]/td[3]/following-sibling::td[4]/a[2]")).click();
		}
		}
	}
	
	public void verifySearchBarAndSummaryButtonOnListCustomer() {
		
		String before_xpath = "//tbody/tr[";
		String after_xpath = "]/td[3]";
		
		for(int i = 1; i <=10 ; i++) {
			
		String name =	driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
//		System.out.println(name);
//		Assert.assertEquals(name, enteredName, "Entered Name Does Not Exist!");
//		break;
//		
		if(name.contains(enteredName)) {
			System.out.println("Entered Name Exists");
			driver.findElement(By.xpath(before_xpath + "]/td[3]/following-sibling::td[4]/a[1]")).click();
		}
		
		break;
	}
	}
}
