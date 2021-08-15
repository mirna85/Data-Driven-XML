package page;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	public void selectDropdown(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByVisibleText(value);
		
	}
	
	public int generateNumber(int bound) {

		Random rnd = new Random();
		int generatedNumber = rnd.nextInt(bound);
		return generatedNumber;
		
	}
	
	public void waitForElement(WebDriver driver2, int i, WebElement element) {
		
		WebDriverWait wait = new WebDriverWait(driver2, i);
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}


}
