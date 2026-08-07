package testRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "@target/rerun.txt",
        glue = "stepDefinitions",
        plugin = {
                "pretty",
                "html:target/rerun-report.html"
        }
)
public class Rerun extends AbstractTestNGCucumberTests {

}
