package ObjectRepository;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestScripts extends pageLocators {

	public static void OpenBrowser(String URL) {
		String projectpath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectpath + "/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(URL);
	}

	public static void EnterCityName(String name) {
		pageLocators.textbox_search(driver).clear();
		pageLocators.textbox_search(driver).sendKeys(name);
		pageLocators.button_search(driver).click();
	}

	public static void TemperatureButtons(String name) {
		if (name == "Celsius") {
			pageLocators.celsius_button(driver).click();

		} else if (name == "Fahrenheit") {
			pageLocators.fahrenheit_buttons(driver).click();
		}
	}

	public static void CloseBrowser(String name) {
		if (name == "close") {
			driver.close();
		} else if (name == "quit") {
			driver.quit();
		}
	}
}
