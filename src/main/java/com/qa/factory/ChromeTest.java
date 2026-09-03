package com.qa.factory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URI;

public class ChromeTest {


        public static void main(String[] args) throws Exception {

            ChromeOptions options = new ChromeOptions();

            WebDriver driver =
                    new RemoteWebDriver(
                            URI.create("http://localhost:4444").toURL(),
                            options
                    );

            driver.get("https://www.google.com");

            System.out.println(driver.getTitle());

            driver.quit();
        }

}
