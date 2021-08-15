package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BrowserFactory {

	static ChromeDriver driver;
	static String browser;
	static String url;

	public static void readConfig() {

		Properties prop = new Properties();
		try {
			InputStream input = new FileInputStream("src\\main\\java\\config\\config.properties");
			prop.load(input);
			browser = prop.getProperty("browser");
			System.out.println("Browser: " + browser);
			url = prop.getProperty("url");
			System.out.println("URL: " + url);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static WebDriver init() {
		readConfig();
		if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("Microsoft Edge")) {
			System.setProperty("webdriver.edge.driver", "driver\\msedgedriver.exe");
			WebDriver driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	public static void tearDown() {

		driver.close();
		driver.quit();

	}

}
