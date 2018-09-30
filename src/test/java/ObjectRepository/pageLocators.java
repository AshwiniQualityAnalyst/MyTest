package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class pageLocators {
	static WebDriver driver;
	private static WebElement element;

	public static WebElement textbox_search(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id='searchform']/div/input"));
		return element;
	}

	public static WebElement button_search(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id='searchform']/button"));
		return element;
	}

	public static String GETTEXTOFNOTFOUND(WebDriver driver) {
		String element = driver.findElement(By.xpath("//div[@class='alert alert-warning']")).getText();
		String StringSplitter = element.replaceAll("\\s+", "").replace("×", "");
		return StringSplitter;
	}

	public static boolean GETTEXTOfTEMPERATURE(WebDriver driver) {
		String element = driver.findElement(By.xpath("//span[@class='badge badge-info']")).getText();
		return true;
	}

	public static boolean GETTEXTWEATHERDETAILS(WebDriver driver) {
		String element = driver.findElement(By.xpath("(//*[@id='forecast_list_ul']/table/tbody/tr/td[2]/p[1])"))
				.getText();
		return true;
	}

	public static WebElement celsius_button(WebDriver driver) {

		element = driver.findElement(By.id("metric"));
		return element;
	}

	public static WebElement fahrenheit_buttons(WebDriver driver) {

		element = driver.findElement(By.id("imperial"));
		return element;
	}

	public static boolean WidgetCityName(WebDriver driver) {
		boolean element = driver.findElement(By.xpath("//h2[@class='weather-widget__city-name']")).isDisplayed();
		return true;
	}

	public static boolean WidgetCityTemperature(WebDriver driver) {
		boolean element = driver.findElement(By.xpath("//h2[@class='weather-widget__city-name']")).isDisplayed();
		return true;
	}

	public static String GetLabelText(WebDriver driver) {
		String element = driver.findElement(By.xpath("//h2[@class='widget__title']")).getText();
		return element;

	}
}
