package ObjectRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class AllTests extends TestScripts {

	@BeforeMethod
	public void SetUpTest() {
		TestScripts.OpenBrowser("https://openweathermap.org/");
	}

	@Test(priority = 0, description = "Check important")
	public void FirstE2E() {
		Assert.assertEquals("Current weather and forecasts in your city", pageLocators.GetLabelText(driver));
		List<String> ExpectedMenuItemsList = Arrays.asList("Weather", "API", "Price", "Partners", "Stations", "Widgets",
				"Blog");
		List<WebElement> ActualMenuItemsList = driver.findElements(By.xpath("//li[@class='nav__item']"));

		for (int i = 0; i < ActualMenuItemsList.size(); i++) {

			Assert.assertEquals(ExpectedMenuItemsList.get(i).trim(), ActualMenuItemsList.get(i).getText().trim());
		}
	}

	@Test(priority = 1, description = "Verifies that website suggests city is Not found")
	public void SecondE2E() {
		TestScripts.EnterCityName("InvalidCityName");
		Assert.assertEquals("Notfound", pageLocators.GETTEXTOFNOTFOUND(driver));
	}

	@Test(priority = 2, description = "Verifies that website successfully returns weather details for the city.")
	public void LastE2E() {
		TestScripts.EnterCityName("Mumbai");
		Assert.assertTrue(pageLocators.GETTEXTOfTEMPERATURE(driver));
		Assert.assertTrue(pageLocators.GETTEXTWEATHERDETAILS(driver));
	}

	@Test(priority = 3, description = "Temperature should be switchable between Fahrenheit and Celsius.")
	public void AdditionalTest() {
		TestScripts.TemperatureButtons("Fahrenheit");
		Assert.assertTrue(pageLocators.WidgetCityTemperature(driver));
		Assert.assertTrue(pageLocators.WidgetCityName(driver));
	}

	@AfterMethod
	public void TearDownTest() {
		TestScripts.CloseBrowser("quit");
	}

}
