package testRunners;

import com.qa.factory.BrowserContext;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;

@CucumberOptions(
        features = "src/test/resources/com/AppFeatures",
        glue = {
                "stepDefinitions",
                "AppHooks"
        },
        plugin = {
                "pretty",
                "html:target/cucumber-report-chrome.html"
        },
        monochrome = true
)
public class ChromeRunner extends AbstractTestNGCucumberTests {

    @BeforeClass
    public void setBrowser() {
        BrowserContext.setBrowser("chrome");
    }
}