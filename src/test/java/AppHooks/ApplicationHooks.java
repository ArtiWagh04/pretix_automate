package AppHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.BrowserContext;
import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {

	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader config;

	Properties prop;

	@Before(order = 0)
	public void getProperty() {

		config = new ConfigReader();
		prop = config.init_prop();
	}

	@Before(order = 1)
	public void launchBrowser() {

		String browserName = BrowserContext.getBrowser();

		System.out.println(
				"Running browser: " + browserName +
						" | Thread: " + Thread.currentThread().getId()
		);

		driverFactory = new DriverFactory();

		driver = driverFactory.init_driver(browserName);
	}

	@After(order = 1)
	public void tearDown(Scenario scenario) {

		if (scenario.isFailed()) {



			byte[] screenshot =
					((TakesScreenshot) driver)
							.getScreenshotAs(OutputType.BYTES);

			scenario.attach(
					screenshot,
					"image/png",
					"Failed Scenario Screenshot"
			);
		}
	}

	@After(order = 2)
	public void quitBrowser() {

		if (driver != null) {
			driver.quit();
		}

//		BrowserContext.removeBrowser();
	}
}