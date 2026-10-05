package com.qa.factory;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFactory {

	public static ThreadLocal<WebDriver> tlDriver =
			new ThreadLocal<>();

	public WebDriver init_driver(String browser) {

		try {

			URL gridUrl = new URL("http://localhost:4444");

			if (browser.equalsIgnoreCase("chrome")) {

				ChromeOptions options = new ChromeOptions();

				tlDriver.set(
						new RemoteWebDriver(gridUrl, options)
				);

			} else if (browser.equalsIgnoreCase("edge")) {

				EdgeOptions options = new EdgeOptions();

				tlDriver.set(
						new RemoteWebDriver(gridUrl, options)
				);

			} else {

				throw new IllegalArgumentException(
						"Unsupported browser: " + browser
				);
			}

			getDriver().manage().deleteAllCookies();
			getDriver().manage().window().maximize();

			return getDriver();

		} catch (MalformedURLException e) {

			throw new RuntimeException(
					"Invalid Selenium Grid URL", e
			);
		}
	}

	public static WebDriver getDriver() {
		return tlDriver.get();
	}
}